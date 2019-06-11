package com.ceiba.estacionamiento.consulta.dominio.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.consulta.dominio.repositorio.TicketVehiculoRepositorio;
import com.ceiba.estacionamiento.consulta.dominio.servicio.ServicioObtenerVehiculos;

@Component("consultaVigilante")
public class Vigilante implements ServicioObtenerVehiculos{

	@Autowired
	TicketVehiculoRepositorio ticketVehiculoRepositorio;
	
	@Override
	public List<DtoTicketVehiculo> obtenerVehiculos() {
		return ticketVehiculoRepositorio.obtenerVehiculos();
	}

}
