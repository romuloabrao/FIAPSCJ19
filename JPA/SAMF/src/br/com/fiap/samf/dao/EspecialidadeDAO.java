package br.com.fiap.samf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.samf.model.Especialidade;

public class EspecialidadeDAO extends GenericDAO<Especialidade> {

	public EspecialidadeDAO(EntityManager em) {
		super(Especialidade.class, em);
	}

	@SuppressWarnings("unchecked")
	public List<Especialidade> listar(Long[] args) {
		StringBuffer JPQLQuery = new StringBuffer();
		JPQLQuery.append("SELECT e FROM Especialidade e WHERE");
		for (int i = 0; i < args.length; i++) {
			if (i > 0) {
				JPQLQuery.append(" OR");
			}
			JPQLQuery.append(" e.codigo = " + args[i]);
		}
		return em.createQuery(JPQLQuery.toString()).getResultList();
	}

}
