package br.com.pc2.sistemadehospedagem.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.pc2.sistemadehospedagem.model.Cliente;

public class ClienteDAOImpl extends ClienteDAO {

    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nomeCliente, rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, cepCliente, nascimentoCliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getRgCliente());
            stmt.setString(3, cliente.getEnderecoCliente());
            stmt.setString(4, cliente.getBairroCliente());
            stmt.setString(5, cliente.getCidadeCliente());
            stmt.setString(6, cliente.getEstadoCliente());
            stmt.setString(7, cliente.getCepCliente());
            stmt.setDate(8, new java.sql.Date(cliente.getNascimentoCliente().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente read(int codCliente) {
        return super.read(codCliente);
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET nomeCliente = ?, rgCliente = ?, enderecoCliente = ?, bairroCliente = ?, cidadeCliente = ?, estadoCliente = ?, cepCliente = ?, nascimentoCliente = ? WHERE codCliente = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getRgCliente());
            stmt.setString(3, cliente.getEnderecoCliente());
            stmt.setString(4, cliente.getBairroCliente());
            stmt.setString(5, cliente.getCidadeCliente());
            stmt.setString(6, cliente.getEstadoCliente());
            stmt.setString(7, cliente.getCepCliente());
            stmt.setDate(8, new java.sql.Date(cliente.getNascimentoCliente().getTime()));
            stmt.setInt(9, cliente.getCodCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codCliente) {
        String sql = "DELETE FROM Cliente WHERE codCliente = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
