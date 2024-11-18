package com.sementesdobrasil.controller;

import com.sementesdobrasil.view.CadastroSeguradoView;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.service.SeguradoService;
import javax.swing.*;
import java.awt.event.*;

public class CadastroSeguradoController {
	private CadastroSeguradoView view;
	private SeguradoService service;

	public CadastroSeguradoController(CadastroSeguradoView view, SeguradoService service) {
		this.view = view;
		this.service = service;
		initController();
	}

	private void initController() {
		view.addSalvarListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarSegurado();
			}
		});
	}

	private void salvarSegurado() {
		try {
			// validação dos dados
			String nome = view.getNome();
			String dataNascimento = view.getDataNascimento();
			String genero = view.getGenero();
			String email = view.getEmail();
			String telefone = view.getTelefone();
			String cpf = view.getCpf();
			String cep = view.getCep();
			if (nome.isEmpty() || dataNascimento.isEmpty() || email.isEmpty() || cpf.isEmpty() || cep.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Todos os campos sÃ£o obrigatórios.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			Segurado segurado = new Segurado(nome, dataNascimento, genero, email, telefone, cpf, cep);
			service.salvarSegurado(segurado);
			JOptionPane.showMessageDialog(view, "Segurado cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			view.dispose(); // Fecha a janela apÃ³s salvar
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(view, "Erro ao salvar segurado: " + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}