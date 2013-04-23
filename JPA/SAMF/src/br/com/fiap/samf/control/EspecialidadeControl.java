package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.fiap.samf.dao.EspecialidadeDAO;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.util.EMF;

public class EspecialidadeControl{
	
	protected EntityManager em;
	
	public EspecialidadeControl() {
		this.em=EMF.createEntityManager();
	}
	
	public Especialidade buscar(Long id) {
		EspecialidadeDAO dao = new EspecialidadeDAO(em);
		em.getTransaction().begin();
		Especialidade t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}


	public List<Especialidade> listar() {
		EspecialidadeDAO dao = new EspecialidadeDAO(em);
		em.getTransaction().begin();
		List<Especialidade> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}


	public void salvar(Especialidade t) {
		EspecialidadeDAO dao = new EspecialidadeDAO(em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Especialidade.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}


	public void remover(Especialidade t) {
		EspecialidadeDAO dao = new EspecialidadeDAO(em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
	
}
