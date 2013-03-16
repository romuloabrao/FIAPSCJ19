package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.MedicoDAO;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medico;

public class MedicoControl extends GenericCrudControl<Medico>{

	public MedicoControl() {
		super(Medico.class , MedicoDAO.class);
	}
	/*
	public void criar(Tratamento tratamento,List<Convenio> list){
		em.getTransaction().begin();
		((TratamentoDAO)dao).criar(tratamento,list);
		em.getTransaction().commit();
	}*/
	
	public List<Medico> buscarMedicos(Especialidade esp){
		return ((MedicoDAO)dao).listar(esp);
	}

}
