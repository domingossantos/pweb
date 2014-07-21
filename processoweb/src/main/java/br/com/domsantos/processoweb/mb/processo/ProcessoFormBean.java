package br.com.domsantos.processoweb.mb.processo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "processoNovo", pattern = "/processo/novo", viewId = "/pages/sistema/processo/processoForm.jsf")
	})
public class ProcessoFormBean {

}
