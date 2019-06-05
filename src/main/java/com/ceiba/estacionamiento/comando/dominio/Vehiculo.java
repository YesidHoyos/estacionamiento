package com.ceiba.estacionamiento.comando.dominio;

import java.util.Date;

public abstract class Vehiculo {

	private String placa;
	private Date fechaIngreso;
	private String cilindraje;
	
	public Vehiculo() {

	}
	
	public Vehiculo(String placa, Date fechaIngreso, String cilindraje) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.cilindraje = cilindraje;
	}
	
	
	public String getCilindraje() {
		return cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}
