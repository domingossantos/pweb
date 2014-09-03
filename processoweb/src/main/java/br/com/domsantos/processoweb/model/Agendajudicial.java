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
@Table(name = "agendajudicial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendajudicial.findAll", query = "SELECT a FROM Agendajudicial a"),
    @NamedQuery(name = "Agendajudicial.findByCdAgenda", query = "SELECT a FROM Agendajudicial a WHERE a.cdAgenda = :cdAgenda"),
    @NamedQuery(name = "Agendajudicial.findByDtAgenda", query = "SELECT a FROM Agendajudicial a WHERE a.dtAgenda = :dtAgenda"),
    @NamedQuery(name = "Agendajudicial.findByHrAgenda", query = "SELECT a FROM Agendajudicial a WHERE a.hrAgenda = :hrAgenda"),
    @NamedQuery(name = "Agendajudicial.findByDsObs", query = "SELECT a FROM Agendajudicial a WHERE a.dsObs = :dsObs")})
public class Agendajudicial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_agenda")
    private Integer cdAgenda;
    @Basic(optional = false)
    @Column(name = "dt_agenda")
    @Temporal(TemporalType.DATE)
    private Date dtAgenda;
    @Basic(optional = false)
    @Column(name = "hr_agenda")
    @Temporal(TemporalType.TIME)
    private Date hrAgenda;
    @Basic(optional = false)
    @Column(name = "ds_obs")
    private String dsObs;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;
    @JoinColumn(name = "cd_processo", referencedColumnName = "cd_processo")
    @ManyToOne(optional = false)
    private Processo processo;

    public Agendajudicial() {
    }

    public Agendajudicial(Integer cdAgenda) {
        this.cdAgenda = cdAgenda;
    }

    public Agendajudicial(Integer cdAgenda, Date dtAgenda, Date hrAgenda, String dsObs) {
        this.cdAgenda = cdAgenda;
        this.dtAgenda = dtAgenda;
        this.hrAgenda = hrAgenda;
        this.dsObs = dsObs;
    }

    public Integer getCdAgenda() {
        return cdAgenda;
    }

    public void setCdAgenda(Integer cdAgenda) {
        this.cdAgenda = cdAgenda;
    }

    public Date getDtAgenda() {
        return dtAgenda;
    }

    public void setDtAgenda(Date dtAgenda) {
        this.dtAgenda = dtAgenda;
    }

    public Date getHrAgenda() {
        return hrAgenda;
    }

    public void setHrAgenda(Date hrAgenda) {
        this.hrAgenda = hrAgenda;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    public Cadastro getCdCadastro() {
        return cadastro;
    }

    public void setCdCadastro(Cadastro cdCadastro) {
        this.cadastro = cdCadastro;
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
        hash += (cdAgenda != null ? cdAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendajudicial)) {
            return false;
        }
        Agendajudicial other = (Agendajudicial) object;
        if ((this.cdAgenda == null && other.cdAgenda != null) || (this.cdAgenda != null && !this.cdAgenda.equals(other.cdAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Agendajudicial[ cdAgenda=" + cdAgenda + " ]";
    }
    
}
