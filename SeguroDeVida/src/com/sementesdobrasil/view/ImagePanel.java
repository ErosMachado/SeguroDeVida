package com.sementesdobrasil.view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    // Construtor para carregar a imagem
    public ImagePanel(String imagePath) {
        try {
            // Carrega a imagem do caminho especificado
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sobrescreve o método paintComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Desenha a imagem no painel ajustando para o tamanho
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
