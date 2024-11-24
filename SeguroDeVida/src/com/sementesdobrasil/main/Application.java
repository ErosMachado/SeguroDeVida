package com.sementesdobrasil.main;
import javax.swing.SwingUtilities;

import com.sementesdobrasil.view.TelaInicialView;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	TelaInicialView main = new TelaInicialView();
                main.setVisible(true);
            }
        });
    }
}
