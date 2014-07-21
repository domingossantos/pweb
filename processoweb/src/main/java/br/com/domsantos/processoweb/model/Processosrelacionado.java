package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the processosrelacionados database table.
 * 
 */
@Entity
@Table(name="processosrelacionados")
@NamedQuery(name="Processosrelacionado.findAll", query="SELECT p FROM Processosrelacionado p")
public class Processosrelacionado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_processos_repacionados")
	private int idProcessosRepacionados;

	@Column(name="cd_processofilho")
	private int cdProcessofilho;

	@Column(name="cd_processopai")
	private int cdProcessopai;

	@Column(name="ds_obs")
	private String dsObs;

	public Processosrelacionado() {
	}

	public int getIdProcessosRepacionados() {
		return this.idProcessosRepacionados;
	}

	public void setIdProcessosRepacionados(int idProcessosRepacionados) {
		this.idProcessosRepacionados = idProcessosRepacionados;
	}

	public int getCdProcessofilho() {
		return this.cdProcessofilho;
	}

	public void setCdProcessofilho(int cdProcessofilho) {
		this.cdProcessofilho = cdProcessofilho;
	}

	public int getCdProcessopai() {
		return this.cdProcessopai;
	}

	public void setCdProcessopai(int cdProcessopai) {
		this.cdProcessopai = cdProcessopai;
	}

	public String getDsObs() {
		return this.dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

}