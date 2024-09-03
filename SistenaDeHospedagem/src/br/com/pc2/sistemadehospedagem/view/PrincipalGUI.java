package br.com.pc2.sistemadehospedagem.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PrincipalGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblGerenciamento;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrincipalGUI frame = new PrincipalGUI();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PrincipalGUI() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 1227, 557);
        setResizable(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    null, "Deseja salvar a aplicação antes de sair?", 
                    "Confirmação de Saída", JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    salvarAplicacao();
                    System.exit(0);
                } else if (confirm == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(144, 238, 144));
        setJMenuBar(menuBar);

        JMenu mnCadastro = new JMenu("Cadastro");
        mnCadastro.setForeground(new Color(0, 128, 0));
        mnCadastro.setBackground(new Color(224, 255, 255));
        mnCadastro.setFont(new Font("Arial Black", Font.PLAIN, 12));
        menuBar.add(mnCadastro);

        JMenuItem mntmCliente = new JMenuItem("Cliente");
        mntmCliente.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteGUI fc = new ClienteGUI();
                fc.setLocationRelativeTo(null);
                fc.setVisible(true);
            }
        });
        mnCadastro.add(mntmCliente);

        JMenuItem mntmHospedagem = new JMenuItem("Hospedagem");
        mntmHospedagem.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmHospedagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HospedagemGUI fh = new HospedagemGUI();
                fh.setLocationRelativeTo(null);
                fh.setVisible(true);
            }
        });
        mnCadastro.add(mntmHospedagem);

        JMenuItem mntmSair = new JMenuItem("Sair");
        mntmSair.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    null, "Deseja salvar a aplicação antes de sair?", 
                    "Confirmação de Saída", JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    salvarAplicacao();
                    System.exit(0);
                } else if (confirm == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        mnCadastro.add(mntmSair);

        JMenu mnAjuda = new JMenu("Ajuda");
        mnAjuda.setForeground(new Color(0, 128, 0));
        mnAjuda.setFont(new Font("Arial Black", Font.PLAIN, 12));
        menuBar.add(mnAjuda);

        JMenuItem mntmSobre = new JMenuItem("Sobre");
        mntmSobre.setFont(new Font("Arial", Font.PLAIN, 12));
        mntmSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sistema de Hospedagem v1.0\nDesenvolvido por: Aron");
            }
        });
        mnAjuda.add(mntmSobre);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 235, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        lblGerenciamento = new JLabel("Sistema de Hospedagem");
        lblGerenciamento.setFont(new Font("Arial Black", Font.PLAIN, 50));
        lblGerenciamento.setHorizontalAlignment(SwingConstants.CENTER);
        lblGerenciamento.setForeground(new Color(0, 128, 0));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(215)
        			.addComponent(lblGerenciamento)
        			.addContainerGap(796, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGap(173)
        			.addComponent(lblGerenciamento)
        			.addContainerGap(263, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                lblGerenciamento.setFont(new Font("Arial Black", Font.PLAIN, getWidth() / 20));
            }
        });
    }

    private void salvarAplicacao() {
        try (FileWriter writer = new FileWriter("aplicacao.txt")) {
            writer.write("Dados da aplicação salvos com sucesso.");
            JOptionPane.showMessageDialog(null, "Aplicação salva com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar a aplicação: " + e.getMessage());
        }
    }
}
