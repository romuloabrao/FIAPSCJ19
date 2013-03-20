package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.BaseEntity;

public class DAOValidator< T extends BaseEntity<?>> {
	
	private EntityManager em;
	
	public DAOValidator(EntityManager em) {
		this.em= em;
	}
	
	@SuppressWarnings("unchecked")
	public boolean checkDelete(T t){
		t=(T) em.getReference(t.getClass(),t.getCodigo());
		List<T> ls = em.createNamedQuery("valida"+t.getClass().getSimpleName()).setParameter("codigo", t.getCodigo()).getResultList();
		return (ls.size()>0);
	}
}
