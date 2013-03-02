package br.com.fiap.samf.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="atendimento_tratamento")
public class AtendimentoTratamentoItem {
	
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
	
}
