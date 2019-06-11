package com.ceiba.estacionamiento.comando.dominio.servicio;

import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;

public interface ServicioSacarVehiculo {

	public TicketVehiculo sacarVehiculo(String placa);
}
