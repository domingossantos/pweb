/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
    @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedidos.findByIdTransacao", query = "SELECT p FROM Pedidos p WHERE p.idTransacao = :idTransacao"),
    @NamedQuery(name = "Pedidos.findByDtPedido", query = "SELECT p FROM Pedidos p WHERE p.dtPedido = :dtPedido"),
    @NamedQuery(name = "Pedidos.findByVlPedido", query = "SELECT p FROM Pedidos p WHERE p.vlPedido = :vlPedido"),
    @NamedQuery(name = "Pedidos.findByTpPagamento", query = "SELECT p FROM Pedidos p WHERE p.tpPagamento = :tpPagamento"),
    @NamedQuery(name = "Pedidos.findByIdItem", query = "SELECT p FROM Pedidos p WHERE p.idItem = :idItem"),
    @NamedQuery(name = "Pedidos.findByIdContrato", query = "SELECT p FROM Pedidos p WHERE p.idContrato = :idContrato"),
    @NamedQuery(name = "Pedidos.findByStPedido", query = "SELECT p FROM Pedidos p WHERE p.stPedido = :stPedido")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Long idPedido;
    @Column(name = "id_transacao")
    private String idTransacao;
    @Column(name = "dt_pedido")
    @Temporal(TemporalType.DATE)
    private Date dtPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_pedido")
    private BigDecimal vlPedido;
    @Column(name = "tp_pagamento")
    private Integer tpPagamento;
    @Column(name = "id_item")
    private Integer idItem;
    @Column(name = "id_contrato")
    private Integer idContrato;
    @Column(name = "st_pedido")
    private Character stPedido;

    public Pedidos() {
    }

    public Pedidos(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public BigDecimal getVlPedido() {
        return vlPedido;
    }

    public void setVlPedido(BigDecimal vlPedido) {
        this.vlPedido = vlPedido;
    }

    public Integer getTpPagamento() {
        return tpPagamento;
    }

    public void setTpPagamento(Integer tpPagamento) {
        this.tpPagamento = tpPagamento;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Character getStPedido() {
        return stPedido;
    }

    public void setStPedido(Character stPedido) {
        this.stPedido = stPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Pedidos[ idPedido=" + idPedido + " ]";
    }
    
}
