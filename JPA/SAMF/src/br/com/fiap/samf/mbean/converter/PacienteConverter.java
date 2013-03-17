package br.com.fiap.samf.mbean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.fiap.samf.control.impl.GenericCrudControl;
import br.com.fiap.samf.model.Paciente;

@FacesConverter(value="samf.PacienteConverter")
public class PacienteConverter implements Converter{
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null && !value.isEmpty()){
			try {
				return new GenericCrudControl<Paciente>(Paciente.class).buscar(Integer.valueOf(value).longValue());
			} catch (Exception e) {
				throw new ConverterException(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) throws ConverterException {
		if (value != null && value instanceof Paciente){
			return String.valueOf(((Paciente) value).getCodigo());  
		}
		return null;  
	}

}