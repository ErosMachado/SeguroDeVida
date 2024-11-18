package com.sementesdobrasil.main;
import com.sementesdobrasil.view.CadastroSeguradoView;
import com.sementesdobrasil.service.SeguradoService;
import com.sementesdobrasil.controller.CadastroSeguradoController;
import javax.swing.SwingUtilities;
public class Application {
 public static void main(String[] args) {
 SwingUtilities.invokeLater(new Runnable() {
 public void run() {
 CadastroSeguradoView view = new CadastroSeguradoView();
 SeguradoService service = new SeguradoService();
 new CadastroSeguradoController(view, service);
 view.setVisible(true);
 }
 });
 }
}