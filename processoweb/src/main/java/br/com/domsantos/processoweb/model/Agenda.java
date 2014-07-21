package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@Table(name="agenda")
@NamedQuery(name="Agenda.findAll", query="SELECT a FROM Agenda a")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_agenda")
	private int cdAgenda;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="ds_obs")
	private String dsObs;

	@Column(name="nm_contato")
	private String nmContato;

	@Column(name="nr_celular")
	private String nrCelular;

	@Column(name="nr_fone")
	private String nrFone;

	@Column(name="nr_foneres")
	private String nrFoneres;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	public Agenda() {
	}

	public int getCdAgenda() {
		return this.cdAgenda;
	}

	public void setCdAgenda(int cdAgenda) {
		this.cdAgenda = cdAgenda;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsObs() {
		return this.dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	public String getNrCelular() {
		return this.nrCelular;
	}

	public void setNrCelular(String nrCelular) {
		this.nrCelular = nrCelular;
	}

	public String getNrFone() {
		return this.nrFone;
	}

	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}

	public String getNrFoneres() {
		return this.nrFoneres;
	}

	public void setNrFoneres(String nrFoneres) {
		this.nrFoneres = nrFoneres;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}