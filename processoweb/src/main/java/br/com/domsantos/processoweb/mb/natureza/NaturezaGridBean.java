package br.com.domsantos.processoweb.mb.natureza;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.model.Comarca;
import br.com.domsantos.processoweb.model.Natureza;
import br.com.domsantos.processoweb.service.NaturezaSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "naturezaGrid", pattern = "/natureza/lista", viewId = "/pages/sistema/natureza/naturezaGrid.jsf", parentId = "paginaRestrita")
	})
public class NaturezaGridBean {
	
	@EJB
	private NaturezaSrv naturezaSrv;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Natureza natureza;
	
	private List<Natureza> naturezas;
	
	@URLAction(mappingId="naturezaGrid", onPostback=false)
	public void abrir(){
		natureza = new Natureza();
		naturezas = naturezaSrv.getPorCadastro(loginBean.getCadastro());
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Natureza getNatureza() {
		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public List<Natureza> getNaturezas() {
		return naturezas;
	}

	public void setNaturezas(List<Natureza> naturezas) {
		this.naturezas = naturezas;
	}

	
	
}

