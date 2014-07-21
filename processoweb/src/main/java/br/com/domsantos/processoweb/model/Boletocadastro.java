package br.com.domsantos.processoweb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the boletocadastro database table.
 * 
 */
@Entity
@Table(name="boletocadastro")
@NamedQuery(name="Boletocadastro.findAll", query="SELECT b FROM Boletocadastro b")
public class Boletocadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_boletocadastro")
	private int cdBoletocadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_vencimento")
	private Date dtVencimento;

	@Column(name="st_boleto")
	private String stBoleto;

	@Column(name="vl_boleto")
	private String vlBoleto;

	@Column(name="vl_nossonumero")
	private String vlNossonumero;

	//bi-directional many-to-one association to Cadastro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cadastro")
	private Cadastro cadastro;

	public Boletocadastro() {
	}

	public int getCdBoletocadastro() {
		return this.cdBoletocadastro;
	}

	public void setCdBoletocadastro(int cdBoletocadastro) {
		this.cdBoletocadastro = cdBoletocadastro;
	}

	public Date getDtVencimento() {
		return this.dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getStBoleto() {
		return this.stBoleto;
	}

	public void setStBoleto(String stBoleto) {
		this.stBoleto = stBoleto;
	}

	public String getVlBoleto() {
		return this.vlBoleto;
	}

	public void setVlBoleto(String vlBoleto) {
		this.vlBoleto = vlBoleto;
	}

	public String getVlNossonumero() {
		return this.vlNossonumero;
	}

	public void setVlNossonumero(String vlNossonumero) {
		this.vlNossonumero = vlNossonumero;
	}

	public Cadastro getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}