package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the varaforo database table.
 * 
 */
@Entity
@Table(name="varaforo")
@NamedQuery(name="Varaforo.findAll", query="SELECT v FROM Varaforo v")
public class Varaforo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_varaforo")
	private int cdVaraforo;

	@Column(name="ds_contato")
	private String dsContato;

	@Column(name="ds_varaforo")
	private String dsVaraforo;

	@Column(name="nr_fone")
	private String nrFone;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="varaforo")
	private List<Processo> processos;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	public Varaforo() {
	}

	public int getCdVaraforo() {
		return this.cdVaraforo;
	}

	public void setCdVaraforo(int cdVaraforo) {
		this.cdVaraforo = cdVaraforo;
	}

	public String getDsContato() {
		return this.dsContato;
	}

	public void setDsContato(String dsContato) {
		this.dsContato = dsContato;
	}

	public String getDsVaraforo() {
		return this.dsVaraforo;
	}

	public void setDsVaraforo(String dsVaraforo) {
		this.dsVaraforo = dsVaraforo;
	}

	public String getNrFone() {
		return this.nrFone;
	}

	public void setNrFone(String nrFone) {
		this.nrFone = nrFone;
	}

	public List<Processo> getProcessos() {
		return this.processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Processo addProcesso(Processo processo) {
		getProcessos().add(processo);
		processo.setVaraforo(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setVaraforo(null);

		return processo;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}