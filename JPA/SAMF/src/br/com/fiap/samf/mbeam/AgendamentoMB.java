package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.control.impl.MedicoControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Agendamento;
import br.com.fiap.samf.model.Atendente;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@SessionScoped //Só esta assim por que da pau no f:ajax.... não tem nenhuma lógica
public class AgendamentoMB {
	private Agendamento agendamento;
	private List<Agendamento> agendamentos;
	//Itens de menor importancia (só no beam).
	private Especialidade campoEspecialidade;
	private List<Medico> campoMedico;
	CrudControl<Agendamento> control;
	
	public AgendamentoMB() {
		this.control = new GenericCrudControl<>(Agendamento.class);
	}
	
	@PostConstruct
	public void init(){
		SessionUser su = (SessionUser) SessionManager.getSessionDoc(SessionManager.Beam.SESSION);
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		this.agendamento = doc !=null? control.buscar((Long) doc.getCodigo()): new Agendamento();
		if( su != null && su.isLoggedIn()){
			if (this.agendamento.getCodigo() == null){
				this.agendamento.setAtendente((Atendente)su.getUser());
			}
		}
	}
	
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	
	public String salvar() {
		control.salvar(agendamento);
		//Limpa a seção para utilizar.
		FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().remove("agendamentoMB");
		return "agendamento";
	}
	
	public List<Agendamento> getAgendamentos() {
		agendamentos = agendamentos == null ? this.control.listar() : agendamentos;
		return agendamentos;
	}
	
	public boolean isNewDoc(){
		return agendamento.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
	public Especialidade getCampoEspecialidade() {
		return campoEspecialidade;
	}
	
	public void setCampoEspecialidade(Especialidade campoEspecialidade) {
		this.campoEspecialidade = campoEspecialidade;
	}
	
	public List<Medico> getCampoMedico() {
		return campoMedico;
	}
	
	public void setCampoMedico(List<Medico> campoMedico) {
		this.campoMedico = campoMedico;
	}
	
	public void handleConvenio(AjaxBehaviorEvent evt){
		this.agendamento.setConvenio(this.agendamento.getPaciente().getConvenio());
	}
	
	public void handleListMedico(AjaxBehaviorEvent evt){
		MedicoControl control = new MedicoControl();
		this.campoMedico = control.buscarMedicos(this.campoEspecialidade);
	}

	public String editar() {
		SessionManager.createSessionDoc(new DocumentSelectedMB(this.agendamento.getClass(), this.agendamento.getCodigo()), SessionManager.Beam.DOCITEM);
		return "agendamento";
	}
}
