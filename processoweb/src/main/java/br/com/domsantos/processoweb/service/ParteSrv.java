package br.com.domsantos.processoweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.ParteDAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Parte;

@Stateless
public class ParteSrv {

	@Inject
	private ParteDAO parteDAO;
	
	public List<Parte> listaPorCadastro(Cadastro cadastro){
		return parteDAO.listaPorCadastro(cadastro);
	}
	
	
}
