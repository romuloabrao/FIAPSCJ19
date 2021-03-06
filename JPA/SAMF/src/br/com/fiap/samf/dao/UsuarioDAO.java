package br.com.fiap.samf.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.fiap.samf.model.Usuario;
import br.com.fiap.samf.util.SessionManager;

public class UsuarioDAO extends GenericDAO<Usuario>{

	public UsuarioDAO(EntityManager em) {
		super(Usuario.class, em);
	}
	
	public Usuario login(Usuario usuario){
		try {
			Usuario userAut = (Usuario)em.createNamedQuery("validaUsuario").setParameter("uuser", usuario.getUser())
					.setParameter("usenha", usuario.getSenha())
					.getSingleResult();	
			return userAut;
		} catch (NoResultException e) {
			SessionManager.destroySessionDoc("sessionUser");
			return null;
			
		}
	}
	
	public boolean contem(Usuario usuario){
		return !em.createNamedQuery("verificaUsuario")
			.setParameter("uuser", usuario.getUser()).setParameter("ucodigo", usuario.getCodigo()).getResultList().isEmpty();
	}	

}
