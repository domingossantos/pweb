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
@Table(name = "tipoconta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoconta.findAll", query = "SELECT t FROM Tipoconta t"),
    @NamedQuery(name = "Tipoconta.findByCdTipoconta", query = "SELECT t FROM Tipoconta t WHERE t.cdTipoconta = :cdTipoconta"),
    @NamedQuery(name = "Tipoconta.findByDsTipoconta", query = "SELECT t FROM Tipoconta t WHERE t.dsTipoconta = :dsTipoconta"),
    @NamedQuery(name = "Tipoconta.findByQtUsuario", query = "SELECT t FROM Tipoconta t WHERE t.qtUsuario = :qtUsuario"),
    @NamedQuery(name = "Tipoconta.findByQtProcessos", query = "SELECT t FROM Tipoconta t WHERE t.qtProcessos = :qtProcessos"),
    @NamedQuery(name = "Tipoconta.findByValor", query = "SELECT t FROM Tipoconta t WHERE t.valor = :valor")})
public class Tipoconta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cd_tipoconta")
    private Short cdTipoconta;
    @Column(name = "ds_tipoconta")
    private String dsTipoconta;
    @Column(name = "qt_usuario")
    private Short qtUsuario;
    @Column(name = "qt_processos")
    private Short qtProcessos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;

    public Tipoconta() {
    }

    public Tipoconta(Short cdTipoconta) {
        this.cdTipoconta = cdTipoconta;
    }

    public Short getCdTipoconta() {
        return cdTipoconta;
    }

    public void setCdTipoconta(Short cdTipoconta) {
        this.cdTipoconta = cdTipoconta;
    }

    public String getDsTipoconta() {
        return dsTipoconta;
    }

    public void setDsTipoconta(String dsTipoconta) {
        this.dsTipoconta = dsTipoconta;
    }

    public Short getQtUsuario() {
        return qtUsuario;
    }

    public void setQtUsuario(Short qtUsuario) {
        this.qtUsuario = qtUsuario;
    }

    public Short getQtProcessos() {
        return qtProcessos;
    }

    public void setQtProcessos(Short qtProcessos) {
        this.qtProcessos = qtProcessos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipoconta != null ? cdTipoconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoconta)) {
            return false;
        }
        Tipoconta other = (Tipoconta) object;
        if ((this.cdTipoconta == null && other.cdTipoconta != null) || (this.cdTipoconta != null && !this.cdTipoconta.equals(other.cdTipoconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Tipoconta[ cdTipoconta=" + cdTipoconta + " ]";
    }
    
}
