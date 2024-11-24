package com.sementesdobrasil.view;

import javax.swing.*;

import java.awt.*;

public class CotacaoView extends JFrame {

	private static final long serialVersionUID = 1L;

	public CotacaoView(String tipoSeguro, double valorFinal, String capitaisSegurados) {
		// Configuração básica
		setTitle("Resultado da Cotação");
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
		JButton contratarButton = new JButton("Contratar");
		contratarButton.setBounds(300, 450, 200, 40);
		contentPane.add(contratarButton);

		contratarButton.addActionListener(e -> {
			int resposta = JOptionPane.showConfirmDialog(CotacaoView.this, "Deseja realizar o seu cadastro?",
					"Não", JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.YES_OPTION) {
			
			LoginBuilder loginBuilder = new LoginBuilder(); // Página de login
			loginBuilder.getFrame().setVisible(true);
			setVisible(false);
			}
		});
	}
}