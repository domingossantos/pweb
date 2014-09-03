/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p"),
    @NamedQuery(name = "Processo.findByCdProcesso", query = "SELECT p FROM Processo p WHERE p.cdProcesso = :cdProcesso"),
    @NamedQuery(name = "Processo.findByNrProcCartorio", query = "SELECT p FROM Processo p WHERE p.nrProcCartorio = :nrProcCartorio"),
    @NamedQuery(name = "Processo.findByDtProcesso", query = "SELECT p FROM Processo p WHERE p.dtProcesso = :dtProcesso"),
    @NamedQuery(name = "Processo.findByVlProcesso", query = "SELECT p FROM Processo p WHERE p.vlProcesso = :vlProcesso"),
    @NamedQuery(name = "Processo.findByNrAno", query = "SELECT p FROM Processo p WHERE p.nrAno = :nrAno"),
    @NamedQuery(name = "Processo.findByNrProcesso", query = "SELECT p FROM Processo p WHERE p.nrProcesso = :nrProcesso"),
    @NamedQuery(name = "Processo.findByStProcesso", query = "SELECT p FROM Processo p WHERE p.stProcesso = :stProcesso"),
    @NamedQuery(name = "Processo.findByDsPasta", query = "SELECT p FROM Processo p WHERE p.dsPasta = :dsPasta"),
    @NamedQuery(name = "Processo.findByCdEstagiario", query = "SELECT p FROM Processo p WHERE p.cdEstagiario = :cdEstagiario"),
    @NamedQuery(name = "Processo.findByCdCliente", query = "SELECT p FROM Processo p WHERE p.cdCliente = :cdCliente")})
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_processo")
    private Integer cdProcesso;
    @Column(name = "nr_proc_cartorio")
    private String nrProcCartorio;
    @Column(name = "dt_processo")
    @Temporal(TemporalType.DATE)
    private Date dtProcesso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_processo")
    private BigDecimal vlProcesso;
    @Basic(optional = false)
    @Column(name = "nr_ano")
    private String nrAno;
    @Basic(optional = false)
    @Column(name = "nr_processo")
    private String nrProcesso;
    @Lob
    @Column(name = "ds_obs")
    private String dsObs;
    @Basic(optional = false)
    @Column(name = "st_processo")
    private Character stProcesso;
    @Column(name = "ds_pasta")
    private String dsPasta;
    @Column(name = "cd_estagiario")
    private Integer cdEstagiario;
    @Column(name = "cd_cliente")
    private Integer cdCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processo")
    private List<Banco> bancoList;
    @JoinColumn(name = "cd_cartorio", referencedColumnName = "cd_cartorio")
    @ManyToOne
    private Cartorio cdCartorio;
    @JoinColumn(name = "cd_adverso", referencedColumnName = "cd_adverso")
    @ManyToOne
    private Adverso cdAdverso;
    @JoinColumn(name = "cd_comarca", referencedColumnName = "cd_comarca")
    @ManyToOne
    private Comarca cdComarca;
    @JoinColumn(name = "cd_varaforo", referencedColumnName = "cd_varaforo")
    @ManyToOne
    private Varaforo cdVaraforo;
    @JoinColumn(name = "cd_natcausa", referencedColumnName = "cd_natureza")
    @ManyToOne
    private Natureza cdNatcausa;
    @JoinColumn(name = "cd_advogado", referencedColumnName = "cd_advogado")
    @ManyToOne
    private Advogado cdAdvogado;
    @JoinColumn(name = "cd_parte", referencedColumnName = "cd_parte")
    @ManyToOne
    private Parte cdParte;
    @JoinColumn(name = "cd_reu", referencedColumnName = "cd_parte")
    @ManyToOne
    private Parte cdReu;
    @JoinColumn(name = "cd_cadastro", referencedColumnName = "cd_cadastro")
    @ManyToOne(optional = false)
    private Cadastro cadastro;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "Processo")
    private List<Andamento> andamentoList;
    @OneToMany(mappedBy = "Processo")
    private List<Contas> contasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Processo")
    private List<Agendajudicial> agendajudicialList;
