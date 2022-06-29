/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.DAO.ModuloConexao;
import br.com.infox.controller.helper.TelaClienteHelper;
import br.com.infox.model.Cliente;
import br.com.infox.model.DAO.ClienteDAO;
import br.com.infox.view.TelaCliente;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author daniel.frey
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
        }else{
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
