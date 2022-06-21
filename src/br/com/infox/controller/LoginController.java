/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller;

import br.com.infox.controller.helper.LoginHelper;
import br.com.infox.view.TelaLogin;

/**
 *
 * @author daniel.frey
 */
public class LoginController {
    private final TelaLogin view;
    private LoginHelper helper;

    public LoginController(TelaLogin view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
}
