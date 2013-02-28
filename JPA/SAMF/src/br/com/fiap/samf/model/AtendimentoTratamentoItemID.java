package br.com.fiap.samf.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AtendimentoTratamentoItemID implements Serializable {
	private static final long serialVersionUID = -8435745675272697438L;
	@ManyToOne
	private Atendimento atendimento;
	@ManyToOne
	private Tratamento tratamento;
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	public Tratamento getTratamento() {
		return tratamento;
	}
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	
}
