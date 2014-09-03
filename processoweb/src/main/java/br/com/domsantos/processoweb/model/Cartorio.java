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
@Table(name = "cartorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartorio.findAll", query = "SELECT c FROM Cartorio c"),
    @NamedQuery(name = "Cartorio.findByCdCartorio", query = "SELECT c FROM Cartorio c WHERE c.cdCartorio = :cdCartorio"),
    @NamedQuery(name = "Cartorio.findByDsCartorio", query = "SELECT c FROM Cartorio c WHERE c.dsCartorio = :dsCartorio"),
    @NamedQuery(name = "Cartorio.findByNrFone", query = "SELECT c FROM Cartorio c WHERE c.nrFone = :nrFone"),
    @NamedQuery(name = "Cartorio.findByNmContato", query = "SELECT c FROM Cartorio c WHERE c.nmContato = :nmContato")})
public class Cartorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_cartorio")
    private Integer cdCartorio;
    @Basic(optional = false)
    @Column(name = "ds_cartorio")
    private String dsCartorio;
    @Basic(optional = false)
    @Column(name = "nr_fone")
    private String nrFone;
    @Column(name = "nm_contato")
    private String nmContato;
    @OneToMany(mappedBy = "cdCartorio")
    private List<Processo> processoList;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;

    public Cartorio() {
    }

    public Cartorio(Integer cdCartorio) {
        this.cdCartorio = cdCartorio;
    }

    public Cartorio(Integer cdCartorio, String dsCartorio, String nrFone) {
        this.cdCartorio = cdCartorio;
        this.dsCartorio = dsCartorio;
        this.nrFone = nrFone;
    }

    public Integer getCdCartorio() {
        return cdCartorio;
    }

    public void setCdCartorio(Integer cdCartorio) {
        this.cdCartorio = cdCartorio;
    }

    public String getDsCartorio() {
        return dsCartorio;
    }

    public void setDsCartorio(String dsCartorio) {
        this.dsCartorio = dsCartorio;
    }

    public String getNrFone() {
        return nrFone;
    }

    public void setNrFone(String nrFone) {
        this.nrFone = nrFone;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
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
        hash += (cdCartorio != null ? cdCartorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartorio)) {
            return false;
        }
        Cartorio other = (Cartorio) object;
        if ((this.cdCartorio == null && other.cdCartorio != null) || (this.cdCartorio != null && !this.cdCartorio.equals(other.cdCartorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Cartorio[ cdCartorio=" + cdCartorio + " ]";
    }
    
}
