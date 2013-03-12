package br.com.fiap.samf.control;

import java.util.List;

public interface CrudControl<T> {
	public T buscar(Long id);
	public List<T> listar();
	public void salvar(T t);
	public void remover(T t);
}
