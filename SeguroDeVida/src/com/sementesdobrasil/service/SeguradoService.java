package com.sementesdobrasil.service;

import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.dao.SeguradoDAO;

public class SeguradoService {
    private SeguradoDAO seguradoDAO;

    public SeguradoService() {
        this.setSeguradoDAO(new SeguradoDAO());
    }

    public void salvarSegurado(Segurado segurado) throws Exception {
        System.out.println("Recebendo segurado no Service: " + segurado.toString());
        getSeguradoDAO().save(segurado);
    }

	public SeguradoDAO getSeguradoDAO() {
		return seguradoDAO;
	}

	public void setSeguradoDAO(SeguradoDAO seguradoDAO) {
		this.seguradoDAO = seguradoDAO;
	}
}
