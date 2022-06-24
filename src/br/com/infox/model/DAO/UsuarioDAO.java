/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model.DAO;

import br.com.infox.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public String buscaNomeUsuario(Usuario usuario) throws SQLException {
        String nome = "";

        String sql = "select usuario from tbusuarios "
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
            nome = resultSet.getString(1);
        }
        return nome;
    }

//    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
//        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//
//        statement.execute();
//        ResultSet resultSet = statement.getResultSet();
//
//        if (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String nomeUsuario = resultSet.getString("usuario");
//            String telefone = resultSet.getString("fone");
//            String login = resultSet.getString("login");
//            String senha = resultSet.getString("senha");
//            String nivelAcesso = resultSet.getString("nivelacesso");
//
//            Usuario usuarioComDadosDoBanco = new Usuario(id, nomeUsuario, login, senha, telefone, nivelAcesso);
//            usuarios.add(usuarioComDadosDoBanco);
//            return usuarios;
//        } else {
//            return null;
//        }
//
//    }
//
//    
    public Usuario pesquisarConsultas(PreparedStatement statement) throws SQLException {
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nomeUsuario = resultSet.getString("usuario");
            String telefone = resultSet.getString("fone");
            String login = resultSet.getString("login");
            String senha = resultSet.getString("senha");
            String nivelAcesso = resultSet.getString("nivelacesso");

            Usuario usuarioComDadosDoBanco = new Usuario(id, nomeUsuario, login, senha, telefone, nivelAcesso);
//            usuarios.add(usuarioComDadosDoBanco);
            return usuarioComDadosDoBanco;
        } else {
            return null;
        }
    }

    public Usuario consultarPorId(Usuario usuario) throws SQLException {

        String sql = "select * from tbusuarios where id = ? limit 1;";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        return pesquisarConsultas(statement);

    }

    public Usuario consultarPorLogin(Usuario usuario) throws SQLException {

        String sql = "select * from tbusuarios where login = ? limit 1;";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getLogin());

        return pesquisarConsultas(statement);
//        return pesquisa(statement).get(0);
    }

    public Usuario consultarPorNome(Usuario usuario) throws SQLException {

        String sql = "select * from tbusuarios where usuario = ? limit 1;";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getNomeUsuario());

        return pesquisarConsultas(statement);
//        return pesquisa(statement).get(0);
    }

    public Usuario insert(Usuario usuario) throws SQLException {
        String sql = "insert into tbusuarios(usuario, fone, login, senha, nivelacesso) values (?,?,?,?,?);";

        PreparedStatement statement = conexao.prepareStatement(sql);

        if (!usuario.getNomeUsuario().equals("") && !usuario.getLogin().equals("") && !usuario.getSenha().equals("")) { //!usuario.getNomeUsuario().isEmpty() && !usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty() && 
            statement.setString(1, usuario.getNomeUsuario());
            statement.setString(2, usuario.getTelefone());
            statement.setString(3, usuario.getLogin());
            statement.setString(4, usuario.getSenha());
            statement.setString(5, usuario.getNivelAcesso());

            statement.execute();
            return usuario;

        } else {
            return null;
        }
    }
}
