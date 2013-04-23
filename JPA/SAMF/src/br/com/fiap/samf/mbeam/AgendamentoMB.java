package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.fiap.samf.control.AgendamentoControl;
import br.com.fiap.samf.control.MedicamentoControl;
import br.com.fiap.samf.control.MedicoControl;
import br.com.fiap.samf.control.TratamentoControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Agendamento;
import br.com.fiap.samf.model.Atendente;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@SessionScoped
public class AgendamentoMB {
	private Agendamento agendamento= new Agendamento();
	private List<Agendamento> agendamentos;
	
	//Itens de menor importancia (só no beam).
	private Especialidade campoEspecialidade;
	private List<Medico> campoMedico;
	AgendamentoControl control;
	
	public AgendamentoMB() {
		this.control = new AgendamentoControl();
	}
	
	@PostConstruct
	private void init(){
		SessionUser su = (SessionUser) SessionManager.getSessionDoc("sessionUser");
		if( su != null && su.isLoggedIn() && su.getUser() instanceof Atendente){
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
		if(agendamento.getCodigo().longValue()==0){
			agendamento.setCodigo(null);
		}
		this.control.salvar(agendamento);
		SessionManager.destroySessionDoc("agendamentoMB");
		return "agendamento";
	}
	
	public List<Agendamento> getAgendamentos() {
		agendamentos = agendamentos == null ? this.control.listar() : agendamentos;
		return agendamentos;
	}
	
	
	
	public List<Agendamento> getAgendamentosDisponiveis() {
		SessionUser su = (SessionUser) SessionManager.getSessionDoc("sessionUser");
		if(su!= null && su.getUser() instanceof Medico){
			return this.control.listar((Medico)su.getUser());
		}
		return null;
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
		HtmlSelectOneMenu select = (HtmlSelectOneMenu) evt.getComponent();
		if(select.getValue() instanceof Especialidade){
			this.campoEspecialidade=(Especialidade)select.getValue();
		}else{
			this.campoEspecialidade=null;
		}
		this.campoMedico = control.buscarMedicos(this.campoEspecialidade);
	}

	public String editar() {
		return "agendamento";
	}
	
	public String criarAtendimento() {
		SessionManager.createSessionDoc(new DocumentSelectedMB(this.agendamento.getClass(), this.agendamento.getCodigo()), "agendamento");
		limparSessao();
		return "atendimento";
	}
	
	public void limparSessao() {
		SessionManager.destroySessionDoc("agendamentoMB");
	}
	
	public List<Tratamento> getAtendTratamento(){
		Agendamento ag= (Agendamento) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("agendamento");
		TratamentoControl tcontrol = new TratamentoControl();
		List<Tratamento> lista =tcontrol.listar(ag.getCodigo());
		return lista;
		
	}
	
	public List<Medicamento> getAtendMedicamento(){
		Agendamento ag= (Agendamento) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("agendamento");
		MedicamentoControl mcontrol = new MedicamentoControl();
		List<Medicamento> lista =mcontrol.listar(ag.getCodigo());
		return lista;
	}
}
