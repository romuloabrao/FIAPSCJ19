package br.com.fiap.samf.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Paciente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3415951304012484034L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private String nome;
	private String rg;
	private String cpf;
	@OneToOne
	private Convenio convenio;
	
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getRg() {
		return rg;
	}
	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	public Convenio getConvenio() {
		return convenio;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return cpf;
	}
}
