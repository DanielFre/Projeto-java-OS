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

import br.com.infox.model.Cliente;
import br.com.infox.view.TelaCliente;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
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
