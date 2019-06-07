package com.ceiba.estacionamiento.comando.dominio.servicio;

import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;

public interface ServicioSacarVehiculo {

	public Vehiculo sacarVehiculo(String placa);
}
