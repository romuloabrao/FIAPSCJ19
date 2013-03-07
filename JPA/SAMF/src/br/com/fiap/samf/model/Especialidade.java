package br.com.fiap.samf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidade  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4828761654376294552L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	private String nome;
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public boolean equals(Object object){
		if(object instanceof Especialidade && this.getCodigo()!=null){
			return this.codigo==((Especialidade)object).getCodigo();
		}
		return false;
	}
	
}
