package br.com.pc2.sistemadehospedagem.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pc2.sistemadehospedagem.model.Cliente;

public class ClienteDAO {
    public void create(Cliente cliente) {
    }

    public Cliente read(int codCliente) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE codCliente = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCodCliente(rs.getInt("codCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setRgCliente(rs.getString("rgCliente"));
                cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
                cliente.setBairroCliente(rs.getString("bairroCliente"));
                cliente.setCidadeCliente(rs.getString("cidadeCliente"));
                cliente.setEstadoCliente(rs.getString("estadoCliente"));
                cliente.setCepCliente(rs.getString("cepCliente"));
                cliente.setNascimentoCliente(rs.getDate("nascimentoCliente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public void update(Cliente cliente) {
    }

    public void delete(int codCliente) {
    }
}
