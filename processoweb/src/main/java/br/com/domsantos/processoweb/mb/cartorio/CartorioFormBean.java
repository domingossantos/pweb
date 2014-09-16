package br.com.domsantos.processoweb.mb.cartorio;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Cartorio;
import br.com.domsantos.processoweb.service.CartorioSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
		@URLMapping(id = "cartorioNovo", pattern = "/cartorio/novo", viewId = "/pages/sistema/cartorio/cartorioForm.jsf", parentId = "paginaRestrita"),
		@URLMapping(id = "cartorioEditar", pattern = "/cartorio/editar/#{cdCartorio : cartorioFormBean.cdCartorio}", viewId = "/pages/sistema/cartorio/cartorioForm.jsf", parentId = "paginaRestrita") })
public class CartorioFormBean extends PaginaBean {

	private static final long serialVersionUID = 6167043013255626563L;

	@EJB
	private CartorioSrv cartorioSrv;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	private Integer cdCartorio;

	private Cartorio cartorio;
	
	private String nome;

	@URLActions(actions = {
			@URLAction(mappingId = "cartorioNovo", onPostback = true),
			@URLAction(mappingId = "cartorioEditar", onPostback = true), })
	public void abrir() {
		if (cdCartorio == null) {
			cartorio = new Cartorio();
			cartorio.setCdCadastro(loginBean.getCadastro());
		} else {
			cartorio = cartorioSrv.getPorId(cdCartorio);
		}
	}

	public String salvar(){
		String path = "";
		try{
			if(cdCartorio != null){
				cartorioSrv.atualizar(cartorio);
			} else {
				cartorioSrv.salvar(cartorio);
			}
			addInfo("Registro salvo com sucesso!");
			path = "pretty:cartorioGrid";
		}catch(Exception e){
			addWarn("Erro ao salvar registro!");
			System.out.println(e.getStackTrace());
		}
		return path;
	}

	
	
	public Integer getCdCartorio() {
		return cdCartorio;
	}

	public void setCdCartorio(Integer cdCartorio) {
		this.cdCartorio = cdCartorio;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
