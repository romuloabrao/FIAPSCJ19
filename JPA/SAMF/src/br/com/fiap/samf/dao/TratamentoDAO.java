package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoDAO extends GenericDAO<Tratamento>{
	
	public TratamentoDAO(EntityManager em) {
		super(Tratamento.class, em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tratamento> listar(Long atendCod){
		return em.createNamedQuery("buscaTratamentosPorId")
				.setParameter("atcodigo", atendCod).getResultList();
	}
}
