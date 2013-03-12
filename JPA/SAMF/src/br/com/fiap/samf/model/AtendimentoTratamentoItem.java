package br.com.fiap.samf.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="atendimento_tratamento")
public class AtendimentoTratamentoItem implements BaseEntity<AtendimentoTratamentoItemID>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7021801389301814233L;

	@EmbeddedId
	private AtendimentoTratamentoItemID codigo;

	private boolean conviniable;
	
	public AtendimentoTratamentoItemID getCodigo() {
		return codigo;
	}
	public void setCodigo(AtendimentoTratamentoItemID codigo) {
		this.codigo = codigo;
	}
	public boolean isConviniable() {
		return conviniable;
	}
	public void setConviniable(boolean conviniable) {
		this.conviniable = conviniable;
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
		if (getClass() != obj.getClass())
			return false;
		AtendimentoTratamentoItem other = (AtendimentoTratamentoItem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
