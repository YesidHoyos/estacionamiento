package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.util.Date;

import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

public abstract class Vehiculo {

	private String placa;
	private Date fechaIngreso;
	private String cilindraje;
	private Date fechaSalida;
	
	protected UtilitarioFecha utilitarioFecha;
	
	public Vehiculo(String placa, Date fechaIngreso, String cilindraje) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.cilindraje = cilindraje;
	}	

	public void setUtilitarioFecha(UtilitarioFecha utilitarioFecha) {
		this.utilitarioFecha = utilitarioFecha;
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
	
	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public abstract void validarIngreso();
	public abstract BigDecimal obtenerValorAPagar();
	
}
