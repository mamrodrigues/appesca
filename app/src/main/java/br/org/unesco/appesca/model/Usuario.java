package br.org.unesco.appesca.model;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = -8637469199477374376L;

	private Integer id;
	private String nome;
	private String endereco;
	private String login;
	private String senha;
	private Integer perfil;

	public Usuario() {
	}

	public Usuario(String nome, String endereco, String login, String senha, Integer perfil) {
		this.nome = nome;
		this.endereco = endereco;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
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

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

}
