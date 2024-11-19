package com.sementesdobrasil.main;
import com.sementesdobrasil.view.TelaPrincipal;
import javax.swing.SwingUtilities;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaPrincipal main = new TelaPrincipal();
                main.setVisible(true);
            }
        });
    }
}
