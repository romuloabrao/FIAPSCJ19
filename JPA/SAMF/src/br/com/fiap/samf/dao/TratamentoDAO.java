package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoDAO extends GenericDAO<Tratamento>{
	
	public TratamentoDAO(EntityManager em) {
		super(Tratamento.class, em);
	}

	public void criar(Tratamento tratamento,List<Convenio> list){
		tratamento = tratamento.getCodigo()!= null? em.getReference(Tratamento.class, tratamento.getCodigo()):tratamento;
		for (Convenio conv: list){
			conv = em.getReference(Convenio.class, conv.getCodigo());
			conv.getTratamentosAutorizados().add(tratamento);
		}
		em.merge(tratamento);
	}
	
	public Tratamento buscar(Object id){
		System.out.println("teste");
		StringBuffer strb = new StringBuffer();
		strb.append("LazyTratamentoConvenio");
		return (Tratamento) em.createNamedQuery(strb.toString()).setParameter("ccodigo", id).getSingleResult();
	}
}
