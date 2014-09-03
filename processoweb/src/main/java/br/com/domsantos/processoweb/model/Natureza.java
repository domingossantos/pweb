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
@Table(name = "natureza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Natureza.findAll", query = "SELECT n FROM Natureza n"),
    @NamedQuery(name = "Natureza.findByCdNatureza", query = "SELECT n FROM Natureza n WHERE n.cdNatureza = :cdNatureza"),
    @NamedQuery(name = "Natureza.findByDsNatureza", query = "SELECT n FROM Natureza n WHERE n.dsNatureza = :dsNatureza")})
public class Natureza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_natureza")
    private Integer cdNatureza;
    @Column(name = "ds_natureza")
    private String dsNatureza;
    @OneToMany(mappedBy = "cdNatcausa")
    private List<Processo> processoList;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;

    public Natureza() {
    }

    public Natureza(Integer cdNatureza) {
        this.cdNatureza = cdNatureza;
    }

    public Integer getCdNatureza() {
        return cdNatureza;
    }

    public void setCdNatureza(Integer cdNatureza) {
        this.cdNatureza = cdNatureza;
    }

    public String getDsNatureza() {
        return dsNatureza;
    }

    public void setDsNatureza(String dsNatureza) {
        this.dsNatureza = dsNatureza;
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
        hash += (cdNatureza != null ? cdNatureza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Natureza)) {
            return false;
        }
        Natureza other = (Natureza) object;
        if ((this.cdNatureza == null && other.cdNatureza != null) || (this.cdNatureza != null && !this.cdNatureza.equals(other.cdNatureza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Natureza[ cdNatureza=" + cdNatureza + " ]";
    }
    
}
