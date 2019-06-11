package com.ceiba.estacionamiento.consulta.unitaria;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.consulta.dominio.modelo.DtoTicketVehiculo;
import com.ceiba.estacionamiento.consulta.dominio.modelo.Vigilante;
import com.ceiba.estacionamiento.consulta.dominio.repositorio.TicketVehiculoRepositorio;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VigilanteTest {
	
	@Mock
	TicketVehiculoRepositorio ticketVehiculoRepositorio;
	
	@InjectMocks
	Vigilante vigilante;

	@Test
	public void obtenerVehiculosTest() {
		
		//arrange
		DtoTicketVehiculo carro = new DtoTicketVehiculo("ABC123", 1, LocalDateTime.now());
		DtoTicketVehiculo moto = new DtoTicketVehiculo("XYZ23B", 2, LocalDateTime.now());
		List<DtoTicketVehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(carro);
		vehiculos.add(moto);
		
		when(ticketVehiculoRepositorio.obtenerVehiculos()).thenReturn(vehiculos);
		
		//act
		List<DtoTicketVehiculo> vehiculosIngresados = vigilante.obtenerVehiculos();
		
		//assert
		assertTrue(vehiculosIngresados.contains(carro));
		assertTrue(vehiculosIngresados.contains(moto));
	}
}