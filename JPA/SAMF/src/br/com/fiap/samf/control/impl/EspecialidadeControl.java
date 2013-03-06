package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.model.Especialidade;

public class EspecialidadeControl extends GenericCrudControl<Especialidade> {
	
	public EspecialidadeControl(Class<Especialidade> classe) {
		super(classe);
	}
	
	public List<Especialidade> listar(Long[] args){
		return null;
		
	}
	
	
}
