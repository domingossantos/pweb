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
	public List<Processo> listaPorCadastroStatus(Cadastro cadastro, char status){
		Query q = getEm().createQuery("select a from Processo a where stProcesso = :status and  a.cadastro = :cadastro order by a.cdProcesso");
		q.setParameter("cadastro", cadastro);
		q.setParameter("status", status);
		
		return q.getResultList();
		
	}
	
	

}
