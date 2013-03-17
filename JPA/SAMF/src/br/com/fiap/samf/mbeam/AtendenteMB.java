package br.com.fiap.samf.mbeam;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.model.Atendente;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class AtendenteMB {
	private Atendente atend=new Atendente();
	private List<Atendente> atendentes;
	private CrudControl<Atendente> control;

	public AtendenteMB() {
		this.control = new GenericCrudControl<Atendente>(Atendente.class);
	}
	
	public Atendente getAtend() {
		return atend;
	}

	public void setAtend(Atendente atend) {
		this.atend = atend;
	}

	public void salvar() {
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc("atendente");
		if (doc != null && doc.getClasse().equals(Atendente.class)) {
			this.atend.setCodigo((Long) doc.getCodigo());
		}
		this.control.salvar(atend);
	}

	public String editar() {
		SessionManager.createSessionDoc(new DocumentSelectedMB(atend.getClass(), atend.getCodigo()),"atendente");
		return "atendente";
	}
	
	public void voltar() {
		SessionManager.destroySessionDoc("atendente");
	}

	public List<Atendente> getAtendentes() {
		atendentes = atendentes == null ? this.control.listar() : atendentes;
		return atendentes;
	}

	public boolean isNewDoc() {
		return atend.getCodigo() == null;
	}

	public String getAcao() {
		return this.isNewDoc() ? "salvar" : "atualizar";
	}
}
