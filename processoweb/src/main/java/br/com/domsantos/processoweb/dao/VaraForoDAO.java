package br.com.domsantos.processoweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Cadastro;
import br.com.domsantos.processoweb.model.Varaforo;

public class VaraForoDAO extends DAO<Varaforo>{
	
	@SuppressWarnings("unchecked")
	public List<Varaforo> getPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select c from Varaforo c where c.cadastro = :cadastro");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
	}

}
