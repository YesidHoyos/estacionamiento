package com.ceiba.estacionamiento.comando.infraestructura.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.comando.aplicacion.VehiculoPOJO;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorVehiculo;

@RestController
@RequestMapping("/vehiculo")
public class ControladorRest {

	@Autowired
	ManejadorVehiculo manejadorVehiculo;

	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public void ingresarVehiculo(@Valid @RequestBody VehiculoPOJO vehiculoPOJO) {
		manejadorVehiculo.ingresarVehiculo(vehiculoPOJO);
	}
	
	@RequestMapping(value = "/sacar", method = RequestMethod.POST)
	public void sacarVehiculo(@RequestParam(name = "placa", required = true) String placa) {
		manejadorVehiculo.sacarVehiculo(placa);
	}
}
