package br.com.fiap.samf.control.impl;

import br.com.fiap.samf.dao.UsuarioDAO;
import br.com.fiap.samf.model.Usuario;
import br.com.fiap.samf.util.ValidacaoLogin;

public class UsuarioControl extends GenericCrudControl<Usuario>{

	public UsuarioControl() {
		super(Usuario.class, UsuarioDAO.class);
	}

	public Usuario logar(Usuario user) {
		ValidacaoLogin.validar(user);
		return ((UsuarioDAO)dao).login(user);
	}
	
	public boolean verifica(Usuario user){
		return ((UsuarioDAO)dao).contem(user);
		
	}
	
	
}