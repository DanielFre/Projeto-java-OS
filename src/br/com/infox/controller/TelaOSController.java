/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.controller.helper.TelaOSHelper;
import br.com.infox.view.TelaOS;

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
    }

   

}
