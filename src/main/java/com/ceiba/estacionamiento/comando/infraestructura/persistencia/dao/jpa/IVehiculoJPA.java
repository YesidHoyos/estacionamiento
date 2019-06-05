package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.VehiculoEntidad;

public interface IVehiculoJPA extends CrudRepository<VehiculoEntidad, Long>{

	VehiculoEntidad findByPlaca(String placa);
	
	@Query(nativeQuery = true, value = "select 1 from vehiculo where placa = ?1 and estado <> 'R'")
	int existeVehiculoEnParqueadero(String placa);
	
	@Query(nativeQuery = true, value = "select count(1) from vehiculo where tipo_vehiculo = 1 and estado <> 'R'")
	int countVehiculosTipoCarro();
	
	@Query(nativeQuery = true, value = "select count(1) from vehiculo where tipo_vehiculo = 2 and estado <> 'R'")
	int countVehiculosTipoMoto();
	
	@Modifying
	@Query(nativeQuery = true, value = "update vehiculo set estado = 'R' where placa = ?1 and estado <> 'R'")
	void retirarVehiculo(String placa);
}
