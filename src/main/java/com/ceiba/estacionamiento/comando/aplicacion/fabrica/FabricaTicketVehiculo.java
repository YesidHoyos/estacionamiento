package com.ceiba.estacionamiento.comando.aplicacion.fabrica;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketCarro;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketMoto;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vigilante;
import com.ceiba.estacionamiento.comando.dominio.utilitario.TipoVehiculo;

@Component
public class FabricaTicketVehiculo {
	
	public TicketVehiculo crear(ComandoTicketVehiculo comandoTicketVehiculo) {
		TicketVehiculo ticketVehiculo = null;
		
		if(comandoTicketVehiculo.getTipo() == TipoVehiculo.CARRO) {
			ticketVehiculo = new TicketCarro(comandoTicketVehiculo.getPlaca(), LocalDateTime.now(), comandoTicketVehiculo.getCilindraje());
		} else if(comandoTicketVehiculo.getTipo() == TipoVehiculo.MOTO) {
			ticketVehiculo = new TicketMoto(comandoTicketVehiculo.getPlaca(), LocalDateTime.now(), comandoTicketVehiculo.getCilindraje());
		} else {
			throw new VigilanteExcepcion(Vigilante.VEHICULO_NO_PERMITIDO);
		}
		return ticketVehiculo;
	}
	
	public ComandoTicketVehiculo obtenerComandoTicketVehiculo(TicketVehiculo ticketVehiculo) {
		ComandoTicketVehiculo comandoTicketVehiculo = null;
		
		if(ticketVehiculo instanceof TicketCarro) {
			comandoTicketVehiculo = new ComandoTicketVehiculo(ticketVehiculo.getPlaca(), TipoVehiculo.CARRO, ticketVehiculo.getFechaIngreso());
		} else if(ticketVehiculo instanceof TicketMoto) {
			comandoTicketVehiculo = new ComandoTicketVehiculo(ticketVehiculo.getPlaca(), TipoVehiculo.MOTO, ticketVehiculo.getFechaIngreso());
		} else {
			throw new VigilanteExcepcion(Vigilante.VEHICULO_NO_PERMITIDO);
		}
		return comandoTicketVehiculo;
	}
}



