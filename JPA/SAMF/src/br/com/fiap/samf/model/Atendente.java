package br.com.fiap.samf.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Usuario {
	private String nome;
	private String rg;
	
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

}