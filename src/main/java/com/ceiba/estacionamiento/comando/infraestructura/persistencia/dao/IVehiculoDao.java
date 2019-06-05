package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao;

import com.ceiba.estacionamiento.comando.dominio.IVehiculoService;

public interface IVehiculoDao {

	public void registrarIngresoVehiculo(IVehiculoService vehiculo);
	
	public IVehiculoService obtenerVehiculoIngresado(String placa);
	
	public boolean existeVehiculoEnParqueadero(String placa);
	
	public void registrarSalidavehiculo(String placa);
	
	public int contarVehiculosEnParqueadero();
	
	public int contarMotosEnParquedero();
	
	public void eliminarTodos();
}
