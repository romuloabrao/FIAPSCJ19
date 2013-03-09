package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoDAO extends GenericDAO<Tratamento>{
	
	public TratamentoDAO(EntityManager em) {
		super(Tratamento.class, em);
	}

	public void criar(Tratamento tratamento,List<Convenio> convenios){
		for (Convenio conv: convenios){
			conv = em.getReference(Convenio.class, conv.getCodigo());
			conv.getTratamentosAutorizados().add(tratamento);
		}
		em.persist(tratamento);
	}
}
