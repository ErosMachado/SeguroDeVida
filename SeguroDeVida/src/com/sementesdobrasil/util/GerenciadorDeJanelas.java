package com.sementesdobrasil.util;

import javax.swing.JFrame;

public class GerenciadorDeJanelas {
    private static JFrame janelaAtual;

    public static void trocarJanela(JFrame novaJanela) {
        if (janelaAtual != null) {
            janelaAtual.dispose(); // Fecha a janela atual
        }
        janelaAtual = novaJanela;
        janelaAtual.setVisible(true); // Exibe a nova janela
    }
}
