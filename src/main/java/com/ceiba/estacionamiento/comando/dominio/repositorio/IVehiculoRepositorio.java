package com.ceiba.estacionamiento.comando.dominio.repositorio;

import java.util.Date;

import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;

public interface IVehiculoRepositorio {

	public void registrarIngresoVehiculo(Vehiculo vehiculo);
	
	public Vehiculo obtenerVehiculoIngresado(String placa);
	
	public boolean existeVehiculoEnParqueadero(String placa);
	
	public void registrarSalidavehiculo(Date fechaSalida, String placa);
	
	public int contarVehiculosEnParqueadero();
	
	public int contarMotosEnParquedero();
	
	public void eliminarTodos();
}
