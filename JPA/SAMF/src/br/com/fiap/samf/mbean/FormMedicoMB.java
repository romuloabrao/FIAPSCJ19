package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.MedicoControl;
import br.com.fiap.samf.model.Medico;
@ManagedBean
@RequestScoped
public class FormMedicoMB {
	private Medico med = new Medico();
	
	public Medico getMed() {
		return med;
	}
	public void setMed(Medico med) {
		this.med = med;
	}
	
	public String salvarMedico(){
		CrudControl<Medico> control = new MedicoControl(Medico.class);
		control.criar(med);
		return "medico";
	}
	
}
