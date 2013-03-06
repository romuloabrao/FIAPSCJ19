package br.com.fiap.samf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Especialidade;

@ManagedBean
@ViewScoped
public class ViewEspecialidadeMB implements Serializable{

	/**
	 * 
	 */
	private List<Especialidade> especialidades;
	
	public ViewEspecialidadeMB() {
		GenericCrudControl<Especialidade> control = new GenericCrudControl<>(Especialidade.class);
		especialidades=control.listar();
	}
	
	private static final long serialVersionUID = -3856389051947194521L;

	public List<Especialidade> getEspecialidades(){
		return especialidades; 
	}
}
