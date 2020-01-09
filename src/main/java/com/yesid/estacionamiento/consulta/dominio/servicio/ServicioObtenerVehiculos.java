package com.yesid.estacionamiento.consulta.dominio.servicio;

import java.util.List;

import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;

public interface ServicioObtenerVehiculos {

	public List<DtoTicketVehiculo> obtenerVehiculos();
}
