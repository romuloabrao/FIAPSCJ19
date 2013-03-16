package br.com.fiap.samf.mbeam;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.impl.TratamentoControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.mbean.utils.PickListConvenio;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class TratamentoMB {
	private Tratamento tratamento;
	private List<Tratamento> tratamentos;
	private PickListConvenio pKconvenios = new PickListConvenio(tratamento);
	private TratamentoControl control;
	
	public TratamentoMB() {
		control = new TratamentoControl();
	}
	
	@PostConstruct
	private void init(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		this.tratamento = doc !=null && this.tratamento.getClass().equals(doc.getClasse())? control.buscar((Long) doc.getCodigo()): new Tratamento();
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
