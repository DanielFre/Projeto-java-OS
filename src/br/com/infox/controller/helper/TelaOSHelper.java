/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller.helper;

import br.com.infox.model.Cliente;
import br.com.infox.model.OS_OrdemServico;
import br.com.infox.model.Usuario;
import br.com.infox.view.TelaOS;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author daniel.frey
 */
public class TelaOSHelper {

    private final TelaOS view;

    public TelaOSHelper(TelaOS view) {
        this.view = view;
    }

    public void limpatela() {
        view.getJtfOSClienteID().setText("0");
        view.getJtfOSClienteCliente().setText("");
        view.getJtfOSData().setText("");
        view.getJtfOSDefeito().setText("");
        view.getJtfOSEquipamento().setText("");
        view.getJtfOSPesquisaCliente().setText("");
        view.getJtfOSServico().setText("");
        view.getJtfOSValor().setText("0,00");
        view.getJtfOSid().setText("0");
        view.getCbcOS_Tecnico().setSelectedItem("");
    }

    public Cliente PegarDadosDaTelaDeOSParaPesquisarCliente() {

        String pesquisa = view.getJtfOSPesquisaCliente().getText();

        Cliente pesquisaClienteOS = new Cliente(pesquisa);
        return pesquisaClienteOS;
    }

    public void limpatabela() {
        view.getJtfOSPesquisaCliente().setText("");
        //o código abaixo limpa os campos da tabela
        ((DefaultTableModel) view.getTblOSClientes().getModel()).setRowCount(0);
    }

    public void setarDadosNaTabelaOS(ResultSet resultSet) {
        //a linha abaixo chama a função que usa a biblioteca rs2xml.jar para popular a tabela em tempo real
        view.getTblOSClientes().setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    public void setarDadosDaTabelaNosCamposDaTela() {
        int dadosLinhaSelecionada = view.getTblOSClientes().getSelectedRow();
        view.getJtfOSClienteID().setText(view.getTblOSClientes().getModel().getValueAt(dadosLinhaSelecionada, 0).toString());
        view.getJtfOSClienteCliente().setText(view.getTblOSClientes().getModel().getValueAt(dadosLinhaSelecionada, 1).toString());

    }

    public OS_OrdemServico setarTipodeOS() {

        if (view.getRdbOS_OrdemDeServico().isSelected()) {
            String tipo = "Ordem de Serviço";

            OS_OrdemServico t_os = new OS_OrdemServico(tipo);
            return t_os;

        } else if (view.getRdbOSOrcamento().isSelected()) {
            String tipo = "Orçamento";
            OS_OrdemServico t_os = new OS_OrdemServico(tipo);
            return t_os;

        } else {
            view.exibeMensagem("Selecione o tipo de OS: \n"
                    + "Orçamento ou Ordem de Serviço!");
            return null;
        }
    }

    public OS_OrdemServico pegarDadosDaTelaParaEmitir_OS() {
        String tipo = setarTipodeOS().getTipo();
        String equipamento = view.getJtfOSEquipamento().getText();
        String defeito = view.getJtfOSDefeito().getText();
        String servico = view.getJtfOSServico().getText();
        String valorOS = view.getJtfOSValor().getText().replace(",", ".");
        float valor = Float.parseFloat(valorOS);
        int id_cliente = Integer.parseInt(view.getJtfOSClienteID().getText());
        int id_usuario_tecnico = Integer.parseInt(view.getJtfOSTecnicoID().getText());

        String situacao = (String) view.getCbcOS_Situacao().getSelectedItem();

        if (id_cliente > 0 && id_usuario_tecnico > 0 && !equipamento.equals("") && equipamento != null && !defeito.equals("") && defeito != null) {
            OS_OrdemServico os = new OS_OrdemServico(equipamento, defeito, servico, valor, id_cliente, id_usuario_tecnico, tipo, situacao);

            return os;
        } else {
            return null;
        }

    }

    public void setarUsuariosTecnicos(ArrayList<Usuario> usuarios) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCbcOS_Tecnico().getModel();

        for (Usuario usuario : usuarios) {
            comboBoxModel.addElement(usuario.getNomeUsuario() + " - " + usuario.getId()); //aqui esta o truque
        }
    }

//    public Usuario pegarIdTecnico() {
//        return  view.getCbcOS_Tecnico().getSelectedItem();
//    }
    public void setarIdTecnico() {
        String teste = (String) view.getCbcOS_Tecnico().getSelectedItem(); //.getSelectedIndex();//electedItem();
        teste = teste.replaceAll(".+ ", "");
        view.getJtfOSTecnicoID().setText(teste + "");

    }

}