/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller.helper;

import br.com.infox.model.Usuario;
import br.com.infox.view.TelaUsuario;

/**
 *
 * @author daniel.frey
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

    public Usuario obterDadosTelaCadastroUsuario() {

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
}
