package com.yesid.estacionamiento.comando.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yesid.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;
import com.yesid.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.yesid.estacionamiento.comando.aplicacion.fabrica.FabricaTicketVehiculo;
import com.yesid.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.yesid.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;

@Component
public class ManejadorIngresarvehiculo {
	
	@Autowired
	FabricaTicketVehiculo fabricaTicketVehiculo;
	
	@Autowired
	ServicioIngresarVehiculo servicioIngresarVehiculo;
	
	public ComandoTicketVehiculo ingresarVehiculo(ComandoVehiculo comandoVehiculo) {
		TicketVehiculo ticketVehiculo = servicioIngresarVehiculo.ingresarVehiculo(fabricaTicketVehiculo.crear(comandoVehiculo));
		return fabricaTicketVehiculo.obtenerComandoTicketVehiculo(ticketVehiculo);
	}

}
