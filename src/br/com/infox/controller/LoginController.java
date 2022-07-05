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
 * @author Daniel Frey
 * @version 1.0.0
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
