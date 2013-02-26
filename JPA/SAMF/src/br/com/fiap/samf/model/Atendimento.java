package br.com.fiap.samf.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQuery(
		name="listaProntuarioPaciente",
		query="SELECT at FROM Atendimento at INNER JOIN at.agendamento ag " +
			  "INNER JOIN ag.paciente p WHERE p.codigo = :pcodigo ")
@Entity
public class Atendimento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	@OneToOne
	private Agendamento agendamento;
	private String descr;
	@ManyToOne
	private Convenio convenio;
	@OneToMany
	private List<Tratamento> tratamentos;
	@OneToMany
	private List<Medicamento> medicamentos;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
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
	public Convenio getConvenio() {
		return convenio;
	}
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
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
}
