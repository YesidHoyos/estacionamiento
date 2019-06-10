package com.ceiba.estacionamiento.comando.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.estacionamiento.comando.dominio.modelo.Moto;
import com.ceiba.estacionamiento.comando.testdatabuilder.MotoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class MotoTest {

	Moto moto = null;

	@Before
	public void setUp() {

	}

	@Test
	public void calcularValorAPagarCuandoPermaneceUnDia() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 02, 0, 0, 0);
		BigDecimal totalAPagar = new BigDecimal(4000);

		moto = new MotoTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.build();

		// act
		moto.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, moto.getTotalAPagar());
	}

	@Test
	public void calcularValorAPagarCuandoPermaneceDosHoras() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 01, 02, 0, 0);
		BigDecimal totalAPagar = new BigDecimal(1000);

		moto = new MotoTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.build();

		// act
		moto.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, moto.getTotalAPagar());
	}
	
	@Test
	public void calcularValorAPagarCuandoPermaneceNueveHoras() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 01, 9, 0, 0);
		BigDecimal totalAPagar = new BigDecimal(4000);

		moto = new MotoTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.build();

		// act
		moto.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, moto.getTotalAPagar());
	}

	@Test
	public void calcularValorAPagarCuandoEsAltoCilindraje() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 02, 03, 0, 0);
		int cilindraje = 600;
		BigDecimal totalAPagar = new BigDecimal(7500);

		moto = new MotoTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.conCilindraje(cilindraje).build();

		// act
		moto.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, moto.getTotalAPagar());
	}
}
