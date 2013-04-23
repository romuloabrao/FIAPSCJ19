package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.samf.control.PacienteControl;
import br.com.fiap.samf.model.Paciente;

@ManagedBean
@RequestScoped
public class PacienteMB{
	private Paciente paciente=new Paciente();
	private PacienteControl control;
	
	public PacienteMB() {
		control = new PacienteControl();
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
		return this.control.listar();
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
	
	public String remover(){
		Paciente item =(Paciente) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("paciente");
		control.remover(item);
		return "viewtratamento";
	}
	
	public boolean getRemovable(){
		Paciente item =(Paciente) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("paciente");
		return ((PacienteControl)control).validaDel(item);
	}
}
