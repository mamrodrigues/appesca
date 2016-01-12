package br.org.unesco.appesca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yesus on 1/12/16.
 */
public class Equipe implements Serializable{

    private Integer id;
    private String nome;
    private String descricao;

    private Usuario coordenador;

    private List<Usuario> listaMembrosEquipe;

    private Date data;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Usuario coordenador) {
        this.coordenador = coordenador;
    }

    public List<Usuario> getListaMembrosEquipe() {
        return listaMembrosEquipe;
    }

    public void setListaMembrosEquipe(List<Usuario> listaMembrosEquipe) {
        this.listaMembrosEquipe = listaMembrosEquipe;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
