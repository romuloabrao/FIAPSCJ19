package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Paciente;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class PacienteMB{
	private Paciente paciente;
	private CrudControl<Paciente> control;
	private List<Paciente> pacientes;
	
	public PacienteMB() {
		control = new GenericCrudControl<Paciente>(Paciente.class);
	}
	
	@PostConstruct
	private void init(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		this.paciente = doc !=null && this.paciente.getClass().equals(doc.getClasse())? control.buscar((Long) doc.getCodigo()): new Paciente();
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
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.getSessionDoc(SessionManager.Beam.DOCITEM);
		if (doc != null && doc.getClasse().equals(paciente.getClass())) {
			this.paciente.setCodigo((Long) doc.getCodigo());
			SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
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
}
