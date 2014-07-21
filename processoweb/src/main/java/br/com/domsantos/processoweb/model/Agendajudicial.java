package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the agendajudicial database table.
 * 
 */
@Entity
@Table(name="agendajudicial")
@NamedQuery(name="Agendajudicial.findAll", query="SELECT a FROM Agendajudicial a")
public class Agendajudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_agenda")
	private int cdAgenda;

	@Column(name="ds_obs")
	private String dsObs;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_agenda")
	private Date dtAgenda;

	@Column(name="hr_agenda")
	private Time hrAgenda;

	//bi-directional many-to-one association to Processo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_processo")
	private Processo processo;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	public Agendajudicial() {
	}

	public int getCdAgenda() {
		return this.cdAgenda;
	}

	public void setCdAgenda(int cdAgenda) {
		this.cdAgenda = cdAgenda;
	}

	public String getDsObs() {
		return this.dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public Date getDtAgenda() {
		return this.dtAgenda;
	}

	public void setDtAgenda(Date dtAgenda) {
		this.dtAgenda = dtAgenda;
	}

	public Time getHrAgenda() {
		return this.hrAgenda;
	}

	public void setHrAgenda(Time hrAgenda) {
		this.hrAgenda = hrAgenda;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}