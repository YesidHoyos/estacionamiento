package com.ceiba.estacionamiento.comando.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VehiculoExcepcion;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vehiculo;
import com.ceiba.estacionamiento.comando.dominio.modelo.Vigilante;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;
import com.ceiba.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VigilanteTest {

	private static final String DIA_MIERCOLES = "06/06/2019";
	private static final String FORMATO_FECHA = "dd/MM/yyyy";

	@Mock
	UtilitarioFecha utilitarioFecha;

	@InjectMocks
	Vigilante vigilante;

	@Test
	public void ingresarCarroEnDiaNoHabil() throws ParseException {
		//arrange
		
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 06, 12, 0, 0);
		String placa = "ABC078";
		Vehiculo carro = new CarroTestDataBuilder()
				.conPlaca(placa)
				.conFechaDeIngreso(fechaIngreso)
				.build();
		SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);

		Calendar calendario = Calendar.getInstance();
		calendario.setTime(formato.parse(DIA_MIERCOLES));

		when(utilitarioFecha.obtenerCalendario()).thenReturn(calendario);
		//act
		try {
			vigilante.ingresarVehiculo(carro);
		} catch (VehiculoExcepcion e) {
			//assert
			assertEquals(Constantes.DIA_NO_HABIL, e.getMessage());
		}
	}
}
