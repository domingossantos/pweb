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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByCdBanco", query = "SELECT b FROM Banco b WHERE b.cdBanco = :cdBanco"),
    @NamedQuery(name = "Banco.findByCdAdvogado", query = "SELECT b FROM Banco b WHERE b.cdAdvogado = :cdAdvogado"),
    @NamedQuery(name = "Banco.findByDsBanco", query = "SELECT b FROM Banco b WHERE b.dsBanco = :dsBanco"),
    @NamedQuery(name = "Banco.findByVlBanco", query = "SELECT b FROM Banco b WHERE b.vlBanco = :vlBanco")})
public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_banco")
    private Integer cdBanco;
    @Basic(optional = false)
    @Column(name = "cd_advogado")
    private int cdAdvogado;
    @Basic(optional = false)
    @Column(name = "ds_banco")
    private String dsBanco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vl_banco")
    private BigDecimal vlBanco;
    @JoinColumn(name = "cd_processo", referencedColumnName = "cd_processo")
    @ManyToOne(optional = false)
    private Processo processo;

    public Banco() {
    }

    public Banco(Integer cdBanco) {
        this.cdBanco = cdBanco;
    }

    public Banco(Integer cdBanco, int cdAdvogado, String dsBanco, BigDecimal vlBanco) {
        this.cdBanco = cdBanco;
        this.cdAdvogado = cdAdvogado;
        this.dsBanco = dsBanco;
        this.vlBanco = vlBanco;
    }

    public Integer getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(Integer cdBanco) {
        this.cdBanco = cdBanco;
    }

    public int getCdAdvogado() {
        return cdAdvogado;
    }

    public void setCdAdvogado(int cdAdvogado) {
        this.cdAdvogado = cdAdvogado;
    }

    public String getDsBanco() {
        return dsBanco;
    }

    public void setDsBanco(String dsBanco) {
        this.dsBanco = dsBanco;
    }

    public BigDecimal getVlBanco() {
        return vlBanco;
    }

    public void setVlBanco(BigDecimal vlBanco) {
        this.vlBanco = vlBanco;
    }

    public Processo getCdProcesso() {
        return processo;
    }

    public void setCdProcesso(Processo cdProcesso) {
        this.processo = cdProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdBanco != null ? cdBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.cdBanco == null && other.cdBanco != null) || (this.cdBanco != null && !this.cdBanco.equals(other.cdBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Banco[ cdBanco=" + cdBanco + " ]";
    }
    
}
