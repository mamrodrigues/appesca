package br.org.unesco.appesca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yesus on 11/29/15.
 */
public class Formulario implements Serializable{

    private long id;
    private String tipo;
    private Date dataAplicacao;
    private String nomePesquisador;

    private boolean enviado;

    private IdentificacaoEntrevistado identificacaoEntrevistado;

    private List<Questao> questoes;

    //Este campo será usado para armazenar o estado da última questão respondida, desta forma carregará direto nesta para retomar a pesquisa.
    private short ultimaQuestaoRespondida;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getNomePesquisador() {
        return nomePesquisador;
    }

    public void setNomePesquisador(String nomePesquisador) {
        this.nomePesquisador = nomePesquisador;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public IdentificacaoEntrevistado getIdentificacaoEntrevistado() {
        return identificacaoEntrevistado;
    }

    public void setIdentificacaoEntrevistado(IdentificacaoEntrevistado identificacaoEntrevistado) {
        this.identificacaoEntrevistado = identificacaoEntrevistado;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public short getUltimaQuestaoRespondida() {
        return ultimaQuestaoRespondida;
    }

    public void setUltimaQuestaoRespondida(short ultimaQuestaoRespondida) {
        this.ultimaQuestaoRespondida = ultimaQuestaoRespondida;
    }
}
