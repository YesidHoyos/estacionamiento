package com.yesid.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketCarro extends TicketVehiculo{
	
	private static final BigDecimal VALOR_HORA = new BigDecimal("1000");
	private static final BigDecimal VALOR_DIA = new BigDecimal("8000");	
	
	public TicketCarro(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		super(placa, fechaIngreso, cilindraje);
	}
	
	public TicketCarro(String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, int cilindraje) {
		super(placa, fechaIngreso, fechaSalida, cilindraje);
	}

	@Override
	public void calcularValorAPagar() {
		BigDecimal totalPagar;
		
		int horasDeParqueo = super.obtenerHorasDeParqueo();	
		
		if(horasDeParqueo>=LIMITE_COBRO_POR_HORAS) {
			totalPagar = super.obtenerValorPorDias(horasDeParqueo, VALOR_DIA, VALOR_HORA);
		} else {
			totalPagar = super.obtenerValorPorHoras(horasDeParqueo, VALOR_HORA);
		}
		this.setTotalAPagar(totalPagar);
	}	
}
