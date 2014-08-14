package br.com.domsantos.processoweb.mb.cartorio;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.model.Cartorio;
import br.com.domsantos.processoweb.service.CartorioSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "cartorioGrid", pattern = "/cartorio/lista", viewId = "/pages/sistema/cartorio/cartorioGrid.jsf", parentId = "paginaRestrita")
	})
public class CartorioGridBean {
	
	@EJB
	private CartorioSrv cartorioSrv;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Cartorio cartorio;
	
	private List<Cartorio> cartorios;
	
	@URLAction(mappingId="cartorioGrid", onPostback=false)
	public void abrir(){
		cartorio = new Cartorio();
		cartorios = cartorioSrv.listaPorCadastro(loginBean.getCadastro());
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	public List<Cartorio> getCartorios() {
		return cartorios;
	}

	public void setCartorios(List<Cartorio> cartorios) {
		this.cartorios = cartorios;
	}
	
	
}

