package br.com.fiap.samf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Convenio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private String nome;
	@ManyToMany
	/*@JoinTable(name="ConvenioTratamento",
				joinColumns={@JoinColumn(name="codigoConvenio",referencedColumnName="codigo")}, 
				inverseJoinColumns={@JoinColumn(name="codigoTratamento",referencedColumnName="codigo")})*/
	private List<Tratamento> tratamentosAutorizados;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTratamentosAutorizados(List<Tratamento> tratamentosAutorizados) {
		this.tratamentosAutorizados = tratamentosAutorizados;
	}
	
	public List<Tratamento> getTratamentosAutorizados() {
		return tratamentosAutorizados;
	}
	
}
