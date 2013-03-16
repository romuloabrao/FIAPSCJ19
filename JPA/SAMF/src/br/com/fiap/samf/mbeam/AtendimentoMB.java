package br.com.fiap.samf.mbeam;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.mbean.utils.DocumentSelectedMB;
import br.com.fiap.samf.util.SessionManager;

@ManagedBean
@RequestScoped
public class AtendimentoMB {
	@PostConstruct
	private void init(){
		SessionUser su = (SessionUser) SessionManager.getSessionDoc(SessionManager.Beam.SESSION);
		DocumentSelectedMB doc = (DocumentSelectedMB) SessionManager.destroySessionDoc(SessionManager.Beam.DOCITEM);
		
	}
}
