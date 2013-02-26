package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Atendimento;
import br.com.fiap.samf.model.Paciente;

public class AtendimentoDAO extends GenericDAO<Atendimento>{

	@SuppressWarnings("unchecked")
	public AtendimentoDAO(EntityManager em) {
		super((Class<Atendimento>) new Atendimento().getClass(), em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listaProntuarioPaciente(Paciente p){
		return em.createNamedQuery("listaProntuarioPaciente")
		        .setParameter("pcodigo",p.getCodigo())
		        .getResultList();
	}

}
