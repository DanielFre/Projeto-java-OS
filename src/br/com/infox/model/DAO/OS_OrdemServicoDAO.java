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

import br.com.infox.model.OS_OrdemServico;
import java.sql.*;

/**
 *
 * @author Daniel Frey
 * @version 1.0.0
 */
public class OS_OrdemServicoDAO {

    private final Connection conexao;

    public OS_OrdemServicoDAO(Connection connection) {
        this.conexao = connection;
    }

    public OS_OrdemServico insert(OS_OrdemServico emitir_os) throws SQLException {
        String sql = "insert into tbos ("
                + "tipo, "
                + "situacao, "
                + "equipamento, "
                + "defeito, "
                + "servico, "
                + "valor, "
                + "id_cliente, "
                + "id_usuario_tecnico"
                + ") "
                + "values (?,?,?,?,?,?,?,?);";//8

        PreparedStatement statement = conexao.prepareStatement(sql);

        if (emitir_os.getId_usuario_tecnico() > 0 && emitir_os.getId_cliente() > 0 && emitir_os.getEquipamento() != null && !emitir_os.getEquipamento().equals("") && emitir_os.getDefeito() != null && !emitir_os.getDefeito().equals("")) {
            statement.setString(1, emitir_os.getTipo());
            statement.setString(2, emitir_os.getSituacao());
            statement.setString(3, emitir_os.getEquipamento());
            statement.setString(4, emitir_os.getDefeito());
            statement.setString(5, emitir_os.getServico());
            statement.setString(6, emitir_os.getValor().replace(",", "."));
            statement.setInt(7, emitir_os.getId_cliente());
            statement.setInt(8, emitir_os.getId_usuario_tecnico());

            statement.execute();
            return emitir_os;

        } else {
            return null;
        }
    }

    public OS_OrdemServico pesquisar(OS_OrdemServico pesquisar_os) throws SQLException {
        String sql = "select os, date_format(data_os, '%d/%m/%Y - %H:%i') as data_os, tipo, situacao, equipamento, defeito, servico, valor, id_cliente, id_usuario_tecnico from tbos where os = ?;";//8

        PreparedStatement statement = conexao.prepareStatement(sql);

        if (pesquisar_os.getOs() > 0) {
            statement.setInt(1, pesquisar_os.getOs());

            statement.execute();

            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {

                int os = resultSet.getInt("os");
                String data_os = resultSet.getString("data_os");
                String tipo = resultSet.getString("tipo");
                String situacao = resultSet.getString("situacao");
                String equipamento = resultSet.getString("equipamento");
                String defeito = resultSet.getString("defeito");
                String servico = resultSet.getString("servico");
                String valor = resultSet.getString("valor");

                int id_cliente = resultSet.getInt("id_cliente");
                int id_usuario_tecnico = resultSet.getInt("id_usuario_tecnico");

                ClienteDAO nomecli = new ClienteDAO(conexao);
                String nomeCliente = nomecli.pesquisaNomePorID(id_cliente);//resultSet.getString("nome");

                UsuarioDAO nomeuser = new UsuarioDAO(conexao);
                String nomeTecnico = nomeuser.buscaNomeUsuarioPorID(id_usuario_tecnico);//resultSet.getString("usuario");

                OS_OrdemServico pesquisa = new OS_OrdemServico(os, data_os, equipamento, defeito, servico, valor, id_cliente, id_usuario_tecnico, tipo, situacao, nomeCliente, nomeTecnico);
                return pesquisa;

            } else {
                return null;
            }

        } else {
            return null;
        }
    }

    public OS_OrdemServico update(OS_OrdemServico alterar_os) throws SQLException {
        String sql = "update tbos set "
                + "tipo = ?, "
                + "situacao = ?, "
                + "equipamento = ?, "
                + "defeito = ?, "
                + "servico = ?, "
                + "valor = ?, "
                + "id_usuario_tecnico = ? "
                + "where os = ? ;";

        PreparedStatement statement = conexao.prepareStatement(sql);

        if (alterar_os.getId_usuario_tecnico() > 0 && alterar_os.getId_cliente() > 0 && alterar_os.getEquipamento() != null && !alterar_os.getEquipamento().equals("") && alterar_os.getDefeito() != null && !alterar_os.getDefeito().equals("")) {
            statement.setString(1, alterar_os.getTipo());
            statement.setString(2, alterar_os.getSituacao());
            statement.setString(3, alterar_os.getEquipamento());
            statement.setString(4, alterar_os.getDefeito());
            statement.setString(5, alterar_os.getServico());
            statement.setString(6, alterar_os.getValor().replace(",", "."));
            statement.setInt(7, alterar_os.getId_usuario_tecnico());
            statement.setInt(8, alterar_os.getOs());

            statement.execute();

            return alterar_os;

        } else {
            return null;
        }
    }

    public OS_OrdemServico delete(OS_OrdemServico deletar_os) throws SQLException {
        String sql = "delete from tbos where os = ? ;";

        PreparedStatement statement = conexao.prepareStatement(sql);

        if (deletar_os.getOs() > 0) {

            statement.setInt(1, deletar_os.getOs());

            statement.execute();

            return deletar_os;

        } else {
            return null;
        }
    }

    public OS_OrdemServico recuperarOS() throws SQLException {
        String sql = "select max(os) from tbos;";

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        if (resultSet.next()) {
            int os = resultSet.getInt("max(os)");

            OS_OrdemServico pesquisa = new OS_OrdemServico(os);
            return pesquisa;

        } else {
            return null;
        }

    }
}
