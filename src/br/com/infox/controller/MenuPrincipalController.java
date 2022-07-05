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
import br.com.infox.view.MenuPrincipal;
import br.com.infox.view.TelaCliente;
import br.com.infox.view.TelaOS;
import br.com.infox.view.TelaSobre;
import br.com.infox.view.TelaUsuario;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class MenuPrincipalController {

    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }

    public void carregarDataAtual() {
        Date dataAtual = new Date();
        DateFormat formatadorDeData = DateFormat.getDateInstance(DateFormat.SHORT);
        this.view.getLbTextoData().setText(formatadorDeData.format(dataAtual));
    }

//    public void carregarUsuarioAtual() {
//
//    }
    public void sairDoSistema() {
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void ajudaSobre() {
        TelaSobre ajuda = new TelaSobre();
        ajuda.setVisible(true);
    }

    public void cadastroUsuarios() {
        TelaUsuario cadUser = new TelaUsuario();
        cadUser.setVisible(true);
        this.view.desktopPanel.add(cadUser);
    }

    public void cadastroClientes() {
        TelaCliente cadClientes = new TelaCliente();
        cadClientes.setVisible(true);
        this.view.desktopPanel.add(cadClientes);
    }

    public void cadastroDeOS() {
        TelaOS cadOS = new TelaOS();
        cadOS.setVisible(true);
        this.view.desktopPanel.add(cadOS);
    }

    public void relatorioDeClientes() {

        int confirma = JOptionPane.showConfirmDialog(null, "Deseja gerar um relatório de todos os clientes cadastrados?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                Connection conexao = new ModuloConexao().getConnection();
                //gerando o relatório com  o framework JasperReport
                JasperPrint print = JasperFillManager.fillReport("reports-templates/clientes.jasper", null, conexao);

                JasperViewer.viewReport(print, false);

            } catch (JRException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void relatorioDeServicos() {

        int confirma = JOptionPane.showConfirmDialog(null, "Deseja gerar um relatório de todos os Serviços?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                Connection conexao = new ModuloConexao().getConnection();
                //gerando o relatório com  o framework JasperReport
                JasperPrint print = JasperFillManager.fillReport("reports-templates/servicos.jasper", null, conexao);

                JasperViewer.viewReport(print, false);

            } catch (JRException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
