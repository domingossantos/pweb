package br.com.domsantos.processoweb.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.service.CadastroSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
		@URLMapping(id = "home", pattern = "/home/", viewId = "/pages/sistema/home.jsf", parentId = "paginaRestrita")
	})
public class HomeBean extends PaginaBean{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	@EJB
	private CadastroSrv cadastroSrv;
	
	
	@URLAction(mappingId="home", onPostback = false)
	public void abrir(){
		
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
}
