package com.ceiba.estacionamiento.comando.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.Carro;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;
import com.ceiba.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CarroTest {
	
	private static final String DIA_MIERCOLES = "06/05/2019";
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	Carro carro = null;

	@Mock
	UtilitarioFecha utilitarioFecha;
	
	@Before
	public void setUp() {
		carro = new CarroTestDataBuilder().build();
		carro.setUtilitarioFecha(utilitarioFecha);
	}
	
	@Test
	public void ingresarCarroEnDiaNoHabil() throws ParseException {
		//arrange
		SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);

		Calendar calendario = Calendar.getInstance();
		calendario.setTime(formato.parse(DIA_MIERCOLES));

		when(utilitarioFecha.obtenerCalendario()).thenReturn(calendario);
		//act
		try {
			carro.validarIngreso();
		} catch (VehiculoExcepcion e) {
			//assert
			assertEquals(Constantes.DIA_NO_HABIL, e.getMessage());
		}
		
	}
	
	@Test
	@Ignore
	public void calcularValorAPagarTest() {
		
	}
	
	@Test
	@Ignore
	public void ingresarCuandoNoHayCupo() {
		
	}
	
	@Test
	@Ignore
	public void validarExistenciaEnParqueadero() {
		
	}
}
