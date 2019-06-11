package com.ceiba.estacionamiento.comando.aplicacion.comando;

import java.io.Serializable;

public class ComandoTicketVehiculo implements Serializable{
	
	private static final long serialVersionUID = -1764970284520387975L;
	
	private String placa;
	private int tipo;
	private int cilindraje;
	
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
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
}
