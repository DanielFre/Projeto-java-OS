/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.model.DAO;

import br.com.infox.model.OS_OrdemServico;
import java.sql.*;

/**
 *
 * @author daniel.frey
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
            statement.setString(6, emitir_os.getValor());
            statement.setInt(7, emitir_os.getId_cliente());
            statement.setInt(8, emitir_os.getId_usuario_tecnico());

            statement.execute();
            return emitir_os;

        } else {
            return null;
        }
    }
}
