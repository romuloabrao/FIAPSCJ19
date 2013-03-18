package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Agendamento;
import br.com.fiap.samf.model.Medico;

public class AgendamentoDAO extends GenericDAO<Agendamento> {

	public AgendamentoDAO(EntityManager em) {
		super(Agendamento.class, em);
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> listar(Medico m) {
		return em.createNamedQuery("buscaAgendamentoPorMedico")
				.setParameter("mcodigo", m.getCodigo()).getResultList();

	}

}
