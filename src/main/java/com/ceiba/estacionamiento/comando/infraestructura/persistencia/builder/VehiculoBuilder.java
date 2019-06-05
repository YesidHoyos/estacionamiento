package com.ceiba.estacionamiento.comando.infraestructura.persistencia.builder;

import com.ceiba.estacionamiento.comando.dominio.Carro;
import com.ceiba.estacionamiento.comando.dominio.IVehiculoService;
import com.ceiba.estacionamiento.comando.dominio.Moto;
import com.ceiba.estacionamiento.comando.dominio.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.VehiculoEntidad;

public class VehiculoBuilder {

	public static IVehiculoService convertirADominio(VehiculoEntidad vehiculoEntidad) {
	
		IVehiculoService vehiculo = null;
		
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
	
	public static VehiculoEntidad convertirAEntidad(IVehiculoService vehiculoService) {
		VehiculoEntidad vehiculoEntidad = null;
		Vehiculo vehiculo = (Vehiculo)vehiculoService;
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
