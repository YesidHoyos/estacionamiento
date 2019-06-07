package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

public abstract class Vehiculo {

	private static final int VEINTICUATRO_HORAS = 24;
	
	private String placa;
	private int cilindraje;
	private LocalDateTime fechaIngreso;	
	private LocalDateTime fechaSalida;
	private BigDecimal totalAPagar;			

	protected UtilitarioFecha utilitarioFecha;
	protected IVehiculoRepositorio vehiculoRepositorio;

	public Vehiculo(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.cilindraje = cilindraje;
	}	

	public void setUtilitarioFecha(UtilitarioFecha utilitarioFecha) {
		this.utilitarioFecha = utilitarioFecha;
	}
	
	public void setVehiculoRepositorio(IVehiculoRepositorio vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public void setTotalAPagar(BigDecimal totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	
	public BigDecimal getTotalAPagar() {
		return totalAPagar;
	}
	
	public void validarIngreso() {
		Calendar calendario = utilitarioFecha.obtenerCalendario();
		int diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		char primeraLetraPLaca = this.getPlaca().charAt(0);
		
		if(primeraLetraPLaca == 'A' && (diaDeLaSemana != Calendar.MONDAY || diaDeLaSemana != Calendar.SUNDAY)) {
			throw new VehiculoExcepcion(Constantes.DIA_NO_HABIL);
		}
	}
	
	public void validarExistenciaEnParqueadero() {
		if(vehiculoRepositorio.existeVehiculoEnParqueadero(this.getPlaca())) {
			throw new VehiculoExcepcion(Constantes.VEHICULO_YA_INGRESADO);
		}
	}
	
	public void validarDiponibilidad() {		
		if(!(this instanceof Carro || this instanceof Moto)) {
			throw new VehiculoExcepcion(Constantes.VEHICULO_NO_PERMITIDO);
		}
	}
	
	public void ingresarAlParquedaero() {
		vehiculoRepositorio.registrarIngresoVehiculo(this);
	}	
	
	public void registrarSalidaDeParqueadero() {
		vehiculoRepositorio.registrarSalidavehiculo(this.getFechaSalida(), this.getPlaca());
	}

	public abstract void calcularValorAPagar();
	
	protected int obtenerHorasDeParqueo() {
		Duration duracion = Duration.between(this.getFechaIngreso(), this.getFechaSalida());
		long duracionSegundos = duracion.getSeconds();
		return (int)Math.ceil((double)duracionSegundos / 3600d);
	}
	
	protected int[] obtenerTiempoDeParqueo(int horasDeParqueo) {
		int dias = 0;
		int horas = 0;
		int[] tiempoDeParqueo = new int[2];

		if(horasDeParqueo<VEINTICUATRO_HORAS) {			
			dias = 1;
			
		} else {
			horas = horasDeParqueo % VEINTICUATRO_HORAS;
			
			if(horas==0) {
				dias = horasDeParqueo / VEINTICUATRO_HORAS;
				
			} else {				
				dias = (horasDeParqueo - horas) / VEINTICUATRO_HORAS;	
				
				if(horas>=9) {
					dias++;
					horas = 0;
				} 
			}
		}
		tiempoDeParqueo[0] = dias;
		tiempoDeParqueo[1] = horas;
		return tiempoDeParqueo;
	}
	
}
