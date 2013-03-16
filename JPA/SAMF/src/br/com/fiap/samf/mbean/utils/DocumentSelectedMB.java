package br.com.fiap.samf.mbean.utils;

/** manipula os documentos de Edição no formulário*/
public class DocumentSelectedMB {
	private Class<?> classe;
	private Object codigo;
	
	public DocumentSelectedMB() {
		// Default
	}
	
	public DocumentSelectedMB(Class<?> classe, Object codigo) {
		this.classe = classe;
		this.codigo = codigo;
	}

	public Class<?> getClasse() {
		return classe;
	}

	public void setClasse(Class<?> classe) {
		this.classe = classe;
	}

	public Object getCodigo() {
		return codigo;
	}

	public void setCodigo(Object codigo) {
		this.codigo = codigo;
	}
	
	
}
