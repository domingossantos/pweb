package br.com.domsantos.processoweb.mb.processo;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Processo;
import br.com.domsantos.processoweb.service.ProcessoSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "processosAbertosGrid", pattern = "/processo/listaAbertos", viewId = "/pages/sistema/processo/processoGrid.jsf", parentId = "paginaRestrita"),
	    @URLMapping(id = "processosFechadosGrid", pattern = "/processo/listaFechados", viewId = "/pages/sistema/processo/processoGrid.jsf", parentId = "paginaRestrita")
	})
public class ProcessoGridBean extends PaginaBean {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private List<Processo> processos;
	
	private Processo processo;
	@EJB
	private ProcessoSrv processoSrv;
	
	@URLAction(mappingId = "processosAbertosGrid", onPostback = true)
	public void listaAbertos(){
		processos = processoSrv.listaAbertosPorCadastro(loginBean.getCadastro());
		
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	
}
