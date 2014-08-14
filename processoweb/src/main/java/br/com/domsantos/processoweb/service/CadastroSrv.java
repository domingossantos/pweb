package br.com.domsantos.processoweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.AdvogadoDAO;
import br.com.domsantos.processoweb.dao.CadastroDAO;
import br.com.domsantos.processoweb.model.Advogado;
import br.com.domsantos.processoweb.model.Cadastro;

@Stateless
public class CadastroSrv {

	@Inject
	private CadastroDAO cadastroDAO;
	
	@Inject
	private AdvogadoDAO advogadoDAO;
	
	public Long checaEmailExiste(String email){
		return cadastroDAO.checaEmailExiste(email);
	}
	
	public Cadastro getCadastroPorId(Integer id){
		return cadastroDAO.getUm(id, Cadastro.class);
	}
	
	public Advogado getAdvogadoPorEmail(String email){
		return advogadoDAO.getPorEmail(email);
	}
	
	public Long checaCpfExiste(String cpf){
		return cadastroDAO.checaCpfExiste(cpf);
	}
	
	public Advogado logar(String email,String senha){
		Advogado advogado = advogadoDAO.getPorEmail(email);
		
		if(advogado.getVlSenha().equals(senha)){
			return advogado;
		} else {
			return null;
		}
		
	}
	
	public Cadastro getPorEmail(String email){
		return cadastroDAO.getPorEmail(email);
	}
	
	public void salvar(Cadastro cadastro){
		cadastroDAO.salvar(cadastro);
	}
	
	public void atualizar(Cadastro cadastro){
		cadastroDAO.atualizar(cadastro);
	}
}
