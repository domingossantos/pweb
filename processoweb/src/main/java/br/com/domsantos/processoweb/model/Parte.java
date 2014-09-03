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
@Table(name = "partes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partes.findAll", query = "SELECT p FROM Parte p"),
    @NamedQuery(name = "Partes.findByCdParte", query = "SELECT p FROM Parte p WHERE p.cdParte = :cdParte"),
    @NamedQuery(name = "Partes.findByNmParte", query = "SELECT p FROM Parte p WHERE p.nmParte = :nmParte"),
    @NamedQuery(name = "Partes.findByDsEndereco", query = "SELECT p FROM Parte p WHERE p.dsEndereco = :dsEndereco"),
    @NamedQuery(name = "Partes.findByDsBairro", query = "SELECT p FROM Parte p WHERE p.dsBairro = :dsBairro"),
    @NamedQuery(name = "Partes.findByDsCidade", query = "SELECT p FROM Parte p WHERE p.dsCidade = :dsCidade"),
    @NamedQuery(name = "Partes.findByDsUf", query = "SELECT p FROM Parte p WHERE p.dsUf = :dsUf"),
    @NamedQuery(name = "Partes.findByNrCep", query = "SELECT p FROM Parte p WHERE p.nrCep = :nrCep"),
    @NamedQuery(name = "Partes.findByNrRg", query = "SELECT p FROM Parte p WHERE p.nrRg = :nrRg"),
    @NamedQuery(name = "Partes.findByNrCpfcnpj", query = "SELECT p FROM Parte p WHERE p.nrCpfcnpj = :nrCpfcnpj"),
    @NamedQuery(name = "Partes.findByNrFone1", query = "SELECT p FROM Parte p WHERE p.nrFone1 = :nrFone1"),
    @NamedQuery(name = "Partes.findByNrFone2", query = "SELECT p FROM Parte p WHERE p.nrFone2 = :nrFone2"),
    @NamedQuery(name = "Partes.findByDsEmail", query = "SELECT p FROM Parte p WHERE p.dsEmail = :dsEmail"),
    @NamedQuery(name = "Partes.findByNrCelular", query = "SELECT p FROM Parte p WHERE p.nrCelular = :nrCelular")})
public class Parte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_parte")
    private Integer cdParte;
    @Basic(optional = false)
    @Column(name = "nm_parte")
    private String nmParte;
    @Column(name = "ds_endereco")
    private String dsEndereco;
    @Column(name = "ds_bairro")
    private String dsBairro;
    @Column(name = "ds_cidade")
    private String dsCidade;
    @Column(name = "ds_uf")
    private String dsUf;
    @Column(name = "nr_cep")
    private String nrCep;
    @Column(name = "nr_rg")
    private String nrRg;
    @Basic(optional = false)
    @Column(name = "nr_cpfcnpj")
    private String nrCpfcnpj;
    @Column(name = "nr_fone1")
    private String nrFone1;
    @Column(name = "nr_fone2")
    private String nrFone2;
    @Column(name = "ds_email")
    private String dsEmail;
    @Column(name = "nr_celular")
    private String nrCelular;
    @OneToMany(mappedBy = "cdParte")
    private List<Processo> processoList;
    @OneToMany(mappedBy = "cdReu")
    private List<Processo> processoList1;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;

    public Parte() {
    }

    public Parte(Integer cdParte) {
        this.cdParte = cdParte;
    }

    public Parte(Integer cdParte, String nmParte, String nrCpfcnpj) {
        this.cdParte = cdParte;
        this.nmParte = nmParte;
        this.nrCpfcnpj = nrCpfcnpj;
    }

    public Integer getCdParte() {
        return cdParte;
    }

    public void setCdParte(Integer cdParte) {
        this.cdParte = cdParte;
    }

    public String getNmParte() {
        return nmParte;
    }

    public void setNmParte(String nmParte) {
        this.nmParte = nmParte;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    public String getDsCidade() {
        return dsCidade;
    }

    public void setDsCidade(String dsCidade) {
        this.dsCidade = dsCidade;
    }

    public String getDsUf() {
        return dsUf;
    }

    public void setDsUf(String dsUf) {
        this.dsUf = dsUf;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }

    public String getNrCpfcnpj() {
        return nrCpfcnpj;
    }

    public void setNrCpfcnpj(String nrCpfcnpj) {
        this.nrCpfcnpj = nrCpfcnpj;
    }

    public String getNrFone1() {
        return nrFone1;
    }

    public void setNrFone1(String nrFone1) {
        this.nrFone1 = nrFone1;
    }

    public String getNrFone2() {
        return nrFone2;
    }

    public void setNrFone2(String nrFone2) {
        this.nrFone2 = nrFone2;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getNrCelular() {
        return nrCelular;
    }

    public void setNrCelular(String nrCelular) {
        this.nrCelular = nrCelular;
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }

    @XmlTransient
    public List<Processo> getProcessoList1() {
        return processoList1;
    }

    public void setProcessoList1(List<Processo> processoList1) {
        this.processoList1 = processoList1;
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
        hash += (cdParte != null ? cdParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parte)) {
            return false;
        }
        Parte other = (Parte) object;
        if ((this.cdParte == null && other.cdParte != null) || (this.cdParte != null && !this.cdParte.equals(other.cdParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Partes[ cdParte=" + cdParte + " ]";
    }
    
}
