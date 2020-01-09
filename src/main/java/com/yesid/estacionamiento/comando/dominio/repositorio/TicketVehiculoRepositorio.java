package com.yesid.estacionamiento.comando.dominio.repositorio;

import java.time.LocalDateTime;

import com.yesid.estacionamiento.comando.dominio.modelo.TicketVehiculo;

public interface TicketVehiculoRepositorio {

	public void registrarIngresoVehiculo(TicketVehiculo ticketVehiculo);
	
	public TicketVehiculo obtenerVehiculoIngresado(String placa);
	
	public boolean existeVehiculoEnParqueadero(String placa);
	
	public void registrarSalidaVehiculo(LocalDateTime fechaSalida, String placa);
	
	public int contarCarrosEnParqueadero();
	
	public int contarMotosEnParquedero();
	
	public void eliminarTodos();
}
