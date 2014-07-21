package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adverso database table.
 * 
 */
@Entity
@Table(name="adverso")
@NamedQuery(name="Adverso.findAll", query="SELECT a FROM Adverso a")
public class Adverso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_adverso")
	private int cdAdverso;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="nm_adverso")
	private String nmAdverso;

	@Column(name="nr_celular")
	private String nrCelular;

	@Column(name="nr_fone")
	private String nrFone;

	@Column(name="nr_foneres")
	private String nrFoneres;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="adverso")
	private List<Processo> processos;

	public Adverso() {
	}

	public int getCdAdverso() {
		return this.cdAdverso;
	}

	public void setCdAdverso(int cdAdverso) {
		this.cdAdverso = cdAdverso;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getNmAdverso() {
		return this.nmAdverso;
	}

	public void setNmAdverso(String nmAdverso) {
		this.nmAdverso = nmAdverso;
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

	public String getNrFoneres() {
		return this.nrFoneres;
	}

	public void setNrFoneres(String nrFoneres) {
		this.nrFoneres = nrFoneres;
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
		processo.setAdverso(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setAdverso(null);

		return processo;
	}

}