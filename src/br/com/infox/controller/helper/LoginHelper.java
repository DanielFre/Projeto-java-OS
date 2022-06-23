/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.controller.helper;

import br.com.infox.view.TelaLogin;
import br.com.infox.DAO.ModuloConexao;
import br.com.infox.model.Usuario;
import java.sql.*;

/**
 *
 * @author daniel.frey
 */
public class LoginHelper {

    private final TelaLogin view;
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public LoginHelper(TelaLogin view) throws SQLException {
        this.view = view;
        this.conexao = ModuloConexao.getConnection(); 
    }
    
    public void verificaConexaoComDatabase(){
        if (this.conexao != null){
            this.view.getJlbDatabase().setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/database-connected-48.png")));
       
        }else{
            this.view.getJlbDatabase().setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/database-desconnected-48.png")));

        }
    }
    
    public Usuario obterDadosDaTelaDeLogin() {
        String login = view.getJtfLogin().getText();
        String senha = new String(view.getJpfSenha().getPassword());
//      String senha = view.getJpfSenha().getText();//old

        Usuario autentica = new Usuario(login, senha);
        return autentica;
    }

    public void setarDadosNaTelaDeLogin(Usuario dados) {
        String login = dados.getLogin();
        String senha = dados.getSenha();

        view.getJtfLogin().setText(login);
        view.getJpfSenha().setText(senha);

    }

    public void limparTela() {
        view.getJtfLogin().setText("");
        view.getJpfSenha().setText("");
    }
}
