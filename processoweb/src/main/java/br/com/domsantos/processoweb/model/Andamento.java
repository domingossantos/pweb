package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the andamento database table.
 * 
 */
@Entity
@Table(name="andamento")
@NamedQuery(name="Andamento.findAll", query="SELECT a FROM Andamento a")
public class Andamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_andamento")
	private int cdAndamento;

	@Lob
	@Column(name="ds_andamento")
	private String dsAndamento;

	@Lob
	@Column(name="ds_obs")
	private String dsObs;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_andamento")
	private Date dtAndamento;

	@Column(name="hr_andamento")
	private Time hrAndamento;

	//bi-directional many-to-one association to Processo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_processo")
	private Processo processo;

	public Andamento() {
	}

	public int getCdAndamento() {
		return this.cdAndamento;
	}

	public void setCdAndamento(int cdAndamento) {
		this.cdAndamento = cdAndamento;
	}

	public String getDsAndamento() {
		return this.dsAndamento;
	}

	public void setDsAndamento(String dsAndamento) {
		this.dsAndamento = dsAndamento;
	}

	public String getDsObs() {
		return this.dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public Date getDtAndamento() {
		return this.dtAndamento;
	}

	public void setDtAndamento(Date dtAndamento) {
		this.dtAndamento = dtAndamento;
	}

	public Time getHrAndamento() {
		return this.hrAndamento;
	}

	public void setHrAndamento(Time hrAndamento) {
		this.hrAndamento = hrAndamento;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}