package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private String idPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_pedido")
	private Date dtPedido;

	@Column(name="id_contrato")
	private int idContrato;

	@Column(name="id_item")
	private int idItem;

	@Column(name="id_transacao")
	private String idTransacao;

	@Column(name="st_pedido")
	private String stPedido;

	@Column(name="tp_pagamento")
	private int tpPagamento;

	@Column(name="vl_pedido")
	private BigDecimal vlPedido;

	public Pedido() {
	}

	public String getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDtPedido() {
		return this.dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	public int getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getIdTransacao() {
		return this.idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getStPedido() {
		return this.stPedido;
	}

	public void setStPedido(String stPedido) {
		this.stPedido = stPedido;
	}

	public int getTpPagamento() {
		return this.tpPagamento;
	}

	public void setTpPagamento(int tpPagamento) {
		this.tpPagamento = tpPagamento;
	}

	public BigDecimal getVlPedido() {
		return this.vlPedido;
	}

	public void setVlPedido(BigDecimal vlPedido) {
		this.vlPedido = vlPedido;
	}

}