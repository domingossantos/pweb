package br.com.domsantos.processoweb.mb.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLAction.PhaseId;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "paginaRestrita", pattern = "", viewId = "/blank.jsf")
public class PaginaRestritaBean extends PaginaBean {

	private static final long serialVersionUID = 2934958898861604048L;

	@URLAction(mappingId = "paginaRestrita", inheritable = true, onPostback = false, phaseId = PhaseId.RESTORE_VIEW)
    public String validarUsuario() {
        if (getUsuarioLogado() != null) {
            return null;
        } else {
            return "pretty:login";
        }
    }
}
