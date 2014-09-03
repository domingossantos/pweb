/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
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
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByCdAgenda", query = "SELECT a FROM Agenda a WHERE a.cdAgenda = :cdAgenda"),
    @NamedQuery(name = "Agenda.findByNmContato", query = "SELECT a FROM Agenda a WHERE a.nmContato = :nmContato"),
    @NamedQuery(name = "Agenda.findByNrFone", query = "SELECT a FROM Agenda a WHERE a.nrFone = :nrFone"),
    @NamedQuery(name = "Agenda.findByNrCelular", query = "SELECT a FROM Agenda a WHERE a.nrCelular = :nrCelular"),
    @NamedQuery(name = "Agenda.findByDsEmail", query = "SELECT a FROM Agenda a WHERE a.dsEmail = :dsEmail"),
    @NamedQuery(name = "Agenda.findByDsObs", query = "SELECT a FROM Agenda a WHERE a.dsObs = :dsObs"),
    @NamedQuery(name = "Agenda.findByNrFoneres", query = "SELECT a FROM Agenda a WHERE a.nrFoneres = :nrFoneres")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_agenda")
    private Integer cdAgenda;
    @Basic(optional = false)
    @Column(name = "nm_contato")
    private String nmContato;
    @Basic(optional = false)
    @Column(name = "nr_fone")
    private String nrFone;
    @Basic(optional = false)
    @Column(name = "nr_celular")
    private String nrCelular;
    @Basic(optional = false)
    @Column(name = "ds_email")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "ds_obs")
    private String dsObs;
    @Column(name = "nr_foneres")
    private String nrFoneres;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;

    public Agenda() {
    }

    public Agenda(Integer cdAgenda) {
        this.cdAgenda = cdAgenda;
    }

    public Agenda(Integer cdAgenda, String nmContato, String nrFone, String nrCelular, String dsEmail, String dsObs) {
        this.cdAgenda = cdAgenda;
        this.nmContato = nmContato;
        this.nrFone = nrFone;
        this.nrCelular = nrCelular;
        this.dsEmail = dsEmail;
        this.dsObs = dsObs;
    }

    public Integer getCdAgenda() {
        return cdAgenda;
    }

    public void setCdAgenda(Integer cdAgenda) {
        this.cdAgenda = cdAgenda;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public String getNrFone() {
        return nrFone;
    }

    public void setNrFone(String nrFone) {
        this.nrFone = nrFone;
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    public String getNrFoneres() {
        return nrFoneres;
    }

    public void setNrFoneres(String nrFoneres) {
        this.nrFoneres = nrFoneres;
    }

    public Cadastro getCdCadastro() {
        return cadastro;
    }

    public void setCdCadastro(Cadastro cdCadastro) {
        this.cadastro = cdCadastro;
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
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.cdAgenda == null && other.cdAgenda != null) || (this.cdAgenda != null && !this.cdAgenda.equals(other.cdAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Agenda[ cdAgenda=" + cdAgenda + " ]";
    }
    
}
