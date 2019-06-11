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
	
	public TicketVehiculo crear(ComandoTicketVehiculo comandoVehiculo) {
		TicketVehiculo vehiculo = null;
		
		if(comandoVehiculo.getTipo() == TipoVehiculo.CARRO) {
			vehiculo = new TicketCarro(comandoVehiculo.getPlaca(), LocalDateTime.now(), comandoVehiculo.getCilindraje());
		} else if(comandoVehiculo.getTipo() == TipoVehiculo.MOTO) {
			vehiculo = new TicketMoto(comandoVehiculo.getPlaca(), LocalDateTime.now(), comandoVehiculo.getCilindraje());
		} else {
			throw new VigilanteExcepcion(Vigilante.VEHICULO_NO_PERMITIDO);
		}
		return vehiculo;
	}
}



