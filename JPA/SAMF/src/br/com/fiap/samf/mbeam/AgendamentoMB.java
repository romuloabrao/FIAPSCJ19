package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.model.Agendamento;

@ManagedBean(name="FormAgendamentoMB")
@RequestScoped
public class AgendamentoMB {
	private Agendamento agendamento= new Agendamento();
	private List<Agendamento> agendamentos;
	
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public Agendamento getAgendamento() {
		return agendamento;
	}
	
	public String salvar() {
		// TODO Auto-generated method stub
		return "agendamento";
	}
	
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	
	public boolean isNewDoc(){
		return agendamento.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
}
