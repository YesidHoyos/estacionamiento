package com.ceiba.estacionamiento.comando.dominio;

import java.util.Date;

public class Moto extends Vehiculo implements IVehiculoService{
	
	private int cilindraje;
	
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Moto() {
	}
	
	public Moto(String placa, Date fechaIngreso, Date fechaSalida) {
		super(placa, fechaIngreso, fechaSalida);
	}

	@Override
	public void validarIngreso() {
		// TODO Auto-generated method stub
		System.out.println("Vehiculo moto valida para ingresar");
	}

	@Override
	public void sacarVehiculo() {
		// TODO Auto-generated method stub
		
	}
}
