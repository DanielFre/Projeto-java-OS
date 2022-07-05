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

import br.com.infox.view.TelaLogin;
import br.com.infox.DAO.ModuloConexao;
import br.com.infox.model.Usuario;
import java.sql.*;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class LoginHelper {

    private final TelaLogin view;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public LoginHelper(TelaLogin view) throws SQLException {
        this.view = view;
        this.conexao = ModuloConexao.getConnection();
    }

    public void verificaConexaoComDatabase() {
        if (this.conexao != null) {
            this.view.getJlbDatabase().setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/database-connected-48.png")));

        } else {
            this.view.getJlbDatabase().setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/database-desconnected-48.png")));

        }
    }

    public Usuario obterDadosDaTelaDeLogin() {
        String login = view.getJtfLogin().getText();
        String senha = new String(view.getJpfSenha().getPassword());
//      String senha = view.getJpfSenha().getText();//old

        Usuario autentica = new Usuario(login, senha);
        return autentica;
    }

    public void setarDadosNaTelaDeLogin(Usuario dados) {
        String login = dados.getLogin();
        String senha = dados.getSenha();

        view.getJtfLogin().setText(login);
        view.getJpfSenha().setText(senha);

    }

    public void limparTela() {
        view.getJtfLogin().setText("");
        view.getJpfSenha().setText("");
    }
}
