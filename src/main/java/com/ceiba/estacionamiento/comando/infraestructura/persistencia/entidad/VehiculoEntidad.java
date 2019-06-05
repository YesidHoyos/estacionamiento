package com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="vehiculo")
public class VehiculoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;
	
	/*@ManyToOne
    @JoinColumn(name = "tipo_vehiculo", nullable=false)
	private TipoVehiculoEntidad tipoVehiculo;*/
	@Column(name = "tipo_vehiculo", nullable = false)
	private int tipoVehiculo;
	
	@Column(nullable = true)
	private String cilindraje;
	
	@Column(nullable = true)
	private String estado;
	
	@Column(name="fecha_salida", nullable = true)
	private String fechaSAlida;
	
	public String getPlaca() {
		return placa;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public VehiculoEntidad(String placa, int tipoVehiculo, String cilindraje, Date fechaIngreso) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
	}
}
