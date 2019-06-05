package com.ceiba.estacionamiento.comando.dominio.servicio;

public interface IVigilante {
	
	public void ingresarVehiculo(String tipo, String placa, String cilindraje);
	public void SacarVehiculo(String placa);

}
