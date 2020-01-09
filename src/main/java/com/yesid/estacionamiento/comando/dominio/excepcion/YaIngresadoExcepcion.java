package com.yesid.estacionamiento.comando.dominio.excepcion;

public class YaIngresadoExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public YaIngresadoExcepcion(String message) {
		super(message);
	}

}
