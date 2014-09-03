package br.com.domsantos.processoweb.mb.processo;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.domsantos.processoweb.mb.LoginBean;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Natureza;
import br.com.domsantos.processoweb.model.Parte;
import br.com.domsantos.processoweb.model.Processo;
import br.com.domsantos.processoweb.service.NaturezaSrv;
import br.com.domsantos.processoweb.service.ParteSrv;
import br.com.domsantos.processoweb.service.ProcessoSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
	    @URLMapping(id = "processoNovo", pattern = "/processo/novo", viewId = "/pages/sistema/processo/processoForm.jsf", parentId = "paginaRestrita"),
	    @URLMapping(id = "processoEditar", pattern = "/processo/editar/#{cdProcesso : processo.cdProcesso}", viewId = "/pages/sistema/processo/processoForm.jsf", parentId = "paginaRestrita")
	})
public class ProcessoFormBean extends PaginaBean{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProcessoSrv processoSrv;
	
	@EJB
	private NaturezaSrv naturezaSrv;
	
	@EJB
	private ParteSrv parteSrv;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Integer cdProcesso;
	
	private Processo processo;
	
	private Parte autor;
	
	private Parte reu;
	
	private Natureza natureza;
	
	private List<Natureza> naturezas;
	
	private List<Parte> autores;
	
	private List<Parte> reus;

	
	@URLActions(actions = {
			@URLAction(mappingId = "processoNovo", onPostback = false),
			@URLAction(mappingId = "processoEditar", onPostback = false), })
	public void abrir(){
		naturezas = naturezaSrv.getPorCadastro(loginBean.getCadastro());
		autores = parteSrv.listaPorCadastro(loginBean.getCadastro());
		reus = parteSrv.listaPorCadastro(loginBean.getCadastro());
		autor = new Parte();
		reu  = new Parte();
		if(cdProcesso == null){
			processo = new Processo();
			processo.setCdCadastro(loginBean.getCadastro());
		} else {
			processo = processoSrv.getId(cdProcesso); 
		}
		
	}
	
	
	@SuppressWarnings("finally")
	public String salvar(){
		
		try{
			processo.setCdParte(autor);
			processo.setCdReu(reu);
			processo.setCdNatcausa(natureza);
			
			if(cdProcesso == null){
				processo.setStProcesso('N');
				processoSrv.salvar(processo);
				
				addInfo("Processo incluido");
			} else {
				processoSrv.atualizar(processo);
				addInfo("P	rocesso Atualizado");
			}
		}
		catch(Exception ex){
			addWarn("Erro ao gravar processo");
			System.out.println(ex.getMessage());
		}
		finally{
			return "pretty:processosAbertosGrid";
		}
	}

	public Integer getCdProcesso() {
		return cdProcesso;
	}


	public void setCdProcesso(Integer cdProcesso) {
		this.cdProcesso = cdProcesso;
	}


	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Natureza> getNaturezas() {
		return naturezas;
	}

	public void setNaturezas(List<Natureza> naturezas) {
		this.naturezas = naturezas;
	}

	public List<Parte> getAutores() {
		return autores;
	}

	public void setAutores(List<Parte> autores) {
		this.autores = autores;
	}

	public List<Parte> getReus() {
		return reus;
	}

	public void setReus(List<Parte> reus) {
		this.reus = reus;
	}


	public Parte getAutor() {
		return autor;
	}


	public void setAutor(Parte autor) {
		this.autor = autor;
	}


	public Parte getReu() {
		return reu;
	}


	public void setReu(Parte reu) {
		this.reu = reu;
	}


	public Natureza getNatureza() {
		return natureza;
	}


	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}
	
	
	

	
}
