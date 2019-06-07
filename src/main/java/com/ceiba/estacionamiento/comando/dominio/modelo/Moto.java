package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;

public class Moto extends Vehiculo{
	
	private static final BigDecimal VALOR_HORA = new BigDecimal("500");
	private static final BigDecimal VALOR_DIA = new BigDecimal("4000");	 
	private static final BigDecimal VALOR_ADICIONAL_MOTOS_ALTO_CILINDRAJE = new BigDecimal("2000");
	private static final int ALTO_CILINDRAJE = 500;

	public Moto(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		super(placa, fechaIngreso, cilindraje);
	}

	@Override
	public void validarIngreso() {
		
		Calendar calendario = utilitarioFecha.obtenerCalendario();
		int diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		char primeraLetraPLaca = this.getPlaca().charAt(0);
		
		if(primeraLetraPLaca == 'A' && (diaDeLaSemana != Calendar.MONDAY || diaDeLaSemana != Calendar.SUNDAY)) {
			throw new VehiculoExcepcion(Constantes.DIA_NO_HABIL);
		}
	}

	@Override
	public void calcularValorAPagar() {
		BigDecimal totalPagar;		
		
		int horasDeParqueo = super.obtenerHorasDeParqueo();	
		
		if(horasDeParqueo>=9) {
			totalPagar = obtenerValorPorDias(horasDeParqueo);			
		} else {
			totalPagar = obtenerValorPorHoras(horasDeParqueo);
		}
		
		if(this.getCilindraje() > ALTO_CILINDRAJE) {
			totalPagar = totalPagar.add(VALOR_ADICIONAL_MOTOS_ALTO_CILINDRAJE);
		}
			
		this.setTotalAPagar(totalPagar);
	}	
	
	private BigDecimal obtenerValorPorHoras(int horasDeParqueo) {
		return (VALOR_HORA).multiply(new BigDecimal(horasDeParqueo));
	}
	
	private BigDecimal obtenerValorPorDias(int horasDeParqueo) {
		BigDecimal totalPagarPorDias;
		BigDecimal totalPagarPorHoras;
		int[] tiempoDeParqueo = super.obtenerTiempoDeParqueo(horasDeParqueo);
		totalPagarPorDias = (VALOR_DIA).multiply(new BigDecimal(tiempoDeParqueo[0]));
		totalPagarPorHoras = (VALOR_HORA).multiply(new BigDecimal(tiempoDeParqueo[1]));
		return totalPagarPorDias.add(totalPagarPorHoras);
	}
	
	@Override
	public void validarDiponibilidad() {
		super.validarDiponibilidad();
		int cantidadMotos = vehiculoRepositorio.contarMotosEnParquedero();
		if(cantidadMotos >= 10) {
			throw new VehiculoExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_MOTOS);
		}
	}
}
