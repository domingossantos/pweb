package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the item_pedido database table.
 * 
 */
@Entity
@Table(name="item_pedido")
@NamedQuery(name="ItemPedido.findAll", query="SELECT i FROM ItemPedido i")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private int idItem;

	@Column(name="ds_item")
	private String dsItem;

	@Column(name="qt_meses")
	private int qtMeses;

	@Column(name="vl_item")
	private BigDecimal vlItem;

	public ItemPedido() {
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getDsItem() {
		return this.dsItem;
	}

	public void setDsItem(String dsItem) {
		this.dsItem = dsItem;
	}

	public int getQtMeses() {
		return this.qtMeses;
	}

	public void setQtMeses(int qtMeses) {
		this.qtMeses = qtMeses;
	}

	public BigDecimal getVlItem() {
		return this.vlItem;
	}

	public void setVlItem(BigDecimal vlItem) {
		this.vlItem = vlItem;
	}

}