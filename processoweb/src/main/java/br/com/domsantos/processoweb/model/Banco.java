package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the banco database table.
 * 
 */
@Entity
@Table(name="banco")
@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b")
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_banco")
	private int cdBanco;

	@Column(name="cd_advogado")
	private int cdAdvogado;

	@Column(name="ds_banco")
	private String dsBanco;

	@Column(name="vl_banco")
	private BigDecimal vlBanco;

	//bi-directional many-to-one association to Processo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_processo")
	private Processo processo;

	public Banco() {
	}

	public int getCdBanco() {
		return this.cdBanco;
	}

	public void setCdBanco(int cdBanco) {
		this.cdBanco = cdBanco;
	}

	public int getCdAdvogado() {
		return this.cdAdvogado;
	}

	public void setCdAdvogado(int cdAdvogado) {
		this.cdAdvogado = cdAdvogado;
	}

	public String getDsBanco() {
		return this.dsBanco;
	}

	public void setDsBanco(String dsBanco) {
		this.dsBanco = dsBanco;
	}

	public BigDecimal getVlBanco() {
		return this.vlBanco;
	}

	public void setVlBanco(BigDecimal vlBanco) {
		this.vlBanco = vlBanco;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}