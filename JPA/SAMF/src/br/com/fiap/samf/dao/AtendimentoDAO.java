package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Atendimento;
import br.com.fiap.samf.model.Paciente;

public class AtendimentoDAO extends GenericDAO<Atendimento>{

	public AtendimentoDAO(EntityManager em) {
		super(Atendimento.class, em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listaProntuarioPaciente(Paciente p){
		return em.createNamedQuery("listaProntuarioPaciente")
		        .setParameter("pcodigo",p.getCodigo())
		        .getResultList();
	}
	
	public void limpaListaMedicamento(Atendimento at){
		em.createNativeQuery("DELETE FROM atendimento_medicamento WHERE Atendimento_codigo= ?1 ;")
		        .setParameter(1,at.getCodigo())
		        .executeUpdate();
	}
	
	public void limpaListaTratamento(Atendimento at){
		em.createNativeQuery("DELETE FROM atendimento_tratamento WHERE Atendimento_codigo= ?1 ;")
		        .setParameter(1,at.getCodigo())
		        .executeUpdate();
	}
	

}
