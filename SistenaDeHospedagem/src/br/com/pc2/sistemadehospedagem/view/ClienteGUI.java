package br.com.pc2.sistemadehospedagem.view;

import br.com.pc2.sistemadehospedagem.controller.ClienteController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClienteGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField codClienteField;
    private JTextField nomeField;
    private JTextField rgField;
    private JTextField enderecoField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private JTextField cepField;
    private JTextField nascimentoField;
    private JTable table;
    private DefaultTableModel tableModel;
    private ClienteController clienteController;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClienteGUI frame = new ClienteGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ClienteGUI() {
        clienteController = new ClienteController();
        setTitle("Cadastro de Cliente");
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

        panel.add(new JLabel("Código Cliente:"));
        codClienteField = new JTextField();
        panel.add(codClienteField);
        codClienteField.setColumns(10);

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);
        nomeField.setColumns(10);

        panel.add(new JLabel("RG:"));
        rgField = new JTextField();
        panel.add(rgField);
        rgField.setColumns(10);

        panel.add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        panel.add(enderecoField);
        enderecoField.setColumns(10);

        panel.add(new JLabel("Bairro:"));
        bairroField = new JTextField();
        panel.add(bairroField);
        bairroField.setColumns(10);

        panel.add(new JLabel("Cidade:"));
        cidadeField = new JTextField();
        panel.add(cidadeField);
        cidadeField.setColumns(10);

        panel.add(new JLabel("Estado:"));
        estadoField = new JTextField();
        panel.add(estadoField);
        estadoField.setColumns(10);

        panel.add(new JLabel("CEP:"));
        cepField = new JTextField();
        panel.add(cepField);
        cepField.setColumns(10);

        panel.add(new JLabel("Data de Nascimento:"));
        nascimentoField = new JTextField();
        panel.add(nascimentoField);
        nascimentoField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Código Cliente", "Nome", "RG", "Endereço", "Bairro", "Cidade", "Estado", "CEP", "Nascimento"
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
        String codCliente = codClienteField.getText();
        String nome = nomeField.getText();
        String rg = rgField.getText();
        String endereco = enderecoField.getText();
        String bairro = bairroField.getText();
        String cidade = cidadeField.getText();
        String estado = estadoField.getText();
        String cep = cepField.getText();
        String nascimento = nascimentoField.getText();

        clienteController.createCliente(codCliente, nome, rg, endereco, bairro, cidade, estado, cep, nascimento);

        Object[] rowData = {codCliente, nome, rg, endereco, bairro, cidade, estado, cep, nascimento};
        tableModel.addRow(rowData);

        limparCampos();
    }

    private void alterarDados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String codCliente = codClienteField.getText();
            String nome = nomeField.getText();
            String rg = rgField.getText();
            String endereco = enderecoField.getText();
            String bairro = bairroField.getText();
            String cidade = cidadeField.getText();
            String estado = estadoField.getText();
            String cep = cepField.getText();
            String nascimento = nascimentoField.getText();

            clienteController.updateCliente(codCliente, nome, rg, endereco, bairro, cidade, estado, cep, nascimento);

            tableModel.setValueAt(codCliente, selectedRow, 0);
            tableModel.setValueAt(nome, selectedRow, 1);
            tableModel.setValueAt(rg, selectedRow, 2);
            tableModel.setValueAt(endereco, selectedRow, 3);
            tableModel.setValueAt(bairro, selectedRow, 4);
            tableModel.setValueAt(cidade, selectedRow, 5);
            tableModel.setValueAt(estado, selectedRow, 6);
            tableModel.setValueAt(cep, selectedRow, 7);
            tableModel.setValueAt(nascimento, selectedRow, 8);
        }
    }

    private void excluirDados() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String codCliente = tableModel.getValueAt(selectedRow, 0).toString();
            clienteController.deleteCliente(codCliente);
            tableModel.removeRow(selectedRow);
        }
    }

    private void pesquisarDados() {
        String codCliente = codClienteField.getText();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(codCliente)) {
                nomeField.setText(tableModel.getValueAt(i, 1).toString());
                rgField.setText(tableModel.getValueAt(i, 2).toString());
                enderecoField.setText(tableModel.getValueAt(i, 3).toString());
                bairroField.setText(tableModel.getValueAt(i, 4).toString());
                cidadeField.setText(tableModel.getValueAt(i, 5).toString());
                estadoField.setText(tableModel.getValueAt(i, 6).toString());
                cepField.setText(tableModel.getValueAt(i, 7).toString());
                nascimentoField.setText(tableModel.getValueAt(i, 8).toString());
                break;
            }
        }
    }

    private void limparCampos() {
        codClienteField.setText("");
        nomeField.setText("");
        rgField.setText("");
        enderecoField.setText("");
        bairroField.setText("");
        cidadeField.setText("");
        estadoField.setText("");
        cepField.setText("");
        nascimentoField.setText("");
    }
}

