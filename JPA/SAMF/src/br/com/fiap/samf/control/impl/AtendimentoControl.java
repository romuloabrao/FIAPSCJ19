package br.com.fiap.samf.control.impl;

import java.util.List;

import br.com.fiap.samf.dao.AtendimentoDAO;
import br.com.fiap.samf.model.Atendimento;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.model.Tratamento;

public class AtendimentoControl extends GenericCrudControl<Atendimento> {

	public AtendimentoControl() {
		super(Atendimento.class, AtendimentoDAO.class);
	}

	public void salvar(Atendimento atendimento) {
		em.getTransaction().begin();
		//limpaListas(atendimento);
		atendimento.setCodigo(atendimento.getAgendamento().getCodigo());
		if (atendimento.getMedicamentos() != null
				&& !atendimento.getMedicamentos().isEmpty()) {
			validaAtendimentoMedicamento(atendimento.getMedicamentos());
		}
		if (atendimento.getTratamentos() != null
				&& !atendimento.getTratamentos().isEmpty()) {
			validaAtendimentoTratamento(atendimento.getTratamentos());
		}
		if (dao.buscar(atendimento.getCodigo()) == null) {
			dao.criar(atendimento);
		} else {
			dao.atualizar(atendimento);
		}
		em.getTransaction().commit();
	}

	public void validaAtendimentoMedicamento(List<Medicamento> listas) {
		for (Medicamento medicamento : listas) {
			medicamento = em.getReference(Medicamento.class,
					medicamento.getCodigo());
		}
	}

	public void validaAtendimentoTratamento(List<Tratamento> listas) {
		for (Tratamento tratamento : listas) {
			tratamento = em.getReference(Tratamento.class,
					tratamento.getCodigo());
		}
	}

}
