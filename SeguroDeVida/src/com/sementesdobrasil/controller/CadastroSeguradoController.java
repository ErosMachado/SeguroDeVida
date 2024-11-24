package com.sementesdobrasil.controller;

import com.sementesdobrasil.view.CadastroSeguradoView;
import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.service.SeguradoService;
import javax.swing.*;
import java.awt.event.*;

public class CadastroSeguradoController {
	private CadastroSeguradoView view;
	private SeguradoService service;
	
	public CadastroSeguradoController(CadastroSeguradoView view, SeguradoDAO seguradoDAO) {
	    this.view = view;
	    this.service = new SeguradoService();
	    initController();
	}

	public CadastroSeguradoController(CadastroSeguradoView view, SeguradoService service) {
		this.view = view;//
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
			String nome = view.getNome();
			int idade = view.getIdade();
			String genero = view.getGenero();
			String email = view.getEmail();
			String telefone = view.getTelefone();
			String cpf = view.getCpf();
			String cep = view.getCep();
			String senha = view.getSenha(); 
            String confirmarSenha = view.getConfirmarSenha();
			String estadoCivil = view.getEstadoCivil(); 

			if (nome.isEmpty() || email.isEmpty() || cpf.isEmpty() || cep.isEmpty()
					|| senha.isEmpty() || confirmarSenha.isEmpty() || estadoCivil.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Todos os campos sao obrigatorios.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (!senha.equals(confirmarSenha)) {
                JOptionPane.showMessageDialog(view, "As senhas nao coincidem.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

			Segurado segurado = new Segurado(nome, idade, genero, email, telefone, cpf, cep, senha,
					estadoCivil);
			service.salvarSegurado(segurado);
			JOptionPane.showMessageDialog(view, "Segurado cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(view, "Erro ao salvar segurado: " + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}