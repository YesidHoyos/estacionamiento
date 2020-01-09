package com.yesid.estacionamiento.comando.aplicacion.testdatabuilder;

import com.yesid.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;

public class ComandoVehiculoDataBuilder {
	
	private static final String PLACA = "ABC123";
	private static final int TIPO = 1;
	private static final int CILINDRAJE = 1000;	
	
	private String placa;
	private int tipo;
	private int cilindraje;
	
	public ComandoVehiculoDataBuilder() {
		this.placa = PLACA;
		this.tipo = TIPO;
		this.cilindraje = CILINDRAJE;
	}
	
	public ComandoVehiculoDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public ComandoVehiculoDataBuilder conTipo(int tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public ComandoVehiculoDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public ComandoVehiculo build() {
		return new ComandoVehiculo(this.placa, this.tipo, this.cilindraje);
	}

}
