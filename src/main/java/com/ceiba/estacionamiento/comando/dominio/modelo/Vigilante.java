package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioSacarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

@Component
public class Vigilante implements ServicioIngresarVehiculo, ServicioSacarVehiculo{

	@Autowired
	private IVehiculoRepositorio vehiculoRepositorio;
	
	@Autowired
	private UtilitarioFecha utilitarioFecha;
	
	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {	
		validarIngreso(vehiculo.getPlaca());
		validarDiponibilidadDeParqueo(vehiculo);	
		validarExistenciaEnParqueadero(vehiculo.getPlaca());		
		ingresarAlParquedaero(vehiculo);
	}
	
	@Override
	public Vehiculo sacarVehiculo(String placa) {		
		Vehiculo vehiculo = vehiculoRepositorio.obtenerVehiculoIngresado(placa);
		vehiculo.setFechaSalida(LocalDateTime.now());
		vehiculo.calcularValorAPagar();
		registrarSalidaDeParqueadero(vehiculo);	
		return vehiculo;
	}
	
	private void validarExistenciaEnParqueadero(String placa) {
		if(vehiculoRepositorio.existeVehiculoEnParqueadero(placa)) {
			throw new VehiculoExcepcion(Constantes.VEHICULO_YA_INGRESADO);
		}
	}
	
	private void validarIngreso(String placa) {
		Calendar calendario = utilitarioFecha.obtenerCalendario();
		int diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		char primeraLetraPLaca = placa.charAt(0);
		
		if(primeraLetraPLaca == 'A' && (diaDeLaSemana != Calendar.MONDAY || diaDeLaSemana != Calendar.SUNDAY)) {
			throw new VehiculoExcepcion(Constantes.DIA_NO_HABIL);
		}
	}
	
	private void validarDiponibilidadDeParqueo(Vehiculo vehiculo) {		
		if(vehiculo instanceof Carro) {
			validarDiponibilidadParaCarro();
			
		} else if(vehiculo instanceof Moto) {
			validarDiponibilidadParaMoto();
		}
		else {
			throw new VehiculoExcepcion(Constantes.VEHICULO_NO_PERMITIDO);
		}
	}
	
	private void validarDiponibilidadParaMoto() {
		int cantidadMotos = vehiculoRepositorio.contarMotosEnParquedero();
		if(cantidadMotos >= 10) {
			throw new VehiculoExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_MOTOS);
		}
	}
	
	private void validarDiponibilidadParaCarro() {
		int cantidadCarros = vehiculoRepositorio.contarCarrosEnParqueadero();
		if(cantidadCarros >= 20) {
			throw new VehiculoExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_CARROS);
		}
	}
	
	private void ingresarAlParquedaero(Vehiculo vehiculo) {
		vehiculoRepositorio.registrarIngresoVehiculo(vehiculo);
	}
	
	private void registrarSalidaDeParqueadero(Vehiculo vehiculo) {
		vehiculoRepositorio.registrarSalidavehiculo(vehiculo.getFechaSalida(), vehiculo.getPlaca());
	}
}
