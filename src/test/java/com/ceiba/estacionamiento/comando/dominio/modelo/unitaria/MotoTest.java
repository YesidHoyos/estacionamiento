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
import com.ceiba.estacionamiento.comando.dominio.modelo.Moto;
import com.ceiba.estacionamiento.comando.dominio.repositorio.IVehiculoRepositorio;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;
import com.ceiba.estacionamiento.comando.testdatabuilder.MotoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MotoTest {

	private static final String DIA_SABADO = "01/05/2019";
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	Moto moto = null;

	@Mock
	UtilitarioFecha utilitarioFecha;
	
	@Mock
	IVehiculoRepositorio vehiculoRepositorio;
	
	@Before
	public void setUp() {
		moto = new MotoTestDataBuilder().build();
		moto.setUtilitarioFecha(utilitarioFecha);
		moto.setVehiculoRepositorio(vehiculoRepositorio);
	}
	
	@Test
	public void ingresarMotoEnDiaNoHabil() throws ParseException {
		//arrange
		SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);

		Calendar calendario = Calendar.getInstance();
		calendario.setTime(formato.parse(DIA_SABADO));

		when(utilitarioFecha.obtenerCalendario()).thenReturn(calendario);
		//act
		try {
			moto.validarIngreso();
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
