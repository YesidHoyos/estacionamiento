package com.ceiba.estacionamiento.comando.dominio.servicio.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vigilante;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.TicketVehiculoDao;
import com.ceiba.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;
import com.ceiba.estacionamiento.comando.testdatabuilder.MotoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VigilanteTest {
	
	TicketVehiculo vehiculo = null;
	
	@Autowired
	TicketVehiculoDao vehiculoDao;
	
	@Autowired
	Vigilante vigilante;
	
	@Before
	public void setUp() {
		
	}	

	@After
	public void tearDown() {
		vehiculoDao.eliminarTodos();
	}

	@Test
	public void ingresarVehiculoTest() {
		//arrange		
		vehiculo = new CarroTestDataBuilder().conPlaca("MNB123").conCilindraje(2500).build();
		
		boolean vehiculoGuardado = false;	
		
		//act
		vigilante.ingresarVehiculo(vehiculo);
		
		//assert
		vehiculoGuardado = vehiculoDao.existeVehiculoEnParqueadero(vehiculo.getPlaca());
		assertTrue(vehiculoGuardado);
	}
	
	@Test
	@Sql("/carro.sql")
	public void ingresarCarroCuandoNoHayCupo() {
		
		//arrange
		vehiculo = new CarroTestDataBuilder().build();
		try {
			//act
			vigilante.ingresarVehiculo(vehiculo);
			fail();
		} catch (VigilanteExcepcion e) {
			//assert
			assertEquals(Vigilante.SIN_ESPACIO_DISPONIBLE_CARROS, e.getMessage());
		}			
	}	
	
	@Test
	@Sql("/moto.sql")
	public void ingresarMotoCuandoNoHayCupo() {
		
		//arrange
		vehiculo = new MotoTestDataBuilder().build();
		
		try {
			//act
			vigilante.ingresarVehiculo(vehiculo);
			fail();
		} catch (VigilanteExcepcion e) {
			//assert
			assertEquals(Vigilante.SIN_ESPACIO_DISPONIBLE_MOTOS, e.getMessage());
		}			
	}
	
	@Test
	public void ingresarVehiculoYaIngresado() {
		
		//arrange
		String placa = "NKD89D";
		vehiculo = new MotoTestDataBuilder().conPlaca(placa).build();
		
		vigilante.ingresarVehiculo(vehiculo);		
		
		try {
			//act
			vigilante.ingresarVehiculo(vehiculo);
			fail();
		} catch (VigilanteExcepcion e) {
			//assert
			assertEquals(Vigilante.VEHICULO_YA_INGRESADO, e.getMessage());
		}		
	}
	
	@Test
	public void sacarVehiculoTest() {
		
		//arrange
		boolean existeEnParqueadero = true;
		String placa = "PQR345";
		vehiculo = new CarroTestDataBuilder().conPlaca(placa).build();
		
		vigilante.ingresarVehiculo(vehiculo);
		
		//act
		vigilante.sacarVehiculo(placa);
		
		//assert
		existeEnParqueadero = vehiculoDao.existeVehiculoEnParqueadero(placa);
		assertFalse(existeEnParqueadero);		
	}
}
