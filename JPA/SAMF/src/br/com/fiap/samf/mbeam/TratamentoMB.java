package br.com.fiap.samf.mbeam;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.util.SessionManager;


@ManagedBean
@RequestScoped
public class TratamentoMB {
	private Tratamento tratamento=new Tratamento();
	private List<Tratamento> tratamentos;
	private CrudControl<Tratamento> control;
	
	public TratamentoMB() {
		control =new GenericCrudControl<>(Tratamento.class);
	}
	

	
	public Tratamento getTratamento() {
		return tratamento;
	}
	
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	
	public void salvar(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc("tratamento");
		if (doc != null && doc.getClasse().equals(Tratamento.class)) {
			this.tratamento.setCodigo((Long) doc.getCodigo());
		}
		control.salvar(tratamento);
	}
	
	public List<Tratamento> getTratamentos() {
		tratamentos = tratamentos == null?control.listar():tratamentos;
		return tratamentos;
	}
	
	public boolean isNewDoc(){
		return tratamento.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
	public String editar() {
		SessionManager.createSessionDoc(new DocumentSelectedMB(tratamento.getClass(), tratamento.getCodigo()),"tratamento");
		return "tratamento";
	}
	
}
