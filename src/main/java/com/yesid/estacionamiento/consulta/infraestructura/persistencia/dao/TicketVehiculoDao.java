package com.yesid.estacionamiento.consulta.infraestructura.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;
import com.yesid.estacionamiento.consulta.dominio.repositorio.TicketVehiculoRepositorio;
import com.yesid.estacionamiento.consulta.infraestructura.persistencia.builder.TicketVehiculoBuilder;
import com.yesid.estacionamiento.consulta.infraestructura.persistencia.dao.jpa.TicketVehiculoJPA;
import com.yesid.estacionamiento.consulta.infraestructura.persistencia.entidad.TicketVehiculoEntidad;

@Component("consultaTicketVehiculoDao")
public class TicketVehiculoDao implements TicketVehiculoRepositorio{

	@Autowired
	TicketVehiculoJPA ticketVehiculoJPA;
	
	@Autowired
	TicketVehiculoBuilder ticketVehiculoBuilder;
	
	@Override
	public List<DtoTicketVehiculo> obtenerVehiculos() {
		List<DtoTicketVehiculo> vehiculos = new ArrayList<>();
		List<TicketVehiculoEntidad> entidadVehiculos = ticketVehiculoJPA.obtenerVehiculosIngresados();
		
		for(TicketVehiculoEntidad ticketVehiculoEntidad : entidadVehiculos) {
			vehiculos.add(ticketVehiculoBuilder.convertirADominio(ticketVehiculoEntidad));
		}
		return vehiculos;	
	}

}
