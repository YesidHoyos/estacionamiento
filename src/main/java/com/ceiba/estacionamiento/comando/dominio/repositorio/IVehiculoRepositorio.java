package com.ceiba.estacionamiento.comando.dominio.repositorio;

import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;

public interface IVehiculoRepositorio {

	public void registrarIngresoVehiculo(Vehiculo vehiculo);
	
	public Vehiculo obtenerVehiculoIngresado(String placa);
	
	public boolean existeVehiculoEnParqueadero(String placa);
	
	public void registrarSalidavehiculo(LocalDateTime fechaSalida, String placa);
	
	public int contarCarrosEnParqueadero();
	
	public int contarMotosEnParquedero();
	
	public void eliminarTodos();
}
