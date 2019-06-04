package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.VehiculoEntidad;

public interface IVehiculoDao extends CrudRepository<VehiculoEntidad, Long>{

	VehiculoEntidad findByPlaca(String placa);
	
	/*@Query("select count(tipo_vehiculo) from vehiculo where tipo_vehiculo = 1")
	int countVehiculosTipoCarro();*/
	
	/*@Query("select count(tipo_vehiculo) from vehiculo where tipo_vehiculo = 2")
	int countVehiculosTipoMoto();*/
}
