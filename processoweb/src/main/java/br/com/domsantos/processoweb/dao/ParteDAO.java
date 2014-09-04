package br.com.domsantos.processoweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Parte;

public class ParteDAO extends DAO<Parte>{

	public List<Parte> listaPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select c from Parte c where c.cadastro = :cadastro");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
		
	}
}
