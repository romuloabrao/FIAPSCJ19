package br.com.fiap.samf.control.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.dao.DAO;
import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.util.EMF;

public class GenericCrudControl<T> implements CrudControl<T>{
	protected EntityManager em;
	protected Class<T> classe;
	protected DAO<T> dao;
	
	/**
	 * Construtor automaticamente utiliza o {@link GenericDAO} para persistência
	 * 
	 * **/
	public GenericCrudControl(Class<T> classe) {
		this.em=EMF.createEntityManager();
		this.dao = new GenericDAO<>(classe, em);
		this.classe= classe;
	}
	
	/**
	 * Construtor utiliza a classe dao, desde que a mesma extenda para um {@link GenericDAO}
	 * somente um filho de {@link GenericCrudControl} pode chamar este construtor;
	 * **/
	protected GenericCrudControl(Class<T> classe,Class<? extends GenericDAO<T>> cldao){
		try {
			this.em=EMF.createEntityManager();
			Constructor<? extends GenericDAO<T>> constructor = cldao.getDeclaredConstructor(EntityManager.class);
			this.dao = (DAO<T>) constructor.newInstance(em);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.classe= classe;
	}
		
	@Override
	public T buscar(long id) {
		em.getTransaction().begin();
		T t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	@Override
	public List<T> listar() {
		em.getTransaction().begin();
		List<T> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	@Override
	public void criar(T t) {
		em.getTransaction().begin();
		dao.criar(t);
		em.getTransaction().commit();
	}

	@Override
	public void remover(T t) {
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}

}
