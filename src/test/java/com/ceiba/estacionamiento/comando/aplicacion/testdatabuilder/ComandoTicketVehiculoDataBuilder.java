package com.ceiba.estacionamiento.comando.aplicacion.testdatabuilder;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;

public class ComandoTicketVehiculoDataBuilder {
	
	private static final String PLACA = "ABC123";
	private static final int TIPO = 1;
	private static final int CILINDRAJE = 1000;	
	
	private String placa;
	private int tipo;
	private int cilindraje;
	
	public ComandoTicketVehiculoDataBuilder() {
		this.placa = PLACA;
		this.tipo = TIPO;
		this.cilindraje = CILINDRAJE;
	}
	
	public ComandoTicketVehiculoDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public ComandoTicketVehiculoDataBuilder conTipo(int tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public ComandoTicketVehiculoDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public ComandoTicketVehiculo build() {
		return new ComandoTicketVehiculo(this.placa, this.tipo, this.cilindraje);
	}

}
