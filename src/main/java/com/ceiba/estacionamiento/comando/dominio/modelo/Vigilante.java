package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioSacarVehiculo;

@Component
public class Vigilante implements ServicioIngresarVehiculo, ServicioSacarVehiculo{

	@Autowired
	protected IVehiculoRepositorio vehiculoRepositorio;
	
	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {		
		vehiculo.validarDiponibilidad();	
		vehiculo.validarExistenciaEnParqueadero();
		vehiculo.validarIngreso();
		vehiculo.ingresarAlParquedaero();
	}
	
	@Override
	public Vehiculo sacarVehiculo(String placa) {		
		Vehiculo vehiculo = vehiculoRepositorio.obtenerVehiculoIngresado(placa);
		vehiculo.setFechaSalida(LocalDateTime.now());
		vehiculo.calcularValorAPagar();
		vehiculo.registrarSalidaDeParqueadero();	
		return vehiculo;
	}

}
