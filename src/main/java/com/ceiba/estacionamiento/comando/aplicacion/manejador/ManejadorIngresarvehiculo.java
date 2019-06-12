package com.ceiba.estacionamiento.comando.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.fabrica.FabricaTicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;

@Component
public class ManejadorIngresarvehiculo {
	
	@Autowired
	FabricaTicketVehiculo fabricaVehiculo;
	
	@Autowired
	ServicioIngresarVehiculo servicioIngresarVehiculo;
	
	public ComandoTicketVehiculo ingresarVehiculo(ComandoTicketVehiculo comandoVehiculo) {
		TicketVehiculo ticketVehiculo = servicioIngresarVehiculo.ingresarVehiculo(fabricaVehiculo.crear(comandoVehiculo));
		return fabricaVehiculo.obtenerComandoTicketVehiculo(ticketVehiculo);
	}

}
