package com.yesid.estacionamiento.consulta.integracion;

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

import com.yesid.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;
import com.yesid.estacionamiento.consulta.dominio.modelo.ServicioObtenerVehiculo;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ServicioObtenerVehiculoTest {

	@Autowired
	ServicioObtenerVehiculo servicioObtenerVehiculo;
	
	@Test
	@Sql("/vehiculo.sql")
	public void obtenerVehiculosTest() {
		
		//arrange
		String placa = "ABC123";
		
		//act
		List<DtoTicketVehiculo> vehiculosIngresados = servicioObtenerVehiculo.obtenerVehiculos();
		
		//assert
		DtoTicketVehiculo dtoTicketVehiculo = vehiculosIngresados.get(0);
		assertEquals(placa, dtoTicketVehiculo.getPlaca());
	}
}
