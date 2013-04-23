package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.model.Atendente;
import br.com.fiap.samf.util.EMF;

public class AtendenteControl {
	private EntityManager em;
	
	public AtendenteControl() {
		this.em=EMF.createEntityManager();
	}
	
	public Atendente buscar(Long id) {
		GenericDAO<Atendente> dao = new GenericDAO<Atendente>(Atendente.class,em);
		em.getTransaction().begin();
		Atendente t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<Atendente> listar(){
		GenericDAO<Atendente> dao = new GenericDAO<Atendente>(Atendente.class,em);
		em.getTransaction().begin();
		List<Atendente> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void salvar(Atendente t) {
		GenericDAO<Atendente> dao = new GenericDAO<Atendente>(Atendente.class,em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Atendente.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}

	public void remover(Atendente t) {
		GenericDAO<Atendente> dao = new GenericDAO<Atendente>(Atendente.class,em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
}
