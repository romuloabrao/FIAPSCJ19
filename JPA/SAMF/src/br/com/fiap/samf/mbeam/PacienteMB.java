package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Paciente;
import br.com.fiap.samf.util.SessionDocManager;

@ManagedBean(name="FormPacienteMB")
@RequestScoped
public class PacienteMB{
	private Paciente paciente= new Paciente();
	private List<Paciente> pacientes;
	private CrudControl<Paciente> control;
	
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
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionDocManager.getSessionDoc();
		if (doc != null && doc.getClasse().equals(paciente.getClass())) {
			this.paciente.setCodigo((Long) doc.getCodigo());
			SessionDocManager.destroySessionDoc();
		}
		this.control.salvar(this.paciente);
	}
	
	public List<Paciente> getPacientes() {
		pacientes = pacientes == null? control.listar():pacientes;
		return pacientes;
	}
	public boolean isNewDoc(){
		return paciente.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
}
