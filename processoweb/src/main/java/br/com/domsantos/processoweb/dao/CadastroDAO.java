package br.com.domsantos.processoweb.dao;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Cadastro;

public class CadastroDAO extends DAO<Cadastro>{
	
	public Long checaEmailExiste(String email){
		
		String sql = "select count(c) from Cadastro c where c.dsEmail = :email";
		Query q = getEm().createQuery(sql);
		q.setParameter("email", email); 
		
		return (Long) q.getSingleResult();
	}
	
	
	public Long checaCpfExiste(String cpf){
		
		String sql = "select count(c) from Cadastro c where c.nrCpfcnpj = :cpf";
		Query q = getEm().createQuery(sql);
		q.setParameter("cpf", cpf); 
		
		return (Long) q.getSingleResult();
	}
	
	public Cadastro getPorEmail(String email){
		String sql = "select c from Cadastro c where c.dsEmail = :email";
		Query q = getEm().createQuery(sql);
		q.setParameter("email", email); 
		
		return (Cadastro) q.getSingleResult();
	}
	
}
