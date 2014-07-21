package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(name="log")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Lob
	@Column(name="desc_sql")
	private String descSql;

	private String login;

	private String operacao;

	public Log() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescSql() {
		return this.descSql;
	}

	public void setDescSql(String descSql) {
		this.descSql = descSql;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

}