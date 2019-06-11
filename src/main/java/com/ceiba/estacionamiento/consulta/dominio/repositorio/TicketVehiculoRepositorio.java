package com.ceiba.estacionamiento.consulta.dominio.repositorio;

import java.util.List;

import com.ceiba.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;

public interface TicketVehiculoRepositorio {

	public List<DtoTicketVehiculo> obtenerVehiculos();
}
