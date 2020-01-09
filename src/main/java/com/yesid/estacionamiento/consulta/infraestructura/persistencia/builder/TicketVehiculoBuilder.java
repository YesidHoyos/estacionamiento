package com.yesid.estacionamiento.consulta.infraestructura.persistencia.builder;

import org.springframework.stereotype.Component;

import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;
import com.yesid.estacionamiento.consulta.infraestructura.persistencia.entidad.TicketVehiculoEntidad;

@Component("consultaTicketVehiculoBuilder")
public class TicketVehiculoBuilder {

	public DtoTicketVehiculo convertirADominio(TicketVehiculoEntidad ticketVehiculoEntidad) {
		DtoTicketVehiculo dtoTicketVehiculo = null;		
		if(ticketVehiculoEntidad != null) {
			dtoTicketVehiculo = new DtoTicketVehiculo(ticketVehiculoEntidad.getPlaca(), ticketVehiculoEntidad.getTipo(), ticketVehiculoEntidad.getFechaIngreso());
		}
		return dtoTicketVehiculo;
	}
}
