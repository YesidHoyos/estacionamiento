package com.ceiba.estacionamiento.comando.dominio.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.VehiculoFabrica;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.servicio.IVigilante;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;

@Component
public class Vigilante implements IVigilante {

	@Autowired
	VehiculoFabrica vehiculoFabrica;
	
	@Autowired
	IVehiculoRepositorio vehiculoRepositorio;
	
	public void setVehiculoDao(IVehiculoRepositorio vehiculoDao) {
		this.vehiculoRepositorio = vehiculoDao;
	}
	
	public void setVehiculoFabrica(VehiculoFabrica vehiculoFabrica) {
		this.vehiculoFabrica = vehiculoFabrica;
	}

	@Override
	public void ingresarVehiculo(String tipo, String placa, String cilindraje) {
		
		validarDiponibilidad(tipo);				
		Vehiculo vehiculo = vehiculoFabrica.getVehiculo(tipo, placa, cilindraje);
		vehiculo.validarIngreso();
		vehiculoRepositorio.registrarIngresoVehiculo(vehiculo);
	}

	private void validarDiponibilidad(String tipo) {
		
		if(tipo.equals(Constantes.CARRO)) {
			validarDisponibilidadCarro();
		} else if(tipo.equals(Constantes.MOTO)) {
			validarDisponibilidadMoto();
		}
		else {
			throw new VigilanteExcepcion(Constantes.VEHICULO_NO_PERMITIDO);
		}
	}
	
	private void validarDisponibilidadCarro() {
		int cantidadCarros = vehiculoRepositorio.contarVehiculosEnParqueadero();
		if(cantidadCarros >= 20) {
			throw new VigilanteExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_CARROS);
		}
	}
	
	private void validarDisponibilidadMoto() {
		int cantidadMotos = vehiculoRepositorio.contarMotosEnParquedero();
		if(cantidadMotos >= 10) {
			throw new VigilanteExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_MOTOS);
		}
	}
	
	@Override
	public void sacarVehiculo(String placa) {
		Vehiculo vehiculo = vehiculoRepositorio.obtenerVehiculoIngresado(placa);
		vehiculo.setFechaSalida(new Date());
		vehiculo.obtenerValorAPagar();
		vehiculoRepositorio.registrarSalidavehiculo(vehiculo.getFechaSalida(), placa);		
	}

}
