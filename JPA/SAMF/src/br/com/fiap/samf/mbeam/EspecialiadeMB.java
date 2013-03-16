package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Especialidade;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class EspecialiadeMB {
	private Especialidade especialidade;
	private CrudControl<Especialidade> control;
	private List<Especialidade> especialidades;
	
	public EspecialiadeMB() {
		this.control =new GenericCrudControl<Especialidade>(Especialidade.class);
	}
	
	@PostConstruct
	private void init(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		this.especialidade = doc !=null && this.especialidade.getClass().equals(doc.getClasse())? control.buscar((Long) doc.getCodigo()): new Especialidade();
	}
	
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	
	public void salvar(){
		this.control.salvar(especialidade);
	}
	
	public List<Especialidade> getEspecialidades(){
		especialidades = especialidades == null? this.control.listar():especialidades;
		return this.especialidades;
	}
	
	public boolean isNewDoc(){
		return especialidade.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
}
