package br.com.fiap.samf.mbeam;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.fiap.samf.model.Atendimento;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.control.AtendimentoControl;

import javax.faces.component.html.HtmlSelectOneMenu;

@ManagedBean
@SessionScoped
public class AtendimentoMB {
	private Atendimento atendimento=new Atendimento();
	private AtendimentoControl control;
	
	//Campos
	private Medicamento campoMedicamento;
	private Tratamento campoTratamento;
	
	public AtendimentoMB() {
		this.control = new AtendimentoControl();
	}
	
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	
	public List<Atendimento> getAtendimentos() {
		return this.control.listar();
	}
	
	public String salvar(){
		if(atendimento.getCodigo().longValue()==0){
			atendimento.setCodigo(null);
		}
		control.salvar(atendimento);
		return "atendimento";
	}
	
	public void handleMedicamento(AjaxBehaviorEvent evt){
		HtmlSelectOneMenu select = (HtmlSelectOneMenu) evt.getComponent();
		if(select.getValue() instanceof Medicamento){
			this.campoMedicamento=(Medicamento)select.getValue();
		}else{
			this.campoMedicamento=null;
		}
	}
	
	public void handleListMedicamento(AjaxBehaviorEvent evt){
		if( this.atendimento.getMedicamentos() == null){
			this.atendimento.setMedicamentos(new ArrayList<Medicamento>());
		}
		if(campoMedicamento!=null){
			if(!this.atendimento.getMedicamentos().contains(campoMedicamento)){
				this.atendimento.getMedicamentos().add(campoMedicamento);
			}
		}
	}
	
	public void handleTratamento(AjaxBehaviorEvent evt){
		HtmlSelectOneMenu select = (HtmlSelectOneMenu) evt.getComponent();
		if(select.getValue() instanceof Tratamento){
			this.campoTratamento=(Tratamento)select.getValue();
		}else{
			this.campoTratamento=null;
		}
	}
	
	public void handleListTratamento(AjaxBehaviorEvent evt){
		if( this.atendimento.getTratamentos() == null){
			this.atendimento.setTratamentos(new ArrayList<Tratamento>());
		}
		if(campoMedicamento!=null){
			if(!this.atendimento.getTratamentos().contains(campoTratamento)){
				this.atendimento.getTratamentos().add(campoTratamento);
			}
		}
	}
}
