package com.sementesdobrasil.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class CadastroCotacaoView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNomeSistema;
    private JTextField textFieldNome;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastroCotacaoView frame = new CadastroCotacaoView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastroCotacaoView() {
        // Define as cores da paleta
        Color backgroundColor = new Color(245, 245, 245); // Cor de fundo (suave)
        Color primaryColor = new Color(34, 123, 180);     // Cor principal (azul)
        Color secondaryColor = new Color(90, 180, 90);    // Cor secundária (verde)
        Color textColor = new Color(33, 33, 33);          // Cor do texto
        Color buttonTextColor = Color.WHITE;              // Texto dos botões

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 565, 356);

        // Painel principal com imagem de fundo
        contentPane = new ImagePanel("SeguroDeVida/src/Imagens/LogoTokio.png"); // Caminho da imagem
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 255, 255)); // Fundo do painel (se necessário)
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título do sistema
        lblNomeSistema = new JLabel("Cotação do Seguro de Vida");
        lblNomeSistema.setBounds(100, 9, 365, 24);
        lblNomeSistema.setFont(new Font("Arial", Font.BOLD, 20));
        lblNomeSistema.setForeground(new Color(0, 100, 0)); // Cor do texto principal
        contentPane.add(lblNomeSistema);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 47, 46, 14);
        lblNome.setFont(new Font("Arial", Font.BOLD, 12));
        lblNome.setForeground(textColor); // Cor do texto
        contentPane.add(lblNome);

        textFieldNome = new JTextField();
        textFieldNome.setBackground(new Color(245, 245, 245));
        textFieldNome.setBounds(76, 44, 224, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        // Data de Nascimento
        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        lblDataNascimento.setBounds(305, 47, 124, 14);
        lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 12));
        lblDataNascimento.setForeground(textColor);
        contentPane.add(lblDataNascimento);

        JFormattedTextField formattedTextFieldDataNascimento = new JFormattedTextField();
        formattedTextFieldDataNascimento.setBackground(new Color(247, 247, 247));
        formattedTextFieldDataNascimento.setBounds(434, 44, 105, 20);
        contentPane.add(formattedTextFieldDataNascimento);

        // Profissão
        JLabel lblProfissao = new JLabel("Profissão:");
        lblProfissao.setBounds(10, 88, 67, 14);
        lblProfissao.setFont(new Font("Arial", Font.BOLD, 12));
        lblProfissao.setForeground(textColor);
        contentPane.add(lblProfissao);

        JComboBox<String> comboBoxProfissao = new JComboBox<>();
        comboBoxProfissao.setBounds(76, 84, 224, 22);
        contentPane.add(comboBoxProfissao);

        // Salário
        JLabel lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(305, 88, 46, 14);
        lblSalario.setFont(new Font("Arial", Font.BOLD, 12));
        lblSalario.setForeground(textColor);
        contentPane.add(lblSalario);

        JComboBox<String> comboBoxSalario = new JComboBox<>();
        comboBoxSalario.setBounds(353, 84, 186, 22);
        contentPane.add(comboBoxSalario);

        // Gênero
        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setBounds(20, 127, 46, 14);
        lblGenero.setFont(new Font("Arial", Font.BOLD, 12));
        lblGenero.setForeground(textColor);
        contentPane.add(lblGenero);

        JComboBox<String> comboBoxGenero = new JComboBox<>();
        comboBoxGenero.setBounds(76, 123, 224, 22);
        contentPane.add(comboBoxGenero);

        // Saúde
        JLabel lblSaude = new JLabel("Saúde:");
        lblSaude.setBounds(305, 127, 46, 14);
        lblSaude.setFont(new Font("Arial", Font.BOLD, 12));
        lblSaude.setForeground(textColor);
        contentPane.add(lblSaude);

        JComboBox<String> comboBoxSaude = new JComboBox<>();
        comboBoxSaude.setBounds(353, 123, 186, 22);
        contentPane.add(comboBoxSaude);

        // Botões
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(20, 187, 105, 30);
        btnVoltar.setBackground(primaryColor); // Fundo azul
        btnVoltar.setForeground(new Color(103, 103, 103)); // Texto branco
        contentPane.add(btnVoltar);

        JButton btnCotar = new JButton("Cotar");
        btnCotar.setBounds(209, 187, 105, 30);
        btnCotar.setBackground(secondaryColor); // Fundo verde
        btnCotar.setForeground(new Color(103, 103, 103));
        contentPane.add(btnCotar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(392, 187, 105, 30);
        btnLimpar.setBackground(primaryColor);
        btnLimpar.setForeground(new Color(103, 103, 103));
        contentPane.add(btnLimpar);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\dev_cristine\\Git\\SeguroDeVida\\SeguroDeVida\\src\\Imagens\\FundoTokio.png"));
        lblNewLabel.setBounds(20, 64, 497, 396);
        contentPane.add(lblNewLabel);
    }
}
