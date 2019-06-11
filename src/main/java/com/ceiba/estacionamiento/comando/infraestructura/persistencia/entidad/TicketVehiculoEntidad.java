package com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="vehiculo")
public class TicketVehiculoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(name = "fecha_ingreso", nullable = false)
	private LocalDateTime fechaIngreso;
	
	@Column(name = "tipo_vehiculo", nullable = false)
	private int tipoVehiculo;
	
	@Column(nullable = true)
	private int cilindraje;
	
	@Column(nullable = false)
	private String estado = "I";
	
	@Column(name="fecha_salida", nullable = true)
	private LocalDateTime fechaSalida;
	
	public String getPlaca() {
		return placa;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public TicketVehiculoEntidad(String placa, int tipoVehiculo, int cilindraje, LocalDateTime fechaIngreso) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
	}
	
	public TicketVehiculoEntidad() {
		
	}
}
