package br.com.domsantos.processoweb.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.domsantos.processoweb.dao.common.DAO;
import br.com.domsantos.processoweb.model.Adverso;
import br.com.domsantos.processoweb.model.Cadastro;

public class AdversoDAO extends DAO<Adverso>{
	
	@SuppressWarnings("unchecked")
	public List<Adverso> listaPorCadastro(Cadastro cadastro){
		Query q = getEm().createQuery("select a from Adverso a where a.cdCadastro = :cadastro order by a.nmAdverso");
		q.setParameter("cadastro", cadastro);
		
		return q.getResultList();
	}
	
	public Adverso getPorId(Integer id){
		return getUm(id, Adverso.class);
	}
	
}
