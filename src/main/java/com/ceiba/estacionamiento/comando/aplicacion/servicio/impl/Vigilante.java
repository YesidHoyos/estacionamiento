package com.ceiba.estacionamiento.comando.aplicacion.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.aplicacion.servicio.IVigilante;
import com.ceiba.estacionamiento.comando.dominio.IVehiculoService;
import com.ceiba.estacionamiento.comando.dominio.VehiculoFabrica;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.IVehiculoDao;

@Component
public class Vigilante implements IVigilante {

	@Autowired
	VehiculoFabrica vehiculoFabrica;
	
	@Autowired
	IVehiculoDao vehiculoDao;
	
	IVehiculoService vehiculo = null;
	
	public void setVehiculoFabrica(VehiculoFabrica vehiculoFabrica) {
		this.vehiculoFabrica = vehiculoFabrica;
	}

	@Override
	public void ingresarVehiculo() {
		// TODO Auto-generated method stub
		System.out.println("Ingresando Vehiculo...");
		vehiculo = vehiculoFabrica.getVehiculo("moto");
		vehiculo.validarIngreso();
		//vehiculoDao.save(vehiculo); Builder
	}

	@Override
	public void SacarVehiculo() {
		// TODO Auto-generated method stub
		System.out.println("Sacando vehiculo...");
	}

}
