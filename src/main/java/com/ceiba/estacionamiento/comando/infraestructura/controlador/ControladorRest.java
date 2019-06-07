package com.ceiba.estacionamiento.comando.infraestructura.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorIngresarvehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorSacarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;

@RestController
@RequestMapping("/vehiculo")
public class ControladorRest {

	@Autowired
	ManejadorIngresarvehiculo manejadorIngresarvehiculo;
	
	@Autowired
	ManejadorSacarVehiculo manejadorSacarVehiculo;	

	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public void ingresarVehiculo(@Valid @RequestBody ComandoVehiculo comandoVehiculo) {
		manejadorIngresarvehiculo.ingresarVehiculo(comandoVehiculo);
	}
	
	@RequestMapping(value = "/sacar", method = RequestMethod.POST)
	public Vehiculo sacarVehiculo(@RequestParam(name = "placa", required = true) String placa) {
		return manejadorSacarVehiculo.sacarVehiculo(placa);
	}
}
