package com.ceiba.estacionamiento.consulta.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.consulta.aplicacion.manejador.ManejadorListarVehiculos;
import com.ceiba.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;

@RestController
public class ConsultaControladorVigilante {
	
	@Autowired
	ManejadorListarVehiculos manejadorListarVehiculos;

	@GetMapping(value = "/vehiculos")
	public List<DtoTicketVehiculo> obtenerVehiculos() {
		return manejadorListarVehiculos.obtenerVehiculos();
	}
}
