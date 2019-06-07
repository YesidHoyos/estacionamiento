package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.VehiculoEntidad;

public interface IVehiculoJPA extends CrudRepository<VehiculoEntidad, Long>{

	@Query(nativeQuery = true, value = "select * from vehiculo where placa = ?1 and estado = 'I'")
	VehiculoEntidad buscarPorPlaca(String placa);
	
	@Query(nativeQuery = true, value = "select 'true' from vehiculo where placa = ?1 and estado = 'I'")
	String existeVehiculoEnParqueadero(String placa);
	
	@Query(nativeQuery = true, value = "select count(1) from vehiculo where tipo_vehiculo = 1 and estado = 'I'")
	int countVehiculosTipoCarro();
	
	@Query(nativeQuery = true, value = "select count(1) from vehiculo where tipo_vehiculo = 2  and estado = 'I'")
	int countVehiculosTipoMoto();
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update vehiculo set estado = 'R', fecha_salida = ?1 where placa = ?2 and estado <> 'R'")
	void retirarVehiculo(LocalDateTime fechaSalida, String placa);
}
