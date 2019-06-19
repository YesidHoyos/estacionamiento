package com.ceiba.estacionamiento.comando.infraestructura.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoTicketVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorIngresarvehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.manejador.ManejadorSacarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;

@RestController
@RequestMapping("/parqueadero")
@CrossOrigin(origins = "*")
public class ComandoControladorVigilante {

	@Autowired
	ManejadorIngresarvehiculo manejadorIngresarvehiculo;
	
	@Autowired
	ManejadorSacarVehiculo manejadorSacarVehiculo;	

	@PostMapping(value = "/vehiculos")
	public ComandoTicketVehiculo ingresarVehiculo(@Valid @RequestBody ComandoVehiculo comandoVehiculo) {
		return manejadorIngresarvehiculo.ingresarVehiculo(comandoVehiculo);
	}
	
	@PutMapping(value = "/vehiculos/{placa}")
	public TicketVehiculo sacarVehiculo(@PathVariable("placa") String placa) {
		return manejadorSacarVehiculo.sacarVehiculo(placa);
	}
}
