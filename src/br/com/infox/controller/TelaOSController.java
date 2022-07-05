/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author daniel.frey
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
                view.exibeMensagem("Ordem de Serviço emitida com Sucesso!");
                limparTela();
                
                osAdd = osDAO.recuperarOS();
                recuperaOSemitida(osAdd.getOs());
                
            } else {
                view.exibeMensagem("Não foi possivel emitir a Ordem de Serviço \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!");
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
                view.exibeMensagem("Nenhuma Ordem de Serviço ou Orçamento \n encontrado para o número informado!");
                limparTela();
            }

        } else {

            view.exibeMensagem("Não foi possível recuperar a Ordem de Serviço \n Clique em pesquisar e informe o número da OS!");

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
        numeroOS = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da OS"));
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
                view.exibeMensagem("Nenhuma Ordem de Serviço ou Orçamento \n encontrado para o número informado!");
                limparTela();
            }

        } else {

            view.exibeMensagem("Informe um número de Ordem de Serviço \n ou Orçamento válido!");

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
                view.exibeMensagem("Ordem de Serviço alterada com Sucesso!");
                limparTela();
                habilitaCampos();
            } else {
                view.exibeMensagem("Não foi possivel alterar a Ordem de Serviço \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!");
        }

    }

    public void deletarOS() throws SQLException {
        OS_OrdemServico os = helper.pegarDadosDaTelaParaAlterar_OS();
        Connection conexao = new ModuloConexao().getConnection();
        OS_OrdemServico osDel = new OS_OrdemServico();
        OS_OrdemServicoDAO osDAO = new OS_OrdemServicoDAO(conexao);

        if (os != null) {
            int deletar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Deletar essa Ordem de Serviço?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (deletar == JOptionPane.YES_OPTION) {
                osDel = osDAO.delete(os);
                if (osDel != null) {
                    view.exibeMensagem("Ordem de Serviço deletada com Sucesso!");
                    limparTela();
                    habilitaCampos();
                } else {
                    view.exibeMensagem("Não foi possivel deletar a Ordem de Serviço \n"
                            + "verifique os dados informados e tente novamente!");
                }
            }
        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!");
        }
    }

    public void imprimirOS() {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Imprimir essa Ordem de Serviço?", "Atenção!", JOptionPane.YES_NO_OPTION);
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
