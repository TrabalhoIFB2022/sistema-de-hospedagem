package br.com.pc2.sistemadehospedagem.view;

import br.com.pc2.sistemadehospedagem.controller.HospedagemController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HospedagemGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodHospedagem;
    private JTextField txtCodCliente;
    private JTextField txtNomeHospede;
    private JTextField txtQtdPessoas;
    private JTextField txtDesconto;
    private JTextField txtValorFinal;
    private JTextField txtEstado;
    private JTextField txtDataInicio;
    private JTextField txtDataFim;
    private JTable table;
    private DefaultTableModel tableModel;
    private HospedagemController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HospedagemGUI frame = new HospedagemGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HospedagemGUI() {
    	setBackground(new Color(230, 230, 250));
        controller = new HospedagemController();
        setTitle("Hospedagem");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 235, 215));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(9, 2, 10, 10));

        panel.add(new JLabel("Código Hospedagem:"));
        txtCodHospedagem = new JTextField();
        panel.add(txtCodHospedagem);
        txtCodHospedagem.setColumns(10);

        panel.add(new JLabel("Código Cliente:"));
        txtCodCliente = new JTextField();
        panel.add(txtCodCliente);
        txtCodCliente.setColumns(10);

        panel.add(new JLabel("Nome Hóspede:"));
        txtNomeHospede = new JTextField();
        panel.add(txtNomeHospede);
        txtNomeHospede.setColumns(10);

        panel.add(new JLabel("Quantidade de Pessoas:"));
        txtQtdPessoas = new JTextField();
        panel.add(txtQtdPessoas);
        txtQtdPessoas.setColumns(10);

        panel.add(new JLabel("Desconto:"));
        txtDesconto = new JTextField();
        panel.add(txtDesconto);
        txtDesconto.setColumns(10);

        panel.add(new JLabel("Valor Final:"));
        txtValorFinal = new JTextField();
        panel.add(txtValorFinal);
        txtValorFinal.setColumns(10);

        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panel.add(txtEstado);
        txtEstado.setColumns(10);

        panel.add(new JLabel("Data Início:"));
        txtDataInicio = new JTextField();
        panel.add(txtDataInicio);
        txtDataInicio.setColumns(10);

        panel.add(new JLabel("Data Fim:"));
        txtDataFim = new JTextField();
        panel.add(txtDataFim);
        txtDataFim.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Código Hospedagem", "Código Cliente", "Nome Hóspede", "Quantidade de Pessoas", "Desconto", "Valor Final", "Estado", "Data Início", "Data Fim"
            }
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton btnInserir = new JButton("Inserir");
        btnInserir.setForeground(new Color(230, 230, 250));
        btnInserir.setBackground(new Color(0, 128, 0));
        buttonPanel.add(btnInserir);

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setForeground(new Color(230, 230, 250));
        btnAlterar.setBackground(new Color(0, 0, 255));
        buttonPanel.add(btnAlterar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setForeground(new Color(230, 230, 250));
        btnExcluir.setBackground(new Color(255, 0, 0));
        buttonPanel.add(btnExcluir);

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setForeground(new Color(230, 230, 250));
        btnPesquisar.setBackground(new Color(255, 0, 255));
        buttonPanel.add(btnPesquisar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setForeground(new Color(0, 0, 255));
        btnLimpar.setBackground(new Color(255, 192, 203));
        buttonPanel.add(btnLimpar);

        JButton btnSair = new JButton("Sair");
        buttonPanel.add(btnSair);

        btnInserir.addActionListener(e -> {
            inserirDados();
            JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso!");
        });
        btnAlterar.addActionListener(e -> {
            alterarDados();
            JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
        });
        btnExcluir.addActionListener(e -> {
            excluirDados();
            JOptionPane.showMessageDialog(this, "Dados excluídos com sucesso!");
        });
        btnPesquisar.addActionListener(e -> {
            pesquisarDados();
            JOptionPane.showMessageDialog(this, "Pesquisa concluída!");
        });
        btnLimpar.addActionListener(e -> {
            limparCampos();
            JOptionPane.showMessageDialog(this, "Campos limpos!");
        });
        btnSair.addActionListener(e -> System.exit(0));
    }

    private void inserirDados() {
        String codHospedagem = txtCodHospedagem.getText();
        String codCliente = txtCodCliente.getText();
        String nomeHospede = txtNomeHospede.getText();
        String qtdPessoas = txtQtdPessoas.getText();
        String desconto = txtDesconto.getText();
        String valorFinal = txtValorFinal.getText();
        String estado = txtEstado.getText();
        String dataInicio = txtDataInicio.getText();
        String dataFim = txtDataFim.getText();

        controller.createHospedagem(codHospedagem, codCliente, "", estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal);

        Object[] rowData = {codHospedagem, codCliente, nomeHospede, qtdPessoas, desconto, valorFinal, estado, dataInicio, dataFim};
        tableModel.addRow(rowData);

        limparCampos();
    }

    private void alterarDados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String codHospedagem = txtCodHospedagem.getText();
            String codCliente = txtCodCliente.getText();
            String nomeHospede = txtNomeHospede.getText();
            String qtdPessoas = txtQtdPessoas.getText();
            String desconto = txtDesconto.getText();
            String valorFinal = txtValorFinal.getText();
            String estado = txtEstado.getText();
            String dataInicio = txtDataInicio.getText();
            String dataFim = txtDataFim.getText();

            controller.updateHospedagem(codHospedagem, codCliente, "", estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal);

            tableModel.setValueAt(codHospedagem, selectedRow, 0);
            tableModel.setValueAt(codCliente, selectedRow, 1);
            tableModel.setValueAt(nomeHospede, selectedRow, 2);
            tableModel.setValueAt(qtdPessoas, selectedRow, 3);
            tableModel.setValueAt(desconto, selectedRow, 4);
            tableModel.setValueAt(valorFinal, selectedRow, 5);
            tableModel.setValueAt(estado, selectedRow, 6);
            tableModel.setValueAt(dataInicio, selectedRow, 7);
            tableModel.setValueAt(dataFim, selectedRow, 8);
        }
    }

    private void excluirDados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String codHospedagem = tableModel.getValueAt(selectedRow, 0).toString();
            controller.deleteHospedagem(codHospedagem);
            tableModel.removeRow(selectedRow);
        }
    }

    private void pesquisarDados() {
        String codHospedagem = txtCodHospedagem.getText();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(codHospedagem)) {
                txtCodCliente.setText(tableModel.getValueAt(i, 1).toString());
                txtNomeHospede.setText(tableModel.getValueAt(i, 2).toString());
                txtQtdPessoas.setText(tableModel.getValueAt(i, 3).toString());
                txtDesconto.setText(tableModel.getValueAt(i, 4).toString());
                txtValorFinal.setText(tableModel.getValueAt(i, 5).toString());
                txtEstado.setText(tableModel.getValueAt(i, 6).toString());
                txtDataInicio.setText(tableModel.getValueAt(i, 7).toString());
                txtDataFim.setText(tableModel.getValueAt(i, 8).toString());
                break;
            }
        }
    }

    private void limparCampos() {
        txtCodHospedagem.setText("");
        txtCodCliente.setText("");
        txtNomeHospede.setText("");
        txtQtdPessoas.setText("");
        txtDesconto.setText("");
        txtValorFinal.setText("");
        txtEstado.setText("");
        txtDataInicio.setText("");
        txtDataFim.setText("");
    }
}