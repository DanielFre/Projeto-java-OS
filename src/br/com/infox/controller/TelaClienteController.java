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
import br.com.infox.controller.helper.TelaClienteHelper;
import br.com.infox.model.Cliente;
import br.com.infox.model.DAO.ClienteDAO;
import br.com.infox.view.TelaCliente;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class TelaClienteController {

    private final TelaCliente view;
    private TelaClienteHelper helper;

    public TelaClienteController(TelaCliente view) {
        this.view = view;
        this.helper = new TelaClienteHelper(view);
    }

    public void limparTela() {
        helper.limpatela();
    }

    public void pesquisarCliente() throws SQLException {
        Cliente pesquisa = helper.PegarDadosDaTelaParaPesquisarCliente();
        Connection conexao = new ModuloConexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);

        if (!pesquisa.getPesquisa().equals("") && pesquisa.getPesquisa() != null) {
            helper.setarDadosNaTabela(clienteDAO.pesquisarCliente(pesquisa));
        } else {
            helper.limpatabela();
        }

    }

    public void cadastrarCliente() throws SQLException {

        Cliente cliente = helper.pegarDadosDaTelaParaCadastrarCliente();

        Connection conexao = new ModuloConexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        Cliente client = new Cliente();

        if (cliente != null) {
            client = clienteDAO.insert(cliente);
            if (client != null) {
                view.exibeMensagem("Cliente cadastrado com sucesso!");
                pesquisarCliente();
                limparTela();

            } else {
                view.exibeMensagem("Não foi possivel cadastrar o cliente \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!!");

        }
    }

    public void atualizarCadastroCliente() throws SQLException {
        Cliente cliente = helper.pegarDadosDaTelaParaCadastrarCliente();

        Connection conexao = new ModuloConexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        Cliente client = new Cliente();

        if (cliente != null) {
            client = clienteDAO.update(cliente);

            if (client != null) {
                view.exibeMensagem("Cliente atualizado com sucesso!");
                pesquisarCliente();
                limparTela();
                view.getBtnClientesCreate().setEnabled(true);

            } else {
                view.exibeMensagem("Não foi possivel atualizar o cadastro do cliente \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!");
        }

    }

    public void deletarCliente() throws SQLException {
        Cliente cliente = helper.pegarDadosDaTelaParaCadastrarCliente();

        Connection conexao = new ModuloConexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        Cliente client = new Cliente();

        if (cliente != null) {
            int confirmaDeletar = JOptionPane.showConfirmDialog(null, "Tem "
                    + "certeza que deseja Deletar esse Cliente?", "Atenção!", JOptionPane.YES_NO_OPTION);

            if (confirmaDeletar == JOptionPane.YES_OPTION) {
                if (clienteDAO.delete(cliente) != null) {
                    view.exibeMensagem("Cliente deletado com sucesso!");
                    pesquisarCliente();
                    limparTela();
                    view.getBtnClientesCreate().setEnabled(true);

                } else {
                    view.exibeMensagem("Não foi possivel apagar o cadastro do cliente \n"
                            + "verifique os dados informados e tente novamente!");
                }
            }
        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!");
        }
    }

    public void setarLinhaTabelaNosCampos() {
        helper.setarDadosDaTabelaNosCamposDaTela();
        view.getBtnClientesCreate().setEnabled(false);
    }

}
