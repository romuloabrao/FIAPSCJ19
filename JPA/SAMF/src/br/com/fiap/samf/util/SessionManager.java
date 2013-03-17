package br.com.fiap.samf.util;

import javax.faces.context.FacesContext;

public class SessionManager {


	public static Object getSessionDoc(String s) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(s);
	}

	public static void createSessionDoc(Object value,String s) {
		if (SessionManager.getSessionDoc(s) != null) {
			SessionManager.destroySessionDoc(s);
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(s, value);
	}

	public static Object destroySessionDoc(String s) {
		if (SessionManager.getSessionDoc(s) != null) {
			return FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().remove(s);
		}
		return null;
	}
}
