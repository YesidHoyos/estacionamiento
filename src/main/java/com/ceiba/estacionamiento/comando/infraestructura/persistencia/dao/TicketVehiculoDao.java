package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.repositorio.TicketVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.builder.TicketVehiculoBuilder;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.jpa.TicketVehiculoJPA;

@Component
public class TicketVehiculoDao implements TicketVehiculoRepositorio{
	
	@Autowired
	TicketVehiculoJPA vehiculoJPA;
	
	@Autowired
	TicketVehiculoBuilder vehiculoBuilder;
	
	public void setVehiculoJPA(TicketVehiculoJPA vehiculoJPA) {
		this.vehiculoJPA = vehiculoJPA;
	}

	@Override
	public void registrarIngresoVehiculo(TicketVehiculo vehiculo) {
		vehiculoJPA.save(vehiculoBuilder.convertirAEntidad(vehiculo));
	}
	
	@Override
	public TicketVehiculo obtenerVehiculoIngresado(String placa) {
		return vehiculoBuilder.convertirADominio(vehiculoJPA.buscarPorPlaca(placa));
	}
	
	@Override
	public boolean existeVehiculoEnParqueadero(String placa) {
		return (vehiculoJPA.existeVehiculoEnParqueadero(placa) == "true");
	}
	
	@Override
	public void registrarSalidavehiculo(LocalDateTime fechaSalida, String placa) {
		vehiculoJPA.retirarVehiculo(fechaSalida, placa);
	}
	
	@Override
	public int contarCarrosEnParqueadero() {
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
