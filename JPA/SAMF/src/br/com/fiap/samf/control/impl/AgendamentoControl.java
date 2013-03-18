package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.AgendamentoDAO;
import br.com.fiap.samf.model.Agendamento;
import br.com.fiap.samf.model.Medico;

public class AgendamentoControl extends GenericCrudControl<Agendamento> {

	public AgendamentoControl() {
		super(Agendamento.class, AgendamentoDAO.class);
	}
	
	public List<Agendamento> listar(Medico m){
		return ((AgendamentoDAO)dao).listar(m);
	}

}
