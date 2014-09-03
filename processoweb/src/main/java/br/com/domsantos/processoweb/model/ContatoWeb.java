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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "contato_web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContatoWeb.findAll", query = "SELECT c FROM ContatoWeb c"),
    @NamedQuery(name = "ContatoWeb.findByIdContatoweb", query = "SELECT c FROM ContatoWeb c WHERE c.idContatoweb = :idContatoweb"),
    @NamedQuery(name = "ContatoWeb.findByNmContatoweb", query = "SELECT c FROM ContatoWeb c WHERE c.nmContatoweb = :nmContatoweb"),
    @NamedQuery(name = "ContatoWeb.findByDsEmail", query = "SELECT c FROM ContatoWeb c WHERE c.dsEmail = :dsEmail")})
public class ContatoWeb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contatoweb")
    private Integer idContatoweb;
    @Column(name = "nm_contatoweb")
    private String nmContatoweb;
    @Column(name = "ds_email")
    private String dsEmail;

    public ContatoWeb() {
    }

    public ContatoWeb(Integer idContatoweb) {
        this.idContatoweb = idContatoweb;
    }

    public Integer getIdContatoweb() {
        return idContatoweb;
    }

    public void setIdContatoweb(Integer idContatoweb) {
        this.idContatoweb = idContatoweb;
    }

    public String getNmContatoweb() {
        return nmContatoweb;
    }

    public void setNmContatoweb(String nmContatoweb) {
        this.nmContatoweb = nmContatoweb;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContatoweb != null ? idContatoweb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContatoWeb)) {
            return false;
        }
        ContatoWeb other = (ContatoWeb) object;
        if ((this.idContatoweb == null && other.idContatoweb != null) || (this.idContatoweb != null && !this.idContatoweb.equals(other.idContatoweb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.ContatoWeb[ idContatoweb=" + idContatoweb + " ]";
    }
    
}
