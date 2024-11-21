
package com.sementesdobrasil.view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaPrincipal() {
		setTitle("Tela Principal");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JLabel labelTitulo = new JLabel("Bem-vindo ao Sistema de Seguro de Vida");
		labelTitulo.setBounds(94, 45, 430, 30);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		labelTitulo.setForeground(new Color(50, 50, 50));
		getContentPane().add(labelTitulo);

		// Criar botões arredondados
		JButton btnLogin = criarBotaoArredondado("Login", 200, 120, new Color(0, 123, 255));
		JButton btnCadastro = criarBotaoArredondado("Cadastro", 200, 180, new Color(40, 167, 69));
		JButton btnSimulacao = criarBotaoArredondado("Simular Cotação", 200, 240, new Color(255, 193, 7));

		// Adicionar os botões à tela
		getContentPane().add(btnLogin);
		getContentPane().add(btnCadastro);
		getContentPane().add(btnSimulacao);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginBuilder login = new LoginBuilder();
				login.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		getContentPane().add(btnLogin);

		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroSeguradoView cadastroSegurado = new CadastroSeguradoView();
				cadastroSegurado.setVisible(true);
				setVisible(false);
			}
		});
		getContentPane().add(btnCadastro);

		btnSimulacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroCotacaoView cadastroCotacao = new CadastroCotacaoView();
				cadastroCotacao.setVisible(true);
				setVisible(false);
			}
		});
		getContentPane().add(btnSimulacao);

		// Exibir a tela
		setVisible(true);
	}

	private JButton criarBotaoArredondado(String texto, int x, int y, Color corFundo) {
		JButton botao = new JButton(texto) {
			/// /**

			//
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
		botao.setForeground(Color.WHITE);
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
		new TelaPrincipal();
	}
}
