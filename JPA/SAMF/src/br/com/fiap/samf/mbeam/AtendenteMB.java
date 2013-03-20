package br.com.fiap.samf.mbeam;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Atendente;

@ManagedBean
@RequestScoped
public class AtendenteMB {
	private Atendente atend=new Atendente();
	private CrudControl<Atendente> control;

	public AtendenteMB() {
		this.control = new GenericCrudControl<Atendente>(Atendente.class);
	}
	
	public Atendente getAtend() {
		return atend;
	}

	public void setAtend(Atendente atend) {
		this.atend = atend;
	}

	public void salvar() {
		if(atend.getCodigo().longValue()==0){
			atend.setCodigo(null);
		}
		this.control.salvar(atend);
	}

	public String editar() {
		return "atendente";
	}

	public List<Atendente> getAtendentes() {
		return this.control.listar();
	}

	public boolean isNewDoc() {
		return atend.getCodigo() == null;
	}

	public String getAcao() {
		return this.isNewDoc() ? "salvar" : "atualizar";
	}
}
