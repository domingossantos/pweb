package br.com.domsantos.processoweb.mb;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.domsantos.common.FuncoesUteis;
import br.com.domsantos.processoweb.mb.common.PaginaBean;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.service.CadastroSrv;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@ManagedBean
@ViewScoped
@URLMappings(mappings = {
	    @URLMapping(id = "cadastro", pattern = "/cadastro/", viewId = "/pages/cadastro.jsf")
	})
public class CadastroFormBean extends PaginaBean{

	private static final long serialVersionUID = 1L;
	
	private Cadastro cadastro;
	private char tipoPessoa;
	private String senha;
	
	@EJB
	private CadastroSrv cadastroSrv;
	
	
	@URLAction(mappingId="cadastro", onPostback=false)
	public void abrir(){
		cadastro = new Cadastro();
	}
	
	
	public void cadastrar(){
		if(cadastroSrv.checaEmailExiste(cadastro.getDsEmail()) > 0){
			addInfo("Email já cadastrado");
			return;
		}
		
		
		if(cadastroSrv.checaCpfExiste(cadastro.getNrCpfcnpf()) > 0){
			addInfo("CPF já cadastrado");
			return;
		}
		
		if(!cadastro.getVlSenha().equals(senha)){
			addInfo("Senha Inválida");
			return;
		}
		
		try{
			Locale locale = new Locale("pt", "BR");
			Calendar data = Calendar.getInstance(locale);
			
			cadastro.setDtCadastro(data.getTime());
			data.add(Calendar.DATE, 30);
			cadastro.setDtValidade(data.getTime());
			cadastroSrv.salvar(cadastro);
			addInfo("Cadastro realizado!");
		}
		catch(Exception ex){
			addInfo("Erro ao cadastrar cliente!");
		}
		
	}

	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
