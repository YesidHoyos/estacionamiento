package com.yesid.estacionamiento.comando.dominio.excepcion;

public class NoPermitidoExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NoPermitidoExcepcion(String message) {
		super(message);
	}

}