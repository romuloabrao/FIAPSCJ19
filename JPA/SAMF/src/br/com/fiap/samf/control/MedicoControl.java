package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.DAOValidator;
import br.com.fiap.samf.dao.MedicoDAO;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.util.EMF;

public class MedicoControl {
	
	protected EntityManager em;

	public MedicoControl() {
		this.em=EMF.createEntityManager();
	}
		
	public Medico buscar(Long id) {
		MedicoDAO dao = new MedicoDAO(em);
		em.getTransaction().begin();
		Medico t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<Medico> listar() {
		MedicoDAO dao = new MedicoDAO(em);
		em.getTransaction().begin();
		List<Medico> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void salvar(Medico t) {
		MedicoDAO dao = new MedicoDAO(em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Medico.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}

	public void remover(Medico t) {
		MedicoDAO dao = new MedicoDAO(em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
		
	public List<Medico> buscarMedicos(Especialidade esp){
		MedicoDAO dao = new MedicoDAO(em);
		return dao.listar(esp);
	}
	
	public boolean validaDel(Medico m){
		DAOValidator<Medico> vdao = new DAOValidator<Medico>(em);
		return vdao.checkDelete(m);
	}

}
