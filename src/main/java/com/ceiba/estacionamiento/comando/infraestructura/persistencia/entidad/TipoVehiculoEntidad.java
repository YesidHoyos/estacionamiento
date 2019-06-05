package com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tipo_vehiculo")
public class TipoVehiculoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String descripcion;
}
