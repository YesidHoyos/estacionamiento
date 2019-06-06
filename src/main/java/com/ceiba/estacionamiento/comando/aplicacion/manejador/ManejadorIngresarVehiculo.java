package com.ceiba.estacionamiento.comando.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.aplicacion.VehiculoPOJO;
import com.ceiba.estacionamiento.comando.dominio.servicio.IVigilante;

@Component
public class ManejadorIngresarVehiculo {

	@Autowired
	IVigilante vigilante;
	
	public void ingresarVehiculo(VehiculoPOJO vehiculoPOJO) {
		vigilante.ingresarVehiculo(vehiculoPOJO.getTipo(), vehiculoPOJO.getPlaca(), vehiculoPOJO.getCilindraje());
	}
}
