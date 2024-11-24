package com.sementesdobrasil.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Segurado;

public class PaginaUsuarioView extends JFrame {
	private static final long serialVersionUID = 1L;

	public PaginaUsuarioView(Segurado segurado) {
	    setTitle("Página do Usuário");
	    setSize(500, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(new BorderLayout());

	    // Painel para informações pessoais
	    JPanel infoPanel = new JPanel();
	    infoPanel.setLayout(new GridLayout(7, 1, 10, 10)); // 7 linhas para exibir todas as informações
	    infoPanel.setBorder(BorderFactory.createTitledBorder("Informações Pessoais"));

	    infoPanel.add(new JLabel("Nome: " + segurado.getNome()));
	    infoPanel.add(new JLabel("idade: " + segurado.getIdade()));
	    infoPanel.add(new JLabel("Gênero: " + segurado.getGenero()));
	    infoPanel.add(new JLabel("E-mail: " + segurado.getEmail()));
	    infoPanel.add(new JLabel("Telefone: " + segurado.getTelefone()));
	    infoPanel.add(new JLabel("CPF: " + segurado.getCpf()));
	    infoPanel.add(new JLabel("CEP: " + segurado.getCep()));

	    // Painel para botões de ações
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));

	    JButton realizarSeguroButton = new JButton("Voltar ao início");
	    JButton SeguroButton = new JButton("Contratar Seguro");
	    JButton adicionarDependenteButton = new JButton("Adicionar Dependentes");

	    // Adicionando os botões ao painel
	    buttonPanel.add(realizarSeguroButton);
	    buttonPanel.add(SeguroButton);
	    buttonPanel.add(adicionarDependenteButton);

	    // Adicionando painéis à tela principal
	    getContentPane().add(infoPanel, BorderLayout.CENTER);
	    getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	
	    // Ações dos botões
	    realizarSeguroButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int resposta = JOptionPane.showConfirmDialog(PaginaUsuarioView.this,
						"Tem certeza que deseja voltar ao início?", "Voltar ao Início", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					TelaPrincipal main = new TelaPrincipal();
					main.setVisible(true);
					setVisible(false);
				}
	        }
	    });

	    SeguroButton.addActionListener(new ActionListener() {    
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	CadastroCotacaoView cadastroCotacao = new CadastroCotacaoView();
				cadastroCotacao.setVisible(true);
				setVisible(false);
	        	
	        }
	    });

	    adicionarDependenteButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(PaginaUsuarioView.this, "Abrir tela para adicionar dependentes.");                
	        }
	    });
	}


	public PaginaUsuarioView() {
		this(new Segurado()); 
	}

	public static void main(String[] args) {
	    String email = "joao@email.com";
	    String senha = "Senha123";
	    


	    SeguradoDAO seguradoDAO = new SeguradoDAO();
	    Segurado segurado = null;

	    try {
	        segurado = seguradoDAO.getSeguradoByEmailSenha(email, senha); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (segurado != null) {  
	    	PaginaUsuarioView perfil = new PaginaUsuarioView(segurado);  // Passando o objeto segurado
            perfil.setVisible(true);
            
	    } else {
	        JOptionPane.showMessageDialog(null, "Credenciais inválidas.");
	    }
	}
}
