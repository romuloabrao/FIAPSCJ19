package br.com.fiap.samf.mbeam;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.samf.control.impl.TratamentoControl;
import br.com.fiap.samf.model.Tratamento;


@ManagedBean
@RequestScoped
public class TratamentoMB {
	private Tratamento tratamento=new Tratamento();
	private List<Tratamento> tratamentos;
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
		return "tratamento";
	}
	
}
