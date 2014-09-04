package br.com.domsantos.processoweb.mb.varaforo;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.model.Comarca;
import br.com.domsantos.processoweb.model.Varaforo;
import br.com.domsantos.processoweb.service.ComarcaSrv;
import br.com.domsantos.processoweb.service.VaraForoSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "varaforoGrid", pattern = "/varaforo/lista", viewId = "/pages/sistema/varaforo/varaforoGrid.jsf", parentId = "paginaRestrita")
	})
public class VaraForoGridBean {
	
	@EJB
	private VaraForoSrv varaForoSrv;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Varaforo varaForo;
	
	private List<Varaforo> varaforos;
	
	@URLAction(mappingId="varaforoGrid", onPostback=false)
	public void abrir(){
		varaForo = new Varaforo();
		varaforos = varaForoSrv.getPorCadastro(loginBean.getCadastro());
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Varaforo getVaraForo() {
		return varaForo;
	}

	public void setVaraForo(Varaforo varaForo) {
		this.varaForo = varaForo;
	}

	public List<Varaforo> getVaraforos() {
		return varaforos;
	}

	public void setVaraforos(List<Varaforo> varaforos) {
		this.varaforos = varaforos;
	}

		
}

