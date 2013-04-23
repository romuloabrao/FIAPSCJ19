package br.com.fiap.samf.control;


import javax.persistence.EntityManager;

import br.com.fiap.samf.dao.UsuarioDAO;
import br.com.fiap.samf.model.Usuario;
import br.com.fiap.samf.util.EMF;
import br.com.fiap.samf.util.ValidacaoLogin;

public class UsuarioControl{
	
	protected EntityManager em;
	
	public UsuarioControl() {
		this.em=EMF.createEntityManager();
	}

	public Usuario logar(Usuario user) {
		UsuarioDAO dao = new UsuarioDAO(em);
		ValidacaoLogin.validar(user);
		return dao.login(user);
	}
	
	public boolean verifica(Usuario user){
		UsuarioDAO dao = new UsuarioDAO(em);
		return dao.contem(user);
		
	}
		
}