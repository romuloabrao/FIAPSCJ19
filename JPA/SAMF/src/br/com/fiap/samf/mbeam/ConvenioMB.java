package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class ConvenioMB {
	public Convenio convenio=new Convenio();
	public CrudControl<Convenio> control;
	private List<Convenio> convenios;
	
	public ConvenioMB() {
		control = new GenericCrudControl<Convenio>(Convenio.class);
	}
	
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	public Convenio getConvenio() {
		return convenio;
	}
	
	public void salvar(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.getSessionDoc(SessionManager.Beam.DOCITEM);
		if (doc != null && doc.getClasse().equals(convenio.getClass())) {
			this.convenio.setCodigo((Long) doc.getCodigo());
			SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		}
		this.control.salvar(this.convenio);
	}
	
	public String editar() {
		SessionManager.createSessionDoc(new DocumentSelectedMB(convenio.getClass(), convenio.getCodigo()),SessionManager.Beam.DOCITEM);
		return "convenios";
	}
	
	public List<Convenio> getConvenios(){
		convenios = convenios == null? this.control.listar():convenios;
		return convenios;
	}
	
	public boolean isNewDoc(){
		return convenio.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
}
