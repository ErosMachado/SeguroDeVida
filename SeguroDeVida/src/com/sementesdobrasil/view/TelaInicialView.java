package com.sementesdobrasil.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class TelaInicialView extends JFrame {

    private static final long serialVersionUID = 1L;

    public TelaInicialView() {
        setTitle("Tela Inicial - DevMarine");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null); // Layout absoluto
        contentPane.setBackground(new Color(255, 255, 255)); // Fundo branco
        setContentPane(contentPane);

        // Saudação e Slogan
        JLabel labelTitulo = new JLabel("Bem-Vindo(a) à DevMarine");
        labelTitulo.setBounds(50, 40, 500, 30);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        labelTitulo.setForeground(new Color(2, 109, 115)); // Texto verde esmaralda 
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labelTitulo);

        JLabel labelSlogan = new JLabel("A Transparência que você precisa, a Proteção que você merece!");
        labelSlogan.setBounds(10, 82, 566, 20);
        labelSlogan.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        labelSlogan.setForeground(new Color(123, 123, 0)); // Texto dourado
        labelSlogan.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labelSlogan);

        // Botões
        JButton btnUsuario = criarBotaoArredondado("Sou um Usuário", 200, 150, new Color(0, 183, 183)); // Azul
        JButton btnCorretor = criarBotaoArredondado("Sou um Corretor", 200, 220, new Color(0, 183, 183)); // Verde

        contentPane.add(btnUsuario);
        contentPane.add(btnCorretor);
        
        JLabel lblLogoDevMarine = new JLabel("");
        lblLogoDevMarine.setIcon(new ImageIcon("C:\\Users\\Cristine\\Desktop\\dev_cristine_novo\\Git\\SeguroDeVida\\SeguroDeVida\\src\\Imagens\\LogoDevMarine.png"));
        lblLogoDevMarine.setBounds(37, 0, 716, 477);
        contentPane.add(lblLogoDevMarine);

        // Ações dos botões
        btnUsuario.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            setVisible(false);
        });

        btnCorretor.addActionListener(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
            setVisible(false);
        });
    }

    private JButton criarBotaoArredondado(String texto, int x, int y, Color corFundo) {
        JButton botao = new JButton(texto) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Configurar cor de fundo e borda arredondada
                g2d.setColor(corFundo);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g);
            }

            @Override
            public void setBorder(Border border) {
                // Evita que o botão adicione bordas extras
            }
        };

        botao.setBounds(x, y, 200, 40);
        botao.setFont(new Font("Arial", Font.PLAIN, 16));
        botao.setForeground(Color.WHITE); // Texto branco
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Adicionando MouseListener para hover
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setBounds(x - 10, y - 5, 220, 50); // Aumenta o tamanho
                botao.setFont(new Font("Arial", Font.BOLD, 18)); // Aumenta a fonte
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setBounds(x, y, 200, 40); // Volta ao tamanho original
                botao.setFont(new Font("Arial", Font.PLAIN, 16)); // Volta à fonte original
            }
        });

        return botao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicialView telaInicial = new TelaInicialView();
            telaInicial.setVisible(true);
        });
    }
}