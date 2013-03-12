package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> implements DAO<T> {

	protected EntityManager em;
	protected Class<T> classe;
	
	public GenericDAO(Class<T> classe, EntityManager em) {
		this.em = em;
		this.classe = classe;
	}
	
	@Override
	public T buscar(long id) {
		return em.find(classe, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		StringBuffer strb = new StringBuffer();
		strb.append("select items from "+classe.getName()+" items" );
		return em.createQuery(strb.toString()).getResultList();
	}

	@Override
	public void criar(T t) {
		em.persist(t);
	}
	
	@Override
	public void atualizar(T t) {
		em.merge(t);
	}

	@Override
	public void remover(T t) {
		em.remove(t);
	}



}
