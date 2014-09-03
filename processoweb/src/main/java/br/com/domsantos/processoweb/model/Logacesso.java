/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
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
@Table(name = "logacesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logacesso.findAll", query = "SELECT l FROM Logacesso l"),
    @NamedQuery(name = "Logacesso.findByCdLogacesso", query = "SELECT l FROM Logacesso l WHERE l.cdLogacesso = :cdLogacesso"),
    @NamedQuery(name = "Logacesso.findByDtUltimoacesso", query = "SELECT l FROM Logacesso l WHERE l.dtUltimoacesso = :dtUltimoacesso"),
    @NamedQuery(name = "Logacesso.findByCdAdvogado", query = "SELECT l FROM Logacesso l WHERE l.cdAdvogado = :cdAdvogado")})
public class Logacesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_logacesso")
    private Integer cdLogacesso;
    @Basic(optional = false)
    @Column(name = "dt_ultimoacesso")
    @Temporal(TemporalType.DATE)
    private Date dtUltimoacesso;
    @Basic(optional = false)
    @Column(name = "cd_advogado")
    private int cdAdvogado;

    public Logacesso() {
    }

    public Logacesso(Integer cdLogacesso) {
        this.cdLogacesso = cdLogacesso;
    }

    public Logacesso(Integer cdLogacesso, Date dtUltimoacesso, int cdAdvogado) {
        this.cdLogacesso = cdLogacesso;
        this.dtUltimoacesso = dtUltimoacesso;
        this.cdAdvogado = cdAdvogado;
    }

    public Integer getCdLogacesso() {
        return cdLogacesso;
    }

    public void setCdLogacesso(Integer cdLogacesso) {
        this.cdLogacesso = cdLogacesso;
    }

    public Date getDtUltimoacesso() {
        return dtUltimoacesso;
    }

    public void setDtUltimoacesso(Date dtUltimoacesso) {
        this.dtUltimoacesso = dtUltimoacesso;
    }

    public int getCdAdvogado() {
        return cdAdvogado;
    }

    public void setCdAdvogado(int cdAdvogado) {
        this.cdAdvogado = cdAdvogado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdLogacesso != null ? cdLogacesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logacesso)) {
            return false;
        }
        Logacesso other = (Logacesso) object;
        if ((this.cdLogacesso == null && other.cdLogacesso != null) || (this.cdLogacesso != null && !this.cdLogacesso.equals(other.cdLogacesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Logacesso[ cdLogacesso=" + cdLogacesso + " ]";
    }
    
}
