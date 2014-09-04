package br.com.domsantos.processoweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Processo;

public class ProcessoDAO extends DAO<Processo>{

	@SuppressWarnings("unchecked")
	public List<Processo> listaPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select a from Processo a where a.cadastro = :cadastro order by a.cdProcesso");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Processo> listaAbertosPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select a from Processo a where stProcesso = 'A' and  a.cadastro = :cadastro order by a.cdProcesso");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Processo> listaFechadosPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select a from Processo a where stProcesso = 'F' and  a.cadastro = :cadastro order by a.cdProcesso");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
		
	}

}
