package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.builder.VehiculoBuilder;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.jpa.IVehiculoJPA;

@Component
public class VehiculoDao implements IVehiculoRepositorio{
	
	@Autowired
	IVehiculoJPA vehiculoJPA;
	
	public void setVehiculoJPA(IVehiculoJPA vehiculoJPA) {
		this.vehiculoJPA = vehiculoJPA;
	}

	@Override
	public void registrarIngresoVehiculo(Vehiculo vehiculo) {
		vehiculoJPA.save(VehiculoBuilder.convertirAEntidad(vehiculo));
	}
	
	@Override
	public Vehiculo obtenerVehiculoIngresado(String placa) {
		return VehiculoBuilder.convertirADominio(vehiculoJPA.findByPlaca(placa));
	}
	
	@Override
	public boolean existeVehiculoEnParqueadero(String placa) {
		return (vehiculoJPA.existeVehiculoEnParqueadero(placa) == 1);
	}
	
	@Override
	public void registrarSalidavehiculo(Date fechaSalida, String placa) {
		vehiculoJPA.retirarVehiculo(fechaSalida, placa);
	}
	
	@Override
	public int contarVehiculosEnParqueadero() {
		return vehiculoJPA.countVehiculosTipoCarro();
	}
	
	@Override
	public int contarMotosEnParquedero() {
		return vehiculoJPA.countVehiculosTipoMoto();
	}
	
	@Override
	public void eliminarTodos() {
		vehiculoJPA.deleteAll();
	}
}
