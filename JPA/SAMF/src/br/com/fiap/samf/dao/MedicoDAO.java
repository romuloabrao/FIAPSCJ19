package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medico;

public class MedicoDAO extends GenericDAO<Medico> {

	@SuppressWarnings("unchecked")
	public MedicoDAO( EntityManager em) {
		super((Class<Medico>) new Medico().getClass(), em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> buscaMedicoPorEspecialidades(Especialidade esp){
		return em.createNamedQuery("buscaMedicoPorEspecialidades")
        .setParameter("ecodigo", esp.getId())
        .getResultList();
	}
	
}
