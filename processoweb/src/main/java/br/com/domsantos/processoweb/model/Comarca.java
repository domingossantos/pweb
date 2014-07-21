package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comarca database table.
 * 
 */
@Entity
@Table(name="comarca")
@NamedQuery(name="Comarca.findAll", query="SELECT c FROM Comarca c")
public class Comarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_comarca")
	private int cdComarca;

	@Column(name="ds_comarca")
	private String dsComarca;

	@Column(name="nm_contato")
	private String nmContato;

	@Column(name="nr_fone")
	private String nrFone;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="comarca")
	private List<Processo> processos;

	public Comarca() {
	}

	public int getCdComarca() {
		return this.cdComarca;
	}

	public void setCdComarca(int cdComarca) {
		this.cdComarca = cdComarca;
	}

	public String getDsComarca() {
		return this.dsComarca;
	}

	public void setDsComarca(String dsComarca) {
		this.dsComarca = dsComarca;
	}

	public String getNmContato() {
		return this.nmContato;
	}

	public void setNmContato(String nmContato) {
		this.nmContato = nmContato;
	}

	public String getNrFone() {
		return this.nrFone;
	}

	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
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
		processo.setComarca(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setComarca(null);

		return processo;
	}

}