package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.MedicoControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Medico;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class MedicoMB {
	private Medico med= new Medico();
	private List<Medico> medicos;
	private CrudControl<Medico> control;
	
	public MedicoMB() {
		this.control = new MedicoControl();
	}
	
	public Medico getMed() {
		return med;
	}
	public void setMed(Medico med) {
		this.med = med;
	}
	
	public void salvar(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc("medico");
		if (doc != null && doc.getClasse().equals(Medico.class)) {
			this.med.setCodigo((Long) doc.getCodigo());
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
	
	public String editar() {
		DocumentSelectedMB doc =new DocumentSelectedMB(med.getClass(), med.getCodigo());
		SessionManager.createSessionDoc(doc,"medico");
		return "medico";
	}
	
	
	
}
