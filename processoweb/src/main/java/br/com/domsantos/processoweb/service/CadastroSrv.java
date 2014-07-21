package br.com.domsantos.processoweb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.AdvogadoDAO;
import br.com.domsantos.processoweb.dao.CadastroDAO;
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
	
	public Long checaCpfExiste(String cpf){
		return cadastroDAO.checaCpfExiste(cpf);
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
