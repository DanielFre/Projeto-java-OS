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
package br.com.infox.controller.helper;

import br.com.infox.model.Usuario;
import br.com.infox.view.TelaUsuario;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class TelaUsuarioHelper {

    private final TelaUsuario view;

    public TelaUsuarioHelper(TelaUsuario view) {
        this.view = view;
    }

    public void limpatela() {
        view.getJtfUserID().setText("0");
        view.getJtfUserNome().setText("");
        view.getJtfUserLogin().setText("");
        view.getJtfUserSenha().setText("");
        view.getJtfUserFone().setText("");
        view.getJtfUserPerfil().setSelectedItem("normal");//combobox
    }

    public void limpatelaID() {
        view.getJtfUserID().setText("0");
    }

    public Usuario obterDadosTelaCadastroUsuario() {
        validaCampoID();

        int id = Integer.parseInt(view.getJtfUserID().getText());
        String nome = view.getJtfUserNome().getText();
        String login = view.getJtfUserLogin().getText();

        if (id > 0) {
//            nome = null;
//            login = null;
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;

        } else if (!nome.equals("") || nome != null) {
//            id = 0;
//            login = null;
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;

        } else if (!login.equals("") || login != null) {
//            id = 0;
//            nome = null;
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;

        } else {
            id = 0;
            nome = "";
            login = "";
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;
        }

    }

    public void setarDadosNaTela(Usuario usuario) {
        view.getJtfUserID().setText(usuario.getId() + "");
        view.getJtfUserNome().setText(usuario.getNomeUsuario());
        view.getJtfUserLogin().setText(usuario.getLogin());
        view.getJtfUserSenha().setText(usuario.getSenha());
        view.getJtfUserFone().setText(usuario.getTelefone());
        view.getJtfUserPerfil().setSelectedItem(usuario.getNivelAcesso());//combobox

    }

    public Usuario pegarDadosDaTelaParaCadastrarUsuario() {
        view.getJtfUserID().setText("0");
        String nome = view.getJtfUserNome().getText();
        String login = view.getJtfUserLogin().getText();
        String senha = view.getJtfUserSenha().getText();
        String fone = view.getJtfUserFone().getText();
        String perfil = view.getJtfUserPerfil().getSelectedItem().toString();

        Usuario cadUser = new Usuario(nome, login, senha, fone, perfil);
        return cadUser;

    }

    public Usuario pegarDadosDaTelaParaAtualizarCadastroDoUsuario() {
        validaCampoID();
        int id = Integer.parseInt(view.getJtfUserID().getText());
        String nome = view.getJtfUserNome().getText();
        String login = view.getJtfUserLogin().getText();
        String senha = view.getJtfUserSenha().getText();
        String fone = view.getJtfUserFone().getText();
        String perfil = view.getJtfUserPerfil().getSelectedItem().toString();

        if (id > 0 && !nome.equals("") && !login.equals("") && !senha.equals("")) {
            Usuario updateUser = new Usuario(id, nome, login, senha, fone, perfil);
            return updateUser;
        } else {
            return null;
        }
    }

    public Usuario pegarDadosDaTelaParaDeletarUsuario() {
        validaCampoID();
        int id = Integer.parseInt(view.getJtfUserID().getText());
        String nome = view.getJtfUserNome().getText();
        String login = view.getJtfUserLogin().getText();

        if (id > 0 && !login.equals("")) {
            Usuario deleteUser = new Usuario(id, nome, login);
            return deleteUser;
        } else {
            return null;
        }
    }

    public void validaCampoID() {
        if (view.getJtfUserID().getText().equals("")) {
            limpatelaID();
        }
    }

}
