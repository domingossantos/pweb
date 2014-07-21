package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the partes database table.
 * 
 */
@Entity
@Table(name="partes")
@NamedQuery(name="Parte.findAll", query="SELECT p FROM Parte p")
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_parte")
	private int cdParte;

	@Column(name="ds_bairro")
	private String dsBairro;

	@Column(name="ds_cidade")
	private String dsCidade;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="ds_endereco")
	private String dsEndereco;

	@Column(name="ds_uf")
	private String dsUf;

	@Column(name="nm_parte")
	private String nmParte;

	@Column(name="nr_celular")
	private String nrCelular;

	@Column(name="nr_cep")
	private String nrCep;

	@Column(name="nr_cpfcnpj")
	private String nrCpfcnpj;

	@Column(name="nr_fone1")
	private String nrFone1;

	@Column(name="nr_fone2")
	private String nrFone2;

	@Column(name="nr_rg")
	private String nrRg;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="parte1")
	private List<Processo> processos1;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="parte2")
	private List<Processo> processos2;

	public Parte() {
	}

	public int getCdParte() {
		return this.cdParte;
	}

	public void setCdParte(int cdParte) {
		this.cdParte = cdParte;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCidade() {
		return this.dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsEndereco() {
		return this.dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsUf() {
		return this.dsUf;
	}

	public void setDsUf(String dsUf) {
		this.dsUf = dsUf;
	}

	public String getNmParte() {
		return this.nmParte;
	}

	public void setNmParte(String nmParte) {
		this.nmParte = nmParte;
	}

	public String getNrCelular() {
		return this.nrCelular;
	}

	public void setNrCelular(String nrCelular) {
		this.nrCelular = nrCelular;
	}

	public String getNrCep() {
		return this.nrCep;
	}

	public void setNrCep(String nrCep) {
		this.nrCep = nrCep;
	}

	public String getNrCpfcnpj() {
		return this.nrCpfcnpj;
	}

	public void setNrCpfcnpj(String nrCpfcnpj) {
		this.nrCpfcnpj = nrCpfcnpj;
	}

	public String getNrFone1() {
		return this.nrFone1;
	}

	public void setNrFone1(String nrFone1) {
		this.nrFone1 = nrFone1;
	}

	public String getNrFone2() {
		return this.nrFone2;
	}

	public void setNrFone2(String nrFone2) {
		this.nrFone2 = nrFone2;
	}

	public String getNrRg() {
		return this.nrRg;
	}

	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Processo> getProcessos1() {
		return this.processos1;
	}

	public void setProcessos1(List<Processo> processos1) {
		this.processos1 = processos1;
	}

	public Processo addProcessos1(Processo processos1) {
		getProcessos1().add(processos1);
		processos1.setParte1(this);

		return processos1;
	}

	public Processo removeProcessos1(Processo processos1) {
		getProcessos1().remove(processos1);
		processos1.setParte1(null);

		return processos1;
	}

	public List<Processo> getProcessos2() {
		return this.processos2;
	}

	public void setProcessos2(List<Processo> processos2) {
		this.processos2 = processos2;
	}

	public Processo addProcessos2(Processo processos2) {
		getProcessos2().add(processos2);
		processos2.setParte2(this);

		return processos2;
	}

	public Processo removeProcessos2(Processo processos2) {
		getProcessos2().remove(processos2);
		processos2.setParte2(null);

		return processos2;
	}

}