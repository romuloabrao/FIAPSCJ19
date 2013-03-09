package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.model.Agendamento;

@ManagedBean
@RequestScoped
public class FormAgendamentoMB {
	private Agendamento agendamento= new Agendamento();
	
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	
	public String salvarAgendamento() {
		// TODO Auto-generated method stub
		return "agendamento";
	}
	
	
}
