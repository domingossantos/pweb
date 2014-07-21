package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the processo database table.
 * 
 */
@Entity
@Table(name="processo")
@NamedQuery(name="Processo.findAll", query="SELECT p FROM Processo p")
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_processo")
	private int cdProcesso;

	@Column(name="cd_cliente")
	private int cdCliente;

	@Column(name="cd_estagiario")
	private int cdEstagiario;

	@Lob
	@Column(name="ds_obs")
	private String dsObs;

	@Column(name="ds_pasta")
	private String dsPasta;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_processo")
	private Date dtProcesso;

	@Column(name="nr_ano")
	private String nrAno;

	@Column(name="nr_proc_cartorio")
	private String nrProcCartorio;

	@Column(name="nr_processo")
	private String nrProcesso;

	@Column(name="st_processo")
	private String stProcesso;

	@Column(name="vl_processo")
	private BigDecimal vlProcesso;

	//bi-directional many-to-one association to Agendajudicial
	@OneToMany(mappedBy="processo")
	private List<Agendajudicial> agendajudicials;

	//bi-directional many-to-one association to Andamento
	@OneToMany(mappedBy="processo")
	private List<Andamento> andamentos;

	//bi-directional many-to-one association to Banco
	@OneToMany(mappedBy="processo")
	private List<Banco> bancos;

	//bi-directional many-to-one association to Conta
	@OneToMany(mappedBy="processo")
	private List<Conta> contas;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	//bi-directional many-to-one association to Parte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_reu")
	private Parte parte1;

	//bi-directional many-to-one association to Parte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_parte")
	private Parte parte2;

	//bi-directional many-to-one association to Advogado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_advogado")
	private Advogado advogado;

	//bi-directional many-to-one association to Natureza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_natcausa")
	private Natureza natureza;

	//bi-directional many-to-one association to Varaforo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_varaforo")
	private Varaforo varaforo;

	//bi-directional many-to-one association to Comarca
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_comarca")
	private Comarca comarca;

	//bi-directional many-to-one association to Adverso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_adverso")
	private Adverso adverso;

	//bi-directional many-to-one association to Cartorio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cartorio")
	private Cartorio cartorio;

	public Processo() {
	}

	public int getCdProcesso() {
		return this.cdProcesso;
	}

	public void setCdProcesso(int cdProcesso) {
		this.cdProcesso = cdProcesso;
	}

	public int getCdCliente() {
		return this.cdCliente;
	}

	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}

	public int getCdEstagiario() {
		return this.cdEstagiario;
	}

	public void setCdEstagiario(int cdEstagiario) {
		this.cdEstagiario = cdEstagiario;
	}

	public String getDsObs() {
		return this.dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public String getDsPasta() {
		return this.dsPasta;
	}

	public void setDsPasta(String dsPasta) {
		this.dsPasta = dsPasta;
	}

	public Date getDtProcesso() {
		return this.dtProcesso;
	}

	public void setDtProcesso(Date dtProcesso) {
		this.dtProcesso = dtProcesso;
	}

	public String getNrAno() {
		return this.nrAno;
	}

	public void setNrAno(String nrAno) {
		this.nrAno = nrAno;
	}

	public String getNrProcCartorio() {
		return this.nrProcCartorio;
	}

	public void setNrProcCartorio(String nrProcCartorio) {
		this.nrProcCartorio = nrProcCartorio;
	}

	public String getNrProcesso() {
		return this.nrProcesso;
	}

	public void setNrProcesso(String nrProcesso) {
		this.nrProcesso = nrProcesso;
	}

	public String getStProcesso() {
		return this.stProcesso;
	}

	public void setStProcesso(String stProcesso) {
		this.stProcesso = stProcesso;
	}

	public BigDecimal getVlProcesso() {
		return this.vlProcesso;
	}

	public void setVlProcesso(BigDecimal vlProcesso) {
		this.vlProcesso = vlProcesso;
	}

	public List<Agendajudicial> getAgendajudicials() {
		return this.agendajudicials;
	}

	public void setAgendajudicials(List<Agendajudicial> agendajudicials) {
		this.agendajudicials = agendajudicials;
	}

	public Agendajudicial addAgendajudicial(Agendajudicial agendajudicial) {
		getAgendajudicials().add(agendajudicial);
		agendajudicial.setProcesso(this);

		return agendajudicial;
	}

	public Agendajudicial removeAgendajudicial(Agendajudicial agendajudicial) {
		getAgendajudicials().remove(agendajudicial);
		agendajudicial.setProcesso(null);

		return agendajudicial;
	}

	public List<Andamento> getAndamentos() {
		return this.andamentos;
	}

	public void setAndamentos(List<Andamento> andamentos) {
		this.andamentos = andamentos;
	}

	public Andamento addAndamento(Andamento andamento) {
		getAndamentos().add(andamento);
		andamento.setProcesso(this);

		return andamento;
	}

	public Andamento removeAndamento(Andamento andamento) {
		getAndamentos().remove(andamento);
		andamento.setProcesso(null);

		return andamento;
	}

	public List<Banco> getBancos() {
		return this.bancos;
	}

	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}

	public Banco addBanco(Banco banco) {
		getBancos().add(banco);
		banco.setProcesso(this);

		return banco;
	}

	public Banco removeBanco(Banco banco) {
		getBancos().remove(banco);
		banco.setProcesso(null);

		return banco;
	}

	public List<Conta> getContas() {
		return this.contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Conta addConta(Conta conta) {
		getContas().add(conta);
		conta.setProcesso(this);

		return conta;
	}

	public Conta removeConta(Conta conta) {
		getContas().remove(conta);
		conta.setProcesso(null);

		return conta;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Parte getParte1() {
		return this.parte1;
	}

	public void setParte1(Parte parte1) {
		this.parte1 = parte1;
	}

	public Parte getParte2() {
		return this.parte2;
	}

	public void setParte2(Parte parte2) {
		this.parte2 = parte2;
	}

	public Advogado getAdvogado() {
		return this.advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Natureza getNatureza() {
		return this.natureza;
	}

	public void setNatureza(Natureza natureza) {
		this.natureza = natureza;
	}

	public Varaforo getVaraforo() {
		return this.varaforo;
	}

	public void setVaraforo(Varaforo varaforo) {
		this.varaforo = varaforo;
	}

	public Comarca getComarca() {
		return this.comarca;
	}

	public void setComarca(Comarca comarca) {
		this.comarca = comarca;
	}

	public Adverso getAdverso() {
		return this.adverso;
	}

	public void setAdverso(Adverso adverso) {
		this.adverso = adverso;
	}

	public Cartorio getCartorio() {
		return this.cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

}