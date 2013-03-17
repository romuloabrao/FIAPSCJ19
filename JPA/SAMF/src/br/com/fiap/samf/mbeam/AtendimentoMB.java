package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Agendamento;
import br.com.fiap.samf.model.Atendimento;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class AtendimentoMB {
	private Atendimento atendimento=new Atendimento();
	private CrudControl<Atendimento> control;
	private List<Atendimento> atendimentos;
	
	
	public AtendimentoMB() {
		this.control = new GenericCrudControl<Atendimento>(Atendimento.class);
	}
	
	
	@PostConstruct
	private void init(){
		//TODO Um pouco ARRUMAR
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc("");
		if(doc.getClasse().equals(Agendamento.class)){
			this.atendimento = new Atendimento();
			CrudControl<Agendamento> agControl = new GenericCrudControl<Agendamento>(Agendamento.class);
			Agendamento ag = agControl.buscar((Long) doc.getCodigo());
			this.atendimento.setAgendamento(ag);
		}else if(doc.getClasse().equals(Atendimento.class)){
			//TODO Um pouco Diferente...
		}
		
		this.atendimento = doc !=null && Atendimento.class.equals(doc.getClasse())? control.buscar((Long) doc.getCodigo()): new Atendimento();
	}
	
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	
	public List<Atendimento> getAtendimentos() {
		this.atendimentos = this.atendimentos == null? this.control.listar(): this.atendimentos;
		return atendimentos;
	}
	
	
}
