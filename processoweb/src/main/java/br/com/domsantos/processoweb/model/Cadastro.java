package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cadastro database table.
 * 
 */
@Entity
@Table(name="cadastro")
@NamedQuery(name="Cadastro.findAll", query="SELECT c FROM Cadastro c")
public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_cadastro")
	private int cdCadastro;

	@Column(name="ds_bairro")
	private String dsBairro;

	@Column(name="ds_cidade")
	private String dsCidade;

	@Column(name="ds_complemento")
	private String dsComplemento;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="ds_endereco")
	private String dsEndereco;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade")
	private Date dtValidade;

	@Column(name="nm_usuario")
	private String nmUsuario;

	@Column(name="nr_cep")
	private String nrCep;

	@Column(name="nr_cpfcnpf")
	private String nrCpfcnpf;

	@Column(name="nr_endereco")
	private String nrEndereco;

	@Column(name="nr_fone")
	private String nrFone;

	@Column(name="sg_uf")
	private String sgUf;

	@Column(name="st_atualizada")
	private String stAtualizada;

	@Column(name="tp_cadastro")
	private String tpCadastro;

	@Column(name="tp_conta")
	private byte tpConta;

	@Column(name="tp_entrada")
	private int tpEntrada;

	@Column(name="vl_senha")
	private String vlSenha;

	public Cadastro() {
	}

	public int getCdCadastro() {
		return this.cdCadastro;
	}

	public void setCdCadastro(int cdCadastro) {
		this.cdCadastro = cdCadastro;
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

	public String getDsComplemento() {
		return this.dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
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

	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtValidade() {
		return this.dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public String getNmUsuario() {
		return this.nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getNrCep() {
		return this.nrCep;
	}

	public void setNrCep(String nrCep) {
		this.nrCep = nrCep;
	}

	public String getNrCpfcnpf() {
		return this.nrCpfcnpf;
	}

	public void setNrCpfcnpf(String nrCpfcnpf) {
		this.nrCpfcnpf = nrCpfcnpf;
	}

	public String getNrEndereco() {
		return this.nrEndereco;
	}

	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public String getNrFone() {
		return this.nrFone;
	}

	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}

	public String getSgUf() {
		return this.sgUf;
	}

	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}

	public String getStAtualizada() {
		return this.stAtualizada;
	}

	public void setStAtualizada(String stAtualizada) {
		this.stAtualizada = stAtualizada;
	}

	public String getTpCadastro() {
		return this.tpCadastro;
	}

	public void setTpCadastro(String tpCadastro) {
		this.tpCadastro = tpCadastro;
	}

	public byte getTpConta() {
		return this.tpConta;
	}

	public void setTpConta(byte tpConta) {
		this.tpConta = tpConta;
	}

	public int getTpEntrada() {
		return this.tpEntrada;
	}

	public void setTpEntrada(int tpEntrada) {
		this.tpEntrada = tpEntrada;
	}

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

}