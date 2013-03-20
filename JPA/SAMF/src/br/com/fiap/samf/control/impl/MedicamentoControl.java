package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.MedicamentoDAO;
import br.com.fiap.samf.model.Medicamento;

public class MedicamentoControl extends GenericCrudControl<Medicamento> {

	public MedicamentoControl() {
		super(Medicamento.class, MedicamentoDAO.class);
		// TODO Auto-generated constructor stub
	}

	public List<Medicamento> listar(Long codigo) {
		return ((MedicamentoDAO)dao).listar(codigo);
	}

}
