package com.ceiba.estacionamiento.comando.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.modelo.TicketCarro;

public class CarroTestDataBuilder {
	
	private static final String PLACA = "BBC123";
	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.of(2019, 05, 06, 0, 0, 0);
	private static final int CILINDRAJE = 1500;
	
	private String placa;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private int cilindraje;
	
	public CarroTestDataBuilder(){
		this.placa = PLACA;
		this.fechaIngreso = FECHA_INGRESO;
		this.fechaSalida = null;
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
	
	public CarroTestDataBuilder conFechaDeSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public CarroTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public TicketCarro build() {
		return new TicketCarro(this.placa,this.fechaIngreso, this.fechaSalida, this.cilindraje);
	}
}
