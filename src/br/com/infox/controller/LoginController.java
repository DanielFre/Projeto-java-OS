/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.DAO.ModuloConexao;
import br.com.infox.controller.helper.LoginHelper;
import br.com.infox.model.DAO.UsuarioDAO;
import br.com.infox.model.Usuario;
import br.com.infox.view.MenuPrincipal;
import br.com.infox.view.TelaLogin;
import java.awt.Color;
import java.sql.*;

/**
 *
 * @author daniel.frey
 */
public class LoginController {

    private final TelaLogin view;
    private final LoginHelper helper;

    public LoginController(TelaLogin view) throws SQLException {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void iniciaSistema() {
        this.helper.verificaConexaoComDatabase();
    }

    public void entrarNoSistema() throws SQLException {
        // pegar o usuario da view
        Usuario usuarioEsenha = this.helper.obterDadosDaTelaDeLogin();

        //pesquisar usuario no banco
        Connection conexao = new ModuloConexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

        boolean existeUsuarioAutenticado = usuarioDAO.verificaSeExisteUsuarioESenhaNoBanco(usuarioEsenha);

        if (existeUsuarioAutenticado) { // se usuario existe direciona para o menu principal

            String perfil = usuarioDAO.buscaPerfilAcesso(usuarioEsenha);
            MenuPrincipal menu = new MenuPrincipal();

            switch (perfil) {
                case "admin":
//                    System.out.println("perfil: admin");
                    menu.menuCadastroUsuarios.setEnabled(true);
                    menu.menuRelatorio.setEnabled(true);
                    menu.getLbTextoUsuario().setForeground(Color.GREEN.darker());
                    break;
                case "normal":
//                    System.out.println("perfil: normal");
                    menu.getLbTextoUsuario().setForeground(Color.blue);
                    break;
                case "especial":
//                    System.out.println("perfil: especial");
                    menu.getLbTextoUsuario().setForeground(Color.red);
                    break;
                default:
                    break;
            }
            menu.getLbTextoUsuario().setText(usuarioDAO.buscaNomeUsuario(usuarioEsenha));
            menu.setVisible(true);
            this.view.dispose();
        } else {        //  senão mostrar alerta informando "usuario ou senha inválidos"
            view.exibeMensagem("Usuário e/ou senha inválidos!");
            this.helper.limparTela();
        }
    }
}
