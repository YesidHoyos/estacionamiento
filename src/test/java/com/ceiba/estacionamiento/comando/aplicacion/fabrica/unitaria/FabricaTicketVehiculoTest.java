package com.ceiba.estacionamiento.comando.aplicacion.fabrica.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.aplicacion.comando.ComandoVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.fabrica.FabricaTicketVehiculo;
import com.ceiba.estacionamiento.comando.aplicacion.testdatabuilder.ComandoVehiculoDataBuilder;
import com.ceiba.estacionamiento.comando.dominio.excepcion.NoPermitidoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketCarro;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketMoto;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vigilante;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FabricaTicketVehiculoTest {

	private static final int MOTO = 2;
	private static final int AVION = 3;
	private static final int CARRO = 1;
	@Autowired
	FabricaTicketVehiculo fabricaTicketVehiculo;

	@Test
	public void crearTicketCarro() {

		// arrange
		ComandoVehiculo comandoTicketVehiculo = new ComandoVehiculoDataBuilder().conTipo(CARRO).build();
		// act
		TicketVehiculo ticketVehiculo = fabricaTicketVehiculo.crear(comandoTicketVehiculo);
		// assert
		assertTrue(ticketVehiculo instanceof TicketCarro);
	}

	@Test
	public void crearTicketMoto() {
		// arrange
		ComandoVehiculo comandoTicketVehiculo = new ComandoVehiculoDataBuilder().conTipo(MOTO).build();
		// act
		TicketVehiculo ticketVehiculo = fabricaTicketVehiculo.crear(comandoTicketVehiculo);
		// assert
		assertTrue(ticketVehiculo instanceof TicketMoto);
	}

	@Test
	public void crearTicketVehiculoNoValido() {

		// arrange
		ComandoVehiculo comandoTicketVehiculo = new ComandoVehiculoDataBuilder().conTipo(AVION).build();
		
		try {
			// act
			fabricaTicketVehiculo.crear(comandoTicketVehiculo);
			fail();
		} catch (NoPermitidoExcepcion e) {
			assertEquals(Vigilante.VEHICULO_NO_PERMITIDO, e.getMessage());
		}
	}
}
