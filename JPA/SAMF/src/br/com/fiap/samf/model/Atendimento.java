package br.com.fiap.samf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
		@NamedQuery(name = "listaProntuarioPaciente", query = "SELECT at FROM Atendimento at INNER JOIN at.agendamento ag "
				+ "INNER JOIN ag.paciente p WHERE p.codigo = :pcodigo "),
		@NamedQuery(name = "buscaMedicamentosPorId", query = "SELECT m FROM Atendimento at INNER JOIN at.medicamentos m WHERE at.codigo= :atcodigo "),
		@NamedQuery(name = "buscaTratamentosPorId", query = "SELECT t FROM Atendimento at INNER JOIN at.tratamentos t WHERE at.codigo= :atcodigo ") })
@Entity
public class Atendimento implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -771671205968833629L;
	@Id
	private Long codigo;
	@OneToOne
	private Agendamento agendamento;
	private String descr;
	@OneToMany
	private List<Tratamento> tratamentos;
	@OneToMany
	private List<Medicamento> medicamentos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<Tratamento> getTratamentos() {
		return tratamentos;
	}

	public void setTratamentos(List<Tratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
