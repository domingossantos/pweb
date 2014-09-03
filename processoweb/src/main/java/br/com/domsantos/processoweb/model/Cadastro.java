/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "cadastro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadastro.findAll", query = "SELECT c FROM Cadastro c"),
    @NamedQuery(name = "Cadastro.findByCdCadastro", query = "SELECT c FROM Cadastro c WHERE c.cdCadastro = :cdCadastro"),
    @NamedQuery(name = "Cadastro.findByNrCpfcnpf", query = "SELECT c FROM Cadastro c WHERE c.nrCpfcnpf = :nrCpfcnpf"),
    @NamedQuery(name = "Cadastro.findByNmUsuario", query = "SELECT c FROM Cadastro c WHERE c.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "Cadastro.findByDsEmail", query = "SELECT c FROM Cadastro c WHERE c.dsEmail = :dsEmail"),
    @NamedQuery(name = "Cadastro.findByVlSenha", query = "SELECT c FROM Cadastro c WHERE c.vlSenha = :vlSenha"),
    @NamedQuery(name = "Cadastro.findByNrFone", query = "SELECT c FROM Cadastro c WHERE c.nrFone = :nrFone"),
    @NamedQuery(name = "Cadastro.findByDtCadastro", query = "SELECT c FROM Cadastro c WHERE c.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Cadastro.findBySgUf", query = "SELECT c FROM Cadastro c WHERE c.sgUf = :sgUf"),
    @NamedQuery(name = "Cadastro.findByDsCidade", query = "SELECT c FROM Cadastro c WHERE c.dsCidade = :dsCidade"),
    @NamedQuery(name = "Cadastro.findByTpCadastro", query = "SELECT c FROM Cadastro c WHERE c.tpCadastro = :tpCadastro"),
    @NamedQuery(name = "Cadastro.findByTpEntrada", query = "SELECT c FROM Cadastro c WHERE c.tpEntrada = :tpEntrada"),
    @NamedQuery(name = "Cadastro.findByTpConta", query = "SELECT c FROM Cadastro c WHERE c.tpConta = :tpConta"),
    @NamedQuery(name = "Cadastro.findByDtValidade", query = "SELECT c FROM Cadastro c WHERE c.dtValidade = :dtValidade"),
    @NamedQuery(name = "Cadastro.findByStAtualizada", query = "SELECT c FROM Cadastro c WHERE c.stAtualizada = :stAtualizada"),
    @NamedQuery(name = "Cadastro.findByDsEndereco", query = "SELECT c FROM Cadastro c WHERE c.dsEndereco = :dsEndereco"),
    @NamedQuery(name = "Cadastro.findByNrEndereco", query = "SELECT c FROM Cadastro c WHERE c.nrEndereco = :nrEndereco"),
    @NamedQuery(name = "Cadastro.findByDsComplemento", query = "SELECT c FROM Cadastro c WHERE c.dsComplemento = :dsComplemento"),
    @NamedQuery(name = "Cadastro.findByNrCep", query = "SELECT c FROM Cadastro c WHERE c.nrCep = :nrCep"),
    @NamedQuery(name = "Cadastro.findByDsBairro", query = "SELECT c FROM Cadastro c WHERE c.dsBairro = :dsBairro")})
