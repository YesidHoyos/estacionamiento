package com.ceiba.estacionamiento.comando.dominio.repositorio;

import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;

public interface TicketVehiculoRepositorio {

	public void registrarIngresoVehiculo(TicketVehiculo vehiculo);
	
	public TicketVehiculo obtenerVehiculoIngresado(String placa);
	
	public boolean existeVehiculoEnParqueadero(String placa);
	
	public void registrarSalidavehiculo(LocalDateTime fechaSalida, String placa);
	
	public int contarCarrosEnParqueadero();
	
	public int contarMotosEnParquedero();
	
	public void eliminarTodos();
}
