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
import javax.persistence.Lob;
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
@Table(name = "favoritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoritos.findAll", query = "SELECT f FROM Favoritos f"),
    @NamedQuery(name = "Favoritos.findByCdFavoritos", query = "SELECT f FROM Favoritos f WHERE f.cdFavoritos = :cdFavoritos"),
    @NamedQuery(name = "Favoritos.findByDsUrl", query = "SELECT f FROM Favoritos f WHERE f.dsUrl = :dsUrl"),
    @NamedQuery(name = "Favoritos.findByDsFavorito", query = "SELECT f FROM Favoritos f WHERE f.dsFavorito = :dsFavorito"),
    @NamedQuery(name = "Favoritos.findByTpFavorito", query = "SELECT f FROM Favoritos f WHERE f.tpFavorito = :tpFavorito"),
    @NamedQuery(name = "Favoritos.findByDsAutor", query = "SELECT f FROM Favoritos f WHERE f.dsAutor = :dsAutor"),
    @NamedQuery(name = "Favoritos.findByDsObs", query = "SELECT f FROM Favoritos f WHERE f.dsObs = :dsObs"),
    @NamedQuery(name = "Favoritos.findByCdAdvogado", query = "SELECT f FROM Favoritos f WHERE f.cdAdvogado = :cdAdvogado")})
public class Favoritos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_favoritos")
    private Integer cdFavoritos;
    @Column(name = "ds_url")
    private String dsUrl;
    @Column(name = "ds_favorito")
    private String dsFavorito;
    @Column(name = "tp_favorito")
    private Character tpFavorito;
    @Column(name = "ds_autor")
    private String dsAutor;
    @Column(name = "ds_obs")
    private String dsObs;
    @Column(name = "cd_advogado")
    private Integer cdAdvogado;
    @Lob
    @Column(name = "tx_favorito")
    private String txFavorito;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne
    private Cadastro cadastro;

    public Favoritos() {
    }

    public Favoritos(Integer cdFavoritos) {
        this.cdFavoritos = cdFavoritos;
    }

    public Integer getCdFavoritos() {
        return cdFavoritos;
    }

    public void setCdFavoritos(Integer cdFavoritos) {
        this.cdFavoritos = cdFavoritos;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getDsFavorito() {
        return dsFavorito;
    }

    public void setDsFavorito(String dsFavorito) {
        this.dsFavorito = dsFavorito;
    }

    public Character getTpFavorito() {
        return tpFavorito;
    }

    public void setTpFavorito(Character tpFavorito) {
        this.tpFavorito = tpFavorito;
    }

    public String getDsAutor() {
        return dsAutor;
    }

    public void setDsAutor(String dsAutor) {
        this.dsAutor = dsAutor;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    public Integer getCdAdvogado() {
        return cdAdvogado;
    }

    public void setCdAdvogado(Integer cdAdvogado) {
        this.cdAdvogado = cdAdvogado;
    }

    public String getTxFavorito() {
        return txFavorito;
    }

    public void setTxFavorito(String txFavorito) {
        this.txFavorito = txFavorito;
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
        hash += (cdFavoritos != null ? cdFavoritos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favoritos)) {
            return false;
        }
        Favoritos other = (Favoritos) object;
        if ((this.cdFavoritos == null && other.cdFavoritos != null) || (this.cdFavoritos != null && !this.cdFavoritos.equals(other.cdFavoritos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Favoritos[ cdFavoritos=" + cdFavoritos + " ]";
    }
    
}
