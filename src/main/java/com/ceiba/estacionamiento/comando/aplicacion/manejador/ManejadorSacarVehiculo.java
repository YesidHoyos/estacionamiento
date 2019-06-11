package com.ceiba.estacionamiento.comando.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioSacarVehiculo;

@Component
public class ManejadorSacarVehiculo {
	
	@Autowired
	ServicioSacarVehiculo servicioSacarVehiculo;
	
	public TicketVehiculo sacarVehiculo(String placa) {
		return servicioSacarVehiculo.sacarVehiculo(placa);
	}

}
