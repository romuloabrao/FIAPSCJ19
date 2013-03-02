package br.com.fiap.samf.mbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Paciente;

@ManagedBean
@RequestScoped
public class FormPacienteMB{
	private Paciente paciente= new Paciente();
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public boolean validaPacinente(){
		return true;
	}
	
	public void salvarPaciente(){
		CrudControl<Paciente> control = new GenericCrudControl<Paciente>(Paciente.class);
		control.criar(this.paciente);
	}
}
