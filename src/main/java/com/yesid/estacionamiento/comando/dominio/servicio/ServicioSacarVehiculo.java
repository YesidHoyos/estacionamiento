package com.yesid.estacionamiento.comando.dominio.servicio;

import com.yesid.estacionamiento.comando.dominio.modelo.TicketVehiculo;

public interface ServicioSacarVehiculo {

	public TicketVehiculo sacarVehiculo(String placa);
}
