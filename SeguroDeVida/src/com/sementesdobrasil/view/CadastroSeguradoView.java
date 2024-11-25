package com.sementesdobrasil.view;

import javax.swing.*;
import javax.swing.border.Border;

import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Segurado;

import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CadastroSeguradoView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField;
	private JTextField idadeField;
	private JComboBox<String> generoBox;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField cpfField;
	private JTextField cepField;
	private JPasswordField senhaField;
	private JPasswordField confirmarSenhaField;
	private JButton limparButton, sairButton;
	private JComboBox<String> estadoCivilBox;
	private JButton salvarButton;
	public CadastroSeguradoView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Cadastro de Segurado");
		setSize(726, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Inicializando os campos
		nomeField = new JTextField();
		nomeField.setBounds(290, 5, 350, 41);
		idadeField = new JTextField();
		idadeField.setBounds(290, 56, 350, 41);
		generoBox = new JComboBox<>(new String[] { "", "Masculino", "Feminino", "Prefiro não informar", "Outro" });
		generoBox.setBounds(290, 108, 350, 41);
		emailField = new JTextField();
		emailField.setBounds(290, 208, 350, 41);
		telefoneField = new JTextField();
		telefoneField.setBounds(290, 259, 350, 41);
		cpfField = new JTextField();
		cpfField.setBounds(290, 310, 350, 41);
		cepField = new JTextField();
		cepField.setBounds(290, 361, 350, 41);
		senhaField = new JPasswordField();
		senhaField.setBounds(290, 412, 350, 41);
		confirmarSenhaField = new JPasswordField();
		confirmarSenhaField.setBounds(290, 463, 350, 41);
		limparButton = new JButton("Limpar");
		limparButton.setForeground(new Color(255, 255, 255));
		limparButton.setBackground(new Color(0, 183, 183));
		limparButton.setBounds(0, 0, 150, 45);
		
		sairButton = new JButton("Sair");
		sairButton.setForeground(new Color(255, 255, 255));
		sairButton.setBackground(new Color(0, 183, 183));
		sairButton.setBounds(190, 0, 150, 45);
		getContentPane().setLayout(null);
		getContentPane().add(nomeField);
		getContentPane().add(idadeField);
		getContentPane().add(generoBox);
		getContentPane().add(emailField);
		getContentPane().add(telefoneField);
		getContentPane().add(cpfField);
		getContentPane().add(cepField);
		getContentPane().add(senhaField);
		getContentPane().add(confirmarSenhaField);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 255, 255));
		buttonPanel.setBounds(184, 515, 350, 66);
		buttonPanel.setLayout(null);
		buttonPanel.add(limparButton);
		buttonPanel.add(sairButton);
		getContentPane().add(buttonPanel);
		
		JButton btnEscondido = new JButton(".");
		btnEscondido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeField.setText("João da Silva");
		        idadeField.setText("28");
		        generoBox.setSelectedIndex(1);
		        emailField.setText("joao@gmail.com");
		        telefoneField.setText("(11) 98765-4321");
		        cpfField.setText("123.456.488-10");
		        cepField.setText("12345-678");
		        senhaField.setText("Senha123");
		        confirmarSenhaField.setText("Senha123");
		        estadoCivilBox.setSelectedIndex(2);
		        
			}
		});
		btnEscondido.setBounds(168, 38, 12, 17);
		buttonPanel.add(btnEscondido);

		estadoCivilBox = new JComboBox<>(new String[] { "", "Solteiro", "Casado", "Viuvo", "Divorciado", "Outro" });
		estadoCivilBox.setBounds(290, 156, 350, 41);
		getContentPane().add(estadoCivilBox);

		JButton voltarBtn = new JButton("Inicio");
		voltarBtn.setForeground(new Color(255, 255, 255));
		voltarBtn.setBackground(new Color(0, 183, 183));
		voltarBtn.addActionListener(new ActionListener() {
			@Override
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
		salvarButton.setForeground(new Color(255, 255, 255));
		salvarButton.setBackground(new Color(0, 183, 183));

		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = nomeField.getText();
				int idade = Integer.parseInt(idadeField.getText()); 
				String genero = generoBox.getSelectedItem().toString();
				String email = emailField.getText();
				String telefone = telefoneField.getText();
				String cpf = cpfField.getText();
				String cep = cepField.getText();
				String senha = new String(senhaField.getPassword());
				String estadoCivil = estadoCivilBox.getSelectedItem().toString();

				Segurado segurado = new Segurado(nome, idade, genero, email, telefone, cpf, cep, senha,
						estadoCivil);

				SeguradoDAO seguradoDAO = new SeguradoDAO();

				try {
					seguradoDAO.save(segurado);
					JOptionPane.showMessageDialog(null, "Segurado salvo com sucesso!");
					LoginBuilder login = new LoginBuilder();
					login.getFrame().setVisible(true);
					setVisible(false);
					
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar segurado: " + ex.getMessage());
				}
			}
		});

		salvarButton.setBounds(550, 515, 150, 45);
		getContentPane().add(salvarButton);
		
		// Adicionando os labels e campos no layout
				JPanel BordaCampoNome = new JPanel();
				BordaCampoNome.setBorder(UIManager.getBorder("TextField.border"));
				BordaCampoNome.setBounds(42, 5, 221, 41);
				getContentPane().add(BordaCampoNome);
				BordaCampoNome.setLayout(null);
		
				JLabel label = new JLabel("Nome:");
				label.setBounds(10, 0, 221, 41);
				BordaCampoNome.add(label);
				label.setFont(new Font("Arial", Font.BOLD, 16));
				label.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoIdade = new JPanel();
				bordaCampoIdade.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoIdade.setBounds(42, 56, 221, 41);
				getContentPane().add(bordaCampoIdade);
				bordaCampoIdade.setLayout(null);
				
				JLabel label_1 = new JLabel("Idade Atual:");
				label_1.setBounds(10, 0, 221, 41);
				bordaCampoIdade.add(label_1);
				label_1.setFont(new Font("Arial", Font.BOLD, 16));
				label_1.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoGenero = new JPanel();
				bordaCampoGenero.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoGenero.setBounds(42, 107, 221, 41);
				getContentPane().add(bordaCampoGenero);
				bordaCampoGenero.setLayout(null);
				
				JLabel label_2 = new JLabel("Gênero:");
				label_2.setBounds(10, 0, 221, 41);
				bordaCampoGenero.add(label_2);
				label_2.setFont(new Font("Arial", Font.BOLD, 16));
				label_2.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoEstadoCivil = new JPanel();
				bordaCampoEstadoCivil.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoEstadoCivil.setBounds(42, 158, 221, 41);
				getContentPane().add(bordaCampoEstadoCivil);
				bordaCampoEstadoCivil.setLayout(null);
				
				JLabel label_3 = new JLabel("Estado Civil:");
				label_3.setBounds(10, 0, 221, 41);
				bordaCampoEstadoCivil.add(label_3);
				label_3.setFont(new Font("Arial", Font.BOLD, 16));
				label_3.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoEmail = new JPanel();
				bordaCampoEmail.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoEmail.setBounds(42, 209, 221, 41);
				getContentPane().add(bordaCampoEmail);
				bordaCampoEmail.setLayout(null);
				
				JLabel label_4 = new JLabel("Email:");
				label_4.setBounds(10, 0, 221, 41);
				bordaCampoEmail.add(label_4);
				label_4.setFont(new Font("Arial", Font.BOLD, 16));
				label_4.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoTelefone = new JPanel();
				bordaCampoTelefone.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoTelefone.setBounds(42, 260, 221, 41);
				getContentPane().add(bordaCampoTelefone);
				bordaCampoTelefone.setLayout(null);
				
				JLabel label_5 = new JLabel("Telefone:");
				label_5.setBounds(10, 0, 221, 41);
				bordaCampoTelefone.add(label_5);
				label_5.setFont(new Font("Arial", Font.BOLD, 16));
				label_5.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoCPF = new JPanel();
				bordaCampoCPF.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoCPF.setBounds(42, 311, 221, 41);
				getContentPane().add(bordaCampoCPF);
				bordaCampoCPF.setLayout(null);
				
				JLabel label_6 = new JLabel("CPF:");
				label_6.setBounds(10, 0, 221, 41);
				bordaCampoCPF.add(label_6);
				label_6.setFont(new Font("Arial", Font.BOLD, 16));
				label_6.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoCEP = new JPanel();
				bordaCampoCEP.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoCEP.setBounds(42, 362, 221, 41);
				getContentPane().add(bordaCampoCEP);
				bordaCampoCEP.setLayout(null);
				
				JLabel label_7 = new JLabel("CEP:");
				label_7.setBounds(10, 0, 221, 41);
				bordaCampoCEP.add(label_7);
				label_7.setFont(new Font("Arial", Font.BOLD, 16));
				label_7.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoSenha = new JPanel();
				bordaCampoSenha.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoSenha.setBounds(42, 413, 221, 41);
				getContentPane().add(bordaCampoSenha);
				bordaCampoSenha.setLayout(null);
				
				JLabel label_8 = new JLabel("Senha:");
				label_8.setBounds(10, 0, 221, 41);
				bordaCampoSenha.add(label_8);
				label_8.setFont(new Font("Arial", Font.BOLD, 16));
				label_8.setForeground(new Color(0, 108, 108));
				
				JPanel bordaCampoConfirmarSenha = new JPanel();
				bordaCampoConfirmarSenha.setBorder(UIManager.getBorder("TextField.border"));
				bordaCampoConfirmarSenha.setBounds(42, 464, 221, 41);
				getContentPane().add(bordaCampoConfirmarSenha);
				bordaCampoConfirmarSenha.setLayout(null);
				
				JLabel label_9 = new JLabel("Confirmar Senha:");
				label_9.setBounds(10, 0, 221, 41);
				bordaCampoConfirmarSenha.add(label_9);
				label_9.setFont(new Font("Arial", Font.BOLD, 16));
				label_9.setForeground(new Color(0, 108, 108));
				
				JLabel lblLogoDevMarine = new JLabel("");
				lblLogoDevMarine.setIcon(new ImageIcon("C:\\Users\\Cristine\\Desktop\\dev_cristine_novo\\Git\\SeguroDeVida\\SeguroDeVida\\src\\Imagens\\LogoDevMarine.png"));
				lblLogoDevMarine.setBounds(108, 0, 813, 582);
				getContentPane().add(lblLogoDevMarine);
				
		limparButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(CadastroSeguradoView.this,
						"Tem certeza que deseja limpar?", "Limpar Dados", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					nomeField.setText("");
					idadeField.setText("");
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
		
		@SuppressWarnings("unused")
		private JButton criarBotaoArredondado(String texto, int x, int y, Color corFundo) {
			JButton botao = new JButton(texto) {
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
			botao.setForeground(Color.WHITE); // Texto branco
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
		public String getNome() {
		return nomeField.getText();
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

	public int getIdade() {
		return Integer.parseInt(idadeField.getText());
	}
}