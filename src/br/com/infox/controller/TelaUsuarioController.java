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

        if (usuario.getId() != 0) {
            System.out.println("getId: " + usuario.getId());
            
            Usuario user = new Usuario();
            user = usuarioDAO.consultarPorId(usuario);
            
            helper.setarDadosNaTela(user);

        } else if (usuario.getNomeUsuario() != null) {
            System.out.println("getNomeUsuario: " + usuario.getNomeUsuario());

        } else if (usuario.getLogin() != null) {
            System.out.println("getLogin: " + usuario.getLogin());

        }

    }
}
