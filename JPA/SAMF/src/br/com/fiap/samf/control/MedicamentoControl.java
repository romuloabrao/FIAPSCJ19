package br.com.fiap.samf.control;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.fiap.samf.dao.MedicamentoDAO;
import br.com.fiap.samf.model.Medicamento;
import br.com.fiap.samf.util.EMF;

public class MedicamentoControl{

	protected EntityManager em;
	
	public MedicamentoControl() {
		this.em=EMF.createEntityManager();
	}
		
	public Medicamento buscar(Long id) {
		MedicamentoDAO dao = new MedicamentoDAO(em);
		em.getTransaction().begin();
		Medicamento t= dao.buscar(id);
		em.getTransaction().commit();
		return t;
	}

	public List<Medicamento> listar() {
		MedicamentoDAO dao = new MedicamentoDAO(em);
		em.getTransaction().begin();
		List<Medicamento> ts= dao.listar();
		em.getTransaction().commit();
		return ts;
	}

	public void salvar(Medicamento t) {
		MedicamentoDAO dao = new MedicamentoDAO(em);
		em.getTransaction().begin();
		if(t.getCodigo()!=null){
			em.getReference(Medicamento.class, t.getCodigo());
			dao.atualizar(t);
		}else{
			dao.criar(t);
		}
		em.getTransaction().commit();
	}

	public void remover(Medicamento t) {
		MedicamentoDAO dao = new MedicamentoDAO(em);
		em.getTransaction().begin();
		dao.remover(t);
		em.getTransaction().commit();
	}

	public List<Medicamento> listar(Long codigo) {
		MedicamentoDAO dao = new MedicamentoDAO(em);
		return dao.listar(codigo);
	}

}
