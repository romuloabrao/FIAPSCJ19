package br.com.fiap.samf.util;

import br.com.fiap.samf.control.impl.UsuarioControl;
import br.com.fiap.samf.model.Usuario;

public class ValidacaoLogin {

	public static Usuario validar(Usuario user) {
		UsuarioControl control = new UsuarioControl();
		return control.logar(user);
	}
	
}
