package com.ceiba.estacionamiento.comando.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.modelo.Carro;

public class CarroTestDataBuilder {
	
	private static final String PLACA = "ABC123";
	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.of(2019, 05, 06, 12, 0, 0);
	private static final int CILINDRAJE = 1500;
	
	private String placa;
	private LocalDateTime fechaIngreso;
	private int cilindraje;
	
	public CarroTestDataBuilder(){
		this.placa = PLACA;
		this.fechaIngreso = FECHA_INGRESO;
		this.cilindraje = CILINDRAJE;
	}
	
	public CarroTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public CarroTestDataBuilder conFechaDeIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	public CarroTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Carro build() {
		return new Carro(this.placa,this.fechaIngreso, this.cilindraje);
	}
}
