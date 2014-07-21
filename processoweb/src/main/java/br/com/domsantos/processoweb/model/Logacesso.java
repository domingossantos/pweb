package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the logacesso database table.
 * 
 */
@Entity
@Table(name="logacesso")
@NamedQuery(name="Logacesso.findAll", query="SELECT l FROM Logacesso l")
public class Logacesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_logacesso")
	private int cdLogacesso;

	@Column(name="cd_advogado")
	private int cdAdvogado;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_ultimoacesso")
	private Date dtUltimoacesso;

	public Logacesso() {
	}

	public int getCdLogacesso() {
		return this.cdLogacesso;
	}

	public void setCdLogacesso(int cdLogacesso) {
		this.cdLogacesso = cdLogacesso;
	}

	public int getCdAdvogado() {
		return this.cdAdvogado;
	}

	public void setCdAdvogado(int cdAdvogado) {
		this.cdAdvogado = cdAdvogado;
	}

	public Date getDtUltimoacesso() {
		return this.dtUltimoacesso;
	}

	public void setDtUltimoacesso(Date dtUltimoacesso) {
		this.dtUltimoacesso = dtUltimoacesso;
	}

}