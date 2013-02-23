package br.com.fiap.samf.control;

import java.util.List;

public interface CrudControl<T> {
	public T buscar(long id);
	public List<T> listar();
	public void criar(T t);
	public void remover(T t);
}
