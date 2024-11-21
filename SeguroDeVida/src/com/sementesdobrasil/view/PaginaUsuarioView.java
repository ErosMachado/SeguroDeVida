package com.sementesdobrasil.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaUsuarioView extends JFrame {
	private static final long serialVersionUID = 1L;

	public PaginaUsuarioView(String nome, String dataNascimento, String genero, String email, String telefone,
			String cpf, String cep) {
		// Configurações da janela
		setTitle("Página do Usuário");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		// Painel para informações pessoais
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(7, 1, 10, 10)); // 7 linhas para exibir todas as informações
		infoPanel.setBorder(BorderFactory.createTitledBorder("Informações Pessoais"));

		infoPanel.add(new JLabel("Nome: " + nome));
		infoPanel.add(new JLabel("Data de Nascimento: " + dataNascimento));
		infoPanel.add(new JLabel("Gênero: " + genero));
		infoPanel.add(new JLabel("E-mail: " + email));
		infoPanel.add(new JLabel("Telefone: " + telefone));
		infoPanel.add(new JLabel("CPF: " + cpf));
		infoPanel.add(new JLabel("CEP: " + cep));

		// Painel para botões de ações
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));

		JButton realizarSeguroButton = new JButton("Realizar Seguro");
		JButton verificarSeguroButton = new JButton("Verificar Seguro");
		JButton adicionarDependenteButton = new JButton("Adicionar Dependentes");

		// Adicionando os botões ao painel
		buttonPanel.add(realizarSeguroButton);
		buttonPanel.add(verificarSeguroButton);
		buttonPanel.add(adicionarDependenteButton);

		// Adicionando painéis à tela principal
		getContentPane().add(infoPanel, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		// Ações dos botões
	
		realizarSeguroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PaginaUsuarioView.this, "Abrir tela para realizar seguro.");
			}
		});
		
		verificarSeguroButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PaginaUsuarioView.this, "Abrir tela para verificar seguro.");
			}
		});
		
		
		adicionarDependenteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PaginaUsuarioView.this, "Abrir tela para adicionar dependentes.");				
			}
		});
	}



	// Construtor sem parâmetros, se necessário
	public PaginaUsuarioView() {
		this("Nome", "Data", "Gênero", "Email", "Telefone", "CPF", "CEP");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			PaginaUsuarioView view = new PaginaUsuarioView("João da Silva", "01/01/2000", "Masculino", "joao@email.com",
					"(11) 98765-4321", "123.456.789-00", "12345-678");
			view.setVisible(true);
		});
	}
}
