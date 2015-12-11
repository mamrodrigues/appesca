package br.org.unesco.appesca.model;

import java.io.Serializable;

/**
 * Created by yesus on 11/29/15.
 * Formulário de identificação do Entrevistado.
 */
public class IdentificacaoEntrevistado implements Serializable{



    private long id;
    private String nome;
    private String apelido;
    private String uf;
    private String municipio;
    private String comunidade;
    private short idade;
    private String sexo;
    private String telefone;
    private byte acessoAComunidade;//Terrestre, Fluvial ou marítimo.
    private short distanciaDoMunicipio; //horas/km.
    private byte localResidencia; //zona urbana, zona rural.

    private byte[] foto;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getComunidade() {
        return comunidade;
    }

    public void setComunidade(String comunidade) {
        this.comunidade = comunidade;
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public byte getAcessoAComunidade() {
        return acessoAComunidade;
    }

    public void setAcessoAComunidade(byte acessoAComunidade) {
        this.acessoAComunidade = acessoAComunidade;
    }

    public short getDistanciaDoMunicipio() {
        return distanciaDoMunicipio;
    }

    public void setDistanciaDoMunicipio(short distanciaDoMunicipio) {
        this.distanciaDoMunicipio = distanciaDoMunicipio;
    }

    public byte getLocalResidencia() {
        return localResidencia;
    }

    public void setLocalResidencia(byte localResidencia) {
        this.localResidencia = localResidencia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
