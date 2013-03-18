package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.control.impl.MedicoControl;
import br.com.fiap.samf.control.impl.UsuarioControl;
import br.com.fiap.samf.model.Medico;

@ManagedBean
@RequestScoped
public class MedicoMB {
	private Medico med= new Medico();
	private List<Medico> medicos;
	private CrudControl<Medico> control;
	
	public MedicoMB() {
		this.control = new GenericCrudControl<Medico>(Medico.class);
	}
	
	public Medico getMed() {
		return med;
	}
	public void setMed(Medico med) {
		this.med = med;
	}
	
	public void salvar(){
		UsuarioControl uControl = new UsuarioControl();
		if(med.getCodigo().longValue()==0){
			med.setCodigo(null);
		}
		
		if(!uControl.verifica(med)){
			this.control.salvar(med);
		}
	}
	
	public List<Medico> getMedicos() {
		this.medicos = this.medicos == null? this.control.listar(): this.medicos;
		return medicos;
	}
	
	public boolean isNewDoc(){
		return med.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
	public String editar() {
		return "medico";
	}
	
	
	
}
