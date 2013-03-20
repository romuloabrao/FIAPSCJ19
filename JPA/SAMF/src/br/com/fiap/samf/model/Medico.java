package br.com.fiap.samf.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
		@NamedQuery(name = "buscaMedicoPorEspecialidades", query = "SELECT m FROM Medico m INNER JOIN m.especialidades e WHERE e.codigo = :ecodigo"),
		@NamedQuery(name = "validaMedico", query = "SELECT ag FROM Agendamento ag INNER JOIN ag.medico m WHERE m.codigo= :codigo") })
@Entity
@DiscriminatorValue("MEDICO")
public class Medico extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7336533739947954626L;

	private String crm;

	private String rg;
	@OneToMany
	private List<Especialidade> especialidades;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

}
