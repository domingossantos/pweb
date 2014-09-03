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
@Table(name = "boletocadastro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletocadastro.findAll", query = "SELECT b FROM Boletocadastro b"),
    @NamedQuery(name = "Boletocadastro.findByCdBoletocadastro", query = "SELECT b FROM Boletocadastro b WHERE b.cdBoletocadastro = :cdBoletocadastro"),
    @NamedQuery(name = "Boletocadastro.findByVlNossonumero", query = "SELECT b FROM Boletocadastro b WHERE b.vlNossonumero = :vlNossonumero"),
    @NamedQuery(name = "Boletocadastro.findByDtVencimento", query = "SELECT b FROM Boletocadastro b WHERE b.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "Boletocadastro.findByVlBoleto", query = "SELECT b FROM Boletocadastro b WHERE b.vlBoleto = :vlBoleto"),
    @NamedQuery(name = "Boletocadastro.findByStBoleto", query = "SELECT b FROM Boletocadastro b WHERE b.stBoleto = :stBoleto")})
public class Boletocadastro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_boletocadastro")
    private Integer cdBoletocadastro;
    @Column(name = "vl_nossonumero")
    private String vlNossonumero;
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Column(name = "vl_boleto")
    private String vlBoleto;
    @Column(name = "st_boleto")
    private Character stBoleto;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne
    private Cadastro cadastro;

    public Boletocadastro() {
    }

    public Boletocadastro(Integer cdBoletocadastro) {
        this.cdBoletocadastro = cdBoletocadastro;
    }

    public Integer getCdBoletocadastro() {
        return cdBoletocadastro;
    }

    public void setCdBoletocadastro(Integer cdBoletocadastro) {
        this.cdBoletocadastro = cdBoletocadastro;
    }

    public String getVlNossonumero() {
        return vlNossonumero;
    }

    public void setVlNossonumero(String vlNossonumero) {
        this.vlNossonumero = vlNossonumero;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getVlBoleto() {
        return vlBoleto;
    }

    public void setVlBoleto(String vlBoleto) {
        this.vlBoleto = vlBoleto;
    }

    public Character getStBoleto() {
        return stBoleto;
    }

    public void setStBoleto(Character stBoleto) {
        this.stBoleto = stBoleto;
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
        hash += (cdBoletocadastro != null ? cdBoletocadastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boletocadastro)) {
            return false;
        }
        Boletocadastro other = (Boletocadastro) object;
        if ((this.cdBoletocadastro == null && other.cdBoletocadastro != null) || (this.cdBoletocadastro != null && !this.cdBoletocadastro.equals(other.cdBoletocadastro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Boletocadastro[ cdBoletocadastro=" + cdBoletocadastro + " ]";
    }
    
}
