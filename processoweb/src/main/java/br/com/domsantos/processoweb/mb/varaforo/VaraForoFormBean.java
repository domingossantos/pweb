package br.com.domsantos.processoweb.mb.varaforo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Comarca;
import br.com.domsantos.processoweb.model.Varaforo;
import br.com.domsantos.processoweb.service.VaraForoSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
		@URLMapping(id = "varaforoNovo", pattern = "/varaforo/novo", viewId = "/pages/sistema/varaforo/varaforoForm.jsf", parentId = "paginaRestrita"),
		@URLMapping(id = "varaforoEditar", pattern = "/varaforo/editar/#{cdVaraforo : varaforoFormBean.cdVaraforo}", viewId = "/pages/sistema/varaforo/varaforoForm.jsf", parentId = "paginaRestrita") })
public class VaraForoFormBean extends PaginaBean {

	private static final long serialVersionUID = 6167043013255626563L;

	@EJB
	private VaraForoSrv varaforoSrv;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;

	private Integer cdVaraforo;

	private Varaforo varaforo;
	
	private String nome;

	@URLActions(actions = {
			@URLAction(mappingId = "varaforoNovo", onPostback = true),
			@URLAction(mappingId = "varaforoEditar", onPostback = true), })
	public void abrir() {
		if (cdVaraforo == null) {
			varaforo = new Varaforo();
			varaforo.setCdCadastro(loginBean.getCadastro());
		} else {
			varaforo = varaforoSrv.getPorId(cdVaraforo);
		}
	}

	public void salvar(){
		
		try{
			if(cdVaraforo != null){
				varaforoSrv.atualizar(varaforo);
			} else {
				varaforoSrv.salvar(varaforo);
			}
			addInfo("Registro salvo com sucesso!");
		}catch(Exception e){
			addWarn("Erro ao salvar registro!");
			System.out.println(e.getStackTrace());
		}
	}

	public Integer getCdVaraforo() {
		return cdVaraforo;
	}

	public void setCdVaraforo(Integer cdVaraforo) {
		this.cdVaraforo = cdVaraforo;
	}

	public Varaforo getVaraforo() {
		return varaforo;
	}

	public void setVaraforo(Varaforo varaforo) {
		this.varaforo = varaforo;
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
