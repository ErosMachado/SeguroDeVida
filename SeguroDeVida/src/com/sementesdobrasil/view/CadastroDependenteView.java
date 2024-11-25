package com.sementesdobrasil.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroDependenteView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField nomeField;
	private JTextField relacionamentoField;
	private JTextField idadeField;
	private JComboBox<String> generoBox;
	private JTextField emailField;
	private JTextField cpfField;
	private JTextField telefoneField;
	private JComboBox<String> estadoCivilBox;
	private JCheckBox dependenciaFinanceiraCheckBox;
	private JTextArea observacoesArea;

	public CadastroDependenteView() {
		setTitle("Cadastro de Dependente");
		setSize(750, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		// Campos e Labels
		addLabelAndField("Nome:", 42, 10, nomeField = new JTextField());
		addLabelAndField("Relacionamento:", 42, 70, relacionamentoField = new JTextField());
		addLabelAndField("Idade:", 42, 130, idadeField = new JTextField());
		generoBox = addComboBox("Gênero:", 42, 190,
				new String[] { "", "Masculino", "Feminino", "Outro", "Prefiro não informar" });
		addLabelAndField("Email:", 42, 250, emailField = new JTextField());
		addLabelAndField("CPF:", 42, 310, cpfField = new JTextField());
		addLabelAndField("Telefone:", 42, 370, telefoneField = new JTextField());
		estadoCivilBox = addComboBox("Estado Civil:", 42, 430,
				new String[] { "", "Solteiro", "Casado", "Divorciado", "Viuvo", "Outro" });

		// Checkbox e TextArea
		dependenciaFinanceiraCheckBox = new JCheckBox("Dependência Financeira");
		dependenciaFinanceiraCheckBox.setBounds(42, 469, 300, 30);
		dependenciaFinanceiraCheckBox.setBackground(Color.WHITE);
		dependenciaFinanceiraCheckBox.setFont(new Font("Arial", Font.BOLD, 14));
		dependenciaFinanceiraCheckBox.setForeground(new Color(0, 108, 108));
		getContentPane().add(dependenciaFinanceiraCheckBox);

		JLabel observacoesLabel = new JLabel("Observações:");
		observacoesLabel.setBounds(42, 506, 150, 30);
		observacoesLabel.setFont(new Font("Arial", Font.BOLD, 16));
		observacoesLabel.setForeground(new Color(0, 108, 108));
		getContentPane().add(observacoesLabel);

		observacoesArea = new JTextArea();
		observacoesArea.setBounds(42, 546, 650, 60);
		observacoesArea.setBorder(UIManager.getBorder("TextField.border"));
		getContentPane().add(observacoesArea);

		// Botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(42, 611, 650, 50);
		buttonPanel.setBackground(Color.WHITE);
		getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);

		JButton limparButton = new JButton("Limpar");
		limparButton.setBounds(0, 0, 203, 50);
		configurarBotao(limparButton, e -> limparCampos());
		buttonPanel.add(limparButton);

		JButton salvarButton = new JButton("Salvar");
		salvarButton.setBounds(223, 0, 203, 50);
		configurarBotao(salvarButton, e -> salvarDependente());
		buttonPanel.add(salvarButton);

		JButton sairButton = new JButton("Início");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginBuilder login = new LoginBuilder();
				login.getFrame().setVisible(true);
				setVisible(false);
			}
		});
		sairButton.setBounds(446, 0, 203, 50);
		buttonPanel.add(sairButton);
		
		JButton btnInvisivel = new JButton("");
		btnInvisivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeField.setText("Marcos Aurélios");
		        idadeField.setText("15");
		        generoBox.setSelectedIndex(1);
		        emailField.setText("marcos@gmail.com");
		        telefoneField.setText("(11) 98765-4221");
		        cpfField.setText("123.456.488-50");
		        relacionamentoField.setText("Filho");
		        estadoCivilBox.setSelectedIndex(1);
				observacoesArea.setText("Nenhuma Oberservação a ser inclusa");
			}
		});
		btnInvisivel.setBackground(new Color(255, 255, 255));
		btnInvisivel.setBounds(213, 22, 9, 10);
		buttonPanel.add(btnInvisivel);
	}

	private void addLabelAndField(String label, int x, int y, JTextField field) {
		JLabel fieldLabel = new JLabel(label);
		fieldLabel.setBounds(x, y, 150, 30);
		fieldLabel.setFont(new Font("Arial", Font.BOLD, 16));
		fieldLabel.setForeground(new Color(0, 108, 108));
		getContentPane().add(fieldLabel);

		field.setBounds(x + 160, y, 300, 30);
		getContentPane().add(field);
	}

	private JComboBox<String> addComboBox(String label, int x, int y, String[] options) {
		JLabel comboLabel = new JLabel(label);
		comboLabel.setBounds(x, y, 150, 30);
		comboLabel.setFont(new Font("Arial", Font.BOLD, 16));
		comboLabel.setForeground(new Color(0, 108, 108));
		getContentPane().add(comboLabel);

		JComboBox<String> comboBox = new JComboBox<>(options);
		comboBox.setBounds(x + 160, y, 300, 30);
		getContentPane().add(comboBox);

		return comboBox;
	}

	private void configurarBotao(JButton botao, ActionListener acao) {
		botao.setForeground(Color.WHITE);
		botao.setBackground(new Color(0, 183, 183));
		botao.setFont(new Font("Arial", Font.BOLD, 14));
		botao.addActionListener(acao);
	}

	private void limparCampos() {
		nomeField.setText("");
		relacionamentoField.setText("");
		idadeField.setText("");
		generoBox.setSelectedIndex(0);
		emailField.setText("");
		cpfField.setText("");
		telefoneField.setText("");
		estadoCivilBox.setSelectedIndex(0);
		dependenciaFinanceiraCheckBox.setSelected(false);
		observacoesArea.setText("");
	}

	@SuppressWarnings("unused")
	private void salvarDependente() {
		String nome = nomeField.getText();
		String relacionamento = relacionamentoField.getText();
		int idade = Integer.parseInt(idadeField.getText());
		String genero = (String) generoBox.getSelectedItem();
		String email = emailField.getText();
		String cpf = cpfField.getText();
		String telefone = telefoneField.getText();
		String estadoCivil = (String) estadoCivilBox.getSelectedItem();
		boolean dependenciaFinanceira = dependenciaFinanceiraCheckBox.isSelected();
		String observacoes = observacoesArea.getText();

		// Lógica para salvar os dados (integrar com DAO ou exibir mensagem)
		JOptionPane.showMessageDialog(this, "Dependente salvo com sucesso!");
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getRelacionamentoField() {
		return relacionamentoField;
	}

	public void setRelacionamentoField(JTextField relacionamentoField) {
		this.relacionamentoField = relacionamentoField;
	}

	public JTextField getIdadeField() {
		return idadeField;
	}

	public void setIdadeField(JTextField idadeField) {
		this.idadeField = idadeField;
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

	public JTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JTextField getTelefoneField() {
		return telefoneField;
	}

	public void setTelefoneField(JTextField telefoneField) {
		this.telefoneField = telefoneField;
	}

	public JComboBox<String> getEstadoCivilBox() {
		return estadoCivilBox;
	}

	public void setEstadoCivilBox(JComboBox<String> estadoCivilBox) {
		this.estadoCivilBox = estadoCivilBox;
	}

	public JCheckBox getDependenciaFinanceiraCheckBox() {
		return dependenciaFinanceiraCheckBox;
	}

	public void setDependenciaFinanceiraCheckBox(JCheckBox dependenciaFinanceiraCheckBox) {
		this.dependenciaFinanceiraCheckBox = dependenciaFinanceiraCheckBox;
	}

	public JTextArea getObservacoesArea() {
		return observacoesArea;
	}

	public void setObservacoesArea(JTextArea observacoesArea) {
		this.observacoesArea = observacoesArea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new CadastroDependenteView().setVisible(true));
	}
}
