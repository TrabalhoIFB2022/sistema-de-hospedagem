package br.com.pc2.sistemadehospedagem.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.pc2.sistemadehospedagem.model.Hospedagem;

public class HospedagemDAO {
    public void create(Hospedagem hospedagem) {
    }

    public Hospedagem read(int codHospedagem) {
        Hospedagem hospedagem = null;
        String sql = "SELECT * FROM Hospedagem WHERE codHospedagem = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codHospedagem);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                hospedagem = new Hospedagem();
                hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
                hospedagem.setCodCliente(rs.getInt("codCliente"));
                hospedagem.setCodChale(rs.getInt("codChale"));
                hospedagem.setEstadoHospedagem(rs.getString("estadoHospedagem"));
                hospedagem.setDataInicio(rs.getDate("dataInicio"));
                hospedagem.setDataFim(rs.getDate("dataFim"));
                hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
                hospedagem.setDesconto(rs.getBigDecimal("desconto"));
                hospedagem.setValorFinal(rs.getBigDecimal("valorFinal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospedagem;
    }

    public void update(Hospedagem hospedagem) {
    }

    public void delete(int codHospedagem) {
    }
}

