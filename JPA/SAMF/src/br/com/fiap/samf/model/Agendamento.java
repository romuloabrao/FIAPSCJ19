package br.com.fiap.samf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQuery(
		name="buscaAgendamentoPorMedico",
		query="SELECT ag FROM Agendamento ag INNER JOIN ag.medico m WHERE m.codigo = :mcodigo")
@Entity
public class Agendamento implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2364427602178672277L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	@ManyToOne(fetch=FetchType.EAGER)
	private Atendente atendente;
	@ManyToOne(fetch=FetchType.EAGER)
	private Medico medico;
	@ManyToOne(fetch=FetchType.EAGER)
	private Paciente paciente;
	private Date data;
	@ManyToOne(fetch=FetchType.EAGER)
	private Convenio convenio;
	@OneToOne(mappedBy="agendamento")
	private Atendimento atendimento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
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
		Agendamento other = (Agendamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
