package com.ceiba.estacionamiento.comando.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.comando.dominio.servicio.IVigilante;

@RestController
public class ControladorRest {

	@Autowired
	IVigilante vigilante;

	public void setVigilanteBean(IVigilante vigilante) {
		this.vigilante = vigilante;
	}

	@RequestMapping(value = "/vehiculo/ingresar", method = RequestMethod.POST)
	public void ingresarVehiculo() {
		vigilante.ingresarVehiculo("moto", "EBC", "150cc");
	}
}
