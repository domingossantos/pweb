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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "processosrelacionados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processosrelacionados.findAll", query = "SELECT p FROM Processosrelacionados p"),
    @NamedQuery(name = "Processosrelacionados.findByIdProcessosRepacionados", query = "SELECT p FROM Processosrelacionados p WHERE p.idProcessosRepacionados = :idProcessosRepacionados"),
    @NamedQuery(name = "Processosrelacionados.findByCdProcessopai", query = "SELECT p FROM Processosrelacionados p WHERE p.processopai = :processopai"),
    @NamedQuery(name = "Processosrelacionados.findByCdProcessofilho", query = "SELECT p FROM Processosrelacionados p WHERE p.processofilho = :processofilho")})
public class Processosrelacionados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_processos_repacionados")
    private Integer idProcessosRepacionados;
    @Basic(optional = false)
    @Column(name = "cd_processopai")
    private int processopai;
    @Basic(optional = false)
    @Column(name = "cd_processofilho")
    private int processofilho;
    @Lob
    @Column(name = "ds_obs")
    private String dsObs;

    public Processosrelacionados() {
    }

    public Processosrelacionados(Integer idProcessosRepacionados) {
        this.idProcessosRepacionados = idProcessosRepacionados;
    }

    public Processosrelacionados(Integer idProcessosRepacionados, int cdProcessopai, int cdProcessofilho) {
        this.idProcessosRepacionados = idProcessosRepacionados;
        this.processopai = cdProcessopai;
        this.processofilho = cdProcessofilho;
    }

    public Integer getIdProcessosRepacionados() {
        return idProcessosRepacionados;
    }

    public void setIdProcessosRepacionados(Integer idProcessosRepacionados) {
        this.idProcessosRepacionados = idProcessosRepacionados;
    }

    public int getCdProcessopai() {
        return processopai;
    }

    public void setCdProcessopai(int cdProcessopai) {
        this.processopai = cdProcessopai;
    }

    public int getCdProcessofilho() {
        return processofilho;
    }

    public void setCdProcessofilho(int cdProcessofilho) {
        this.processofilho = cdProcessofilho;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcessosRepacionados != null ? idProcessosRepacionados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processosrelacionados)) {
            return false;
        }
        Processosrelacionados other = (Processosrelacionados) object;
        if ((this.idProcessosRepacionados == null && other.idProcessosRepacionados != null) || (this.idProcessosRepacionados != null && !this.idProcessosRepacionados.equals(other.idProcessosRepacionados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Processosrelacionados[ idProcessosRepacionados=" + idProcessosRepacionados + " ]";
    }
    
}
