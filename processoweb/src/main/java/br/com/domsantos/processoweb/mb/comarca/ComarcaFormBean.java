package br.com.domsantos.processoweb.mb.comarca;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Cartorio;
import br.com.domsantos.processoweb.model.Comarca;
import br.com.domsantos.processoweb.service.CartorioSrv;
import br.com.domsantos.processoweb.service.ComarcaSrv;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
		@URLMapping(id = "comarcaNovo", pattern = "/comarca/novo", viewId = "/pages/sistema/comarca/comarcaForm.jsf", parentId = "paginaRestrita"),
		@URLMapping(id = "comarcaEditar", pattern = "/comarca/editar/#{cdComarca : comarcaFormBean.cdComarca}", viewId = "/pages/sistema/comarca/comarcaForm.jsf", parentId = "paginaRestrita") })
public class ComarcaFormBean extends PaginaBean {

	private static final long serialVersionUID = 6167043013255626563L;

	@EJB
	private ComarcaSrv comarcaSrv;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	private Integer cdComarca;

	private Comarca comarca;
	
	private String nome;

	@URLActions(actions = {
			@URLAction(mappingId = "comarcaNovo", onPostback = true),
			@URLAction(mappingId = "comarcaEditar", onPostback = true), })
	public void abrir() {
		if (cdComarca == null) {
			comarca = new Comarca();
			comarca.setCdCadastro(loginBean.getCadastro());
		} else {
			comarca = comarcaSrv.getPorId(cdComarca);
		}
	}

	public void salvar(){
		
		try{
			if(cdComarca != null){
				comarcaSrv.atualizar(comarca);
			} else {
				comarcaSrv.salvar(comarca);
			}
			addInfo("Registro salvo com sucesso!");
		}catch(Exception e){
			addWarn("Erro ao salvar registro!");
			System.out.println(e.getStackTrace());
		}
	}


	public Integer getCdComarca() {
		return cdComarca;
	}

	public void setCdComarca(Integer cdComarca) {
		this.cdComarca = cdComarca;
	}

	public Comarca getComarca() {
		return comarca;
	}

	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
