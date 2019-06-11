package com.ceiba.estacionamiento.consulta.dominio.servicio;

import java.util.List;

import com.ceiba.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;

public interface ServicioObtenerVehiculos {

	public List<DtoTicketVehiculo> obtenerVehiculos();
}
