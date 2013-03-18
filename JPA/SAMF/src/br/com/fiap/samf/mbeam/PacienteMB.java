package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Paciente;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class PacienteMB{
	private Paciente paciente=new Paciente();
	private CrudControl<Paciente> control;
	private List<Paciente> pacientes;
	
	public PacienteMB() {
		control = new GenericCrudControl<Paciente>(Paciente.class);
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public boolean validaPacinente(){
		return true;
	}
	
	public void salvar(){
		if(paciente.getCodigo().longValue()==0){
			paciente.setCodigo(null);
		}
		this.control.salvar(this.paciente);
	}
	
	public List<Paciente> getPacientes() {
		this.pacientes = this.pacientes == null? this.control.listar(): this.pacientes;
		return pacientes;
	}
	public boolean isNewDoc(){
		return paciente.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
	public String editar() {
		return "paciente";
	}
}
