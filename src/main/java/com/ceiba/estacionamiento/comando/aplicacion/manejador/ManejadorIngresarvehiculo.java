package com.ceiba.estacionamiento.comando.aplicacion.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.fabrica.FabricaVehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;

@Component
public class ManejadorIngresarvehiculo {
	
	@Autowired
	FabricaVehiculo fabricaVehiculo;
	
	@Autowired
	ServicioIngresarVehiculo servicioIngresarVehiculo;
	
	public void ingresarVehiculo(ComandoVehiculo comandoVehiculo) {
		servicioIngresarVehiculo.ingresarVehiculo(fabricaVehiculo.crear(comandoVehiculo));
	}

}
