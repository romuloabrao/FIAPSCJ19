package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Medicamento;

public class MedicamentoDAO extends GenericDAO<Medicamento> {

	public MedicamentoDAO(EntityManager em) {
		super(Medicamento.class, em);
	}

	@SuppressWarnings("unchecked")
	public List<Medicamento> listar(Long atendCod) {
		return em.createNamedQuery("buscaMedicamentosPorId")
				.setParameter("atcodigo", atendCod).getResultList();
	}

}
