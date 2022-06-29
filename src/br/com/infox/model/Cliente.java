/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model;

/**
 *
 * @author daniel.frey
 */
public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String fone;
    private String email;
    private String pesquisa;

    public Cliente() {
    }

    public Cliente(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Cliente(String nome, String endereco, String fone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.email = email;
    }

    public Cliente(int id, String nome, String endereco, String fone, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.email = email;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}
