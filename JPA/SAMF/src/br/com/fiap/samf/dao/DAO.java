package br.com.fiap.samf.dao;

import java.util.List;

public interface DAO<T> {
	public T buscar(long id);
	public List<T> listar();
	public void criar(T t);
	public void remover(T t);
}
