package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.impl.TratamentoControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.mbean.utils.PickListConvenio;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.util.SessionDocManager;

@ManagedBean(name="FormTratamentoMB")
@RequestScoped
public class TratamentoMB {
	private Tratamento tratamento = new Tratamento();
	private List<Tratamento> tratamentos;
	private PickListConvenio pKconvenios = new PickListConvenio(tratamento);
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
	
	public PickListConvenio getpKconvenios() {
		return pKconvenios;
	}
	
	public void setpKconvenios(PickListConvenio pKconvenios) {
		this.pKconvenios = pKconvenios;
	}
	
	public void salvar(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionDocManager.getSessionDoc();
		if (doc != null && doc.getClasse().equals(tratamento.getClass())) {
			this.tratamento.setCodigo((Long) doc.getCodigo());
			SessionDocManager.destroySessionDoc();
		}
		control.criar(tratamento,pKconvenios.getConvenios().getSource());
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
	
}
