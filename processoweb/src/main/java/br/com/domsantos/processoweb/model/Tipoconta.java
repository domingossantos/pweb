package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tipoconta database table.
 * 
 */
@Entity
@Table(name="tipoconta")
@NamedQuery(name="Tipoconta.findAll", query="SELECT t FROM Tipoconta t")
public class Tipoconta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_tipoconta")
	private byte cdTipoconta;

	@Column(name="ds_tipoconta")
	private String dsTipoconta;

	@Column(name="qt_processos")
	private short qtProcessos;

	@Column(name="qt_usuario")
	private byte qtUsuario;

	private BigDecimal valor;

	public Tipoconta() {
	}

	public byte getCdTipoconta() {
		return this.cdTipoconta;
	}

	public void setCdTipoconta(byte cdTipoconta) {
		this.cdTipoconta = cdTipoconta;
	}

	public String getDsTipoconta() {
		return this.dsTipoconta;
	}

	public void setDsTipoconta(String dsTipoconta) {
		this.dsTipoconta = dsTipoconta;
	}

	public short getQtProcessos() {
		return this.qtProcessos;
	}

	public void setQtProcessos(short qtProcessos) {
		this.qtProcessos = qtProcessos;
	}

	public byte getQtUsuario() {
		return this.qtUsuario;
	}

	public void setQtUsuario(byte qtUsuario) {
		this.qtUsuario = qtUsuario;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}