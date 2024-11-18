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
				// Instância do serviço (Service) responsável pelas operações relacionadas
				// ao cadastro de segurados (lógica de negócios).
				SeguradoService service = new SeguradoService();
				// Instância do control., que liga a view de acodo com o services
				new CadastroSeguradoController(view, service);
				// Torna a interface gráfica visível para o usuário.
				view.setVisible(true);
			}
		});
	}
}
