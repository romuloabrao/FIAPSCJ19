package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.AgendamentoDAO;
import br.com.fiap.samf.model.Agendamento;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.util.EMF;

public class AgendamentoControl {

	private EntityManager em;
	
	public AgendamentoControl() {
		this.em=EMF.createEntityManager();
	}
		
	public Agendamento buscar(Long id) {
		AgendamentoDAO dao = new AgendamentoDAO(em);
		em.getTransaction().begin();
		Agendamento t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<Agendamento> listar() {
		AgendamentoDAO dao = new AgendamentoDAO(em);
		em.getTransaction().begin();
		List<Agendamento> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void salvar(Agendamento t) {
		AgendamentoDAO dao = new AgendamentoDAO(em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Agendamento.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}

	public void remover(Agendamento t) {
		AgendamentoDAO dao = new AgendamentoDAO(em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}
	
	public List<Agendamento> listar(Medico m){
		AgendamentoDAO dao = new AgendamentoDAO(em); 
		return dao.listar(m);
	}

}
