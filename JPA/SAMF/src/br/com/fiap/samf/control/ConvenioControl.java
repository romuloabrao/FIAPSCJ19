package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.DAO;
import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.model.BaseEntity;
import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.util.EMF;

public class ConvenioControl{
	private EntityManager em;
	
	public ConvenioControl() {
		this.em=EMF.createEntityManager();
	}
	

	public Convenio buscar(Long id) {
		GenericDAO<Convenio> dao = new GenericDAO<Convenio>(Convenio.class, em);
		em.getTransaction().begin();
		Convenio t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}


	public List<Convenio> listar() {
		GenericDAO<Convenio> dao = new GenericDAO<Convenio>(Convenio.class, em);
		em.getTransaction().begin();
		List<Convenio> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}


	public void salvar(Convenio t) {
		GenericDAO<Convenio> dao = new GenericDAO<Convenio>(Convenio.class, em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Convenio.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}


	public void remover(Convenio t) {
		GenericDAO<Convenio> dao = new GenericDAO<Convenio>(Convenio.class, em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
}
