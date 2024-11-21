package com.sementesdobrasil.view;

import javax.swing.*;

import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Segurado;

import java.awt.event.*;
import java.sql.SQLException;

public class CadastroSeguradoView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JTextField dataNascimentoField;
	private JComboBox<String> generoBox;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField cpfField;
	private JTextField cepField;
	private JPasswordField senhaField;
	private JPasswordField confirmarSenhaField;
	private JButton limparButton, sairButton;
	private JLabel label_9;
	private JComboBox<String> estadoCivilBox;
	private JButton salvarButton;

	public CadastroSeguradoView() {
		setTitle("Cadastro de Segurado");
		setSize(726, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Inicializando os campos
		nomeField = new JTextField();
		nomeField.setBounds(360, 5, 350, 41);
		dataNascimentoField = new JTextField();
		dataNascimentoField.setBounds(360, 56, 350, 41);
		generoBox = new JComboBox<>(new String[] { "", "Masculino", "Feminino", "Prefiro não informar", "Outro" });
		generoBox.setBounds(360, 108, 350, 41);
		emailField = new JTextField();
		emailField.setBounds(360, 208, 350, 41);
		telefoneField = new JTextField();
		telefoneField.setBounds(360, 259, 350, 41);
		cpfField = new JTextField();
		cpfField.setBounds(360, 310, 350, 41);
		cepField = new JTextField();
		cepField.setBounds(360, 361, 350, 41);
		senhaField = new JPasswordField();
		senhaField.setBounds(360, 412, 350, 41);
		confirmarSenhaField = new JPasswordField();
		confirmarSenhaField.setBounds(360, 463, 350, 41);
		limparButton = new JButton("Limpar");
		limparButton.setBounds(0, 1, 150, 45);
		sairButton = new JButton("Sair");
		sairButton.setBounds(180, 0, 150, 45);
		getContentPane().setLayout(null);

		// Adicionando os labels e campos no layout
		JLabel label = new JLabel("Nome:");
		label.setBounds(0, 5, 350, 41);
		getContentPane().add(label);
		getContentPane().add(nomeField);
		JLabel label_1 = new JLabel("Data de Nascimento (dd/mm/yyyy):");
		label_1.setBounds(0, 56, 350, 41);
		getContentPane().add(label_1);
		getContentPane().add(dataNascimentoField);
		JLabel label_2 = new JLabel("Gênero:");
		label_2.setBounds(0, 107, 350, 41);
		getContentPane().add(label_2);
		getContentPane().add(generoBox);
		JLabel label_3 = new JLabel("E-mail:");
		label_3.setBounds(0, 208, 350, 41);
		getContentPane().add(label_3);
		getContentPane().add(emailField);
		JLabel label_4 = new JLabel("Telefone:");
		label_4.setBounds(0, 259, 350, 41);
		getContentPane().add(label_4);
		getContentPane().add(telefoneField);
		JLabel label_5 = new JLabel("CPF:");
		label_5.setBounds(0, 310, 350, 41);
		getContentPane().add(label_5);
		getContentPane().add(cpfField);
		JLabel label_6 = new JLabel("CEP:");
		label_6.setBounds(0, 361, 350, 41);
		getContentPane().add(label_6);
		getContentPane().add(cepField);
		JLabel label_7 = new JLabel("Senha:");
		label_7.setBounds(0, 412, 350, 41);
		getContentPane().add(label_7);
		getContentPane().add(senhaField);
		JLabel label_8 = new JLabel("Confirmar Senha:");
		label_8.setBounds(0, 463, 350, 41);
		getContentPane().add(label_8);
		getContentPane().add(confirmarSenhaField);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(184, 515, 350, 66);
		buttonPanel.setLayout(null);
		buttonPanel.add(limparButton);
		buttonPanel.add(sairButton);
		getContentPane().add(buttonPanel);

		label_9 = new JLabel("Estado Civil:");
		label_9.setBounds(0, 156, 350, 41);
		getContentPane().add(label_9);

		estadoCivilBox = new JComboBox<>(new String[] { "", "Solteiro", "Casado", "Viuvo", "Outro" });
		estadoCivilBox.setBounds(360, 156, 350, 41);
		getContentPane().add(estadoCivilBox);

		JButton voltarBtn = new JButton("Inicio");
		voltarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaPrincipal main = new TelaPrincipal();
				main.setVisible(true);
				setVisible(false);
			}

		});
		voltarBtn.setBounds(10, 515, 150, 45);
		getContentPane().add(voltarBtn);

		// Definindo o botão de salvar
		salvarButton = new JButton("Salvar");

		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeField.getText();
				String dataNascimento = dataNascimentoField.getText();
				String genero = generoBox.getSelectedItem().toString();
				String email = emailField.getText();
				String telefone = telefoneField.getText();
				String cpf = cpfField.getText();
				String cep = cepField.getText();
				String senha = new String(senhaField.getPassword());
				String estadoCivil = estadoCivilBox.getSelectedItem().toString();

				Segurado segurado = new Segurado(nome, dataNascimento, genero, email, telefone, cpf, cep, senha,
						estadoCivil);

				SeguradoDAO seguradoDAO = new SeguradoDAO();

				try {
					seguradoDAO.save(segurado);
					JOptionPane.showMessageDialog(null, "Segurado salvo com sucesso!");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar segurado: " + ex.getMessage());
				}
			}
		});

		salvarButton.setBounds(550, 515, 150, 45);
		getContentPane().add(salvarButton);

		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(CadastroSeguradoView.this,
						"Tem certeza que deseja limpar?", "Limpar Dados", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					nomeField.setText("");
					dataNascimentoField.setText("");
					generoBox.setSelectedIndex(0);
					emailField.setText("");
					telefoneField.setText("");
					cpfField.setText("");
					cepField.setText("");
					senhaField.setText("");
					confirmarSenhaField.setText("");
					estadoCivilBox.setSelectedIndex(0);
				}
			}
		});

		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(CadastroSeguradoView.this, "Tem certeza que deseja sair?",
						"Sair", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	public String getNome() {
		return nomeField.getText();
	}

	public String getDataNascimento() {
		return dataNascimentoField.getText();
	}

	public String getGenero() {
		return (String) generoBox.getSelectedItem();
	}

	public String getEmail() {
		return emailField.getText();
	}

	public String getTelefone() {
		return telefoneField.getText();
	}

	public String getCpf() {
		return cpfField.getText();
	}

	public String getCep() {
		return cepField.getText();
	}

	public String getSenha() {
		return new String(senhaField.getPassword());
	}

	public String getConfirmarSenha() {
		return new String(confirmarSenhaField.getPassword());
	}

	public String getEstadoCivil() {
		return (String) estadoCivilBox.getSelectedItem();
	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void addSalvarListener(ActionListener listener) {
		salvarButton.addActionListener(listener);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CadastroSeguradoView().setVisible(true);
			}
		});
	}
}