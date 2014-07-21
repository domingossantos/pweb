package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the natureza database table.
 * 
 */
@Entity
@Table(name="natureza")
@NamedQuery(name="Natureza.findAll", query="SELECT n FROM Natureza n")
public class Natureza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_natureza")
	private int cdNatureza;

	@Column(name="ds_natureza")
	private String dsNatureza;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="natureza")
	private List<Processo> processos;

	public Natureza() {
	}

	public int getCdNatureza() {
		return this.cdNatureza;
	}

	public void setCdNatureza(int cdNatureza) {
		this.cdNatureza = cdNatureza;
	}

	public String getDsNatureza() {
		return this.dsNatureza;
	}

	public void setDsNatureza(String dsNatureza) {
		this.dsNatureza = dsNatureza;
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
		processo.setNatureza(this);

		return processo;
	}

	public Processo removeProcesso(Processo processo) {
		getProcessos().remove(processo);
		processo.setNatureza(null);

		return processo;
	}

}