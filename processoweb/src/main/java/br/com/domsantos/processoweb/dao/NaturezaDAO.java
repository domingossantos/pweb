package br.com.domsantos.processoweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Natureza;

public class NaturezaDAO extends DAO<Natureza> {

	@SuppressWarnings("unchecked")
	public List<Natureza> getPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select c from Natureza c where c.cadastro = :cadastro");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
	}
}
