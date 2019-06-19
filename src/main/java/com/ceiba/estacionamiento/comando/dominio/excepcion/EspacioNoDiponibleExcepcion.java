package com.ceiba.estacionamiento.comando.dominio.excepcion;

public class EspacioNoDiponibleExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EspacioNoDiponibleExcepcion(String message) {
		super(message);
	}

}