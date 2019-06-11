package com.ceiba.estacionamiento.consulta.infraestructura.persistencia.entidad;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "vehiculo")
public class TicketVehiculoEntidad {
	
	@Id
	private long id;

	@Column
	private String placa;
	
	@Column(name = "tipo_vehiculo")
	private int tipo;
	
	@Column(name = "fecha_ingreso")
	private LocalDateTime fechaIngreso;
	
	public String getPlaca() {
		return placa;
	}

	public int getTipo() {
		return tipo;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

}
