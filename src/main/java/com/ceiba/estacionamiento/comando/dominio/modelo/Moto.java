package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Moto extends Vehiculo{
	
	private static final BigDecimal VALOR_HORA = new BigDecimal(500);
	private static final BigDecimal VALOR_DIA = new BigDecimal(4000);	 
	private static final BigDecimal VALOR_ADICIONAL_MOTOS_ALTO_CILINDRAJE = new BigDecimal("2000");
	private static final int ALTO_CILINDRAJE = 500;

	public Moto(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		super(placa, fechaIngreso, cilindraje);
	}
	
	public Moto(String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, int cilindraje) {
		super(placa, fechaIngreso, fechaSalida, cilindraje);
	}

	@Override
	public void calcularValorAPagar() {
		BigDecimal totalPagar;		
		
		int horasDeParqueo = super.obtenerHorasDeParqueo();	
		if(horasDeParqueo>=9) {
			totalPagar = super.obtenerValorPorDias(horasDeParqueo, VALOR_DIA, VALOR_HORA);			
		} else {	
			totalPagar = super.obtenerValorPorHoras(horasDeParqueo, VALOR_HORA);
		}
		
		if(this.getCilindraje() > ALTO_CILINDRAJE) {
			totalPagar = totalPagar.add(VALOR_ADICIONAL_MOTOS_ALTO_CILINDRAJE);
		}
			
		this.setTotalAPagar(totalPagar);
	}	
}
