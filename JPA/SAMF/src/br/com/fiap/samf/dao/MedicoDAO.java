package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.model.Medico;

public class MedicoDAO extends GenericDAO<Medico> {

	public MedicoDAO( EntityManager em) {
		super(Medico.class, em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> listar(Especialidade esp){
		return em.createNamedQuery("buscaMedicoPorEspecialidades")
        .setParameter("ecodigo", esp.getCodigo())
        .getResultList();
	}
	
}
