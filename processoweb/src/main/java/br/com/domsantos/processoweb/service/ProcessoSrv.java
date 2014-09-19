package br.com.domsantos.processoweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.domsantos.processoweb.dao.ProcessoDAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Processo;

@Stateless
public class ProcessoSrv {

	@Inject
	private ProcessoDAO processoDAO;
	
	public Processo getId(Integer id){
		return processoDAO.getUm(id, Processo.class);
	}
	
	public List<Processo> listaProcessosNovos(Cadastro cadastro){
		return processoDAO.listaPorCadastroStatus(cadastro, 'N');
	}
	
	public void salvar(Processo processo){
		processoDAO.salvar(processo);
	}
	
	public void atualizar(Processo processo){
		processoDAO.atualizar(processo);
	}
}
