package br.com.domsantos.processoweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.common.FuncoesUteis;
import br.com.domsantos.processoweb.dao.AdversoDAO;
import br.com.domsantos.processoweb.model.Adverso;
import br.com.domsantos.processoweb.model.Cadastro;

@Stateless
public class AdversoSrv {

	@Inject
	private AdversoDAO adversoDAO;
	
	
	public List<Adverso> listaPorCadastro(Cadastro cadastro){
		return adversoDAO.listaPorCadastro(cadastro);
	}
	
	public Adverso getPorId(Integer id){		
		return adversoDAO.getPorId(id);
	}
	
	public void salvar(Adverso adverso){
		adverso.setNrFone(FuncoesUteis.limpaCaracter(adverso.getNrFone()));
		adverso.setNrCelular(FuncoesUteis.limpaCaracter(adverso.getNrCelular()));
		adverso.setNrFoneres(FuncoesUteis.limpaCaracter(adverso.getNrFoneres()));
		adversoDAO.salvar(adverso);
	}
	
	public void atualizar(Adverso adverso){
		adverso.setNrFone(FuncoesUteis.limpaCaracter(adverso.getNrFone()));
		adverso.setNrCelular(FuncoesUteis.limpaCaracter(adverso.getNrCelular()));
		adverso.setNrFoneres(FuncoesUteis.limpaCaracter(adverso.getNrFoneres()));
		
		adversoDAO.atualizar(adverso);
	}
	
}
