package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contato_web database table.
 * 
 */
@Entity
@Table(name="contato_web")
@NamedQuery(name="ContatoWeb.findAll", query="SELECT c FROM ContatoWeb c")
public class ContatoWeb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contatoweb")
	private int idContatoweb;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="nm_contatoweb")
	private String nmContatoweb;

	public ContatoWeb() {
	}

	public int getIdContatoweb() {
		return this.idContatoweb;
	}

	public void setIdContatoweb(int idContatoweb) {
		this.idContatoweb = idContatoweb;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getNmContatoweb() {
		return this.nmContatoweb;
	}

	public void setNmContatoweb(String nmContatoweb) {
		this.nmContatoweb = nmContatoweb;
	}

}