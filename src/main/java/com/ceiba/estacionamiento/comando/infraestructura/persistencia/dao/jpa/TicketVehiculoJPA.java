package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.jpa;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.estacionamiento.comando.infraestructura.persistencia.entidad.TicketVehiculoEntidad;

public interface TicketVehiculoJPA extends CrudRepository<TicketVehiculoEntidad, Long>{

	@Query(nativeQuery = true, value = "select * from ticket_vehiculo where placa = ?1 and estado = 'I'")
	TicketVehiculoEntidad buscarPorPlaca(String placa);
	
	@Query(nativeQuery = true, value = "select 'true' from ticket_vehiculo where placa = ?1 and estado = 'I'")
	String existeVehiculoEnParqueadero(String placa);
	
	@Query(nativeQuery = true, value = "select count(1) from ticket_vehiculo where tipo_vehiculo = 1 and estado = 'I'")
	int countVehiculosTipoCarro();
	
	@Query(nativeQuery = true, value = "select count(1) from ticket_vehiculo where tipo_vehiculo = 2  and estado = 'I'")
	int countVehiculosTipoMoto();
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update ticket_vehiculo set estado = 'R', fecha_salida = ?1 where placa = ?2 and estado = 'I'")
	void retirarVehiculo(LocalDateTime fechaSalida, String placa);
}
