package com.ceiba.estacionamiento.comando.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.modelo.Moto;

public class MotoTestDataBuilder {

	private static final String PLACA = "ABC123";
	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.of(2019, 05, 01, 12, 0, 0);
	private static final int CILINDRAJE = 200;
	
	private String placa;
	private LocalDateTime fechaIngreso;
	private int cilindraje;
	
	public MotoTestDataBuilder(){
		this.placa = PLACA;
		this.fechaIngreso = FECHA_INGRESO;
		this.cilindraje = CILINDRAJE;
	}
	
	public MotoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public MotoTestDataBuilder conFechaDeIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	public MotoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Moto build() {
		return new Moto(this.placa,this.fechaIngreso, this.cilindraje);
	}
}
