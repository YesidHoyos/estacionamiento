package com.ceiba.estacionamiento.comando.dominio.servicio.integracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.Carro;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vigilante;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.VehiculoDao;
import com.ceiba.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VigilanteTest {
	
	Carro carro = null;

	@Autowired
	UtilitarioFecha utilitarioFecha;
	
	@Autowired
	IVehiculoRepositorio vehiculoRepositorio;
	
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
		carro = new CarroTestDataBuilder().conPlaca("MNB123").conCilindraje(2500).build();
		carro.setUtilitarioFecha(utilitarioFecha);
		carro.setVehiculoRepositorio(vehiculoRepositorio);
		
		boolean vehiculoGuardado = false;	
		
		//act
		vigilante.ingresarVehiculo(carro);
		
		//assert
		vehiculoGuardado = vehiculoDao.existeVehiculoEnParqueadero(carro.getPlaca());
		assertTrue(vehiculoGuardado);
	}
	
	@Test
	@Ignore
	public void ingresarVehiculoNoValido() {
		
		//arrange
		carro = new CarroTestDataBuilder().conPlaca("MNB123").conCilindraje(2500).build();
		carro.setUtilitarioFecha(utilitarioFecha);
		//act
		try {
			vigilante.ingresarVehiculo(carro);
		} catch (VehiculoExcepcion e) {
			//assert
			assertEquals(Constantes.VEHICULO_NO_PERMITIDO, e.getMessage());
		}		
	}
	
	@Test
	@Ignore
	public void ingresarVehiculoCarroCuandoNoHayCupo() {
		
		//arrange
			
		//act
		
		//assert
	}
	
}
