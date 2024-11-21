package com.sementesdobrasil.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

    /**
     * Launch the application.
     */
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

    /**
     * Create the application.
     */
    public LoginBuilder() {
        initialize();
    }
    
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Cor de fundo
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        // Título da tela
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

        // Botão de login
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBounds(110, 270, 180, 40);
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        frame.getContentPane().add(loginButton);

        // Botão de cadastro
        JButton registerButton = new JButton("Criar Cadastro");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBounds(310, 270, 180, 40);
        registerButton.setBackground(new Color(40, 167, 69));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder());
        frame.getContentPane().add(registerButton);

        // Ações dos botões
        loginButton.addActionListener(e -> {
            String email = emailField.getText().toLowerCase();
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

    }


}