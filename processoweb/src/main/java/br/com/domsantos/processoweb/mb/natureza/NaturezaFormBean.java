package br.com.domsantos.processoweb.mb.natureza;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Comarca;
import br.com.domsantos.processoweb.model.Natureza;
import br.com.domsantos.processoweb.service.ComarcaSrv;
import br.com.domsantos.processoweb.service.NaturezaSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
		@URLMapping(id = "naturezaNovo", pattern = "/natureza/novo", viewId = "/pages/sistema/natureza/naturezaForm.jsf", parentId = "paginaRestrita"),
		@URLMapping(id = "naturezaEditar", pattern = "/natureza/editar/#{cdNatureza : naturezaFormBean.cdNatureza}", viewId = "/pages/sistema/natureza/naturezaForm.jsf", parentId = "paginaRestrita") })
public class NaturezaFormBean extends PaginaBean {

	private static final long serialVersionUID = 6167043013255626563L;

	@EJB
	private NaturezaSrv naturezaSrv;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	private Integer cdNatureza;

	private Natureza natureza;
	
	

	@URLActions(actions = {
			@URLAction(mappingId = "naturezaNovo"),
			@URLAction(mappingId = "naturezaEditar"), })
	public void abrir() {
		if (cdNatureza== null) {
			natureza = new Natureza();
			natureza.setCdCadastro(loginBean.getCadastro());
		} else {
			natureza = naturezaSrv.getPorIr(cdNatureza);
		}
	}

	public void salvar(){
		
		try{
			if(cdNatureza != null){
				naturezaSrv.atualizar(natureza);
			} else {
				naturezaSrv.salvar(natureza);
			}
			addInfo("Registro salvo com sucesso!");
		}catch(Exception e){
			addWarn("Erro ao salvar registro!");
			System.out.println(e.getStackTrace());
		}
	}



	public Integer getCdNatureza() {
		return cdNatureza;
	}

	public void setCdNatureza(Integer cdNatureza) {
		this.cdNatureza = cdNatureza;
	}

	public Natureza getNatureza() {
		return natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	
		
}
