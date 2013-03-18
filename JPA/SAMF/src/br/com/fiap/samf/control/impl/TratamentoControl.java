package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.TratamentoDAO;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoControl extends GenericCrudControl<Tratamento>{
	
	public TratamentoControl() {
		super(Tratamento.class,TratamentoDAO.class);
	}

	public List<Tratamento> listar(Long codigo) {
		return ((TratamentoDAO)dao).listar(codigo);
	}
	
	
	

}
