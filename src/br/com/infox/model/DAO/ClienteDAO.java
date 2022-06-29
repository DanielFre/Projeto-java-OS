/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model.DAO;

import br.com.infox.model.Cliente;
import java.sql.*;

/**
 *
 * @author daniel.frey
 */
public class ClienteDAO {

    private final Connection conexao;

    public ClienteDAO(Connection connection) {
        this.conexao = connection;
    }

//    public Cliente pesquisarConsultas(PreparedStatement statement) throws SQLException {
//        statement.execute();
//         
//        ResultSet resultSet = statement.getResultSet();
//
//        if (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String nome = resultSet.getString("nome");
//            String endereco = resultSet.getString("endereco");
//            String fone = resultSet.getString("fone");
//            String email = resultSet.getString("email");
//
//            Cliente clienteComDadosDoBanco = new Cliente(id, nome, endereco, fone, email);
//
//            return clienteComDadosDoBanco;
//        } else {
//            return null;
//        }
//    }
//
//    public Cliente consultarPorNome(Cliente cliente) throws SQLException {
//
//        String sql = "select * from tbclientes where nome like %?%;";
//
//        PreparedStatement statement = conexao.prepareStatement(sql);
//        statement.setString(1, cliente.getNome());
//
//        return pesquisarConsultas(statement);
//    }
    public Cliente insert(Cliente cliente) throws SQLException {
        String sql = "insert into tbclientes(nome, endereco, fone, email) values (?,?,?,?);";

        PreparedStatement statement = conexao.prepareStatement(sql);

        if (cliente.getNome() != null && !cliente.getNome().equals("") && cliente.getFone() != null && !cliente.getFone().equals("")) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
            statement.setString(3, cliente.getFone());
            statement.setString(4, cliente.getEmail());

            statement.execute();
            return cliente;

        } else {
            return null;
        }
    }

    public Cliente update(Cliente cliente) throws SQLException {

        String sql = "update tbclientes set nome = ?, endereco = ?, fone = ?, email = ? where id = ? ;";
        PreparedStatement statement = conexao.prepareStatement(sql);

        if (!cliente.getNome().equals("") && !cliente.getFone().equals("")) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEndereco());
            statement.setString(3, cliente.getFone());
            statement.setString(4, cliente.getEmail());
            statement.setInt(5, cliente.getId());

            statement.execute();

            return cliente;

        } else {
            return null;
        }
    }

    public Cliente delete(Cliente cliente) throws SQLException {
        String sql = "delete from tbclientes where id = ? and nome = ?;";
        PreparedStatement statement = conexao.prepareStatement(sql);

        if (cliente.getId() > 0 && !cliente.getNome().equals("")) {

            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNome());

            statement.execute();
            return cliente;

        } else {
            return null;
        }
    }

    public ResultSet pesquisarCliente(Cliente cliente) throws SQLException {
        String sql = "select "
                + "id as 'ID', "
                + "nome as 'Nome', "
                + "endereco as 'Endereço', "
                + "fone as 'Telefone', "
                + "email as 'E-mail' "
                + "from tbclientes "
                + "where "
                + "nome like ? "
                + "order by nome asc;";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, "%" + cliente.getPesquisa() + "%");

        ResultSet resultSet = statement.executeQuery();
        return resultSet;

    }

}
