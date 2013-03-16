package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Atendente;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.util.SessionManager;
@ManagedBean
@RequestScoped
public class MedicamentoMB {
	private Medicamento medicamento;
	private List<Medicamento> medicamentos;
	private CrudControl<Medicamento> control;
	
	public MedicamentoMB() {
		control = new GenericCrudControl<Medicamento>(Medicamento.class);
	}
	
	@PostConstruct
	private void init(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		this.medicamento = doc !=null && this.medicamento.getClass().equals(doc.getClasse())? control.buscar((Long) doc.getCodigo()): new Medicamento();
	}
	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void salvar(){
		control.salvar(medicamento);
	}
	
	public List<Medicamento> getMedicamentos() {
		this.medicamentos = this.medicamentos == null? this.control.listar():this.medicamentos;
		return medicamentos;
	}
	
	public boolean isNewDoc(){
		return medicamento.getCodigo()== null;
	}
	
	public String getAcao(){
		return this.isNewDoc()?"Salvar":"Atualizar";
	}
}