public class Cadastro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_cadastro")
    private Integer cdCadastro;
    @Column(name = "nr_cpfcnpf")
    private String nrCpfcnpf;
    @Basic(optional = false)
    @Column(name = "nm_usuario")
    private String nmUsuario;
    @Basic(optional = false)
    @Column(name = "ds_email")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "vl_senha")
    private String vlSenha;
    @Column(name = "nr_fone")
    private String nrFone;
    @Basic(optional = false)
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "sg_uf")
    private String sgUf;
    @Column(name = "ds_cidade")
    private String dsCidade;
    @Column(name = "tp_cadastro")
    private Character tpCadastro;
    @Column(name = "tp_entrada")
    private Integer tpEntrada;
    @Column(name = "tp_conta")
    private Short tpConta;
    @Basic(optional = false)
    @Column(name = "dt_validade")
    @Temporal(TemporalType.DATE)
    private Date dtValidade;
    @Basic(optional = false)
    @Column(name = "st_atualizada")
    private Character stAtualizada;
    @Basic(optional = false)
    @Column(name = "ds_endereco")
    private String dsEndereco;
    @Basic(optional = false)
    @Column(name = "nr_endereco")
    private String nrEndereco;
    @Basic(optional = false)
    @Column(name = "ds_complemento")
    private String dsComplemento;
    @Basic(optional = false)
    @Column(name = "nr_cep")
    private String nrCep;
    @Basic(optional = false)
    @Column(name = "ds_bairro")
    private String dsBairro;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Agenda> agendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Processo> processoList;
    @OneToMany(mappedBy = "cdCadastro")
    private List<Adverso> adversoList;
    @OneToMany(mappedBy = "cdCadastro")
    private List<Boletocadastro> boletocadastroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Varaforo> varaforoList;
    @OneToMany(mappedBy = "cdCadastro")
    private List<Favoritos> favoritosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Agendajudicial> agendajudicialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Cartorio> cartorioList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Advogado> advogadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Natureza> naturezaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdCadastro")
    private List<Parte> partesList;
    @OneToMany(mappedBy = "cdCadastro")
    private List<Comarca> comarcaList;
	*/
    public Cadastro() {
    }

    public Cadastro(Integer cdCadastro) {
        this.cdCadastro = cdCadastro;
    }


    public Integer getCdCadastro() {
        return cdCadastro;
    }

    public void setCdCadastro(Integer cdCadastro) {
        this.cdCadastro = cdCadastro;
    }

    public String getNrCpfcnpf() {
        return nrCpfcnpf;
    }

    public void setNrCpfcnpf(String nrCpfcnpf) {
        this.nrCpfcnpf = nrCpfcnpf;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getVlSenha() {
        return vlSenha;
    }

    public void setVlSenha(String vlSenha) {
        this.vlSenha = vlSenha;
    }

    public String getNrFone() {
        return nrFone;
    }

    public void setNrFone(String nrFone) {
        this.nrFone = nrFone;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getSgUf() {
        return sgUf;
    }

    public void setSgUf(String sgUf) {
        this.sgUf = sgUf;
    }

    public String getDsCidade() {
        return dsCidade;
    }

    public void setDsCidade(String dsCidade) {
        this.dsCidade = dsCidade;
    }

    public Character getTpCadastro() {
        return tpCadastro;
    }

    public void setTpCadastro(Character tpCadastro) {
        this.tpCadastro = tpCadastro;
    }

    public Integer getTpEntrada() {
        return tpEntrada;
    }

    public void setTpEntrada(Integer tpEntrada) {
        this.tpEntrada = tpEntrada;
    }

    public Short getTpConta() {
        return tpConta;
    }

    public void setTpConta(Short tpConta) {
        this.tpConta = tpConta;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }

    public Character getStAtualizada() {
        return stAtualizada;
    }

    public void setStAtualizada(Character stAtualizada) {
        this.stAtualizada = stAtualizada;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNrEndereco() {
        return nrEndereco;
    }

    public void setNrEndereco(String nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }
    /*
    @XmlTransient
    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(List<Agenda> agendaList) {
        this.agendaList = agendaList;
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }

    @XmlTransient
    public List<Adverso> getAdversoList() {
        return adversoList;
    }

    public void setAdversoList(List<Adverso> adversoList) {
        this.adversoList = adversoList;
    }

    @XmlTransient
    public List<Boletocadastro> getBoletocadastroList() {
        return boletocadastroList;
    }

    public void setBoletocadastroList(List<Boletocadastro> boletocadastroList) {
        this.boletocadastroList = boletocadastroList;
    }

    @XmlTransient
    public List<Varaforo> getVaraforoList() {
        return varaforoList;
    }

    public void setVaraforoList(List<Varaforo> varaforoList) {
        this.varaforoList = varaforoList;
    }

    @XmlTransient
    public List<Favoritos> getFavoritosList() {
        return favoritosList;
    }

    public void setFavoritosList(List<Favoritos> favoritosList) {
        this.favoritosList = favoritosList;
    }

    @XmlTransient
    public List<Agendajudicial> getAgendajudicialList() {
        return agendajudicialList;
    }

    public void setAgendajudicialList(List<Agendajudicial> agendajudicialList) {
        this.agendajudicialList = agendajudicialList;
    }

    @XmlTransient
    public List<Cartorio> getCartorioList() {
        return cartorioList;
    }

    public void setCartorioList(List<Cartorio> cartorioList) {
        this.cartorioList = cartorioList;
    }

    @XmlTransient
    public List<Advogado> getAdvogadoList() {
        return advogadoList;
    }

    public void setAdvogadoList(List<Advogado> advogadoList) {
        this.advogadoList = advogadoList;
    }

    @XmlTransient
    public List<Natureza> getNaturezaList() {
        return naturezaList;
    }

    public void setNaturezaList(List<Natureza> naturezaList) {
        this.naturezaList = naturezaList;
    }

    @XmlTransient
    public List<Parte> getPartesList() {
        return partesList;
    }

    public void setPartesList(List<Parte> partesList) {
        this.partesList = partesList;
    }

    @XmlTransient
    public List<Comarca> getComarcaList() {
        return comarcaList;
    }

    public void setComarcaList(List<Comarca> comarcaList) {
        this.comarcaList = comarcaList;
    }
	*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCadastro != null ? cdCadastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadastro)) {
            return false;
        }
        Cadastro other = (Cadastro) object;
        if ((this.cdCadastro == null && other.cdCadastro != null) || (this.cdCadastro != null && !this.cdCadastro.equals(other.cdCadastro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Cadastro[ cdCadastro=" + cdCadastro + " ]";
    }
    
}
