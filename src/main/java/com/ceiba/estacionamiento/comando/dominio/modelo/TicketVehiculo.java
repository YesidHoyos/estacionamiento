package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import com.ceiba.estacionamiento.comando.dominio.utilitario.TiempoTranscurrido;

public abstract class TicketVehiculo {

	private static final double SEGUNDOS_EN_UNA_HORA = 3600d;
	private static final int VEINTICUATRO_HORAS = 24;
	protected static final int LIMITE_COBRO_POR_HORAS = 9;
	
	private String placa;
	private int cilindraje;
	private LocalDateTime fechaIngreso;	
	private LocalDateTime fechaSalida;
	private BigDecimal totalAPagar;			

	public TicketVehiculo(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.cilindraje = cilindraje;
	}
	
	public TicketVehiculo(String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, int cilindraje) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cilindraje = cilindraje;
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

	public abstract void calcularValorAPagar();
	
	public int obtenerHorasDeParqueo() {
		Duration duracion = Duration.between(this.getFechaIngreso(), this.getFechaSalida());
		long duracionSegundos = duracion.getSeconds();
		return (int)Math.ceil((double)duracionSegundos / SEGUNDOS_EN_UNA_HORA);
	}
	
	public TiempoTranscurrido obtenerTiempoDeParqueo(int horasDeParqueo) {
		int dias;
		int horas = 0;
		TiempoTranscurrido tiempoTranscurrido = new TiempoTranscurrido();

		if(horasDeParqueo<VEINTICUATRO_HORAS) {			
			dias = 1;			
		} else {
			horas = horasDeParqueo % VEINTICUATRO_HORAS;
			
			if(horas==0) {
				dias = horasDeParqueo / VEINTICUATRO_HORAS;
				
			} else {				
				dias = (horasDeParqueo - horas) / VEINTICUATRO_HORAS;	
				
				if(horas>=LIMITE_COBRO_POR_HORAS) {
					dias++;
					horas = 0;
				} 
			}
		}
		tiempoTranscurrido.setDias(dias);
		tiempoTranscurrido.setHoras(horas);
		return tiempoTranscurrido;
	}
	
	protected BigDecimal obtenerValorPorDias(int horasDeParqueo, BigDecimal valorDia, BigDecimal valorHora) {
		BigDecimal totalPagarPorDias;
		BigDecimal totalPagarPorHoras;
		TiempoTranscurrido tiempoDeParqueo = obtenerTiempoDeParqueo(horasDeParqueo);
		totalPagarPorDias = (valorDia).multiply(new BigDecimal(tiempoDeParqueo.getDias()));
		totalPagarPorHoras = (valorHora).multiply(new BigDecimal(tiempoDeParqueo.getHoras()));
		return totalPagarPorDias.add(totalPagarPorHoras);
	}
	
	protected BigDecimal obtenerValorPorHoras(int horasDeParqueo, BigDecimal valorHora) {
		return (valorHora).multiply(new BigDecimal(horasDeParqueo));
	}
	
}
