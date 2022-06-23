/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model.DAO;

import br.com.infox.model.Usuario;
import java.sql.*;

/**
 *
 * @author daniel.frey
 */
public class UsuarioDAO {

    private final Connection conexao;

    public UsuarioDAO(Connection connection) {
        this.conexao = connection;
    }

    public boolean verificaSeExisteUsuarioESenhaNoBanco(Usuario usuario) throws SQLException {

        String sql = "select login, senha  from tbusuarios "
                + "where "
                + "login = ? "
                + "and "
                + "senha = ?;";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, usuario.getLogin());
        statement.setString(2, usuario.getSenha());

        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        return resultSet.next();
    }

    public String buscaPerfilAcesso(Usuario usuario) throws SQLException {
        String nivelPerfil = "";
        
        String sql = "select nivelacesso from tbusuarios "
                + "where "
                + "login = ? "
                + "and "
                + "senha = ?;";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, usuario.getLogin());
        statement.setString(2, usuario.getSenha());

        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        if (resultSet.next()) {
            nivelPerfil = resultSet.getString(1);
        }
        return nivelPerfil;
    }

}
