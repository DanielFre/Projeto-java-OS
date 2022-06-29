/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller.helper;

import br.com.infox.model.Cliente;
import br.com.infox.view.TelaCliente;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author daniel.frey
 */
public class TelaClienteHelper {

    private final TelaCliente view;

    public TelaClienteHelper(TelaCliente view) {
        this.view = view;
    }

    public void limpatela() {
        view.getJtfClientesNome().setText("");
        view.getJtfClientesEndereco().setText("");
        view.getJtfClientesFone().setText("");
        view.getJtfClientesEmail().setText("");
//        view.getJtfClientesPesquisar().setText("");
        view.getJtfClienteID().setText("0");

    }

    public void limpatabela() {
        view.getJtfClientesPesquisar().setText("");
        //o código abaixo limpa os campos da tabela
        ((DefaultTableModel) view.getJtfClientesTable().getModel()).setRowCount(0);

    }

    public void setarDadosNaTabela(ResultSet resultSet) {
        //a linha abaixo chama a função que usa a biblioteca rs2xml.jar para popular a tabela em tempo real
        view.getJtfClientesTable().setModel(DbUtils.resultSetToTableModel(resultSet));

    }

    public void setarDadosDaTabelaNosCamposDaTela() {
        int dadosLinhaSelecionada = view.getJtfClientesTable().getSelectedRow();

        view.getJtfClienteID().setText(view.getJtfClientesTable().getModel().getValueAt(dadosLinhaSelecionada, 0).toString());
        view.getJtfClientesNome().setText(view.getJtfClientesTable().getModel().getValueAt(dadosLinhaSelecionada, 1).toString());
        view.getJtfClientesEndereco().setText(view.getJtfClientesTable().getModel().getValueAt(dadosLinhaSelecionada, 2).toString());
        view.getJtfClientesFone().setText(view.getJtfClientesTable().getModel().getValueAt(dadosLinhaSelecionada, 3).toString());
        view.getJtfClientesEmail().setText(view.getJtfClientesTable().getModel().getValueAt(dadosLinhaSelecionada, 4).toString());

    }

    public Cliente PegarDadosDaTelaParaPesquisarCliente() {

        String pesquisa = view.getJtfClientesPesquisar().getText();

        Cliente pesquisaCliente = new Cliente(pesquisa);
        return pesquisaCliente;

    }

    public Cliente pegarDadosDaTelaParaCadastrarCliente() {
        int id = Integer.parseInt(view.getJtfClienteID().getText());
        String nome = view.getJtfClientesNome().getText();
        String endereco = view.getJtfClientesEndereco().getText();
        String fone = view.getJtfClientesFone().getText();
        String email = view.getJtfClientesEmail().getText();

        if (!nome.equals("") && !fone.equals("")) {
            Cliente cadCliente = new Cliente(id, nome, endereco, fone, email);
            return cadCliente;
        } else {
            return null;
        }

    }

}
