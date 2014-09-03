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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "andamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Andamento.findAll", query = "SELECT a FROM Andamento a"),
    @NamedQuery(name = "Andamento.findByCdAndamento", query = "SELECT a FROM Andamento a WHERE a.cdAndamento = :cdAndamento"),
    @NamedQuery(name = "Andamento.findByDtAndamento", query = "SELECT a FROM Andamento a WHERE a.dtAndamento = :dtAndamento"),
    @NamedQuery(name = "Andamento.findByHrAndamento", query = "SELECT a FROM Andamento a WHERE a.hrAndamento = :hrAndamento")})
public class Andamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_andamento")
    private Integer cdAndamento;
    @Basic(optional = false)
    @Column(name = "dt_andamento")
    @Temporal(TemporalType.DATE)
    private Date dtAndamento;
    @Column(name = "hr_andamento")
    @Temporal(TemporalType.TIME)
    private Date hrAndamento;
    @Basic(optional = false)
    @Lob
    @Column(name = "ds_andamento")
    private String dsAndamento;
    @Basic(optional = false)
    @Lob
    @Column(name = "ds_obs")
    private String dsObs;
    @JoinColumn(name = "cd_processo", referencedColumnName = "cd_processo")
    @ManyToOne(optional = false)
    private Processo processo;

    public Andamento() {
    }

    public Andamento(Integer cdAndamento) {
        this.cdAndamento = cdAndamento;
    }

    public Andamento(Integer cdAndamento, Date dtAndamento, String dsAndamento, String dsObs) {
        this.cdAndamento = cdAndamento;
        this.dtAndamento = dtAndamento;
        this.dsAndamento = dsAndamento;
        this.dsObs = dsObs;
    }

    public Integer getCdAndamento() {
        return cdAndamento;
    }

    public void setCdAndamento(Integer cdAndamento) {
        this.cdAndamento = cdAndamento;
    }

    public Date getDtAndamento() {
        return dtAndamento;
    }

    public void setDtAndamento(Date dtAndamento) {
        this.dtAndamento = dtAndamento;
    }

    public Date getHrAndamento() {
        return hrAndamento;
    }

    public void setHrAndamento(Date hrAndamento) {
        this.hrAndamento = hrAndamento;
    }

    public String getDsAndamento() {
        return dsAndamento;
    }

    public void setDsAndamento(String dsAndamento) {
        this.dsAndamento = dsAndamento;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
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
        hash += (cdAndamento != null ? cdAndamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Andamento)) {
            return false;
        }
        Andamento other = (Andamento) object;
        if ((this.cdAndamento == null && other.cdAndamento != null) || (this.cdAndamento != null && !this.cdAndamento.equals(other.cdAndamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Andamento[ cdAndamento=" + cdAndamento + " ]";
    }
    
}
