package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.samf.model.Usuario;
import br.com.fiap.samf.util.ValidacaoLogin;

@ManagedBean
@SessionScoped
public class SessionUser {
	private Usuario user = new Usuario();
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public String Login(){
		this.user = ValidacaoLogin.validar(user);
		return user != null? "home": "erro";
	}
	
}
