package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.TratamentoDAO;
import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoControl extends GenericCrudControl<Tratamento>{
	
	public TratamentoControl() {
		super(Tratamento.class,TratamentoDAO.class);
	}
	
	public void salvar(Tratamento tratamento){
		em.getTransaction().begin();
		((TratamentoDAO)dao).criar(tratamento,(List<Convenio>) tratamento.getListaConvenio());
		em.getTransaction().commit();
	}

}
