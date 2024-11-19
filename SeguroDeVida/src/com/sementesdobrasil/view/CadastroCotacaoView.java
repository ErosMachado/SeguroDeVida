package com.sementesdobrasil.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;

public class CadastroCotacaoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNomeSistema;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCotacaoView frame = new CadastroCotacaoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCotacaoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNomeSistema = new JLabel("Cotação do Seguro de Vida");
		lblNomeSistema.setBounds(153, 9, 258, 24);
		lblNomeSistema.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNomeSistema);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome.setBounds(20, 47, 46, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(76, 44, 224, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 12));
		lblDataNascimento.setBounds(305, 47, 124, 14);
		contentPane.add(lblDataNascimento);
		
		JFormattedTextField formattedTextFieldDataNascimento = new JFormattedTextField();
		formattedTextFieldDataNascimento.setBounds(434, 44, 105, 20);
		contentPane.add(formattedTextFieldDataNascimento);
		
		JLabel lblProfissao = new JLabel("Profissão:");
		lblProfissao.setFont(new Font("Arial", Font.BOLD, 12));
		lblProfissao.setBounds(10, 88, 67, 14);
		contentPane.add(lblProfissao);
		
		JComboBox comboBoxProfissao = new JComboBox();
		comboBoxProfissao.setBounds(76, 84, 224, 22);
		contentPane.add(comboBoxProfissao);
		
		JLabel lblSalario = new JLabel("Salário:");
		lblSalario.setFont(new Font("Arial", Font.BOLD, 12));
		lblSalario.setBounds(305, 88, 46, 14);
		contentPane.add(lblSalario);
		
		JComboBox comboBoxSalario = new JComboBox();
		comboBoxSalario.setBounds(353, 84, 186, 22);
		contentPane.add(comboBoxSalario);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setFont(new Font("Arial", Font.BOLD, 12));
		lblGenero.setBounds(20, 127, 46, 14);
		contentPane.add(lblGenero);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(76, 123, 224, 22);
		contentPane.add(comboBoxGenero);
		
		JLabel lblSaude = new JLabel("Saúde:");
		lblSaude.setFont(new Font("Arial", Font.BOLD, 12));
		lblSaude.setBounds(305, 127, 46, 14);
		contentPane.add(lblSaude);
		
		JComboBox comboBoxSaude = new JComboBox();
		comboBoxSaude.setBounds(353, 123, 186, 22);
		contentPane.add(comboBoxSaude);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(20, 187, 105, 30);
		contentPane.add(btnVoltar);
		
		JButton btnCotar = new JButton("Cotar");
		btnCotar.setBounds(209, 187, 105, 30);
		contentPane.add(btnCotar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(392, 187, 105, 30);
		contentPane.add(btnLimpar);
	}
}
