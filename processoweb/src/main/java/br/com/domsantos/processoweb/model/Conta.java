package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the contas database table.
 * 
 */
@Entity
@Table(name="contas")
@NamedQuery(name="Conta.findAll", query="SELECT c FROM Conta c")
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_conta")
	private int cdConta;

	@Column(name="ds_conta")
	private String dsConta;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_conta")
	private Date dtConta;

	@Column(name="tp_operacao")
	private String tpOperacao;

	@Column(name="vl_conta")
	private BigDecimal vlConta;

	//bi-directional many-to-one association to Processo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_processo")
	private Processo processo;

	public Conta() {
	}

	public int getCdConta() {
		return this.cdConta;
	}

	public void setCdConta(int cdConta) {
		this.cdConta = cdConta;
	}

	public String getDsConta() {
		return this.dsConta;
	}

	public void setDsConta(String dsConta) {
		this.dsConta = dsConta;
	}

	public Date getDtConta() {
		return this.dtConta;
	}

	public void setDtConta(Date dtConta) {
		this.dtConta = dtConta;
	}

	public String getTpOperacao() {
		return this.tpOperacao;
	}

	public void setTpOperacao(String tpOperacao) {
		this.tpOperacao = tpOperacao;
	}

	public BigDecimal getVlConta() {
		return this.vlConta;
	}

	public void setVlConta(BigDecimal vlConta) {
		this.vlConta = vlConta;
	}

	public Processo getProcesso() {
		return this.processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

}