package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.DAOValidator;
import br.com.fiap.samf.dao.TratamentoDAO;
import br.com.fiap.samf.model.Tratamento;

public class TratamentoControl extends GenericCrudControl<Tratamento>{
	
	public TratamentoControl() {
		super(Tratamento.class,TratamentoDAO.class);
	}

	public List<Tratamento> listar(Long codigo) {
		return ((TratamentoDAO)dao).listar(codigo);
	}
	
	
	public boolean validaDel(Tratamento t){
		DAOValidator<Tratamento> vdao = new DAOValidator<Tratamento>(em);
		return vdao.checkDelete(t);
	}

}
