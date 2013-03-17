package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.util.SessionManager;
@ManagedBean
@RequestScoped
public class MedicamentoMB {
	private Medicamento medicamento=new Medicamento();
	private List<Medicamento> medicamentos;
	private CrudControl<Medicamento> control;
	
	public MedicamentoMB() {
		control = new GenericCrudControl<Medicamento>(Medicamento.class);
	}
	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void salvar(){
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc("medicamento");
		if (doc != null && doc.getClasse().equals(Medicamento.class)) {
			this.medicamento.setCodigo((Long) doc.getCodigo());
		}
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
	
	public String editar() {
		SessionManager.createSessionDoc(new DocumentSelectedMB(medicamento.getClass(), medicamento.getCodigo()),"medicamento");
		return "medicamento";
	}

	public void voltar() {
		SessionManager.destroySessionDoc("medicamento");
	}
}
