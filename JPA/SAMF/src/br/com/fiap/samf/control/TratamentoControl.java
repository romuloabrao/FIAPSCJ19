package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.samf.dao.DAOValidator;
import br.com.fiap.samf.dao.GenericDAO;
import br.com.fiap.samf.dao.TratamentoDAO;
import br.com.fiap.samf.model.Tratamento;
import br.com.fiap.samf.util.EMF;

public class TratamentoControl{
	
	protected EntityManager em;

	/**
	 * Construtor automaticamente utiliza o {@link GenericDAO} para persist�ncia
	 * 
	 * **/
	public TratamentoControl() {
		this.em=EMF.createEntityManager();
	}
		

	public Tratamento buscar(Long id) {
		TratamentoDAO dao = new TratamentoDAO(em);
		em.getTransaction().begin();
		Tratamento t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}


	public List<Tratamento> listar() {
		TratamentoDAO dao = new TratamentoDAO(em);
		em.getTransaction().begin();
		List<Tratamento> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}


	public void salvar(Tratamento t) {
		TratamentoDAO dao = new TratamentoDAO(em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Tratamento.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}


	public void remover(Tratamento t) {
		TratamentoDAO dao = new TratamentoDAO(em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}


	public List<Tratamento> listar(Long codigo) {
		TratamentoDAO dao = new TratamentoDAO(em);
		return dao.listar(codigo);
	}
	
	public boolean validaDel(Tratamento t){
		DAOValidator<Tratamento> vdao = new DAOValidator<Tratamento>(em);
		return vdao.checkDelete(t);
	}

}
