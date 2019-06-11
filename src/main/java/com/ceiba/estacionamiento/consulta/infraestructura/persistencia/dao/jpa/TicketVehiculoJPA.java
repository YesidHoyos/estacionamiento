package com.ceiba.estacionamiento.consulta.infraestructura.persistencia.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.consulta.infraestructura.persistencia.entidad.TicketVehiculoEntidad;

@Component("consultaTicketVehiculoJPA")
public interface TicketVehiculoJPA extends CrudRepository<TicketVehiculoEntidad, Long>{

	@Query(nativeQuery = true, value = "select id, placa, tipo_vehiculo, fecha_ingreso from ticket_vehiculo where estado = 'I'")
	List<TicketVehiculoEntidad> obtenerVehiculosIngresados();
}
