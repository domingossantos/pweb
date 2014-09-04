package br.com.domsantos.processoweb.service;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.ComarcaDAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Comarca;

@Stateless
public class ComarcaSrv {

	@Inject
	private ComarcaDAO comarcaDAO;
	
	public List<Comarca> listaPorCadastro(Cadastro cadastro){
		return comarcaDAO.listaPorCadastro(cadastro);
	}
	
	public Comarca getPorId(Integer id){
		return comarcaDAO.getUm(id, Comarca.class);
	}
	
	public void salvar(Comarca comarca){
		comarcaDAO.salvar(comarca);
	}
	
	public void atualizar(Comarca comarca){
		comarcaDAO.atualizar(comarca);
	}
}
