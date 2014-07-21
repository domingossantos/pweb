package br.com.domsantos.processoweb.mb.adverso;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Adverso;
import br.com.domsantos.processoweb.service.AdversoSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "adversoGrid", pattern = "/adverso/lista", viewId = "/pages/sistema/adverso/adversoGrid.jsf")
	})
public class AdversoGridBean extends PaginaBean {
	
	@EJB 
	private AdversoSrv adversoSrv;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Adverso adverso;
	
	private List<Adverso> adversoLista;
	
	@URLAction(mappingId="adversoGrid")
	public void abrir(){
		adverso = new Adverso();
		adversoLista = adversoSrv.listaPorCadastro(loginBean.getCadastro());
	}
	
	public Adverso getAdverso() {
		return adverso;
	}

	public void setAdverso(Adverso adverso) {
		this.adverso = adverso;
	}

	public List<Adverso> getAdversoLista() {
		return adversoLista;
	}

	public void setAdversoLista(List<Adverso> adversoLista) {
		this.adversoLista = adversoLista;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
	
}
