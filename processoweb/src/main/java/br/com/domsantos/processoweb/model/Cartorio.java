package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cartorio database table.
 * 
 */
@Entity
@Table(name="cartorio")
@NamedQuery(name="Cartorio.findAll", query="SELECT c FROM Cartorio c")
public class Cartorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_cartorio")
	private int cdCartorio;

	@Column(name="ds_cartorio")
	private String dsCartorio;

	@Column(name="nm_contato")
	private String nmContato;

	@Column(name="nr_fone")
	private String nrFone;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;


	public int getCdCartorio() {
		return this.cdCartorio;
	}

	public void setCdCartorio(int cdCartorio) {
		this.cdCartorio = cdCartorio;
	}

	public String getDsCartorio() {
		return this.dsCartorio;
	}

	public void setDsCartorio(String dsCartorio) {
		this.dsCartorio = dsCartorio;
	}

	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	public String getNrFone() {
		return this.nrFone;
	}

	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}