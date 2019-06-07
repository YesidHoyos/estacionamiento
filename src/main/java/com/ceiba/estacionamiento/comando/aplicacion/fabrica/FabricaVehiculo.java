package com.ceiba.estacionamiento.comando.aplicacion.fabrica;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.Carro;
import com.ceiba.estacionamiento.comando.dominio.modelo.Moto;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

@Component
public class FabricaVehiculo {
	
	@Autowired
	private UtilitarioFecha utilitarioFecha;
	
	@Autowired
	IVehiculoRepositorio vehiculoRepositorio;
	
	public Vehiculo crear(ComandoVehiculo comandoVehiculo) {
		Vehiculo vehiculo = null;
		
		if(comandoVehiculo.getTipo().equals(Constantes.CARRO)) {
			vehiculo = new Carro(comandoVehiculo.getPlaca(), LocalDateTime.now(), comandoVehiculo.getCilindraje());
		} else if(comandoVehiculo.getTipo().equals(Constantes.MOTO)) {
			vehiculo = new Moto(comandoVehiculo.getPlaca(), LocalDateTime.now(), comandoVehiculo.getCilindraje());
		} else {
			throw new VehiculoExcepcion(Constantes.VEHICULO_NO_PERMITIDO);
		}
		vehiculo.setUtilitarioFecha(utilitarioFecha);	
		vehiculo.setVehiculoRepositorio(vehiculoRepositorio);
		return vehiculo;
	}
}



