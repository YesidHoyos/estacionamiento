package com.ceiba.estacionamiento.comando.aplicacion;

import java.io.Serializable;

public class VehiculoPOJO implements Serializable{
	
	private static final long serialVersionUID = -1764970284520387975L;
	
	private String placa;
	private String tipo;
	private String cilindraje;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
}
