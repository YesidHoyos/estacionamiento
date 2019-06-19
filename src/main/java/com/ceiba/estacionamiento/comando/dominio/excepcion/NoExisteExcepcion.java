package com.ceiba.estacionamiento.comando.dominio.excepcion;

public class NoExisteExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NoExisteExcepcion(String message) {
		super(message);
	}

}
