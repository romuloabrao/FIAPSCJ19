package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Atendente;
@ManagedBean
@RequestScoped
public class FormAtendenteMB {
	private Atendente atend = new Atendente();
	
	public Atendente getAtend() {
		return atend;
	}
	public void setAtend(Atendente atend) {
		this.atend = atend;
	}
	public String salvarAtendente(){
		CrudControl<Atendente> control = new GenericCrudControl<Atendente>(Atendente.class);
		control.criar(this.atend);
		return null;
	}
}
