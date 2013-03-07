package br.com.fiap.samf.mbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Tratamento;

@ManagedBean
@ViewScoped
public class ViewConvenioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3856389051947194521L;
	private List<Convenio> convenios;
	private GenericCrudControl<Convenio> control;
	
	public ViewConvenioMB() {
		this.control = new GenericCrudControl<>(Convenio.class);
	}
	
	public List<Convenio> getConvenios(){
		if(convenios == null){
			convenios = this.control.listar();
		}
		return convenios;
	}
}
