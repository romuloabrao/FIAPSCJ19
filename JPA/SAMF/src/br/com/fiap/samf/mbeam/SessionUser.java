package br.com.fiap.samf.mbeam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.samf.control.UsuarioControl;
import br.com.fiap.samf.model.Admin;
import br.com.fiap.samf.model.Atendente;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.model.Usuario;

@ManagedBean(name="sessionUser")
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
		UsuarioControl control = new UsuarioControl();
		user = control.logar(this.user);
		return user != null? "home": "erro";
	}
	
	public String getNomeCargo(){
		return user.getClass().getSimpleName();
	}
	
	public boolean isLoggedIn(){
		return user instanceof Medico || user instanceof Atendente || user instanceof Admin;
	}
}
