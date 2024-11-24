package com.sementesdobrasil.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sementesdobrasil.dao.CotacaoDAO;
import com.sementesdobrasil.model.Corretor;
import com.sementesdobrasil.model.Cotacao;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.model.Seguro;
import com.sementesdobrasil.service.CotacaoService;

public class CadastroCotacaoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CadastroCotacaoView frame = new CadastroCotacaoView();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public CadastroCotacaoView() {
		// Configuração da janela principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 700); // Aumentado para dar mais espaço ao novo campo
		setLocationRelativeTo(null); // Centralizar a janela

		// Painel principal
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255)); // Verde claro
		setContentPane(contentPane);

		// Cabeçalho
		JLabel titulo = new JLabel("Cotação de Seguro de Vida");
		titulo.setFont(new Font("Roboto", Font.BOLD, 28)); // Título maior
		titulo.setBounds(200, 20, 400, 40);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new Color(34, 85, 34)); // Verde escuro
		contentPane.add(titulo);

		// Painel de Cadastro
		JPanel cadastroPanel = new JPanel();
		cadastroPanel.setBounds(50, 80, 700, 370); // Aumentado o tamanho para o novo campo
		cadastroPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(34, 85, 34)),
				"Dados do Cliente"));
		cadastroPanel.setLayout(null);
		cadastroPanel.setBackground(new Color(245, 255, 245)); // Fundo branco-esverdeado
		contentPane.add(cadastroPanel);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		nomeLabel.setBounds(50, 30, 100, 20);
		cadastroPanel.add(nomeLabel);

		JTextField nomeField = new JTextField();
		nomeField.setFont(new Font("Roboto", Font.PLAIN, 14));
		nomeField.setBounds(150, 30, 400, 30);
		cadastroPanel.add(nomeField);

		JLabel idadeLabel = new JLabel("Idade:");
		idadeLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		idadeLabel.setBounds(50, 80, 100, 20);
		cadastroPanel.add(idadeLabel);

		JTextField idadeField = new JTextField();
		idadeField.setFont(new Font("Roboto", Font.PLAIN, 14));
		idadeField.setBounds(150, 80, 265, 30);
		cadastroPanel.add(idadeField);

		JLabel generoLabel = new JLabel("Gênero:");
		generoLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		generoLabel.setBounds(50, 130, 100, 20);
		cadastroPanel.add(generoLabel);

		String[] generos = { "*Preenchimento Obrigatório*", "Feminino", "Masculino", "Outro" };
		JComboBox<String> generoCombo = new JComboBox<>(generos);
		generoCombo.setFont(new Font("Roboto", Font.PLAIN, 14));
		generoCombo.setBounds(150, 130, 265, 30);
		cadastroPanel.add(generoCombo);

		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
		emailLabel.setBounds(50, 180, 100, 20);
		cadastroPanel.add(emailLabel);

		JTextField emailField = new JTextField();
		emailField.setFont(new Font("Roboto", Font.PLAIN, 14));
		emailField.setBounds(150, 180, 265, 30);
		cadastroPanel.add(emailField);

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

		// Novo campo Profissão
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
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Sargento, soldado, cabo e agente de polícia militar",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Policial militar: comandante, coronel, tenente, major, capitão, subtenente",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Policial civil - agente de segurança penitenciária",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Polícia Civil, exceto agente penitenciário",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Policial Federal, ferroviário e rodoviário",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Policial legislativo e do Senado Federal",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Cabo, marinheiro e taifeiro das Forças Armadas",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Oficiais, suboficiais e sargentos do Exército, Marinha e Aeronáutica",
				"SEGURANÇA PÚBLICA E FORÇAS ARMADAS - Monitor ou instrutor de menores (Fundação Casa e similares)",
				"TRANSPORTE E LOGÍSTICA - Motoboy", "TRANSPORTE E LOGÍSTICA - Motorista de caminhão",
				"TRANSPORTE E LOGÍSTICA - Mototaxista", "TRANSPORTE E LOGÍSTICA - Piloto de avião",
				"TRANSPORTE E LOGÍSTICA - Piloto de helicóptero", "TRANSPORTE E LOGÍSTICA - Instrutor de voo",
				"TRABALHO DE RISCO OU PERIGOSO - Mergulhador", "TRABALHO DE RISCO OU PERIGOSO - Pirotécnico",
				"TRABALHO DE RISCO OU PERIGOSO - Limpador de vidros (especialmente em altura)",
				"TRABALHO DE RISCO OU PERIGOSO - Vigilante ou segurança (especialmente em áreas de risco)",
				"TRABALHO EM ÁREAS DE RISCO OU PERIGO - Boiadeiro (trabalhador rural em condições de risco)",
				"TRABALHO EM ÁREAS DE RISCO OU PERIGO - Guarda Civil Municipal (especialmente se atuando em áreas de risco elevado)",
				"ESPORTES E ATIVIDADES DE ALTO RISCO - Piloto de competição automobilística" };
		JComboBox<String> profissaoCombo = new JComboBox<>(profissoes);
		profissaoCombo.setFont(new Font("Roboto", Font.PLAIN, 14));
		profissaoCombo.setBounds(150, 280, 400, 30);
		cadastroPanel.add(profissaoCombo);

		// Botões (sem alterações)
		JPanel botoesPanel = new JPanel();
		botoesPanel.setBounds(50, 470, 700, 50);
		botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		botoesPanel.setBackground(new Color(230, 250, 230));
		contentPane.add(botoesPanel);

		JButton salvarButton = new JButton("Cotar");
		salvarButton.setFont(new Font("Roboto", Font.BOLD, 16));
		salvarButton.setBackground(new Color(50, 99, 99));
		salvarButton.setForeground(Color.WHITE);
		botoesPanel.add(salvarButton);

		JButton LimparButton = new JButton("Limpar");
		LimparButton.setForeground(Color.WHITE);
		LimparButton.setFont(new Font("Dialog", Font.BOLD, 16));
		LimparButton.setBackground(new Color(50, 99, 99));
		botoesPanel.add(LimparButton);

		JButton VoltarButton = new JButton("Voltar");
		VoltarButton.setFont(new Font("Roboto", Font.BOLD, 16));
		VoltarButton.setBackground(new Color(50, 99, 99));
		VoltarButton.setForeground(Color.WHITE);
		botoesPanel.add(VoltarButton);

		JLabel lblLogoTokio = new JLabel("");
		lblLogoTokio.setIcon(new ImageIcon(CadastroCotacaoView.class.getResource("/Imagens/FundoTokio.png")));
		lblLogoTokio.setBounds(145, 470, 500, 183);
		contentPane.add(lblLogoTokio);

		VoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(CadastroCotacaoView.this,
						"Tem certeza que deseja sair? Sua cotação será perdida após isso...", "Sair",
						JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					TelaPrincipal telaPrincipal = new TelaPrincipal();
					telaPrincipal.setVisible(true);
					setVisible(false);
				}
			}
		});

		LimparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(CadastroCotacaoView.this, "Tem certeza que deseja limpar?",
						"Limpar Dados", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					nomeField.setText("");
					idadeField.setText("");
					generoCombo.setSelectedIndex(0);
					emailField.setText("");
					rendaCombo.setSelectedIndex(0);
					profissaoCombo.setSelectedIndex(0);
				}
			}
		});

		salvarButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Captura os dados preenchidos no formulário
		            String nome = nomeField.getText();
		            int idade = Integer.parseInt(idadeField.getText());
		            String genero = (String) generoCombo.getSelectedItem();
		            String faixaSalarial = (String) rendaCombo.getSelectedItem();
		            String profissao = (String) profissaoCombo.getSelectedItem();

		            // Validação simples
		            if (nome.isEmpty() || idade <= 0 || genero.equals("*Preenchimento Obrigatório*")
		                    || faixaSalarial.equals("*Preenchimento Obrigatório*")
		                    || profissao.equals("*Preenchimento Obrigatório*")) {
		                JOptionPane.showMessageDialog(CadastroCotacaoView.this,
		                        "Todos os campos devem ser preenchidos!");
		                return;
		            }

		            // Chamada ao serviço de cálculo
		            CotacaoService cotacaoService = new CotacaoService();
		            String tipoSeguro = cotacaoService.definirTipoSeguro(genero, idade, profissao, faixaSalarial);
		            double valorFinal = cotacaoService.calcularValorFinal(genero, idade, profissao, faixaSalarial);
		            String capitaisSegurados = cotacaoService.obterCapitaisSegurados(tipoSeguro);

		            // Cria o objeto Cotacao a ser salvo no banco
		            Cotacao cotacao = new Cotacao();
		            cotacao.setSegurado(new Segurado(nome, idade, genero));  // Exemplo de como preencher o segurado
		            cotacao.setSeguro(new Seguro(tipoSeguro));               // Exemplo de como preencher o seguro
		            cotacao.setValorFinal(valorFinal);
		            cotacao.setCorretor(new Corretor(nome));       // Exemplo de como preencher o corretor (supondo que você tenha essa informação)

		            // Chama o método para salvar a cotação no banco
		            CotacaoDAO cotacaoDAO = new CotacaoDAO();  // Classe de acesso ao banco
		            cotacaoDAO.saveCotacao(cotacao);

		            // Abre a página CotacaoView com os dados calculados
		            CotacaoView cotacaoView = new CotacaoView(tipoSeguro, valorFinal, capitaisSegurados);
		            cotacaoView.setVisible(true);
		            setVisible(false);

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(CadastroCotacaoView.this,
		                    "Erro ao processar a cotação: " + ex.getMessage());
		        }
		    }
		});


	}
}
