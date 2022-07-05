/*
 * The MIT License
 *
 * Copyright 2022 Daniel Frey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.infox.model;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class Usuario {

    private int id;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String telefone;
    private String nivelAcesso;

    public Usuario() {
    }

    public Usuario(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String nomeUsuario, String login) {
        this.id = id;
        this.login = login;
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario(String nome, String login, String senha, String fone, String perfil) {
        this.nomeUsuario = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = fone;
        this.nivelAcesso = perfil;
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
