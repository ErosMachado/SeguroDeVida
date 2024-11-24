package com.sementesdobrasil.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sementesdobrasil.controller.CadastroSeguradoController;
import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.service.SeguradoService;


public class LoginBuilder {

    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginBuilder window = new LoginBuilder();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginBuilder() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Cor de fundo
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        // Título
        JLabel titleLabel = new JLabel("Bem-vindo!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(60, 60, 60));
        titleLabel.setBounds(200, 30, 200, 40);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(titleLabel);

        // Subtítulo
        JLabel subtitleLabel = new JLabel("Faça login para continuar");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(100, 100, 100));
        subtitleLabel.setBounds(180, 70, 240, 25);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(subtitleLabel);

        // Campo de e-mail
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailLabel.setBounds(110, 120, 380, 20);
        emailLabel.setForeground(new Color(60, 60, 60));
        frame.getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBounds(110, 140, 380, 30);
        emailField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        frame.getContentPane().add(emailField);

        // Campo de senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setBounds(110, 190, 380, 20);
        passwordLabel.setForeground(new Color(60, 60, 60));
        frame.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(110, 210, 380, 30);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        frame.getContentPane().add(passwordField);

        // Botões arredondados
        JButton loginButton = criarBotaoComHover("Entrar", new Color(0, 123, 255), Color.WHITE);
        loginButton.setBounds(110, 270, 180, 40);

        JButton registerButton = criarBotaoComHover("Criar Cadastro", new Color(40, 167, 69), Color.WHITE);
        registerButton.setBounds(310, 270, 180, 40);

        // Adicionar ações aos botões
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] passwordChars = passwordField.getPassword();
            String senha = new String(passwordChars);

            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
            } else {
                SeguradoDAO seguradoDAO = new SeguradoDAO();
                Segurado segurado = null;

                try {
                    segurado = seguradoDAO.getSeguradoByEmailSenha(email, senha);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                if (segurado != null) {
                    JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
                    PaginaUsuarioView perfil = new PaginaUsuarioView(segurado);  // Passando o objeto segurado
                    perfil.setVisible(true);
                    frame.dispose();  // Fecha a tela de login
                } else {
                    JOptionPane.showMessageDialog(frame, "E-mail ou senha inválidos.");
                }
            }
        });

        registerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Tela de cadastro vai ser aberta...");
            CadastroSeguradoView view = new CadastroSeguradoView();
            SeguradoService service = new SeguradoService();
            new CadastroSeguradoController(view, service);
            view.setVisible(true);
            frame.dispose();
        });

        // Adicionar os botões à tela
        frame.getContentPane().add(loginButton);
        frame.getContentPane().add(registerButton);
    }

    private JButton criarBotaoComHover(String texto, Color corFundo, Color corTexto) {
        JButton botao = new JButton(texto) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Cor de fundo
                g2d.setColor(corFundo);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // Cor da borda
                g2d.setColor(corTexto);
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

                super.paintComponent(g);
            }
        };

        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setForeground(corTexto);
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setBorder(BorderFactory.createEmptyBorder());

        // Adicionar MouseListener para o efeito de crescimento
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Aumenta o tamanho do botão quando o mouse passa sobre ele
                botao.setBounds(botao.getX() - 5, botao.getY() - 5, botao.getWidth() + 10, botao.getHeight() + 10);
                botao.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaura o tamanho original do botão quando o mouse sai
                botao.setBounds(botao.getX() + 5, botao.getY() + 5, botao.getWidth() - 10, botao.getHeight() - 10);
                botao.repaint();
            }
        });

        return botao;
    }
}