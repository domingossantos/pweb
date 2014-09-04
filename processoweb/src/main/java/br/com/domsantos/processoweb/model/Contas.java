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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "contas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c"),
    @NamedQuery(name = "Contas.findByCdConta", query = "SELECT c FROM Contas c WHERE c.cdConta = :cdConta"),
    @NamedQuery(name = "Contas.findByTpOperacao", query = "SELECT c FROM Contas c WHERE c.tpOperacao = :tpOperacao"),
    @NamedQuery(name = "Contas.findByVlConta", query = "SELECT c FROM Contas c WHERE c.vlConta = :vlConta"),
    @NamedQuery(name = "Contas.findByDsConta", query = "SELECT c FROM Contas c WHERE c.dsConta = :dsConta"),
    @NamedQuery(name = "Contas.findByDtConta", query = "SELECT c FROM Contas c WHERE c.dtConta = :dtConta")})
public class Contas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_conta")
    private Integer cdConta;
    @Basic(optional = false)
    @Column(name = "tp_operacao")
    private Character tpOperacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "vl_conta")
    private BigDecimal vlConta;
    @Basic(optional = false)
    @Column(name = "ds_conta")
    private String dsConta;
    @Basic(optional = false)
    @Column(name = "dt_conta")
    @Temporal(TemporalType.DATE)
    private Date dtConta;
    @JoinColumn(name = "cd_processo", referencedColumnName = "cd_processo")
    @ManyToOne
    private Processo processo;

    public Contas() {
    }

    public Contas(Integer cdConta) {
        this.cdConta = cdConta;
    }

    public Contas(Integer cdConta, Character tpOperacao, BigDecimal vlConta, String dsConta, Date dtConta) {
        this.cdConta = cdConta;
        this.tpOperacao = tpOperacao;
        this.vlConta = vlConta;
        this.dsConta = dsConta;
        this.dtConta = dtConta;
    }

    public Integer getCdConta() {
        return cdConta;
    }

    public void setCdConta(Integer cdConta) {
        this.cdConta = cdConta;
    }

    public Character getTpOperacao() {
        return tpOperacao;
    }

    public void setTpOperacao(Character tpOperacao) {
        this.tpOperacao = tpOperacao;
    }

    public BigDecimal getVlConta() {
        return vlConta;
    }

    public void setVlConta(BigDecimal vlConta) {
        this.vlConta = vlConta;
    }

    public String getDsConta() {
        return dsConta;
    }

    public void setDsConta(String dsConta) {
        this.dsConta = dsConta;
    }

    public Date getDtConta() {
        return dtConta;
    }

    public void setDtConta(Date dtConta) {
        this.dtConta = dtConta;
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
        hash += (cdConta != null ? cdConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.cdConta == null && other.cdConta != null) || (this.cdConta != null && !this.cdConta.equals(other.cdConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Contas[ cdConta=" + cdConta + " ]";
    }
    
}
