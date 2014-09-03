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
import javax.persistence.FetchType;
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
@Table(name = "advogado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advogado.findAll", query = "SELECT a FROM Advogado a"),
    @NamedQuery(name = "Advogado.findByCdAdvogado", query = "SELECT a FROM Advogado a WHERE a.cdAdvogado = :cdAdvogado"),
    @NamedQuery(name = "Advogado.findByNrOab", query = "SELECT a FROM Advogado a WHERE a.nrOab = :nrOab"),
    @NamedQuery(name = "Advogado.findByNmAdvogado", query = "SELECT a FROM Advogado a WHERE a.nmAdvogado = :nmAdvogado"),
    @NamedQuery(name = "Advogado.findByNrFone", query = "SELECT a FROM Advogado a WHERE a.nrFone = :nrFone"),
    @NamedQuery(name = "Advogado.findByDsLogin", query = "SELECT a FROM Advogado a WHERE a.dsLogin = :dsLogin"),
    @NamedQuery(name = "Advogado.findByVlSenha", query = "SELECT a FROM Advogado a WHERE a.vlSenha = :vlSenha"),
    @NamedQuery(name = "Advogado.findByNrCelular", query = "SELECT a FROM Advogado a WHERE a.nrCelular = :nrCelular"),
    @NamedQuery(name = "Advogado.findByDsEmail", query = "SELECT a FROM Advogado a WHERE a.dsEmail = :dsEmail"),
    @NamedQuery(name = "Advogado.findByTpAdv", query = "SELECT a FROM Advogado a WHERE a.tpAdv = :tpAdv"),
    @NamedQuery(name = "Advogado.findByTpUsuario", query = "SELECT a FROM Advogado a WHERE a.tpUsuario = :tpUsuario"),
    @NamedQuery(name = "Advogado.findByStMaster", query = "SELECT a FROM Advogado a WHERE a.stMaster = :stMaster")})
public class Advogado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_advogado")
    private Integer cdAdvogado;
    @Column(name = "nr_oab")
    private String nrOab;
    @Basic(optional = false)
    @Column(name = "nm_advogado")
    private String nmAdvogado;
    @Basic(optional = false)
    @Column(name = "nr_fone")
    private String nrFone;
    @Basic(optional = false)
    @Column(name = "ds_login")
    private String dsLogin;
    @Basic(optional = false)
    @Column(name = "vl_senha")
    private String vlSenha;
    @Basic(optional = false)
    @Column(name = "nr_celular")
    private String nrCelular;
    @Basic(optional = false)
    @Column(name = "ds_email")
    private String dsEmail;
    @Column(name = "tp_adv")
    private Character tpAdv;
    @Column(name = "tp_usuario")
    private Character tpUsuario;
    @Column(name = "st_master")
    private Character stMaster;
    @OneToMany(mappedBy = "cdAdvogado")
    private List<Processo> processoList;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private Cadastro cadastro;

    public Advogado() {
    }

    public Advogado(Integer cdAdvogado) {
        this.cdAdvogado = cdAdvogado;
    }

    public Advogado(Integer cdAdvogado, String nmAdvogado, String nrFone, String dsLogin, String vlSenha, String nrCelular, String dsEmail) {
        this.cdAdvogado = cdAdvogado;
        this.nmAdvogado = nmAdvogado;
        this.nrFone = nrFone;
        this.dsLogin = dsLogin;
        this.vlSenha = vlSenha;
        this.nrCelular = nrCelular;
        this.dsEmail = dsEmail;
    }

    public Integer getCdAdvogado() {
        return cdAdvogado;
    }

    public void setCdAdvogado(Integer cdAdvogado) {
        this.cdAdvogado = cdAdvogado;
    }

    public String getNrOab() {
        return nrOab;
    }

    public void setNrOab(String nrOab) {
        this.nrOab = nrOab;
    }

    public String getNmAdvogado() {
        return nmAdvogado;
    }

    public void setNmAdvogado(String nmAdvogado) {
        this.nmAdvogado = nmAdvogado;
    }

    public String getNrFone() {
        return nrFone;
    }

    public void setNrFone(String nrFone) {
        this.nrFone = nrFone;
    }

    public String getDsLogin() {
        return dsLogin;
    }

    public void setDsLogin(String dsLogin) {
        this.dsLogin = dsLogin;
    }

    public String getVlSenha() {
        return vlSenha;
    }

    public void setVlSenha(String vlSenha) {
        this.vlSenha = vlSenha;
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

    public Character getTpAdv() {
        return tpAdv;
    }

    public void setTpAdv(Character tpAdv) {
        this.tpAdv = tpAdv;
    }

    public Character getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(Character tpUsuario) {
        this.tpUsuario = tpUsuario;
    }

    public Character getStMaster() {
        return stMaster;
    }

    public void setStMaster(Character stMaster) {
        this.stMaster = stMaster;
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
        hash += (cdAdvogado != null ? cdAdvogado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advogado)) {
            return false;
        }
        Advogado other = (Advogado) object;
        if ((this.cdAdvogado == null && other.cdAdvogado != null) || (this.cdAdvogado != null && !this.cdAdvogado.equals(other.cdAdvogado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Advogado[ cdAdvogado=" + cdAdvogado + " ]";
    }
    
}
