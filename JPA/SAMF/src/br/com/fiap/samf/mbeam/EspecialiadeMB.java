package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Especialidade;

@ManagedBean
@RequestScoped
public class EspecialiadeMB {
	private Especialidade especialidade=new Especialidade();
	private CrudControl<Especialidade> control;
	private List<Especialidade> especialidades;
	
	public EspecialiadeMB() {
		this.control =new GenericCrudControl<Especialidade>(Especialidade.class);
	}
	
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	
	public void salvar(){
		if(especialidade.getCodigo().longValue()==0){
			especialidade.setCodigo(null);
		}
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
	
	public String editar() {
		return "especialidade";
	}
}
