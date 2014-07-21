package br.com.domsantos.processoweb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("phoneConverter")
public class PhoneConverter implements Converter{
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        String phoneNumber = (String) modelValue;
        
        return phoneNumber.replaceFirst("(\\d{2})(\\d{4})(\\d+)", "($1) $2-$3");
    }

    
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        // Conversion is not necessary for now. However, if you ever intend to use 
        // it on input components, you probably want to implement it here.
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
