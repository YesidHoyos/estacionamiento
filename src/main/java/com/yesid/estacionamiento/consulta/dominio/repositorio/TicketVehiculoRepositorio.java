package com.yesid.estacionamiento.consulta.dominio.repositorio;

import java.util.List;

import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;

public interface TicketVehiculoRepositorio {

	public List<DtoTicketVehiculo> obtenerVehiculos();
}
