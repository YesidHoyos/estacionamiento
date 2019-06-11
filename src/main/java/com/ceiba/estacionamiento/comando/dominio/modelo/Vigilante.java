package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.repositorio.TicketVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.servicio.ServicioSacarVehiculo;
import com.ceiba.estacionamiento.comando.dominio.utilitario.TipoVehiculo;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Fecha;

@Component
public class Vigilante implements ServicioIngresarVehiculo, ServicioSacarVehiculo {

	private static final int NUMERO_MAXIMO_CARROS = 20;

	private static final int NUMERO_MAXIMO_MOTOS = 10;

	private static final char PRIMERA_LETRA_PLACA_NO_VALIDA = 'A';

	public static final String SIN_ESPACIO_DISPONIBLE_CARROS = "No hay disponibilidad de parqueo para carros";
	public static final String SIN_ESPACIO_DISPONIBLE_MOTOS = "No hay disponibilidad de parqueo para motos";
	public static final String VEHICULO_NO_PERMITIDO = "El tipo de vehiculo no es permitido";
	public static final String DIA_NO_HABIL = "No se permite el ingreso del vehiculo en día no habil";
	public static final String VEHICULO_YA_INGRESADO = "El vehiculo  ya fue ingresado al parqueadero";

	@Autowired
	private TicketVehiculoRepositorio vehiculoRepositorio;

	@Autowired
	private Fecha utilitarioFecha;

	@Override
	public void ingresarVehiculo(TicketVehiculo vehiculo) {
		validarIngreso(vehiculo.getPlaca());
		validarDiponibilidadDeParqueo(vehiculo);
		validarExistenciaEnParqueadero(vehiculo.getPlaca());
		ingresarAlParquedaero(vehiculo);
	}

	@Override
	public TicketVehiculo sacarVehiculo(String placa) {
		TicketVehiculo vehiculo = vehiculoRepositorio.obtenerVehiculoIngresado(placa);
		vehiculo.setFechaSalida(LocalDateTime.now());
		vehiculo.calcularValorAPagar();
		registrarSalidaDeParqueadero(vehiculo);
		return vehiculo;
	}

	private void validarExistenciaEnParqueadero(String placa) {
		if (vehiculoRepositorio.existeVehiculoEnParqueadero(placa)) {
			throw new VigilanteExcepcion(VEHICULO_YA_INGRESADO);
		}
	}

	private void validarIngreso(String placa) {
		Calendar fechaActual = utilitarioFecha.obtenerFechaActual();
		int diaDeLaSemana = fechaActual.get(Calendar.DAY_OF_WEEK);
		char primeraLetraPLaca = placa.charAt(0);

		if (primeraLetraPLaca == PRIMERA_LETRA_PLACA_NO_VALIDA && !esDiaHabil(diaDeLaSemana)) {
			throw new VigilanteExcepcion(DIA_NO_HABIL);
		}
	}

	private boolean esDiaHabil(int diaDeLaSemana) {
		return diaDeLaSemana == Calendar.MONDAY || diaDeLaSemana == Calendar.SUNDAY;
	}

	private void validarDiponibilidadDeParqueo(TicketVehiculo vehiculo) {
		if (vehiculo instanceof TicketCarro) {
			validarDiponibilidadParaCarro();

		} else if (vehiculo instanceof TicketMoto) {
			validarDiponibilidadParaMoto();
		} else {
			throw new VigilanteExcepcion(VEHICULO_NO_PERMITIDO);
		}
	}

	private void validarDiponibilidadParaMoto() {
		int cantidadMotos = vehiculoRepositorio.contarMotosEnParquedero();
		if (cantidadMotos >= NUMERO_MAXIMO_MOTOS) {
			throw new VigilanteExcepcion(SIN_ESPACIO_DISPONIBLE_MOTOS);
		}
	}

	private void validarDiponibilidadParaCarro() {
		int cantidadCarros = vehiculoRepositorio.contarCarrosEnParqueadero();
		if (cantidadCarros >= NUMERO_MAXIMO_CARROS) {
			throw new VigilanteExcepcion(SIN_ESPACIO_DISPONIBLE_CARROS);
		}
	}

	private void ingresarAlParquedaero(TicketVehiculo vehiculo) {
		vehiculoRepositorio.registrarIngresoVehiculo(vehiculo);
	}

	private void registrarSalidaDeParqueadero(TicketVehiculo vehiculo) {
		vehiculoRepositorio.registrarSalidavehiculo(vehiculo.getFechaSalida(), vehiculo.getPlaca());
	}
}
