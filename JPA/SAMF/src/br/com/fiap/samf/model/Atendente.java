package br.com.fiap.samf.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ATENDENTE")
public class Atendente extends Usuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = -471664313724018976L;
	private String rg;
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getRg() {
		return rg;
	}
}