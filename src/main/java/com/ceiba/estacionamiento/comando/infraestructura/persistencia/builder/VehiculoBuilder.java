package com.ceiba.estacionamiento.comando.infraestructura.persistencia.builder;

import com.ceiba.estacionamiento.comando.dominio.modelo.Carro;
import com.ceiba.estacionamiento.comando.dominio.modelo.Moto;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.VehiculoEntidad;

public class VehiculoBuilder {

	public static Vehiculo convertirADominio(VehiculoEntidad vehiculoEntidad) {
	
		Vehiculo vehiculo = null;
		
		if(vehiculoEntidad != null) {
			
			if(vehiculoEntidad.getTipoVehiculo() == Constantes.TIPO_CARRO) {
			vehiculo = new Carro(vehiculoEntidad.getPlaca(), vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getCilindraje());
			} 
			else if(vehiculoEntidad.getTipoVehiculo() == Constantes.TIPO_MOTO) {
				vehiculo = new Moto(vehiculoEntidad.getPlaca(), vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getCilindraje());
			}
		}
		return vehiculo;
	}
	
	public static VehiculoEntidad convertirAEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = null;
		int tipoVehiculo = 0;
		
		if(vehiculo instanceof Carro) {
			tipoVehiculo = Constantes.TIPO_CARRO;
		} 
		else if (vehiculo instanceof Moto) {
			tipoVehiculo = Constantes.TIPO_MOTO;
		}
		
		if(vehiculo != null) {
			vehiculoEntidad = new VehiculoEntidad(vehiculo.getPlaca(), tipoVehiculo, vehiculo.getCilindraje(), vehiculo.getFechaIngreso());
		}
		
		return vehiculoEntidad;
	}
}
