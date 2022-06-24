/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller.helper;

import br.com.infox.model.Usuario;
import br.com.infox.view.TelaUsuario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

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

//       view.getjTFusuario().setText("");
//       view.getjPFsenha().setText("");
    }

    public Usuario obterDadosTelaCadastroUsuario() {

        int id = Integer.parseInt(view.getJtfUserID().getText());
        String nome = view.getJtfUserNome().getText();
        String login = view.getJtfUserLogin().getText();
      
        if (id!=0) {
            nome = null;
            login = null;
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;
        } else if (!nome.equals("")) {
            id = 0;
            login = null;
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;
        } else if (!login.equals("")) {
            id = 0;
            nome = null;
            Usuario modelo = new Usuario(id, nome, login);
            return modelo;
        } else {
            id = 0;
            nome = null;
            login = null;
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
}
