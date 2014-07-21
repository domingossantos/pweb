package br.com.domsantos.processoweb.dao.common;

import java.io.Serializable;
import java.util.List;

import br.com.domsantos.processoweb.exception.AcessoDBError;


public interface DAOLocal<T> {

	void salvar(T entity) throws AcessoDBError;

	void atualizar(T entity) throws AcessoDBError;

	void remover(Serializable id, Class<T> clazz) throws AcessoDBError;

	T getUm(Serializable id, Class<T> clazz) throws AcessoDBError;

	List<T> listar(Class<T> clazz) throws AcessoDBError;
}