package com.ceiba.estacionamiento.consulta.dominio.modelo;

import java.time.LocalDateTime;

public class DtoTicketVehiculo {

	private String placa;
	private int tipo;
	private LocalDateTime fechaIngreso;
	
	public DtoTicketVehiculo(String placa, int tipo, LocalDateTime fechaIngreso) {
		this.placa = placa;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
