package br.com.fiap.samf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import br.com.fiap.samf.model.Tratamento;

@Entity
public class Convenio implements  Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 51594201944092152L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	private String nome;
	@ManyToMany(cascade={CascadeType.ALL})
	/*@JoinTable(name="ConvenioTratamento",
				joinColumns={@JoinColumn(name="codigoConvenio",referencedColumnName="codigo")}, 
				inverseJoinColumns={@JoinColumn(name="codigoTratamento",referencedColumnName="codigo")})*/
	private List<Tratamento> tratamentosAutorizados;
	

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
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
	
	public boolean equals(Object object){
		if(object instanceof Convenio && this.getCodigo()!=null){
			return this.codigo==((Convenio)object).getCodigo();
		}
		return false;
	}
	
}
