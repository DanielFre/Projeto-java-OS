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
import br.com.infox.controller.helper.TelaOSHelper;
import br.com.infox.model.Cliente;
import br.com.infox.model.DAO.ClienteDAO;
import br.com.infox.model.DAO.OS_OrdemServicoDAO;
import br.com.infox.model.DAO.UsuarioDAO;
import br.com.infox.model.OS_OrdemServico;
import br.com.infox.model.Usuario;
import br.com.infox.view.TelaOS;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class TelaOSController {

    private final TelaOS view;
    private TelaOSHelper helper;

    public TelaOSController(TelaOS view) {
        this.view = view;
        this.helper = new TelaOSHelper(view);
    }

    public void limparTela() {
        helper.limpatela();
        helper.limpatabela();
        habilitaCampos();
    }

    public void habilitaCampos() {
        view.getBtnOS_Alterar().setEnabled(false);
        view.getBtnOS_Deletar().setEnabled(false);
        view.getBtnOS_Imprimir().setEnabled(false);

        view.getBtnOS_Adicionar().setEnabled(true);
        view.getBtnOS_Pesquisar().setEnabled(true);

        view.getJtfOSPesquisaCliente().setEnabled(true);
        view.getTblOSClientes().setVisible(true);
    }

    public void desabilitaCampos() {
        view.getBtnOS_Alterar().setEnabled(true);
        view.getBtnOS_Deletar().setEnabled(true);
        view.getBtnOS_Imprimir().setEnabled(true);

        view.getBtnOS_Adicionar().setEnabled(false);
        view.getBtnOS_Pesquisar().setEnabled(false);

        view.getJtfOSPesquisaCliente().setEnabled(false);
        view.getTblOSClientes().setVisible(false);
    }

    public void pesquisarCliente() throws SQLException {
        Cliente pesquisa = helper.PegarDadosDaTelaDeOSParaPesquisarCliente();
        Connection conexao = new ModuloConexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);

        if (!pesquisa.getPesquisa().equals("") && pesquisa.getPesquisa() != null) {
            helper.setarDadosNaTabelaOS(clienteDAO.pesquisarClienteNaOS(pesquisa));
        } else {
            helper.limpatabela();
        }

    }

    public void setarLinhaTabelaNosCampos() {
        helper.setarDadosDaTabelaNosCamposDaTela();
    }

    public void setarTipodeOS() {
        helper.setarTipodeOS();
    }

    public void emitirOS() throws SQLException {
        OS_OrdemServico os = helper.pegarDadosDaTelaParaEmitir_OS();
        Connection conexao = new ModuloConexao().getConnection();
        OS_OrdemServico osAdd = new OS_OrdemServico();
        OS_OrdemServicoDAO osDAO = new OS_OrdemServicoDAO(conexao);

        if (os != null) {
            osAdd = osDAO.insert(os);
            if (osAdd != null) {
                view.exibeMensagem("Ordem de Servi??o emitida com Sucesso!");
                limparTela();

                osAdd = osDAO.recuperarOS();
                recuperaOSemitida(osAdd.getOs());

            } else {
                view.exibeMensagem("N??o foi possivel emitir a Ordem de Servi??o \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigat??rios!");
        }

    }

    public void recuperaOSemitida(int os) throws SQLException {
        OS_OrdemServico osID = helper.setarId_OS(os);
        Connection conexao = new ModuloConexao().getConnection();
        OS_OrdemServico osPesquisa = new OS_OrdemServico();

        OS_OrdemServicoDAO osDAO = new OS_OrdemServicoDAO(conexao);

        if (os > 0) {
            osPesquisa = osDAO.pesquisar(osID);

            if (osPesquisa != null) {
                desabilitaCampos();

                helper.setarDadosOSnaTela(osPesquisa);

            } else {
                view.exibeMensagem("Nenhuma Ordem de Servi??o ou Or??amento \n encontrado para o n??mero informado!");
                limparTela();
            }

        } else {

            view.exibeMensagem("N??o foi poss??vel recuperar a Ordem de Servi??o \n Clique em pesquisar e informe o n??mero da OS!");

        }
    }

    public void atualizaUsuariosTecnicos() throws SQLException {
        Connection conexao = new ModuloConexao().getConnection();
        //buscar cleinte no banco de dados 
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        ArrayList<Usuario> usuarios = usuarioDAO.selectAll();

        //exibir  cliente no combobox clientes
        helper.setarUsuariosTecnicos(usuarios);

    }

    public void tecnicoSelecionado() {
        helper.setarIdTecnico();
    }

    public void pesquisarOS() throws SQLException {
        int numeroOS = 0;
        numeroOS = Integer.parseInt(JOptionPane.showInputDialog("Informe o n??mero da OS"));
        OS_OrdemServico osID = helper.setarId_OS(numeroOS);

        Connection conexao = new ModuloConexao().getConnection();
        OS_OrdemServico osPesquisa = new OS_OrdemServico();

        OS_OrdemServicoDAO osDAO = new OS_OrdemServicoDAO(conexao);

        if (numeroOS > 0) {
            osPesquisa = osDAO.pesquisar(osID);

            if (osPesquisa != null) {
                desabilitaCampos();

                helper.setarDadosOSnaTela(osPesquisa);

            } else {
                view.exibeMensagem("Nenhuma Ordem de Servi??o ou Or??amento \n encontrado para o n??mero informado!");
                limparTela();
            }

        } else {

            view.exibeMensagem("Informe um n??mero de Ordem de Servi??o \n ou Or??amento v??lido!");

        }
    }

    public void alterarOS() throws SQLException {
        OS_OrdemServico os = helper.pegarDadosDaTelaParaAlterar_OS();
        Connection conexao = new ModuloConexao().getConnection();
        OS_OrdemServico osAtt = new OS_OrdemServico();
        OS_OrdemServicoDAO osDAO = new OS_OrdemServicoDAO(conexao);

        if (os != null) {
            osAtt = osDAO.update(os);
            if (osAtt != null) {
                view.exibeMensagem("Ordem de Servi??o alterada com Sucesso!");
                limparTela();
                habilitaCampos();
            } else {
                view.exibeMensagem("N??o foi possivel alterar a Ordem de Servi??o \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigat??rios!");
        }

    }

    public void deletarOS() throws SQLException {
        OS_OrdemServico os = helper.pegarDadosDaTelaParaAlterar_OS();
        Connection conexao = new ModuloConexao().getConnection();
        OS_OrdemServico osDel = new OS_OrdemServico();
        OS_OrdemServicoDAO osDAO = new OS_OrdemServicoDAO(conexao);

        if (os != null) {
            int deletar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Deletar essa Ordem de Servi??o?", "Aten????o", JOptionPane.YES_NO_OPTION);
            if (deletar == JOptionPane.YES_OPTION) {
                osDel = osDAO.delete(os);
                if (osDel != null) {
                    view.exibeMensagem("Ordem de Servi??o deletada com Sucesso!");
                    limparTela();
                    habilitaCampos();
                } else {
                    view.exibeMensagem("N??o foi possivel deletar a Ordem de Servi??o \n"
                            + "verifique os dados informados e tente novamente!");
                }
            }
        } else {
            view.exibeMensagem("Informe todos os campos obrigat??rios!");
        }
    }

    public void imprimirOS() {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Imprimir essa Ordem de Servi??o?", "Aten????o!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                Connection conexao = new ModuloConexao().getConnection();

                //usando a classe HashMap para criar um filtro
                HashMap filtro = new HashMap();
                filtro.put("os", Integer.parseInt(view.getJtfOSid().getText()));

                //imprimindo uma OS com  o framework JasperReport
                JasperPrint print = JasperFillManager.fillReport("reports-templates/os.jasper", filtro, conexao);

                JasperViewer.viewReport(print, false);

            } catch (JRException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
