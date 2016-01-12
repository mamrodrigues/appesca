package br.org.unesco.appesca.model;

import java.util.List;

import br.org.unesco.appesca.enums.PerfilEnum;

public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = -8637469199477374376L;

	private Integer id;
	private String nome;
	private String email;
	private String endereco;
	private String login;
	private String senha;
	private PerfilEnum perfil;
	private byte[] imagem;

	private List<Equipe> listaEquipes;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public List<Equipe> getListaEquipes() {
		return listaEquipes;
	}

	public void setListaEquipes(List<Equipe> listaEquipes) {
		this.listaEquipes = listaEquipes;
	}
}
