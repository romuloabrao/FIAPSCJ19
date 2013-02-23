package br.com.fiap.samf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamento{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	private double valor;
	private String nome;
	private String fabricante;
	
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
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getFabricante() {
		return fabricante;
	}
}
