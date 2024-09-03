package br.com.pc2.sistemadehospedagem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospedagemController {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/sistemadehospedagem";
        String user = "sistenadehospedagem";
        String password = "pc2";
        return DriverManager.getConnection(url, user, password);
    }

    public void createHospedagem(String codHospedagem, String codCliente, String codChale, String estadoHospedagem, String dataInicio, String dataFim, String qtdPessoas, String desconto, String valorFinal) {
        String sql = "INSERT INTO hospedagem (codHospedagem, codCliente, codChale, estadoHospedagem, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codHospedagem);
            stmt.setString(2, codCliente);
            stmt.setString(3, codChale);
            stmt.setString(4, estadoHospedagem);
            stmt.setString(5, dataInicio);
            stmt.setString(6, dataFim);
            stmt.setString(7, qtdPessoas);
            stmt.setString(8, desconto);
            stmt.setString(9, valorFinal);
            stmt.executeUpdate();
            System.out.println("Dados salvos com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar os dados.");
        }
    }

    public void updateHospedagem(String codHospedagem, String codCliente, String codChale, String estadoHospedagem, String dataInicio, String dataFim, String qtdPessoas, String desconto, String valorFinal) {
        String sql = "UPDATE hospedagem SET codCliente=?, codChale=?, estadoHospedagem=?, dataInicio=?, dataFim=?, qtdPessoas=?, desconto=?, valorFinal=? WHERE codHospedagem=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codCliente);
            stmt.setString(2, codChale);
            stmt.setString(3, estadoHospedagem);
            stmt.setString(4, dataInicio);
            stmt.setString(5, dataFim);
            stmt.setString(6, qtdPessoas);
            stmt.setString(7, desconto);
            stmt.setString(8, valorFinal);
            stmt.setString(9, codHospedagem);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar os dados.");
        }
    }

    public void deleteHospedagem(String codHospedagem) {
        String sql = "DELETE FROM hospedagem WHERE codHospedagem=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codHospedagem);
            stmt.executeUpdate();
            System.out.println("Dados deletados com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar os dados.");
        }
    }
}


