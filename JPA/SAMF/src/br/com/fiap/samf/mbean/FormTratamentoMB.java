package br.com.fiap.samf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.impl.TratamentoControl;
import br.com.fiap.samf.mbean.picklist.PickListConvenio;
import br.com.fiap.samf.model.Tratamento;

@ManagedBean
@RequestScoped
public class FormTratamentoMB {
	private Tratamento tratamento = new Tratamento();
	private PickListConvenio pKconvenios = new PickListConvenio(tratamento);
	
	public Tratamento getTratamento() {
		return tratamento;
	}
	
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	public PickListConvenio getpKconvenios() {
		return pKconvenios;
	}
	
	public void setpKconvenios(PickListConvenio pKconvenios) {
		this.pKconvenios = pKconvenios;
	}
	
	public String salvarTratamento(){
		TratamentoControl control = new TratamentoControl();
		control.criar(tratamento,pKconvenios.getConvenios().getSource());
		return "tratamento";
	}
}
