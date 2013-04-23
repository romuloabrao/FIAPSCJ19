package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.DAOValidator;
import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.model.Paciente;
import br.com.fiap.samf.util.EMF;

public class PacienteControl{
	
	protected EntityManager em;
	
	public PacienteControl() {
		this.em=EMF.createEntityManager();
	}
		
	public Paciente buscar(Long id) {
		GenericDAO<Paciente> dao = new GenericDAO<>(Paciente.class,em);
		em.getTransaction().begin();
		Paciente t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<Paciente> listar() {
		GenericDAO<Paciente> dao = new GenericDAO<>(Paciente.class,em);
		em.getTransaction().begin();
		List<Paciente> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void salvar(Paciente t) {
		GenericDAO<Paciente> dao = new GenericDAO<>(Paciente.class,em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Paciente.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}

	public void remover(Paciente t) {
		GenericDAO<Paciente> dao = new GenericDAO<>(Paciente.class,em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
	
	public boolean validaDel(Paciente p){
		DAOValidator<Paciente> vdao = new DAOValidator<Paciente>(em);
		return vdao.checkDelete(p);
	}

}
