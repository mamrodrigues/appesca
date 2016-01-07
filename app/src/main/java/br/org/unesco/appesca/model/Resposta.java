package br.org.unesco.appesca.model;

public class Resposta implements java.io.Serializable {

	private static final long serialVersionUID = 6100540469341649847L;
	
	private Integer id;
	private Integer opcao;
	private byte[] texto;
	private byte[] audio;
	private int idPergunta;

	public Resposta() {
	}

	public Resposta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

	public Resposta(Integer opcao, byte[] texto, byte[] audio, int idPergunta) {
		this.opcao = opcao;
		this.texto = texto;
		this.audio = audio;
		this.idPergunta = idPergunta;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOpcao() {
		return this.opcao;
	}

	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}

	public byte[] getTexto() {
		return this.texto;
	}

	public void setTexto(byte[] texto) {
		this.texto = texto;
	}

	public byte[] getAudio() {
		return this.audio;
	}

	public void setAudio(byte[] audio) {
		this.audio = audio;
	}

	public int getIdPergunta() {
		return this.idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

}
