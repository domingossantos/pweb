package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the advogado database table.
 * 
 */
@Entity
@Table(name="advogado")
@NamedQuery(name="Advogado.findAll", query="SELECT a FROM Advogado a")
public class Advogado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_advogado")
	private int cdAdvogado;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="ds_login")
	private String dsLogin;

	@Column(name="nm_advogado")
	private String nmAdvogado;

	@Column(name="nr_celular")
	private String nrCelular;

	@Column(name="nr_fone")
	private String nrFone;

	@Column(name="nr_oab")
	private String nrOab;

	@Column(name="st_master")
	private String stMaster;

	@Column(name="tp_adv")
	private String tpAdv;

	@Column(name="tp_usuario")
	private String tpUsuario;

	@Column(name="vl_senha")
	private String vlSenha;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="advogado")
	private List<Processo> processos;

	public Advogado() {
	}

	public int getCdAdvogado() {
		return this.cdAdvogado;
	}

	public void setCdAdvogado(int cdAdvogado) {
		this.cdAdvogado = cdAdvogado;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsLogin() {
		return this.dsLogin;
	}

	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}

	public String getNmAdvogado() {
		return this.nmAdvogado;
	}

	public void setNmAdvogado(String nmAdvogado) {
		this.nmAdvogado = nmAdvogado;
	}

	public String getNrCelular() {
		return this.nrCelular;
	}

	public void setNrCelular(String nrCelular) {
		this.nrCelular = nrCelular;
	}

	public String getNrFone() {
		return this.nrFone;
	}

	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}

	public String getNrOab() {
		return this.nrOab;
	}

	public void setNrOab(String nrOab) {
		this.nrOab = nrOab;
	}

	public String getStMaster() {
		return this.stMaster;
	}

	public void setStMaster(String stMaster) {
		this.stMaster = stMaster;
	}

	public String getTpAdv() {
		return this.tpAdv;
	}

	public void setTpAdv(String tpAdv) {
		this.tpAdv = tpAdv;
	}

	public String getTpUsuario() {
		return this.tpUsuario;
	}

	public void setTpUsuario(String tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Processo> getProcessos() {
		return this.processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Processo addProcesso(Processo processo) {
		getProcessos().add(processo);
		processo.setAdvogado(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setAdvogado(null);

		return processo;
	}

}