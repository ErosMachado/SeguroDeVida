package com.sementesdobrasil.view;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;


public class CadastroSeguradoView extends JFrame {
	private JTextField nomeField;
	private JTextField dataNascimentoField;
	private JComboBox<String> generoBox;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField cpfField;
	private JTextField cepField;
	private JButton salvarButton;

	public CadastroSeguradoView() {
		setTitle("Cadastro de Segurado");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(8, 2));
		// Inicialização dos componentes
		nomeField = new JTextField();
		dataNascimentoField = new JTextField();
		generoBox = new JComboBox<>(new String[] { "Masculino", "Feminino", "Outro" });
		emailField = new JTextField();
		telefoneField = new JTextField();
		cpfField = new JTextField();
		cepField = new JTextField();
		salvarButton = new JButton("Salvar");
		// Adicionando componentes à tela
		add(new JLabel("Nome:"));
		add(nomeField);
		add(new JLabel("Data de Nascimento (dd/mm/yyyy):"));
		add(dataNascimentoField);
		add(new JLabel("Gênero:"));
		add(generoBox);
		add(new JLabel("E-mail:"));
		add(emailField);
		add(new JLabel("Telefone:"));
		add(telefoneField);
		add(new JLabel("CPF:"));
		add(cpfField);
		add(new JLabel("CEP:"));
		add(cepField);
		add(new JLabel(""));
		add(salvarButton);
		// Adicionando ActionListener para o botão salvar
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica para salvar segurado
				// Validação e chamada ao Controller
			}
		});
	}

	// Métodos para acessar os campos
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

	// Método para adicionar ActionListener no botão salvar
	public void addSalvarListener(ActionListener listener) {
		salvarButton.addActionListener(listener);
	}
	
	//getters and setters

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getDataNascimentoField() {
		return dataNascimentoField;
	}

	public void setDataNascimentoField(JTextField dataNascimentoField) {
		this.dataNascimentoField = dataNascimentoField;
	}

	public JComboBox<String> getGeneroBox() {
		return generoBox;
	}

	public void setGeneroBox(JComboBox<String> generoBox) {
		this.generoBox = generoBox;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getTelefoneField() {
		return telefoneField;
	}

	public void setTelefoneField(JTextField telefoneField) {
		this.telefoneField = telefoneField;
	}

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTextField getCepField() {
		return cepField;
	}

	public void setCepField(JTextField cepField) {
		this.cepField = cepField;
	}

	public JButton getSalvarButton() {
		return salvarButton;
	}

	public void setSalvarButton(JButton salvarButton) {
		this.salvarButton = salvarButton;
	}
}
