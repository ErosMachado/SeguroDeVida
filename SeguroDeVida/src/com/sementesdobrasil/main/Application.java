package com.sementesdobrasil.main;
import com.sementesdobrasil.view.CadastroSeguradoView;
import com.sementesdobrasil.service.SeguradoService;
import com.sementesdobrasil.controller.CadastroSeguradoController;
import javax.swing.SwingUtilities;

public class Application {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CadastroSeguradoView view = new CadastroSeguradoView();
				// Inst�ncia do servi�o (Service) respons�vel pelas opera��es relacionadas
				// ao cadastro de segurados (l�gica de neg�cios).
				SeguradoService service = new SeguradoService();
				// Inst�ncia do control., que liga a view de acodo com o services
				new CadastroSeguradoController(view, service);
				// Torna a interface gr�fica vis�vel para o usu�rio.
				view.setVisible(true);
			}
		});
	}
}
