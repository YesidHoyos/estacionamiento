package com.ceiba.estacionamiento.comando.dominio.excepcion;

public class VehiculoExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public VehiculoExcepcion(String message) {
		super(message);
	}

}
