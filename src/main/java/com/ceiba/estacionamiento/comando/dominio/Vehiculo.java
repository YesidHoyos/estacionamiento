package com.ceiba.estacionamiento.comando.dominio;

import java.util.Date;

public abstract class Vehiculo {

	public Vehiculo() {

	}
	
	public Vehiculo(String placa, Date fechaIngreso, Date fechaSalida) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	private String placa;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
}
