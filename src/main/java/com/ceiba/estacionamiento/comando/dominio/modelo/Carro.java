package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;


public class Carro extends Vehiculo{
	
	private static final BigDecimal VALOR_HORA = new BigDecimal("1000");
	private static final BigDecimal VALOR_DIA = new BigDecimal("8000");	
	
	public Carro(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		super(placa, fechaIngreso, cilindraje);
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
		int cantidadCarros = vehiculoRepositorio.contarVehiculosEnParqueadero();
		if(cantidadCarros >= 20) {
			throw new VehiculoExcepcion(Constantes.SIN_ESPACIO_DISPONIBLE_CARROS);
		}
	}
}
