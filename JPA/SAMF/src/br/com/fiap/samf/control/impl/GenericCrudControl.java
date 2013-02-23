package br.com.fiap.samf.control.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.util.EMF;

public class GenericCrudControl<T> implements CrudControl<T>{
	protected EntityManager em;
	protected Class<T> classe;
	
	public GenericCrudControl(Class<T> classe) {
		this.em=EMF.createEntityManager();
		this.classe= classe;
	}
	
	@Override
	public T buscar(long id) {
		GenericDAO<T> dao = new GenericDAO<>(classe, em);
		em.getTransaction().begin();
		T t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	@Override
	public List<T> listar() {
		GenericDAO<T> dao = new GenericDAO<>(classe, em);
		em.getTransaction().begin();
		List<T> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	@Override
	public void criar(T t) {
		GenericDAO<T> dao = new GenericDAO<>(classe, em);
		em.getTransaction().begin();
		dao.criar(t);
		em.getTransaction().commit();
	}

	@Override
	public void remover(T t) {
		GenericDAO<T> dao = new GenericDAO<>(classe, em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}

}
