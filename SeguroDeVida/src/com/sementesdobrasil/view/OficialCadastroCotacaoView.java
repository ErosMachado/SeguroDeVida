package com.sementesdobrasil.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sementesdobrasil.dao.CotacaoDAO;
import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Cotacao;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.model.Seguro;
import com.sementesdobrasil.service.CotacaoService;
import com.sementesdobrasil.util.GerenciadorDeJanelas;

public class OficialCadastroCotacaoView extends JFrame {
	private static final long serialVersionUID = 1L;
	private Segurado segurado; // Variável de instância para armazenar o segurado



	public OficialCadastroCotacaoView(Segurado segurado) {
		this.segurado = segurado;
		setTitle("Cotação de Seguro");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		JPanel cadastroPanel = new JPanel(null);
		cadastroPanel.setBounds(0, 0, 600, 500);
		add(cadastroPanel);

		// Campo de Profissão
		JLabel profissaoLabel = new JLabel("Profissão:");
		profissaoLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		profissaoLabel.setBounds(50, 280, 100, 20);
		cadastroPanel.add(profissaoLabel);

		String[] profissoes = { "*Preenchimento Obrigatório*", "Não exerço nenhuma destas atividades profissionais",
				"APOSENTADO (POR IVALIDEZ OU DOENÇA)",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Supervisor ou coordenador extração mineral ou da construção civil",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Técnico em extração mineral ou geologia",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Técnico em mineralogia ou geologia",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Auxiliar ou técnico na extração mineral",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Garimpeiro",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Pintor sem equipamento de segurança",
				"CONSTRUÇÃO CIVIL E MINERAÇÃO - Plataformista de petróleo",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Bombeiros: comandante, coronel, tenente, major, capitão, subtenente",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Sargento, soldado, cabo e agente dos bombeiros",
				"TRANSPORTE E LOGÍSTICA - Motorista de caminhão",
				"ESPORTES E ATIVIDADES DE ALTO RISCO - Piloto de competição automobilística" };
		JComboBox<String> profissaoCombo = new JComboBox<>(profissoes);
		profissaoCombo.setFont(new Font("Roboto", Font.PLAIN, 14));
		profissaoCombo.setBounds(150, 280, 400, 30);
		cadastroPanel.add(profissaoCombo);

		// Campo de Faixa Salarial
		JLabel rendaLabel = new JLabel("Faixa Salarial:");
		rendaLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		rendaLabel.setBounds(50, 230, 150, 20);
		cadastroPanel.add(rendaLabel);

		String[] faixasSalarial = { "*Preenchimento Obrigatório*", "1040 - 2050", "2051 - 3050", "3051 - 4050",
				"4051 - 5050", "Acima de 5050" };
		JComboBox<String> rendaCombo = new JComboBox<>(faixasSalarial);
		rendaCombo.setFont(new Font("Roboto", Font.PLAIN, 14));
		rendaCombo.setBounds(150, 230, 265, 30);
		cadastroPanel.add(rendaCombo);

		// Campo de Gênero
		JLabel generoLabel = new JLabel("Gênero:");
		generoLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		generoLabel.setBounds(50, 130, 100, 20);
		cadastroPanel.add(generoLabel);

		String[] generos = { "*Preenchimento Obrigatório*", "Feminino", "Masculino", "Outro" };
		JComboBox<String> generoCombo = new JComboBox<>(generos);
		generoCombo.setFont(new Font("Roboto", Font.PLAIN, 14));
		generoCombo.setBounds(150, 130, 265, 30);
		cadastroPanel.add(generoCombo);

		// Campo de Idade
		JLabel idadeLabel = new JLabel("Idade:");
		idadeLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		idadeLabel.setBounds(50, 80, 100, 20);
		cadastroPanel.add(idadeLabel);

		JTextField idadeField = new JTextField();
		idadeField.setFont(new Font("Roboto", Font.PLAIN, 14));
		idadeField.setBounds(150, 80, 265, 30);
		cadastroPanel.add(idadeField);

		// Botão "Voltar"
		JButton voltarButton = criarBotaoArredondado("Voltar", 50, 400, Color.RED);
		cadastroPanel.add(voltarButton);

		voltarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PaginaUsuarioView perfil = new PaginaUsuarioView(segurado);
				GerenciadorDeJanelas.trocarJanela(perfil); // Gerencia a troca de janelas
				setVisible(false);
			}
		});

		// Botão "Realizar Seguro"
		JButton realizarSeguroButton = criarBotaoArredondado("Realizar Seguro", 350, 400, Color.GREEN);
		cadastroPanel.add(realizarSeguroButton);

		// Dentro do ActionListener do botão "Realizar Seguro"
		realizarSeguroButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Validação da idade
		            int idade = Integer.parseInt(idadeField.getText().trim());
		            if (idade <= 0) {
		                throw new NumberFormatException("Idade deve ser maior que 0");
		            }

		            String genero = (String) generoCombo.getSelectedItem();
		            String faixaSalarial = (String) rendaCombo.getSelectedItem();
		            String profissao = (String) profissaoCombo.getSelectedItem();

		            if (genero.equals("*Preenchimento Obrigatório*") || faixaSalarial.equals("*Preenchimento Obrigatório*")
		                || profissao.equals("*Preenchimento Obrigatório*")) {
		                JOptionPane.showMessageDialog(OficialCadastroCotacaoView.this, "Todos os campos devem ser preenchidos!");
		                return;
		            }

		            // Definir tipo de seguro e calcular valores
		            CotacaoService cotacaoService = new CotacaoService();
		            String tipoSeguro = cotacaoService.definirTipoSeguro(genero, idade, profissao, faixaSalarial);
		            double valorFinal = cotacaoService.calcularValorFinal(genero, idade, profissao, faixaSalarial);
		            String capitaisSegurados = cotacaoService.obterCapitaisSegurados(tipoSeguro);

		            // Buscar id_seguro no banco com base no tipo de seguro
		            int idSeguro = cotacaoService.buscarIdSeguro(tipoSeguro);
		            if (idSeguro == 0) {
		                throw new Exception("Tipo de seguro não encontrado no banco de dados.");
		            }

		            // Aqui o método getEmail() deve ser implementado na classe Segurado, caso contrário
		            SeguradoDAO seguradoDAO = new SeguradoDAO();
		            int idSegurado = seguradoDAO.getIdSeguradoLogado(segurado.getEmail());

		            Cotacao cotacao = new Cotacao();
		            cotacao.setSegurado(new Segurado(idSegurado)); // Define o ID do segurado
		            cotacao.setSeguro(new Seguro(idSeguro)); // Define o ID do seguro
		            cotacao.setValorFinal(valorFinal);

		            CotacaoDAO cotacaoDAO = new CotacaoDAO();
		            cotacaoDAO.saveCotacao(cotacao);

		            JOptionPane.showMessageDialog(OficialCadastroCotacaoView.this, "Cotação salva com sucesso!");

		            OficialCotacaoView cotacaoView = new OficialCotacaoView(tipoSeguro, valorFinal, capitaisSegurados);
		            cotacaoView.setVisible(true);
		            setVisible(false);

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(OficialCadastroCotacaoView.this, "Erro na idade: " + ex.getMessage());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(OficialCadastroCotacaoView.this, "Erro ao processar a cotação: " + ex.getMessage());
		        }
		    }
		});



		setVisible(true);
	}

	public OficialCadastroCotacaoView() {
		// TODO Auto-generated constructor stub
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

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
		new OficialCadastroCotacaoView();
	}
}
