package com.ceiba.estacionamiento.comando.infraestructura.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorIngresarvehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorSacarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;

@RestController
@RequestMapping("/vehiculo")
public class ComandoControladorVigilante {

	@Autowired
	ManejadorIngresarvehiculo manejadorIngresarvehiculo;
	
	@Autowired
	ManejadorSacarVehiculo manejadorSacarVehiculo;	

	@PostMapping(value = "/ingresar")
	public void ingresarVehiculo(@Valid @RequestBody ComandoTicketVehiculo comandoVehiculo) {
		manejadorIngresarvehiculo.ingresarVehiculo(comandoVehiculo);
	}
	
	@PostMapping(value = "/sacar")
	public TicketVehiculo sacarVehiculo(@RequestParam(name = "placa", required = true) String placa) {
		return manejadorSacarVehiculo.sacarVehiculo(placa);
	}
}
