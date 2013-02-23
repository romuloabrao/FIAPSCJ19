package br.com.fiap.samf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tratamento{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private double valor;
	private String nome;
	@ManyToOne
	private Especialidade especialidade;
	@ManyToMany(mappedBy="tratamentosAutorizados")
	private List<Convenio> listaConvenio;
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	
	public void setListaConvenio(List<Convenio> listaConvenio) {
		this.listaConvenio = listaConvenio;
	}
	
	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}
}
