package com.ceiba.estacionamiento.comando.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioSacarVehiculo;

@Component
public class ManejadorSacarVehiculo {
	
	@Autowired
	ServicioSacarVehiculo servicioSacarVehiculo;
	
	public Vehiculo sacarVehiculo(String placa) {
		return servicioSacarVehiculo.sacarVehiculo(placa);
	}

}