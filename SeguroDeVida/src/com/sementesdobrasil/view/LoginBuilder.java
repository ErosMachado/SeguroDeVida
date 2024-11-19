package com.sementesdobrasil.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Label;

public class LoginBuilder {

    private JFrame frame;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginBuilder window = new LoginBuilder();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LoginBuilder() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Configuração do JFrame (janela principal)
        frame = new JFrame();
        frame.setBounds(100, 100, 513, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // E-mail
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(58, 37, 80, 14);
        frame.getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(58, 61, 392, 23);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);
        
        // Senha
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(58, 95, 80, 14);
        frame.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(58, 109, 392, 23);
        frame.getContentPane().add(passwordField);

        // Botão Entrar
        JButton loginButton = new JButton("Entrar");
        loginButton.setBounds(124, 166, 89, 23);
        frame.getContentPane().add(loginButton);

        // Botão Criar Cadastro
        JButton registerButton = new JButton("Criar Cadastro");
        registerButton.setBounds(241, 166, 141, 23);
        frame.getContentPane().add(registerButton);
        
        Label label = new Label("New label");
        label.setBounds(58, 138, 392, 22);
        frame.getContentPane().add(label);

        // Ação para o botão "Entrar"
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            // Simulação de validação de login
            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
            } else {
                JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!");
            }
        });

        // Ação para o botão "Criar Cadastro"
        registerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Tela de cadastro será aberta...");
            // Lógica de abertura de tela de cadastro
        });
    }
}
