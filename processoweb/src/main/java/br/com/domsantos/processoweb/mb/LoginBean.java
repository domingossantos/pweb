package br.com.domsantos.processoweb.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Advogado;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.service.CadastroSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@SessionScoped
@URLMappings(mappings = {
		@URLMapping(id = "login", pattern = "/login/", viewId = "/login.jsf"),
		@URLMapping(id = "logout", pattern = "/logout/", viewId = "/login.jsf")
	})
public class LoginBean extends PaginaBean{

	private static final long serialVersionUID = 1L;

	private Cadastro cadastro;
	
	private Advogado advogado;
	
	private String email;
	
	private String senha;
	
	private boolean usuarioLogado;
	
	@EJB
	private CadastroSrv cadastroSrv;

	@URLAction(mappingId="login",onPostback=false)
	public void abrir(){
		cadastro = new Cadastro();
		advogado = new Advogado();
		usuarioLogado = false;
	}
	
	public String logar(){
		cadastro = cadastroSrv.getPorEmail(email);
		return "pretty:home";
	}
	
	@URLAction(mappingId="logout", onPostback=false)
	public String logout(){
		cadastro = null;
		return "pretty:login";
	}
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
	
}
