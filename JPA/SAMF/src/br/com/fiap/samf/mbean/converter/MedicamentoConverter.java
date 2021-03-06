package br.com.fiap.samf.mbean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.fiap.samf.control.MedicamentoControl;
import br.com.fiap.samf.model.Medicamento;

@FacesConverter(value="samf.MedicamentoConverter")
public class MedicamentoConverter implements Converter{
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null && !value.isEmpty()){
			try {
				return new MedicamentoControl().buscar(Integer.valueOf(value).longValue());
			} catch (Exception e) {
				throw new ConverterException(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) throws ConverterException {
		if (value != null && value instanceof Medicamento){
			return String.valueOf(((Medicamento) value).getCodigo());  
		}
		return "";  
	}

}
