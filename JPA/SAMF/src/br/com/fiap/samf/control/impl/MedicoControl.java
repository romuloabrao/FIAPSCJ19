package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.DAOValidator;
import br.com.fiap.samf.dao.MedicoDAO;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medico;

public class MedicoControl extends GenericCrudControl<Medico>{

	public MedicoControl() {
		super(Medico.class , MedicoDAO.class);
	}
	
	public List<Medico> buscarMedicos(Especialidade esp){
		return ((MedicoDAO)dao).listar(esp);
	}
	
	public boolean validaDel(Medico m){
		DAOValidator<Medico> vdao = new DAOValidator<Medico>(em);
		return vdao.checkDelete(m);
	}

}
