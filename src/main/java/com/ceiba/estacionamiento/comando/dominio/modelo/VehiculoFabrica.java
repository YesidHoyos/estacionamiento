package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

@Component
public class VehiculoFabrica {
	
	@Autowired
	private UtilitarioFecha utilitarioFecha;
	
	public Vehiculo getVehiculo(String tipo, String placa, String cilindraje) {
		
		Vehiculo vehiculo = null;
		
		if(tipo.equals(Constantes.CARRO)) {
			vehiculo = new Carro(placa, new Date(), cilindraje);
		} else if(tipo.equals(Constantes.MOTO)) {
			vehiculo = new Moto(placa, new Date(), cilindraje);
		} else {
			throw new VigilanteExcepcion(Constantes.VEHICULO_NO_PERMITIDO);
		}
		vehiculo.setUtilitarioFecha(utilitarioFecha);		
		return vehiculo;
	}

}
