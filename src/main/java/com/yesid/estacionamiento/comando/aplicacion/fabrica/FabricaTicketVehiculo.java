package com.yesid.estacionamiento.comando.aplicacion.fabrica;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.yesid.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;
import com.yesid.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.yesid.estacionamiento.comando.dominio.excepcion.NoPermitidoExcepcion;
import com.yesid.estacionamiento.comando.dominio.modelo.TicketCarro;
import com.yesid.estacionamiento.comando.dominio.modelo.TicketMoto;
import com.yesid.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.yesid.estacionamiento.comando.dominio.modelo.Vigilante;
import com.yesid.estacionamiento.comando.dominio.utilitario.TipoVehiculo;

@Component
public class FabricaTicketVehiculo {
	
	public TicketVehiculo crear(ComandoVehiculo comandoTicketVehiculo) {
		TicketVehiculo ticketVehiculo = null;
		
		if(comandoTicketVehiculo.getTipo() == TipoVehiculo.CARRO) {
			ticketVehiculo = new TicketCarro(comandoTicketVehiculo.getPlaca(), LocalDateTime.now(), comandoTicketVehiculo.getCilindraje());
		} else if(comandoTicketVehiculo.getTipo() == TipoVehiculo.MOTO) {
			ticketVehiculo = new TicketMoto(comandoTicketVehiculo.getPlaca(), LocalDateTime.now(), comandoTicketVehiculo.getCilindraje());
		} else {
			throw new NoPermitidoExcepcion(Vigilante.VEHICULO_NO_PERMITIDO);
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
			throw new NoPermitidoExcepcion(Vigilante.VEHICULO_NO_PERMITIDO);
		}
		return comandoTicketVehiculo;
	}
}



