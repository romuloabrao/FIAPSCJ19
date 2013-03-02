package br.com.fiap.samf.mbean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.fiap.samf.model.Convenio;

@FacesConverter(value="ConvenioConverter", forClass=Convenio.class)
public class ConvenioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		return null;
	}

}
