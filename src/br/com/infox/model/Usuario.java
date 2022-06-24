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
public class Usuario {
    private int id;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String telefone;
    private String nivelAcesso;

    public Usuario(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, String fone, String perfil) {
        this.nomeUsuario = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = fone;
        this.nivelAcesso = perfil;
    }

    public Usuario(int id, String nomeUsuario, String login) {
        this.id = id;
        this.login = login;
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario(int id, String nomeUsuario, String login, String senha, String telefone, String nivelAcesso) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.nomeUsuario = nomeUsuario;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
