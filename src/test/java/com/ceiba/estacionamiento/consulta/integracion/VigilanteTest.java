package com.ceiba.estacionamiento.consulta.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;
import com.ceiba.estacionamiento.consulta.dominio.modelo.Vigilante;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VigilanteTest {

	@Autowired
	Vigilante vigilante;
	
	@Test
	@Sql("/vehiculo.sql")
	public void obtenerVehiculosTest() {
		
		//arrange
		String placa = "ABC123";
		
		//act
		List<DtoTicketVehiculo> vehiculosIngresados = vigilante.obtenerVehiculos();
		
		//assert
		DtoTicketVehiculo dtoTicketVehiculo = vehiculosIngresados.get(0);
		assertEquals(placa, dtoTicketVehiculo.getPlaca());
	}
}
