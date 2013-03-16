package br.com.fiap.samf.util;

import javax.faces.context.FacesContext;

public class SessionManager {


	public static enum Beam {
		DOCITEM("docItem"), SESSION("sessionUser");
		private String beam;

		private Beam(String b) {
			beam = b;
		}

		public String getBeam() {
			return beam;
		}
		
		@Override
		public String toString() {
			return this.getBeam();
		}
	}

	public static Object getSessionDoc(Enum<Beam> b) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(b.toString());
	}

	public static void createSessionDoc(Object value,Enum<Beam> b) {
		if (SessionManager.getSessionDoc(b) != null) {
			SessionManager.destroySessionDoc(b);
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(b.toString(), value);
	}

	public static Object destroySessionDoc(Enum<Beam> b) {
		if (SessionManager.getSessionDoc(b) != null) {
			return FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().remove(b.toString());
		}
		return null;
	}
}
