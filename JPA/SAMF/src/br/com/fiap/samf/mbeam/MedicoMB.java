package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.MedicoControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.util.SessionDocManager;
@ManagedBean(name="FormMedicoMB")
@RequestScoped
public class MedicoMB {
	private Medico med = new Medico();
	private List<Medico> medicos;
	private CrudControl<Medico> control;
	
	public MedicoMB() {
		this.control = new MedicoControl(Medico.class);
	}
	public Medico getMed() {
		return med;
	}
	public void setMed(Medico med) {
		this.med = med;
	}
	
	public void salvar(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionDocManager.getSessionDoc();
		if (doc != null && doc.getClasse().equals(med.getClass())) {
			this.med.setCodigo((Long) doc.getCodigo());
			SessionDocManager.destroySessionDoc();
		}
		this.control.salvar(med);
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
	
	
	
}
