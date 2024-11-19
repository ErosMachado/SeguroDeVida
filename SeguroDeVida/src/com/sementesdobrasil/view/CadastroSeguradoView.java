package com.sementesdobrasil.view;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class CadastroSeguradoView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JTextField dataNascimentoField;
	private JComboBox<String> generoBox, estadoCivilBox;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField cpfField;
	private JTextField cepField, senhaField, confirmarSenhaField;
	private JButton salvarButton;

	public CadastroSeguradoView() {
		setTitle("Cadastro de Segurado");
		setSize(773, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(8, 2));

		nomeField = new JTextField();
		dataNascimentoField = new JTextField();
		generoBox = new JComboBox<>(new String[] { "", "Masculino", "Feminino", "Prefiro não informar", "Outro" });
		generoBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Masculino", "Feminino", "Prefiro não informar", "Outro" }));
		estadoCivilBox = new JComboBox<>(
				new String[] { "", "Solteiro(a)", "Casado(a)", "Divorciado(a)", "viuvo(a)", "Outro" });
		estadoCivilBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Solteiro(a)", "Casado(a)", "Divorciado(a)", "viuvo(a)", "Outro" }));
		emailField = new JTextField();
		telefoneField = new JTextField();
		cpfField = new JTextField();
		cepField = new JTextField();
		senhaField = new JTextField();
		confirmarSenhaField = new JTextField();
		salvarButton = new JButton("Salvar");
		
		
		getContentPane().add(new JLabel("Nome:"));
		getContentPane().add(nomeField);
		getContentPane().add(new JLabel("Data de Nascimento (dd/mm/yyyy):"));
		getContentPane().add(dataNascimentoField);
		getContentPane().add(new JLabel("Gênero:"));
		getContentPane().add(generoBox);
		getContentPane().add(new JLabel("Estado Civíl:"));
		getContentPane().add(estadoCivilBox);
		getContentPane().add(new JLabel("E-mail:"));
		getContentPane().add(emailField);
		getContentPane().add(new JLabel("Telefone:"));
		getContentPane().add(telefoneField);
		getContentPane().add(new JLabel("CPF:"));
		getContentPane().add(cpfField);
		getContentPane().add(new JLabel("CEP:"));
		getContentPane().add(cepField);
		getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("Senha:"));
		getContentPane().add(senhaField);
		getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("Confirmar Senha:"));
		getContentPane().add(confirmarSenhaField);
		getContentPane().add(new JLabel(""));
		getContentPane().add(salvarButton);

		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public JComboBox<String> getEstadoCivilBox() {
		return estadoCivilBox;
	}

	public void setEstadoCivilBox(JComboBox<String> estadoCivilBox) {
		this.estadoCivilBox = estadoCivilBox;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public void setSenhaField(JTextField senhaField) {
		this.senhaField = senhaField;
	}

	public JTextField getConfirmarSenhaField() {
		return confirmarSenhaField;
	}

	public void setConfirmarSenhaField(JTextField confirmarSenhaField) {
		this.confirmarSenhaField = confirmarSenhaField;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Metodos para acessar os campos
	public String getNome() {
		return nomeField.getText();
	}

	public String getDataNascimento() {
		return dataNascimentoField.getText();
	}

	public String getGenero() {
		return (String) generoBox.getSelectedItem();
	}
	
	public String getEstadoCivil() {
		return (String) estadoCivilBox.getSelectedItem();
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
		return senhaField.getText();
	}
	public String getConfirmarSenha() {
		return confirmarSenhaField.getText();
	}

	// Metodo para adicionar ActionListener no botao salvar
	public void addSalvarListener(ActionListener listener) {
		salvarButton.addActionListener(listener);
	}

	// getters and setters

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