package br.com.domsantos.processoweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.VaraForoDAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Varaforo;

@Stateless
public class VaraForoSrv {

	@Inject
	private VaraForoDAO varaForoDAO;
	
	public List<Varaforo> getPorCadastro(Cadastro cadastro){
		return varaForoDAO.getPorCadastro(cadastro);
	}
	
	public Varaforo getPorId(Integer id){
		return varaForoDAO.getUm(id, Varaforo.class);
	}
	
	public void salvar(Varaforo varaforo){
		varaForoDAO.salvar(varaforo);
	}
	
	public void atualizar(Varaforo varaforo){
		varaForoDAO.atualizar(varaforo);
	}
}
