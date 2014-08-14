package br.com.domsantos.processoweb.mb.adverso;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Adverso;
import br.com.domsantos.processoweb.service.AdversoSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
		@URLMapping(id = "adversoNovo", pattern = "/adverso/novo", viewId = "/pages/sistema/adverso/adversoForm.jsf", parentId = "paginaRestrita"),
		@URLMapping(id = "adversoEditar", pattern = "/adverso/editar/#{idAdverso : adversoFormBean.idAdverso}", viewId = "/pages/sistema/adverso/adversoForm.jsf", parentId = "paginaRestrita") })
public class AdversoFormBean extends PaginaBean {

	private static final long serialVersionUID = 1L;

	@EJB
	private AdversoSrv adversoSrv;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	private Adverso adverso;

	private Integer idAdverso;

//	@PostConstruct
//	public void init() {
//	    adverso =  new Adverso();
//	}
	
	@URLActions(actions={
		@URLAction(mappingId = "adversoNovo", onPostback = false),
		@URLAction(mappingId = "adversoEditar", onPostback = false)
	})
	public void abrir() {
		
		if(idAdverso != null){
			adverso = adversoSrv.getPorId(idAdverso);
		} else {
			adverso = new Adverso();
			
		}
	}

	
	public void salvar() {
		try {
			if (idAdverso != null) {
				adversoSrv.atualizar(adverso);
			} else {
				adverso.setCadastro(loginBean.getCadastro());
				adversoSrv.salvar(adverso);
			}
			addInfo("Registro Salvo!");
		} catch (Exception e) {
			addWarn("Erro ao salvar registro!");
			System.out.println(e.getStackTrace());
		}
	}

	public Integer getIdAdverso() {
		return idAdverso;
	}

	public void setIdAdverso(Integer idAdverso) {
		this.idAdverso = idAdverso;
	}


	public Adverso getAdverso() {
		return adverso;
	}


	public void setAdverso(Adverso adverso) {
		this.adverso = adverso;
	}


	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
