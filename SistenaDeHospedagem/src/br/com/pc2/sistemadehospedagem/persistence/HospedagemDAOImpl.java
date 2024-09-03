package br.com.pc2.sistemadehospedagem.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.pc2.sistemadehospedagem.model.Hospedagem;

public class HospedagemDAOImpl extends HospedagemDAO {

    @Override
    public void create(Hospedagem hospedagem) {
        String sql = "INSERT INTO Hospedagem (codCliente, codChale, estadoHospedagem, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hospedagem.getCodCliente());
            stmt.setInt(2, hospedagem.getCodChale());
            stmt.setString(3, hospedagem.getEstadoHospedagem());
            stmt.setDate(4, new java.sql.Date(hospedagem.getDataInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(hospedagem.getDataFim().getTime()));
            stmt.setInt(6, hospedagem.getQtdPessoas());
            stmt.setBigDecimal(7, hospedagem.getDesconto());
            stmt.setBigDecimal(8, hospedagem.getValorFinal());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hospedagem hospedagem) {
        String sql = "UPDATE Hospedagem SET codCliente = ?, codChale = ?, estadoHospedagem = ?, dataInicio = ?, dataFim = ?, qtdPessoas = ?, desconto = ?, valorFinal = ? WHERE codHospedagem = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hospedagem.getCodCliente());
            stmt.setInt(2, hospedagem.getCodChale());
            stmt.setString(3, hospedagem.getEstadoHospedagem());
            stmt.setDate(4, new java.sql.Date(hospedagem.getDataInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(hospedagem.getDataFim().getTime()));
            stmt.setInt(6, hospedagem.getQtdPessoas());
            stmt.setBigDecimal(7, hospedagem.getDesconto());
            stmt.setBigDecimal(8, hospedagem.getValorFinal());
            stmt.setInt(9, hospedagem.getCodHospedagem());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codHospedagem) {
        String sql = "DELETE FROM Hospedagem WHERE codHospedagem = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codHospedagem);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

