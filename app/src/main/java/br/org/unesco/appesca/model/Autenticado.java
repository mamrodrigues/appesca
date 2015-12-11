package br.org.unesco.appesca.model;

import java.io.Serializable;

/**
 * Created by yesus on 11/29/15.
 */
public class Autenticado implements Serializable{
    private String nome;
    private String email;

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
}
