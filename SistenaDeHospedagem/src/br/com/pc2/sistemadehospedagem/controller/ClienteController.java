package br.com.pc2.sistemadehospedagem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteController {
    
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/sistemadehospedagem";
        String user = "sistenadehospedagem";
        String password = "pc2";
        return DriverManager.getConnection(url, user, password);
    }

    public void createCliente(String codigo, String nome, String rg, String endereco, String bairro, String cidade, String estado, String cep, String nascimento) {
        String sql = "INSERT INTO clientes (codigo, nome, rg, endereco, bairro, cidade, estado, cep, nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.setString(2, nome);
            stmt.setString(3, rg);
            stmt.setString(4, endereco);
            stmt.setString(5, bairro);
            stmt.setString(6, cidade);
            stmt.setString(7, estado);
            stmt.setString(8, cep);
            stmt.setString(9, nascimento);
            stmt.executeUpdate();
            System.out.println("Dados salvos com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar os dados.");
        }
    }

    public void updateCliente(String codigo, String nome, String rg, String endereco, String bairro, String cidade, String estado, String cep, String nascimento) {
        String sql = "UPDATE clientes SET nome=?, rg=?, endereco=?, bairro=?, cidade=?, estado=?, cep=?, nascimento=? WHERE codigo=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, rg);
            stmt.setString(3, endereco);
            stmt.setString(4, bairro);
            stmt.setString(5, cidade);
            stmt.setString(6, estado);
            stmt.setString(7, cep);
            stmt.setString(8, nascimento);
            stmt.setString(9, codigo);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar os dados.");
        }
    }

    public void deleteHospedagem(String codCliente) {
        String sql = "DELETE FROM hospedagem WHERE codHospedagem=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codCliente);
            stmt.executeUpdate();
            System.out.println("Dados deletados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar os dados.");
        }
    }

    public void deleteCliente(String codCliente) {
        System.out.println("Cliente com código " + codCliente + " deletado.");
    }
}
		

