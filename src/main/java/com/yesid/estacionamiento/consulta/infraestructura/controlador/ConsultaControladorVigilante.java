package com.yesid.estacionamiento.consulta.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yesid.estacionamiento.consulta.aplicacion.manejador.ManejadorListarVehiculos;
import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;

@RestController
@RequestMapping("/parqueadero")
@CrossOrigin(origins = "*")
public class ConsultaControladorVigilante {
	
	@Autowired
	ManejadorListarVehiculos manejadorListarVehiculos;

	@GetMapping(value = "/vehiculos")
	public List<DtoTicketVehiculo> obtenerVehiculos() {
		return manejadorListarVehiculos.obtenerVehiculos();
	}
}
