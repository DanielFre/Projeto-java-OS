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
import javax.swing.JOptionPane;

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
        view.getBtnOS_Adicionar().setEnabled(true);
        view.getJtfOSPesquisaCliente().setEnabled(true);
        view.getTblOSClientes().setVisible(true);
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
            } else {
                view.exibeMensagem("Não foi possivel emitir a Ordem de Serviço \n"
                        + "verifique os dados informados e tente novamente!");
            }

        } else {
            view.exibeMensagem("Informe todos os campos obrigatórios!!");
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
                view.getBtnOS_Adicionar().setEnabled(false);
                view.getJtfOSPesquisaCliente().setEnabled(false);
                view.getTblOSClientes().setVisible(false);

                helper.setarDadosOSnaTela(osPesquisa);

            } else {
                view.exibeMensagem("Nenhuma Ordem de Serviço ou Orçamento \n encontrado para o número informado!");
                limparTela();
            }

        } else {
          
            view.exibeMensagem("Informe um número de Ordem de Serviço \n ou Orçamento válido!");
            
        }
    }

}
