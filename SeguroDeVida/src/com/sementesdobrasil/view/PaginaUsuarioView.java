package com.sementesdobrasil.view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.util.GerenciadorDeJanelas;

public class PaginaUsuarioView extends JFrame {
    private static final long serialVersionUID = 1L;
    public PaginaUsuarioView(Segurado segurado) {
        setTitle("Página do Usuário");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 255, 255)); // Fundo branco

        // Título
        JLabel tituloLabel = new JLabel("Bem-vindo(a) à sua página");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tituloLabel.setForeground(new Color(2, 109, 115)); // Verde esmeralda
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        getContentPane().add(tituloLabel, BorderLayout.NORTH);

        // Painel para informações pessoais
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(7, 1, 10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(2, 109, 115)), 
                "Informações Pessoais", 
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(2, 109, 115)));
        infoPanel.setBackground(new Color(245, 245, 245)); // Fundo cinza claro

        infoPanel.add(criarInfoLabel("Nome: " + segurado.getNome()));
        infoPanel.add(criarInfoLabel("Idade: " + segurado.getIdade()));
        infoPanel.add(criarInfoLabel("Gênero: " + segurado.getGenero()));
        infoPanel.add(criarInfoLabel("E-mail: " + segurado.getEmail()));
        infoPanel.add(criarInfoLabel("Telefone: " + segurado.getTelefone()));
        infoPanel.add(criarInfoLabel("CPF: " + segurado.getCpf()));
        infoPanel.add(criarInfoLabel("CEP: " + segurado.getCep()));

        // Painel para botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 0));
        buttonPanel.setBackground(new Color(255, 255, 255)); // Fundo branco
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton realizarSeguroButton = criarBotaoArredondado("Voltar ao início", new Color(0, 183, 183));
        JButton SeguroButton = criarBotaoArredondado("Contratar Seguro", new Color(0, 183, 183));
        JButton adicionarDependenteButton = criarBotaoArredondado("Adicionar Dependentes", new Color(0, 183, 183));

        buttonPanel.add(realizarSeguroButton);
        buttonPanel.add(SeguroButton);
        buttonPanel.add(adicionarDependenteButton);

        getContentPane().add(infoPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        realizarSeguroButton.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(PaginaUsuarioView.this,
                    "Tem certeza que deseja voltar ao início?", "Voltar ao Início", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                GerenciadorDeJanelas.trocarJanela(new TelaPrincipal());
            }
        });

        SeguroButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(PaginaUsuarioView.this, "Abrindo tela para realizar seguro.");
            OficialCadastroCotacaoView cadastroCotacao = new OficialCadastroCotacaoView(segurado);
            cadastroCotacao.setVisible(true);
            setVisible(false);
        });

        adicionarDependenteButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(PaginaUsuarioView.this, "Abrindo tela para adicionar dependentes.");
            CadastroDependenteView dependente = new CadastroDependenteView();
            dependente.setVisible(true);
            setVisible(false);
        });
    }

    private JLabel criarInfoLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(50, 50, 50)); // Cinza escuro
        return label;
    }

    private JButton criarBotaoArredondado(String texto, Color corFundo) {
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

        botao.setFont(new Font("Arial", Font.PLAIN, 14));
        botao.setForeground(Color.WHITE); // Texto branco
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Adicionando animações ao botão
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botao.setFont(new Font("Arial", Font.BOLD, 16)); // Fonte maior
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botao.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte padrão
            }
        });

        return botao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Criando um objeto segurado fictício para demonstração
                SeguradoDAO seguradoDAO = new SeguradoDAO();
                Segurado segurado = seguradoDAO.getSeguradoByEmailSenha("joao@email.com", "Senha123");

                if (segurado != null) {
                    new PaginaUsuarioView(segurado).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar usuário: " + e.getMessage());
            }
        });
    }

}
