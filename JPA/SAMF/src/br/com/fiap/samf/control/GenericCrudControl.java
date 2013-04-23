package br.com.fiap.samf.control;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.DAO;
import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.model.BaseEntity;
import br.com.fiap.samf.util.EMF;

public class GenericCrudControl<T extends BaseEntity<?>>{
	protected EntityManager em;
	protected Class<T> classe;
	protected DAO<T> dao;
	
	/**
	 * Construtor automaticamente utiliza o {@link GenericDAO} para persist�ncia
	 * 
	 * **/
	public GenericCrudControl(Class<T> classe) {
		this.em=EMF.createEntityManager();
		this.dao = new GenericDAO<>(classe, em);
		this.classe= classe;
	}
		
	public T buscar(Long id) {
		em.getTransaction().begin();
		T t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<T> listar() {
		em.getTransaction().begin();
		List<T> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void salvar(T t) {
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(classe, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}

	public void remover(T t) {
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
}
