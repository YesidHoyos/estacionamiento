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
	TicketVehiculoJPA ticketVehiculoJPA;
	
	@Autowired
	TicketVehiculoBuilder ticketVehiculoBuilder;
	
	public void setVehiculoJPA(TicketVehiculoJPA ticketVehiculoJPA) {
		this.ticketVehiculoJPA = ticketVehiculoJPA;
	}

	@Override
	public void registrarIngresoVehiculo(TicketVehiculo ticketVehiculo) {
		ticketVehiculoJPA.save(ticketVehiculoBuilder.convertirAEntidad(ticketVehiculo));
	}
	
	@Override
	public TicketVehiculo obtenerVehiculoIngresado(String placa) {
		return ticketVehiculoBuilder.convertirADominio(ticketVehiculoJPA.buscarPorPlaca(placa));
	}
	
	@Override
	public boolean existeVehiculoEnParqueadero(String placa) {
		return (ticketVehiculoJPA.existeVehiculoEnParqueadero(placa) == "true");
	}
	
	@Override
	public void registrarSalidaVehiculo(LocalDateTime fechaSalida, String placa) {
		ticketVehiculoJPA.retirarVehiculo(fechaSalida, placa);
	}
	
	@Override
	public int contarCarrosEnParqueadero() {
		return ticketVehiculoJPA.countVehiculosTipoCarro();
	}
	
	@Override
	public int contarMotosEnParquedero() {
		return ticketVehiculoJPA.countVehiculosTipoMoto();
	}
	
	@Override
	public void eliminarTodos() {
		ticketVehiculoJPA.deleteAll();
	}
}
