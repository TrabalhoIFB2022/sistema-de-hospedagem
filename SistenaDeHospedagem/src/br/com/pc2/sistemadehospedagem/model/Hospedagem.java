package br.com.pc2.sistemadehospedagem.model;

import java.math.BigDecimal;
import java.util.Date;

public class Hospedagem {
    private int codHospedagem;
    private int codCliente;
    private int codChale;
    private String estadoHospedagem;
    private Date dataInicio;
    private Date dataFim;
    private int qtdPessoas;
    private BigDecimal desconto;
    private BigDecimal valorFinal;

    public int getCodHospedagem() {
        return codHospedagem;
    }

    public void setCodHospedagem(int codHospedagem) {
        this.codHospedagem = codHospedagem;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodChale() {
        return codChale;
    }

    public void setCodChale(int codChale) {
        this.codChale = codChale;
    }

    public String getEstadoHospedagem() {
        return estadoHospedagem;
    }

    public void setEstadoHospedagem(String estadoHospedagem) {
        this.estadoHospedagem = estadoHospedagem;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}
