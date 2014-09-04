package br.com.domsantos.processoweb.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ObjConverter implements Converter {

    @SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {
    	if (value == null || value.trim().isEmpty())
            return null;
        List<Object> items = new ArrayList<Object>();
        List<UIComponent> uicompList = uicomp.getChildren();
        for (UIComponent comp : uicompList)
            if (comp instanceof UISelectItems)
                items.addAll((List<Object>) ((UISelectItems) comp).getValue());
        Object item = null;
        for (Object each : items)
            if (each.toString().equals(value))
                item = each;
        return item;
    }

    public String getAsString(FacesContext facesContext, UIComponent uicomp, Object value) {
        if (value == null || value == "")
            return "";
        return value.toString();
    }

}
