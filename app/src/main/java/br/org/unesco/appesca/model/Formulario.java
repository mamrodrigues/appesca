package br.org.unesco.appesca.model;

import java.util.Date;

public class Formulario implements java.io.Serializable {

	private static final long serialVersionUID = 2165508619825487958L;

	private Integer id;
	private String nome;
	private int idTipoFormulario;
	private int idUsuario;
	private Date dataAplicacao;
	private boolean isEnviado;

	public Formulario() {
	}

	public Formulario(String nome, int idTipoFormulario, int idUsuario, Date dataAplicacao) {
		this.nome = nome;
		this.idTipoFormulario = idTipoFormulario;
		this.idUsuario = idUsuario;
		this.dataAplicacao = dataAplicacao;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdTipoFormulario() {
		return this.idTipoFormulario;
	}

	public void setIdTipoFormulario(int idTipoFormulario) {
		this.idTipoFormulario = idTipoFormulario;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataAplicacao() {
		return this.dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public boolean isEnviado() {
		return isEnviado;
	}

	public void setIsEnviado(boolean isEnviado) {
		this.isEnviado = isEnviado;
	}
}
