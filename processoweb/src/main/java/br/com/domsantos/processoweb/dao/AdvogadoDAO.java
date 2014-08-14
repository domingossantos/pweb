package br.com.domsantos.processoweb.dao;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Advogado;

public class AdvogadoDAO extends DAO<Advogado> {
	
	public Advogado getPorEmail(String email){
		String sql = "select a from Advogado a where a.dsEmail = :email";
		Query q = getEm().createQuery(sql);
		q.setParameter("email", email); 
		
		return (Advogado) q.getSingleResult();
	}
}
