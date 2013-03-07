import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.samf.control.CrudControl;
import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Medicamento;

@ManagedBean
@RequestScoped
public class FormMedicamentoMB {
	private Medicamento medicamento;
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public String salvarMedicamento(){
		CrudControl<Medicamento> control = new GenericCrudControl<Medicamento>(Medicamento.class);
		control.criar(medicamento);
		return "medicamento";
	}

}
