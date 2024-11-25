package com.sementesdobrasil.view;

import javax.swing.*;


import java.awt.*;

public class PersonalizaCotacaoView extends JFrame {

    private static final long serialVersionUID = 1L;
   

    public PersonalizaCotacaoView() {
    	
        setTitle("Personalizar Coberturas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 255, 245));
        setContentPane(contentPane);

        JLabel titulo = new JLabel("Personalizar Coberturas");
        titulo.setFont(new Font("Roboto", Font.BOLD, 28));
        titulo.setBounds(200, 20, 400, 40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titulo);

        // Checkbox para capitais segurados
        JCheckBox[] capitaisCheckBoxes = {
                new JCheckBox("BÁSICA (MORTE): R$ 50.000,00"),
                new JCheckBox("MORTE ACIDENTAL: R$ 50.000,00"),
                new JCheckBox("INVALIDEZ PERMANENTE: R$ 50.000,00"),
                new JCheckBox("DOENÇAS GRAVES: R$ 15.000,00"),
                new JCheckBox("FUNERAL FAMILIAR: R$ 7.000,00")
        };

        int yPosition = 100;
        for (JCheckBox checkBox : capitaisCheckBoxes) {
            checkBox.setFont(new Font("Roboto", Font.PLAIN, 16));
            checkBox.setBounds(50, yPosition, 700, 30);
            checkBox.setSelected(true);
            contentPane.add(checkBox);
            yPosition += 40;
        }

        // Botão para aplicar mudanças
        JButton aplicarButton = new JButton("Aplicar");
        aplicarButton.setBounds(300, 450, 200, 40);
        contentPane.add(aplicarButton);

        aplicarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Coberturas atualizadas!");
            LoginBuilder loginBuilder = new LoginBuilder(); // Página de login
            loginBuilder.getFrame().setVisible(true);
            setVisible(false);
        });
    }
}