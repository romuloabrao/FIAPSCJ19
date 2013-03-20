package br.com.fiap.samf.control.impl;

import br.com.fiap.samf.dao.DAOValidator;
import br.com.fiap.samf.model.Paciente;

public class PacienteControl extends GenericCrudControl<Paciente>{
	
	public PacienteControl() {
		super(Paciente.class);
	}
	
	public boolean validaDel(Paciente p){
		DAOValidator<Paciente> vdao = new DAOValidator<Paciente>(em);
		return vdao.checkDelete(p);
	}

}
