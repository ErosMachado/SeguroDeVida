package com.sementesdobrasil.service;

import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.dao.SeguradoDAO;

public class SeguradoService {
	private SeguradoDAO seguradoDAO;


	public SeguradoService() {
		this.seguradoDAO = new SeguradoDAO();
	}

	public void salvarSegurado(Segurado segurado) throws Exception {
		seguradoDAO.save(segurado);
	}

}