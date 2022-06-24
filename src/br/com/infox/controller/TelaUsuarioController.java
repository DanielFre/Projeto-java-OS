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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void limparTela() {
        helper.limpatela();
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
                limparTela();
            }

        } else if (usuario.getNomeUsuario() != null && !usuario.getNomeUsuario().equals("")) {

            user = usuarioDAO.consultarPorNome(usuario);
            if (user != null) {
                helper.setarDadosNaTela(user);
            } else {
                view.exibeMensagem("Nenhum usuário encontrado para o NOME informado!");
                limparTela();
            }

        } else if (usuario.getLogin() != null && !usuario.getLogin().equals("")) {

            user = usuarioDAO.consultarPorLogin(usuario);
            if (user != null) {
                helper.setarDadosNaTela(user);
            } else {
                view.exibeMensagem("Nenhum usuário encontrado para o LOGIN informado!");
                limparTela();
            }

        } else {
            view.exibeMensagem("Nenhum campo de pesquisa foi informado!");
            limparTela();
        }
    }

    public void cadastrarUsuario() throws SQLException {

        Usuario usuario = helper.pegarDadosDaTelaParaCadastrarUsuario();

        Connection conexao = new ModuloConexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        Usuario user = new Usuario();

        Usuario usuarioVerificaLogin = helper.obterDadosTelaCadastroUsuario();

        user = usuarioDAO.consultarPorLogin(usuarioVerificaLogin);
        if (user == null) { //se deu certo e não tem outro login igual
            user = usuarioDAO.insert(usuario);
            if (user != null) {
                view.exibeMensagem("Usuário salvo com sucesso!");
                consultarUsuario();

            } else {
                view.exibeMensagem("Informe todos os campos obrigatórios!");
            }

        } else {
            view.exibeMensagem("LOGIN já cadastrado para outro Usuário!");
        }
    }
}
