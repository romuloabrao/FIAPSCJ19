package br.com.fiap.samf.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQuery(
		name="buscaMedicoPorEspecialidades",
		query="SELECT m FROM Medico m INNER JOIN m.especialidades e WHERE e.id = :ecodigo")
@Entity
@DiscriminatorValue("MEDICO")
public class Medico extends Usuario {
	private String crm;
	private String nome;
	private String rg;
	@OneToMany
	private List<Especialidade> especialidades;
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
