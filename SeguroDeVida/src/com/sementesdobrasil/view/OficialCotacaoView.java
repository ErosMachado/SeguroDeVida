package com.sementesdobrasil.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OficialCotacaoView extends JFrame {

    private static final long serialVersionUID = 1L;

    public OficialCotacaoView(String tipoSeguro, double valorFinal, String capitaisSegurados) {
        // Configuração básica
        setTitle("Resultado da Cotação do Seguro de Vida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 255, 245)); // Fundo branco-esverdeado
        setContentPane(contentPane);

        // Cabeçalho
        JLabel titulo = new JLabel("Resultado da Cotação");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setBounds(200, 20, 400, 40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(new Color(34, 85, 34));
        contentPane.add(titulo);

        // Tipo de Seguro
        JLabel tipoSeguroLabel = new JLabel("Tipo de Seguro: " + tipoSeguro);
        tipoSeguroLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
        tipoSeguroLabel.setBounds(50, 80, 700, 30);
        tipoSeguroLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(tipoSeguroLabel);

        // Capitais Segurados
        JTextArea capitaisArea = new JTextArea(capitaisSegurados);
        capitaisArea.setFont(new Font("Roboto", Font.PLAIN, 16));
        capitaisArea.setEditable(false);
        capitaisArea.setBounds(50, 130, 700, 200);
        contentPane.add(capitaisArea);

        // Valor Final
        JLabel valorLabel = new JLabel(
                String.format("Valor Final: R$ %.2f (ou 12x de R$ %.2f)", valorFinal, valorFinal / 12));
        valorLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        valorLabel.setBounds(50, 350, 700, 30);
        valorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(valorLabel);

        // Botões
        JButton contratarButton = criarBotaoEstilizado("Contratar");
        contratarButton.setBounds(200, 450, 180, 50);
        contentPane.add(contratarButton);

        JButton personalizarButton = criarBotaoEstilizado("Personalizar");
        personalizarButton.setBounds(420, 450, 180, 50);
        contentPane.add(personalizarButton);

        // Ações dos botões
        contratarButton.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(OficialCotacaoView.this, 
                "Deseja Confirmar sua contratação?", "Confirmar Contratação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                LoginBuilder loginBuilder = new LoginBuilder(); // Página de login
                loginBuilder.getFrame().setVisible(true);
                setVisible(false);
            }
        });

        personalizarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(OficialCotacaoView.this, 
                "Abrindo página de personalização da cotação!", "Personalizar Cotação", JOptionPane.INFORMATION_MESSAGE);
            PersonalizaCotacaoView personalizar = new PersonalizaCotacaoView();
			personalizar.setVisible(true);
			setVisible(false);
        });
    }

    // Método para criar botões estilizados
    private JButton criarBotaoEstilizado(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Roboto", Font.BOLD, 16));
        botao.setBackground(new Color(34, 85, 34));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Animação ao passar o mouse
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setBackground(new Color(44, 105, 44)); // Tom mais claro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setBackground(new Color(34, 85, 34)); // Cor original
            }
        });

        return botao;
    }
}
