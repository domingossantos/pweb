/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "adverso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adverso.findAll", query = "SELECT a FROM Adverso a"),
    @NamedQuery(name = "Adverso.findByCdAdverso", query = "SELECT a FROM Adverso a WHERE a.cdAdverso = :cdAdverso"),
    @NamedQuery(name = "Adverso.findByNmAdverso", query = "SELECT a FROM Adverso a WHERE a.nmAdverso = :nmAdverso"),
    @NamedQuery(name = "Adverso.findByNrFone", query = "SELECT a FROM Adverso a WHERE a.nrFone = :nrFone"),
    @NamedQuery(name = "Adverso.findByNrCelular", query = "SELECT a FROM Adverso a WHERE a.nrCelular = :nrCelular"),
    @NamedQuery(name = "Adverso.findByNrFoneres", query = "SELECT a FROM Adverso a WHERE a.nrFoneres = :nrFoneres"),
    @NamedQuery(name = "Adverso.findByDsEmail", query = "SELECT a FROM Adverso a WHERE a.dsEmail = :dsEmail")})
public class Adverso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_adverso")
    private Integer cdAdverso;
    @Column(name = "nm_adverso")
    private String nmAdverso;
    @Column(name = "nr_fone")
    private String nrFone;
    @Column(name = "nr_celular")
    private String nrCelular;
    @Column(name = "nr_foneres")
    private String nrFoneres;
    @Column(name = "ds_email")
    private String dsEmail;
    @OneToMany(mappedBy = "cdAdverso")
    private List<Processo> processoList;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne
    private Cadastro cadastro;

    public Adverso() {
    }

    public Adverso(Integer cdAdverso) {
        this.cdAdverso = cdAdverso;
    }

    public Integer getCdAdverso() {
        return cdAdverso;
    }

    public void setCdAdverso(Integer cdAdverso) {
        this.cdAdverso = cdAdverso;
    }

    public String getNmAdverso() {
        return nmAdverso;
    }

    public void setNmAdverso(String nmAdverso) {
        this.nmAdverso = nmAdverso;
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

    public String getNrFoneres() {
        return nrFoneres;
    }

    public void setNrFoneres(String nrFoneres) {
        this.nrFoneres = nrFoneres;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
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
        hash += (cdAdverso != null ? cdAdverso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adverso)) {
            return false;
        }
        Adverso other = (Adverso) object;
        if ((this.cdAdverso == null && other.cdAdverso != null) || (this.cdAdverso != null && !this.cdAdverso.equals(other.cdAdverso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Adverso[ cdAdverso=" + cdAdverso + " ]";
    }
    
}