*/
    public Processo() {
    }

    public Processo(Integer cdProcesso) {
        this.cdProcesso = cdProcesso;
    }

    public Processo(Integer cdProcesso, String nrAno, String nrProcesso, Character stProcesso) {
        this.cdProcesso = cdProcesso;
        this.nrAno = nrAno;
        this.nrProcesso = nrProcesso;
        this.stProcesso = stProcesso;
    }

    public Integer getCdProcesso() {
        return cdProcesso;
    }

    public void setCdProcesso(Integer cdProcesso) {
        this.cdProcesso = cdProcesso;
    }

    public String getNrProcCartorio() {
        return nrProcCartorio;
    }

    public void setNrProcCartorio(String nrProcCartorio) {
        this.nrProcCartorio = nrProcCartorio;
    }

    public Date getDtProcesso() {
        return dtProcesso;
    }

    public void setDtProcesso(Date dtProcesso) {
        this.dtProcesso = dtProcesso;
    }

    public BigDecimal getVlProcesso() {
        return vlProcesso;
    }

    public void setVlProcesso(BigDecimal vlProcesso) {
        this.vlProcesso = vlProcesso;
    }

    public String getNrAno() {
        return nrAno;
    }

    public void setNrAno(String nrAno) {
        this.nrAno = nrAno;
    }

    public String getNrProcesso() {
        return nrProcesso;
    }

    public void setNrProcesso(String nrProcesso) {
        this.nrProcesso = nrProcesso;
    }

    public String getDsObs() {
        return dsObs;
    }

    public void setDsObs(String dsObs) {
        this.dsObs = dsObs;
    }

    public Character getStProcesso() {
        return stProcesso;
    }

    public void setStProcesso(Character stProcesso) {
        this.stProcesso = stProcesso;
    }

    public String getDsPasta() {
        return dsPasta;
    }

    public void setDsPasta(String dsPasta) {
        this.dsPasta = dsPasta;
    }

    public Integer getCdEstagiario() {
        return cdEstagiario;
    }

    public void setCdEstagiario(Integer cdEstagiario) {
        this.cdEstagiario = cdEstagiario;
    }

    public Integer getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(Integer cdCliente) {
        this.cdCliente = cdCliente;
    }

    @XmlTransient
    public List<Banco> getBancoList() {
        return bancoList;
    }

    public void setBancoList(List<Banco> bancoList) {
        this.bancoList = bancoList;
    }

    public Cartorio getCdCartorio() {
        return cdCartorio;
    }

    public void setCdCartorio(Cartorio cdCartorio) {
        this.cdCartorio = cdCartorio;
    }

    public Adverso getCdAdverso() {
        return cdAdverso;
    }

    public void setCdAdverso(Adverso cdAdverso) {
        this.cdAdverso = cdAdverso;
    }

    public Comarca getCdComarca() {
        return cdComarca;
    }

    public void setCdComarca(Comarca cdComarca) {
        this.cdComarca = cdComarca;
    }

    public Varaforo getCdVaraforo() {
        return cdVaraforo;
    }

    public void setCdVaraforo(Varaforo cdVaraforo) {
        this.cdVaraforo = cdVaraforo;
    }

    public Natureza getCdNatcausa() {
        return cdNatcausa;
    }

    public void setCdNatcausa(Natureza cdNatcausa) {
        this.cdNatcausa = cdNatcausa;
    }

    public Advogado getCdAdvogado() {
        return cdAdvogado;
    }

    public void setCdAdvogado(Advogado cdAdvogado) {
        this.cdAdvogado = cdAdvogado;
    }

    public Parte getCdParte() {
        return cdParte;
    }

    public void setCdParte(Parte cdParte) {
        this.cdParte = cdParte;
    }

    public Parte getCdReu() {
        return cdReu;
    }

    public void setCdReu(Parte cdReu) {
        this.cdReu = cdReu;
    }

    public Cadastro getCdCadastro() {
        return cadastro;
    }

    public void setCdCadastro(Cadastro cdCadastro) {
        this.cadastro = cdCadastro;
    }
    /*
    @XmlTransient
    public List<Andamento> getAndamentoList() {
        return andamentoList;
    }

    public void setAndamentoList(List<Andamento> andamentoList) {
        this.andamentoList = andamentoList;
    }

    @XmlTransient
    public List<Contas> getContasList() {
        return contasList;
    }

    public void setContasList(List<Contas> contasList) {
        this.contasList = contasList;
    }

    @XmlTransient
    public List<Agendajudicial> getAgendajudicialList() {
        return agendajudicialList;
    }

    public void setAgendajudicialList(List<Agendajudicial> agendajudicialList) {
        this.agendajudicialList = agendajudicialList;
    }
	*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdProcesso != null ? cdProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.cdProcesso == null && other.cdProcesso != null) || (this.cdProcesso != null && !this.cdProcesso.equals(other.cdProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.domsantos.processoweb.model.Processo[ cdProcesso=" + cdProcesso + " ]";
    }
    
}
