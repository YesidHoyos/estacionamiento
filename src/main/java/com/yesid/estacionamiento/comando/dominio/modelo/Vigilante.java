package com.yesid.estacionamiento.comando.dominio.modelo;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yesid.estacionamiento.comando.dominio.excepcion.DiaNoHabilExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.EspacioNoDiponibleExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.NoExisteExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.NoPermitidoExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.YaIngresadoExcepcion;
import com.yesid.estacionamiento.comando.dominio.repositorio.TicketVehiculoRepositorio;
import com.yesid.estacionamiento.comando.dominio.servicio.ServicioIngresarVehiculo;
import com.yesid.estacionamiento.comando.dominio.servicio.ServicioSacarVehiculo;
import com.yesid.estacionamiento.comando.dominio.utilitario.Fecha;

@Component
public class Vigilante implements ServicioIngresarVehiculo, ServicioSacarVehiculo {

	private static final int NUMERO_MAXIMO_CARROS = 20;

	private static final int NUMERO_MAXIMO_MOTOS = 10;

	private static final char PRIMERA_LETRA_PLACA_NO_VALIDA = 'A';

	public static final String SIN_ESPACIO_DISPONIBLE_CARROS = "No hay disponibilidad de parqueo para carros";
	public static final String SIN_ESPACIO_DISPONIBLE_MOTOS = "No hay disponibilidad de parqueo para motos";
	public static final String VEHICULO_NO_PERMITIDO = "El tipo de vehiculo no es permitido";
	public static final String DIA_NO_HABIL = "No se permite el ingreso del vehiculo en día no habil";
	public static final String VEHICULO_YA_INGRESADO = "El vehiculo ya fue ingresado al parqueadero";
	public static final String VEHICULO_NO_EXISTENTE = "El vehiculo no existe en el parqueadero";

	@Autowired
	private TicketVehiculoRepositorio ticketVehiculoRepositorio;

	@Autowired
	private Fecha fecha;

	@Override
	public TicketVehiculo ingresarVehiculo(TicketVehiculo ticketVehiculo) {
		validarIngreso(ticketVehiculo.getPlaca());
		validarDiponibilidadDeParqueo(ticketVehiculo);
		validarExistenciaEnParqueadero(ticketVehiculo.getPlaca());
		ingresarAlParquedaero(ticketVehiculo);
		return ticketVehiculo;
	}

	@Override
	public TicketVehiculo sacarVehiculo(String placa) {
		TicketVehiculo ticketVehiculo = ticketVehiculoRepositorio.obtenerVehiculoIngresado(placa);
		if(ticketVehiculo == null) {
			throw new NoExisteExcepcion(VEHICULO_NO_EXISTENTE);
		}
		ticketVehiculo.setFechaSalida(LocalDateTime.now());
		ticketVehiculo.calcularValorAPagar();
		registrarSalidaDeParqueadero(ticketVehiculo);
		return ticketVehiculo;
	}

	private void validarExistenciaEnParqueadero(String placa) {
		if (ticketVehiculoRepositorio.existeVehiculoEnParqueadero(placa)) {
			throw new YaIngresadoExcepcion(VEHICULO_YA_INGRESADO);
		}
	}

	private void validarIngreso(String placa) {
		Calendar fechaActual = fecha.obtenerFechaActual();
		int diaDeLaSemana = fechaActual.get(Calendar.DAY_OF_WEEK);
		char primeraLetraPLaca = placa.charAt(0);

		if (primeraLetraPLaca == PRIMERA_LETRA_PLACA_NO_VALIDA && !esDiaHabil(diaDeLaSemana)) {
			throw new DiaNoHabilExcepcion(DIA_NO_HABIL);
		}
	}

	private boolean esDiaHabil(int diaDeLaSemana) {
		return diaDeLaSemana == Calendar.MONDAY || diaDeLaSemana == Calendar.SUNDAY;
	}

	private void validarDiponibilidadDeParqueo(TicketVehiculo ticketVehiculo) {
		if (ticketVehiculo instanceof TicketCarro) {
			validarDiponibilidadParaCarro();

		} else if (ticketVehiculo instanceof TicketMoto) {
			validarDiponibilidadParaMoto();
		} else {
			throw new NoPermitidoExcepcion(VEHICULO_NO_PERMITIDO);
		}
	}

	private void validarDiponibilidadParaMoto() {
		int cantidadMotos = ticketVehiculoRepositorio.contarMotosEnParquedero();
		if (cantidadMotos >= NUMERO_MAXIMO_MOTOS) {
			throw new EspacioNoDiponibleExcepcion(SIN_ESPACIO_DISPONIBLE_MOTOS);
		}
	}

	private void validarDiponibilidadParaCarro() {
		int cantidadCarros = ticketVehiculoRepositorio.contarCarrosEnParqueadero();
		if (cantidadCarros >= NUMERO_MAXIMO_CARROS) {
			throw new EspacioNoDiponibleExcepcion(SIN_ESPACIO_DISPONIBLE_CARROS);
		}
	}

	private void ingresarAlParquedaero(TicketVehiculo ticketVehiculo) {
		ticketVehiculoRepositorio.registrarIngresoVehiculo(ticketVehiculo);
	}

	private void registrarSalidaDeParqueadero(TicketVehiculo ticketVehiculo) {
		ticketVehiculoRepositorio.registrarSalidaVehiculo(ticketVehiculo.getFechaSalida(), ticketVehiculo.getPlaca());
	}
}
