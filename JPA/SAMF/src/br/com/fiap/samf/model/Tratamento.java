package br.com.fiap.samf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
public class Tratamento implements BaseEntity<Long> {
	/**
	 *SELECT m FROM Medico m INNER JOIN m.especialidades e WHERE e.codigo = :ecodigo
	 */
	private static final long serialVersionUID = 2298977466305464044L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	private double valor;
	private String nome;
	@ManyToOne
	private Especialidade especialidade;

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Tratamento))
			return false;
		Tratamento other = (Tratamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
