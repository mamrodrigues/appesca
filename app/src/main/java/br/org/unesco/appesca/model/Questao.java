package br.org.unesco.appesca.model;

import java.io.Serializable;

/**
 * Created by yesus on 11/29/15.
 * Classe que representa a questão de qualquer tipo.
 */
public class Questao implements Serializable{

    private long id;
    private short numeroQuestao;
    private byte tipoQuestao;
    private String outroResposta;

    private byte[] audio;

    private boolean respondida;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getNumeroQuestao() {
        return numeroQuestao;
    }

    public void setNumeroQuestao(short numeroQuestao) {
        this.numeroQuestao = numeroQuestao;
    }

    public byte getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(byte tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public String getOutroResposta() {
        return outroResposta;
    }

    public void setOutroResposta(String outroResposta) {
        this.outroResposta = outroResposta;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    public boolean isRespondida() {
        return respondida;
    }

    public void setRespondida(boolean respondida) {
        this.respondida = respondida;
    }
}
