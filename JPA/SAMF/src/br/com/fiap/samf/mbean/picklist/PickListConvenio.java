package br.com.fiap.samf.mbean.picklist;

import java.util.ArrayList;
import java.util.List;


import org.primefaces.model.DualListModel;  

import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Convenio;
import br.com.fiap.samf.model.Tratamento;
public class PickListConvenio {  
  
    List<Convenio> itensConveniados = null;  
    List<Convenio> itensNConveniados = null; 
    private DualListModel<Convenio> convenios;  
  
    public PickListConvenio(Tratamento tratamento) {  
    	this.itensNConveniados = new GenericCrudControl<Convenio>(Convenio.class).listar();
    	if(tratamento.getListaConvenio()==null){
        	this.itensConveniados = new ArrayList<Convenio>();
        }else{
        	this.itensConveniados = tratamento.getListaConvenio();
        }
        this.itensNConveniados.removeAll(this.itensConveniados);
        convenios = new DualListModel<Convenio>(this.itensConveniados, this.itensNConveniados);  
    }
    
    public void setConvenios(DualListModel<Convenio> convenios) {
		this.convenios = convenios;
	}
    
    public DualListModel<Convenio> getConvenios() {
		return convenios;
	}
    
}  