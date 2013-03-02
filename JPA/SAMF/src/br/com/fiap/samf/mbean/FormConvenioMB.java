package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Convenio;

@ManagedBean
@RequestScoped
public class FormConvenioMB {
	public Convenio convenio=new Convenio();
	
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	public Convenio getConvenio() {
		return convenio;
	}
	
	public void salvarConvenio(){
		GenericCrudControl<Convenio> control = new GenericCrudControl<Convenio>(Convenio.class);
		control.criar(this.convenio);
	}
}
