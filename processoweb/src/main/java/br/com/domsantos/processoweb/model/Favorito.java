package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the favoritos database table.
 * 
 */
@Entity
@Table(name="favoritos")
@NamedQuery(name="Favorito.findAll", query="SELECT f FROM Favorito f")
public class Favorito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_favoritos")
	private int cdFavoritos;

	@Column(name="cd_advogado")
	private int cdAdvogado;

	@Column(name="ds_autor")
	private String dsAutor;

	@Column(name="ds_favorito")
	private String dsFavorito;

	@Column(name="ds_obs")
	private String dsObs;

	@Column(name="ds_url")
	private String dsUrl;

	@Column(name="tp_favorito")
	private String tpFavorito;

	@Lob
	@Column(name="tx_favorito")
	private String txFavorito;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	public Favorito() {
	}

	public int getCdFavoritos() {
		return this.cdFavoritos;
	}

	public void setCdFavoritos(int cdFavoritos) {
		this.cdFavoritos = cdFavoritos;
	}

	public int getCdAdvogado() {
		return this.cdAdvogado;
	}

	public void setCdAdvogado(int cdAdvogado) {
		this.cdAdvogado = cdAdvogado;
	}

	public String getDsAutor() {
		return this.dsAutor;
	}

	public void setDsAutor(String dsAutor) {
		this.dsAutor = dsAutor;
	}

	public String getDsFavorito() {
		return this.dsFavorito;
	}

	public void setDsFavorito(String dsFavorito) {
		this.dsFavorito = dsFavorito;
	}

	public String getDsObs() {
		return this.dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public String getDsUrl() {
		return this.dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}

	public String getTpFavorito() {
		return this.tpFavorito;
	}

	public void setTpFavorito(String tpFavorito) {
		this.tpFavorito = tpFavorito;
	}

	public String getTxFavorito() {
		return this.txFavorito;
	}

	public void setTxFavorito(String txFavorito) {
		this.txFavorito = txFavorito;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}