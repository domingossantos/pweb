/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "item_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPedido.findAll", query = "SELECT i FROM ItemPedido i"),
    @NamedQuery(name = "ItemPedido.findByIdItem", query = "SELECT i FROM ItemPedido i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "ItemPedido.findByDsItem", query = "SELECT i FROM ItemPedido i WHERE i.dsItem = :dsItem"),
    @NamedQuery(name = "ItemPedido.findByVlItem", query = "SELECT i FROM ItemPedido i WHERE i.vlItem = :vlItem"),
    @NamedQuery(name = "ItemPedido.findByQtMeses", query = "SELECT i FROM ItemPedido i WHERE i.qtMeses = :qtMeses")})
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item")
    private Integer idItem;
    @Column(name = "ds_item")
    private String dsItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_item")
    private BigDecimal vlItem;
    @Basic(optional = false)
    @Column(name = "qt_meses")
    private int qtMeses;

    public ItemPedido() {
    }

    public ItemPedido(Integer idItem) {
        this.idItem = idItem;
    }

    public ItemPedido(Integer idItem, int qtMeses) {
        this.idItem = idItem;
        this.qtMeses = qtMeses;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getDsItem() {
        return dsItem;
    }

    public void setDsItem(String dsItem) {
        this.dsItem = dsItem;
    }

    public BigDecimal getVlItem() {
        return vlItem;
    }

    public void setVlItem(BigDecimal vlItem) {
        this.vlItem = vlItem;
    }

    public int getQtMeses() {
        return qtMeses;
    }

    public void setQtMeses(int qtMeses) {
        this.qtMeses = qtMeses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.ItemPedido[ idItem=" + idItem + " ]";
    }
    
}
