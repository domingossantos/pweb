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
@Table(name = "varaforo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Varaforo.findAll", query = "SELECT v FROM Varaforo v"),
    @NamedQuery(name = "Varaforo.findByCdVaraforo", query = "SELECT v FROM Varaforo v WHERE v.cdVaraforo = :cdVaraforo"),
    @NamedQuery(name = "Varaforo.findByDsVaraforo", query = "SELECT v FROM Varaforo v WHERE v.dsVaraforo = :dsVaraforo"),
    @NamedQuery(name = "Varaforo.findByNrFone", query = "SELECT v FROM Varaforo v WHERE v.nrFone = :nrFone"),
    @NamedQuery(name = "Varaforo.findByDsContato", query = "SELECT v FROM Varaforo v WHERE v.dsContato = :dsContato")})
public class Varaforo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_varaforo")
    private Integer cdVaraforo;
    @Basic(optional = false)
    @Column(name = "ds_varaforo")
    private String dsVaraforo;
    @Basic(optional = false)
    @Column(name = "nr_fone")
    private String nrFone;
    @Basic(optional = false)
    @Column(name = "ds_contato")
    private String dsContato;
    @OneToMany(mappedBy = "cdVaraforo")
    private List<Processo> processoList;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;

    public Varaforo() {
    }

    public Varaforo(Integer cdVaraforo) {
        this.cdVaraforo = cdVaraforo;
    }

    public Varaforo(Integer cdVaraforo, String dsVaraforo, String nrFone, String dsContato) {
        this.cdVaraforo = cdVaraforo;
        this.dsVaraforo = dsVaraforo;
        this.nrFone = nrFone;
        this.dsContato = dsContato;
    }

    public Integer getCdVaraforo() {
        return cdVaraforo;
    }

    public void setCdVaraforo(Integer cdVaraforo) {
        this.cdVaraforo = cdVaraforo;
    }

    public String getDsVaraforo() {
        return dsVaraforo;
    }

    public void setDsVaraforo(String dsVaraforo) {
        this.dsVaraforo = dsVaraforo;
    }

    public String getNrFone() {
        return nrFone;
    }

    public void setNrFone(String nrFone) {
        this.nrFone = nrFone;
    }

    public String getDsContato() {
        return dsContato;
    }

    public void setDsContato(String dsContato) {
        this.dsContato = dsContato;
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
        hash += (cdVaraforo != null ? cdVaraforo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Varaforo)) {
            return false;
        }
        Varaforo other = (Varaforo) object;
        if ((this.cdVaraforo == null && other.cdVaraforo != null) || (this.cdVaraforo != null && !this.cdVaraforo.equals(other.cdVaraforo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Varaforo[ cdVaraforo=" + cdVaraforo + " ]";
    }
    
}
