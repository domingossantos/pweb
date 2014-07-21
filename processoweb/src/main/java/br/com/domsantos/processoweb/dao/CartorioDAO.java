package br.com.domsantos.processoweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Cartorio;

public class CartorioDAO extends DAO<Cartorio>{
	
	@SuppressWarnings("unchecked")
	public List<Cartorio> listaPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select c from Cartorio c where c.cadastro = :cadastro");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
	}
}
