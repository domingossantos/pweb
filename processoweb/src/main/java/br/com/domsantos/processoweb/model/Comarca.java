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
@Table(name = "comarca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comarca.findAll", query = "SELECT c FROM Comarca c"),
    @NamedQuery(name = "Comarca.findByCdComarca", query = "SELECT c FROM Comarca c WHERE c.cdComarca = :cdComarca"),
    @NamedQuery(name = "Comarca.findByDsComarca", query = "SELECT c FROM Comarca c WHERE c.dsComarca = :dsComarca"),
    @NamedQuery(name = "Comarca.findByNrFone", query = "SELECT c FROM Comarca c WHERE c.nrFone = :nrFone"),
    @NamedQuery(name = "Comarca.findByNmContato", query = "SELECT c FROM Comarca c WHERE c.nmContato = :nmContato")})
public class Comarca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_comarca")
    private Integer cdComarca;
    @Column(name = "ds_comarca")
    private String dsComarca;
    @Column(name = "nr_fone")
    private String nrFone;
    @Column(name = "nm_contato")
    private String nmContato;
    @OneToMany(mappedBy = "cdComarca")
    private List<Processo> processoList;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne
    private Cadastro cadastro;

    public Comarca() {
    }

    public Comarca(Integer cdComarca) {
        this.cdComarca = cdComarca;
    }

    public Integer getCdComarca() {
        return cdComarca;
    }

    public void setCdComarca(Integer cdComarca) {
        this.cdComarca = cdComarca;
    }

    public String getDsComarca() {
        return dsComarca;
    }

    public void setDsComarca(String dsComarca) {
        this.dsComarca = dsComarca;
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
        hash += (cdComarca != null ? cdComarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comarca)) {
            return false;
        }
        Comarca other = (Comarca) object;
        if ((this.cdComarca == null && other.cdComarca != null) || (this.cdComarca != null && !this.cdComarca.equals(other.cdComarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Comarca[ cdComarca=" + cdComarca + " ]";
    }
    
}
