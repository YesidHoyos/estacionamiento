package com.ceiba.estacionamiento.comando.dominio.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.IVehiculoService;
import com.ceiba.estacionamiento.comando.dominio.VehiculoFabrica;
import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.servicio.IVigilante;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.IVehiculoDao;

@Component
public class Vigilante implements IVigilante {

	@Autowired
	VehiculoFabrica vehiculoFabrica;
	
	@Autowired
	IVehiculoDao vehiculoDao;
	
	@Autowired
	private UtilitarioFecha utilitarioFecha;
	
	IVehiculoService vehiculo = null;
	
	public void setVehiculoDao(IVehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}
	
	public void setVehiculoFabrica(VehiculoFabrica vehiculoFabrica) {
		this.vehiculoFabrica = vehiculoFabrica;
	}

	@Override
	public void ingresarVehiculo(String tipo, String placa, String cilindraje) {
		
		validarDiponibilidad(tipo);				
		vehiculo = vehiculoFabrica.getVehiculo(tipo, placa, cilindraje);
		vehiculo.setUtilitarioFecha(utilitarioFecha);
		vehiculo.validarIngreso();
		vehiculoDao.registrarIngresoVehiculo(vehiculo);
	}

	private void validarDiponibilidad(String tipo) {
		
		if(tipo == Constantes.CARRO) {
			validarDisponibilidadCarro();
		} else if(tipo == Constantes.MOTO) {
			validarDisponibilidadMoto();
		}
		else {
			throw new VigilanteExcepcion(Constantes.VEHICULO_NO_PERMITIDO);
		}
	}
	
	private void validarDisponibilidadCarro() {
		int cantidadCarros = vehiculoDao.contarVehiculosEnParqueadero();
		if(cantidadCarros >= 20) {
			throw new VigilanteExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_CARROS);
		}
	}
	
	private void validarDisponibilidadMoto() {
		int cantidadMotos = vehiculoDao.contarMotosEnParquedero();
		if(cantidadMotos >= 10) {
			throw new VigilanteExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_MOTOS);
		}
	}
	
	@Override
	public void SacarVehiculo(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Sacando vehiculo...");
	}

}
