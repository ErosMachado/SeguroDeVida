package com.sementesdobrasil.view;

import javax.swing.*;

import com.sementesdobrasil.controller.CadastroSeguradoController;
import com.sementesdobrasil.service.SeguradoService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
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

		// Bot�o de Login
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(200, 120, 200, 40);
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(0, 123, 255));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Abrindo tela de login...");
			}
		});
		getContentPane().add(btnLogin);

		// Bot�o de Cadastro
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(200, 180, 200, 40);
		btnCadastro.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCadastro.setBackground(new Color(40, 167, 69)); // Cor verde
		btnCadastro.setForeground(Color.WHITE); // Cor da fonte
		btnCadastro.setFocusPainted(false);
		btnCadastro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroSeguradoView view = new CadastroSeguradoView();
                SeguradoService service = new SeguradoService();
                new CadastroSeguradoController(view, service);
                view.setVisible(true);
                setVisible(false);
			}
		});
		getContentPane().add(btnCadastro);

		// Bot�o de Simula��o de Cota��o
		JButton btnSimulacao = new JButton("Simular Cotacao");
		btnSimulacao.setBounds(200, 240, 200, 40);
		btnSimulacao.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSimulacao.setBackground(new Color(255, 193, 7)); // Cor amarela
		btnSimulacao.setForeground(Color.WHITE); // Cor da fonte
		btnSimulacao.setFocusPainted(false);
		btnSimulacao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Remove as bordas padr�o
		btnSimulacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Redirecionar para a tela de simula��o (ainda vazia)
				System.out.println("Abrindo tela de simulacao...");
			}
		});
		getContentPane().add(btnSimulacao);

		// Exibir a tela
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
