package br.com.domsantos.processoweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.CartorioDAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Cartorio;

@Stateless
public class CartorioSrv {

	@Inject
	private CartorioDAO cartorioDAO;
	
	public List<Cartorio> listaPorCadastro(Cadastro cadastro){
		return cartorioDAO.listaPorCadastro(cadastro);
	}
	
	public Cartorio getPorId(Integer id){
		return cartorioDAO.getUm(id, Cartorio.class);
	}
	
	public void salvar(Cartorio cartorio){
		cartorioDAO.salvar(cartorio);
	}
	
	public void atualizar(Cartorio cartorio){
		cartorioDAO.atualizar(cartorio);
	}
}
