package com.ceiba.estacionamiento.comando.dominio.excepcion;

public class DiaNoHabilExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DiaNoHabilExcepcion(String message) {
		super(message);
	}

}
