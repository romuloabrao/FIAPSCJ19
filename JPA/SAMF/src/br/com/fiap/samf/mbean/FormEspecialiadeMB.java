package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Especialidade;

@ManagedBean
@RequestScoped
public class FormEspecialiadeMB {
	private Especialidade especialidade= new Especialidade();
	
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	
	public String salvarEspecialidade(){
		CrudControl<Especialidade> control = new GenericCrudControl<Especialidade>(Especialidade.class);
		control.criar(especialidade);
		return "especialidade";
	}
	
	public String novo(){
		this.especialidade = new Especialidade();
		return "especialidade";
	}
	
}
