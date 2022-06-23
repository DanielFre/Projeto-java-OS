/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.view.MenuPrincipal;
import br.com.infox.view.TelaSobre;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel.frey
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
    
    public void carregarUsuarioAtual() {
        
    }

    public void sairDoSistema() {
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção!", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

    public void ajudaSobre() {
        TelaSobre ajuda = new TelaSobre();
        ajuda.setVisible(true);
    }
}