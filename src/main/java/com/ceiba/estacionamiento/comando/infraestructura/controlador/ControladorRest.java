package com.ceiba.estacionamiento.comando.infraestructura.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.comando.aplicacion.VehiculoPOJO;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorIngresarVehiculo;


@RestController
@RequestMapping("/vehiculo")
public class ControladorRest {

	@Autowired
	ManejadorIngresarVehiculo manejadorIngresarVehiculo;

	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public void ingresarVehiculo(@Valid @RequestBody VehiculoPOJO vehiculoPOJO) {
		manejadorIngresarVehiculo.ingresarVehiculo(vehiculoPOJO);
	}
}
