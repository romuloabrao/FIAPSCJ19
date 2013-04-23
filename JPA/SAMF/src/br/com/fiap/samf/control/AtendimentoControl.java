package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.AtendimentoDAO;
import br.com.fiap.samf.model.Atendimento;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.util.EMF;

public class AtendimentoControl{
	
	private EntityManager em;
	
	public AtendimentoControl() {
		this.em=EMF.createEntityManager();
	}
	
	public Atendimento buscar(Long id) {
		AtendimentoDAO dao = new AtendimentoDAO(em);
		em.getTransaction().begin();
		Atendimento t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<Atendimento> listar() {
		AtendimentoDAO dao = new AtendimentoDAO(em);
		em.getTransaction().begin();
		List<Atendimento> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void remover(Atendimento t) {
		AtendimentoDAO dao = new AtendimentoDAO(em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}

	public void salvar(Atendimento atendimento) {
		AtendimentoDAO dao = new AtendimentoDAO(em);
		em.getTransaction().begin();
		//limpaListas(atendimento);
		atendimento.setCodigo(atendimento.getAgendamento().getCodigo());
		if (atendimento.getMedicamentos() != null
				&& !atendimento.getMedicamentos().isEmpty()) {
			validaAtendimentoMedicamento(atendimento.getMedicamentos());
		}
		if (atendimento.getTratamentos() != null
				&& !atendimento.getTratamentos().isEmpty()) {
			validaAtendimentoTratamento(atendimento.getTratamentos());
		}
		if (dao.buscar(atendimento.getCodigo()) == null) {
			dao.criar(atendimento);
		} else {
			dao.atualizar(atendimento);
		}
		em.getTransaction().commit();
	}

	public void validaAtendimentoMedicamento(List<Medicamento> listas) {

		for (Medicamento medicamento : listas) {
			medicamento = em.getReference(Medicamento.class,
					medicamento.getCodigo());
		}
	}

	public void validaAtendimentoTratamento(List<Tratamento> listas) {
		for (Tratamento tratamento : listas) {
			tratamento = em.getReference(Tratamento.class,
					tratamento.getCodigo());
		}
	}

}
