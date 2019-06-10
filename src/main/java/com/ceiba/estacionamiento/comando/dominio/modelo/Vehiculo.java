package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Vehiculo {

	private static final int VEINTICUATRO_HORAS = 24;
	
	private String placa;
	private int cilindraje;
	private LocalDateTime fechaIngreso;	
	private LocalDateTime fechaSalida;
	private BigDecimal totalAPagar;			

	public Vehiculo(String placa, LocalDateTime fechaIngreso, int cilindraje) {
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.cilindraje = cilindraje;
	}
	
	public Vehiculo(String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, int cilindraje) {
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
		return (int)Math.ceil((double)duracionSegundos / 3600d);
	}
	
	public int[] obtenerTiempoDeParqueo(int horasDeParqueo) {
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
