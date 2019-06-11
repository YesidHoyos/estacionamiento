package com.ceiba.estacionamiento.comando.infraestructura.persistencia.builder;

import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.modelo.TicketCarro;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketMoto;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.utilitario.TipoVehiculo;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.TicketVehiculoEntidad;

@Component
public class TicketVehiculoBuilder {

	public TicketVehiculo convertirADominio(TicketVehiculoEntidad vehiculoEntidad) {
	
		TicketVehiculo vehiculo = null;
		
		if(vehiculoEntidad != null) {
			
			if(vehiculoEntidad.getTipoVehiculo() == TipoVehiculo.CARRO) {
			vehiculo = new TicketCarro(vehiculoEntidad.getPlaca(), vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getCilindraje());
			} 
			else if(vehiculoEntidad.getTipoVehiculo() == TipoVehiculo.MOTO) {
				vehiculo = new TicketMoto(vehiculoEntidad.getPlaca(), vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getCilindraje());
			}
		}		
		return vehiculo;
	}
	
	public TicketVehiculoEntidad convertirAEntidad(TicketVehiculo vehiculo) {
		TicketVehiculoEntidad vehiculoEntidad = null;
		int tipoVehiculo = 0;
		
		if(vehiculo != null) {
			
			if(vehiculo instanceof TicketCarro) {
				tipoVehiculo = TipoVehiculo.CARRO;
			} 
			else if (vehiculo instanceof TicketMoto) {
				tipoVehiculo = TipoVehiculo.MOTO;
			}
			
			vehiculoEntidad = new TicketVehiculoEntidad(vehiculo.getPlaca(), tipoVehiculo, vehiculo.getCilindraje(), vehiculo.getFechaIngreso());
		}
		return vehiculoEntidad;
	}
}
