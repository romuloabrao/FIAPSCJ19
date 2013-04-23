package br.com.fiap.samf.mbeam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.MedicamentoControl;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class MedicamentoMB {
	private Medicamento medicamento=new Medicamento();
	private List<Medicamento> medicamentos;
	private MedicamentoControl control;
	
	public MedicamentoMB() {
		control = new MedicamentoControl();
	}
	
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void salvar(){
		if(medicamento.getCodigo().longValue()==0){
			medicamento.setCodigo(null);
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
		return "medicamento";
	}

	public void voltar() {
		SessionManager.destroySessionDoc("medicamento");
	}
}
