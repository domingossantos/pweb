package br.com.domsantos.processoweb.mb.comarca;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.model.Comarca;
import br.com.domsantos.processoweb.service.ComarcaSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "comarcaGrid", pattern = "/comarca/lista", viewId = "/pages/sistema/comarca/comarcaGrid.jsf", parentId = "paginaRestrita")
	})
public class ComarcaGridBean {
	
	@EJB
	private ComarcaSrv comarcasSrv;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Comarca comarca;
	
	private List<Comarca> comarcas;
	
	@URLAction(mappingId="comarcaGrid", onPostback=false)
	public void abrir(){
		comarca = new Comarca();
		comarcas = comarcasSrv.listaPorCadastro(loginBean.getCadastro());
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Comarca getComarca() {
		return comarca;
	}

	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}

	public List<Comarca> getComarcas() {
		return comarcas;
	}

	public void setComarcas(List<Comarca> comarcas) {
		this.comarcas = comarcas;
	}

	
}

