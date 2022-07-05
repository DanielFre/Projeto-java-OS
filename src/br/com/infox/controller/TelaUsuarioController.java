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
import br.com.infox.controller.helper.TelaUsuarioHelper;
import br.com.infox.model.DAO.UsuarioDAO;
import br.com.infox.model.Usuario;
import br.com.infox.view.TelaUsuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
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

    public void atualizarCadastroUsuario() throws SQLException {
        Usuario usuario = helper.pegarDadosDaTelaParaAtualizarCadastroDoUsuario();

        Connection conexao = new ModuloConexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        Usuario user = new Usuario();

        Usuario usuarioVerificaLogin = helper.obterDadosTelaCadastroUsuario();

        if (usuario != null) {
            user = usuarioDAO.consultarPorLogin(usuarioVerificaLogin);
            if (user != null) { //se deu certo e não tem outro login igual
                user = usuarioDAO.update(usuario);
                if (user != null) {
                    view.exibeMensagem("Usuário atualizado com sucesso!");
                    helper.limpatelaID();
                    consultarUsuario();

                } else {
                    view.exibeMensagem("Informe todos os campos obrigatórios!");
                }

            } else {
                view.exibeMensagem("LOGIN não pode ser diferente do já cadastrado para o Usuário!");
            }
        } else {
            view.exibeMensagem("Informe os campos obrigatórios (*) e/ou ID do usuario e clique \n"
                    + "em pesquisar para poder atualizar o cadastro de um Usuario!");
        }
    }

    public void deletarUsuario() throws SQLException {
        Usuario usuario = helper.pegarDadosDaTelaParaDeletarUsuario();

        Connection conexao = new ModuloConexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        Usuario user = new Usuario();

        if (usuario != null) {

            if (usuarioDAO.consultarPorIDeLogin(usuario) != null) {
                int confirmaDeletar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Deletar esse usuário?", "Atenção!", JOptionPane.YES_NO_OPTION);

                if (confirmaDeletar == JOptionPane.YES_OPTION) {

                    user = usuarioDAO.delete(usuario);
                    if (user != null) {
                        view.exibeMensagem("Usuário deletado com sucesso!");
                        limparTela();

                    } else {
                        view.exibeMensagem("Não foi possível deletar o usuário, \n"
                                + "verifique os dados e tente novamente!");
                    }

                }
            } else {
                view.exibeMensagem("Nenhum usuário com o ID e LOGIN informados!");
            }

        } else {
            view.exibeMensagem("Infome no mínimo o ID e LOGIN do usuário!");
        }

    }
}
