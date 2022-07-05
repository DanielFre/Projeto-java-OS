/*
 * The MIT License
 *
 * Copyright 2022 Daniel Frey.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.infox.model.DAO;

import br.com.infox.model.Cliente;
import java.sql.*;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class ClienteDAO {

    private final Connection conexao;

    public ClienteDAO(Connection connection) {
        this.conexao = connection;
    }

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

    public ResultSet pesquisarClienteNaOS(Cliente cliente) throws SQLException {
        String sql = "select "
                + "id as 'Id', "
                + "nome as 'Nome', "
                + "fone as 'Telefone' "
                + "from tbclientes "
                + "where "
                + "nome like ? "
                + "order by nome asc;";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, "%" + cliente.getPesquisa() + "%");

        ResultSet resultSet = statement.executeQuery();
        return resultSet;

    }

    public String pesquisaNomePorID(int id_cliente) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(id_cliente);

        String nome = "";

        String sql = "select nome from tbclientes where id = ?;";

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setInt(1, cliente.getId());

        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        if (resultSet.next()) {
            nome = resultSet.getString(1);
        }
        return nome;
    }

}
