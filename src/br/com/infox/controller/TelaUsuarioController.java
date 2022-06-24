/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.DAO.ModuloConexao;
import br.com.infox.controller.helper.TelaUsuarioHelper;
import br.com.infox.model.DAO.UsuarioDAO;
import br.com.infox.model.Usuario;
import br.com.infox.view.TelaUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel.frey
 */
public class TelaUsuarioController {

    private final TelaUsuario view;
    private TelaUsuarioHelper helper;

    public TelaUsuarioController(TelaUsuario view) {
        this.view = view;
        this.helper = new TelaUsuarioHelper(view);
    }

    public void consultarUsuario() throws SQLException {

        Usuario usuario = helper.obterDadosTelaCadastroUsuario();
        //pesquisar usuario no banco
        Connection conexao = new ModuloConexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        Usuario user = new Usuario();

        if (usuario.getId() > 0) {

            user = usuarioDAO.consultarPorId(usuario);
            if (user != null) {
                helper.setarDadosNaTela(user);
            } else {
                view.exibeMensagem("Nenhum usuário encontrado para o ID informado!");
            }

        } else if (usuario.getNomeUsuario() != null && !usuario.getNomeUsuario().equals("")) {

            user = usuarioDAO.consultarPorNome(usuario);
            if (user != null) {
                helper.setarDadosNaTela(user);
            } else {
                view.exibeMensagem("Nenhum usuário encontrado para o NOME informado!");
            }

        } else if (usuario.getLogin() != null && !usuario.getLogin().equals("")) {

            user = usuarioDAO.consultarPorLogin(usuario);
            if (user != null) {
                helper.setarDadosNaTela(user);
            } else {
                view.exibeMensagem("Nenhum usuário encontrado para o LOGIN informado!");
            }

        } else {
            view.exibeMensagem("Nenhum campo de pesquisa foi informado!");
        }
    }

    public void limparTela() {
        helper.limpatela();
    }
}
