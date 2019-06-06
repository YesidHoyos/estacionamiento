package com.ceiba.estacionamiento.comando.dominio.servicio.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.servicio.impl.Vigilante;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.VehiculoDao;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VigilanteTest {
	
	@Autowired
	VehiculoDao vehiculoDao;
	
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
		String tipo = "carro";
		String placa = "MNB123";
		String cilindraje = "2500";
		boolean vehiculoGuardado = false;
		
		//act
		vigilante.ingresarVehiculo(tipo, placa, cilindraje);
		
		//assert
		vehiculoGuardado = vehiculoDao.existeVehiculoEnParqueadero(placa);
		assertTrue(vehiculoGuardado);
	}
	
	@Test
	public void ingresarVehiculoNoValido() {
		
		//arrange
		String tipo = "avion";
		String placa = "MNB123";
		String cilindraje = "27000cc";
		//act
		try {
			vigilante.ingresarVehiculo(tipo, placa, cilindraje);
		} catch (VigilanteExcepcion e) {
			//assert
			assertEquals(Constantes.VEHICULO_NO_PERMITIDO, e.getMessage());
		}		
	}
	
	@Test
	public void ingresarVehiculoCuandoNoHayCupo() {
		
	}
}
