/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel.frey
 */
public class ModuloConexao {

    public static Connection getConnection() {;
        Connection conexao;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbinfox", "root", "root");
            return conexao;
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
