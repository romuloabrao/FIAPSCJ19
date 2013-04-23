package br.com.fiap.samf.mbeam;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.samf.control.TratamentoControl;
import br.com.fiap.samf.model.Tratamento;


@ManagedBean
@RequestScoped
public class TratamentoMB {
	private Tratamento tratamento=new Tratamento();
	private TratamentoControl control;
	
	public TratamentoMB() {
		control = new TratamentoControl();
	}

	public Tratamento getTratamento() {
		return tratamento;
	}
	
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	
	public void salvar(){
		if(tratamento.getCodigo().longValue()==0){
			tratamento.setCodigo(null);
		}
		control.salvar(tratamento);
	}
	
	public List<Tratamento> getTratamentos() {
		return control.listar();
	}
	
	public boolean isNewDoc(){
		return tratamento.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
	
	public String editar() {
		return "tratamento";
	}
	
	public String remover(){
		Tratamento t =(Tratamento) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("tratamento");
		control.remover(t);
		return "viewtratamento";
	}
	
	public boolean getRemovable(){
		Tratamento t =(Tratamento) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("tratamento");
		return control.validaDel(t);
	}
	
}
