
package br.com.fiap.samf.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
@NamedQuery(
		name="LazyTratamentoConvenio",
		query="select t from Tratamento t INNER JOIN t.listaConvenio WHERE t.codigo = :ccodigo")
@Entity
public class Tratamento implements BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2298977466305464044L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	private double valor;
	private String nome;
	@ManyToOne
	private Especialidade especialidade;
	@ManyToMany(cascade={CascadeType.ALL})
	private Collection<Convenio> listaConvenio;

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

	public void setListaConvenio(Collection<Convenio> listaConvenio) {
		this.listaConvenio = listaConvenio;
	}

	public Collection<Convenio> getListaConvenio() {
		return listaConvenio;
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
