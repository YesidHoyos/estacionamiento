package com.yesid.estacionamiento.comando.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

import com.yesid.estacionamiento.comando.dominio.excepcion.DiaNoHabilExcepcion;
import com.yesid.estacionamiento.comando.dominio.modelo.TicketVehiculo;
import com.yesid.estacionamiento.comando.dominio.modelo.Vigilante;
import com.yesid.estacionamiento.comando.dominio.utilitario.Fecha;
import com.yesid.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VigilanteTest {

	private static final String DIA_MIERCOLES = "06/06/2019";
	private static final String FORMATO_FECHA = "dd/MM/yyyy";

	@Mock
	Fecha fecha;

	@InjectMocks
	Vigilante vigilante;

	@Test
	public void ingresarCarroEnDiaNoHabil() throws ParseException {
		//arrange
		
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 06, 12, 0, 0);
		String placa = "ABC078";
		TicketVehiculo carro = new CarroTestDataBuilder()
				.conPlaca(placa)
				.conFechaDeIngreso(fechaIngreso)
				.build();
		SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);

		Calendar fechaActual = Calendar.getInstance();
		fechaActual.setTime(formato.parse(DIA_MIERCOLES));

		when(fecha.obtenerFechaActual()).thenReturn(fechaActual);
		//act
		try {
			vigilante.ingresarVehiculo(carro);
			fail();
		} catch (DiaNoHabilExcepcion e) {
			//assert
			assertEquals(Vigilante.DIA_NO_HABIL, e.getMessage());
		}
	}
}
