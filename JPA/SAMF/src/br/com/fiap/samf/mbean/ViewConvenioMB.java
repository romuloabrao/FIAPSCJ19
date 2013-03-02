package br.com.fiap.samf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Convenio;

@ManagedBean
@ViewScoped
public class ViewConvenioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3856389051947194521L;

	public List<Convenio> getConvenios(){
		GenericCrudControl<Convenio> control = new GenericCrudControl<>(Convenio.class);
		return control.listar();
	}
}
