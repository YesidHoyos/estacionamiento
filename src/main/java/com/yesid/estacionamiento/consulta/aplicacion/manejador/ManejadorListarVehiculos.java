package com.yesid.estacionamiento.consulta.aplicacion.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;
import com.yesid.estacionamiento.consulta.dominio.servicio.ServicioObtenerVehiculos;

@Component
public class ManejadorListarVehiculos {

	@Autowired
	ServicioObtenerVehiculos servicioObtenerVehiculos;
	
	public List<DtoTicketVehiculo> obtenerVehiculos() {
		return servicioObtenerVehiculos.obtenerVehiculos();
	}
}
