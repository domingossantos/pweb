package br.com.domsantos.processoweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.NaturezaDAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Natureza;

@Stateless
public class NaturezaSrv {
	
	@Inject
	private NaturezaDAO naturezaDAO;
	
	public List<Natureza> getPorCadastro(Cadastro cadastro){
		return naturezaDAO.getPorCadastro(cadastro);
	}
	
	public Natureza getPorIr(Integer cdNatureza){
		return naturezaDAO.getUm(cdNatureza, Natureza.class);
	}
	
	public void salvar(Natureza natureza){
		naturezaDAO.salvar(natureza);
	}
	
	public void atualizar(Natureza natureza){
		naturezaDAO.atualizar(natureza);
	}
	
	

}
