package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoControl extends GenericCrudControl<Tratamento>{

	public TratamentoControl() {
		super(Tratamento.class);
		
	}
	
	public void criar(Tratamento tratamento,List<Convenio> convenios){
		em.getTransaction().begin();
		for (Convenio conv: convenios){
			conv = em.getReference(Convenio.class, conv.getCodigo());
			conv.getTratamentosAutorizados().add(tratamento);
		}
		em.persist(tratamento);
		em.getTransaction().commit();
	}	

}
