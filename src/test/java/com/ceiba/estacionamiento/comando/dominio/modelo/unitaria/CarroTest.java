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

import com.ceiba.estacionamiento.comando.dominio.modelo.Carro;
import com.ceiba.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;


@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CarroTest {
	
	Carro carro = null;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void calcularValorAPagarCuandoPermaneceUnDiaYTresHoras() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 02, 03, 0, 0);
		BigDecimal totalAPagar = new BigDecimal(11000);

		carro = new CarroTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.build();

		// act
		carro.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, carro.getTotalAPagar());
	}

	@Test
	public void calcularValorAPagarCuandoPermaneceDosHoras() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 01, 02, 0, 0);
		BigDecimal totalAPagar = new BigDecimal(2000);

		carro = new CarroTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.build();

		// act
		carro.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, carro.getTotalAPagar());
	}
	
	@Test
	public void calcularValorAPagarCuandoPermaneceNueveHoras() {

		// arrange
		LocalDateTime fechaIngreso = LocalDateTime.of(2019, 05, 01, 0, 0, 0);
		LocalDateTime fechaSalida = LocalDateTime.of(2019, 05, 01, 9, 0, 0);
		BigDecimal totalAPagar = new BigDecimal(8000);

		carro = new CarroTestDataBuilder()
				.conFechaDeIngreso(fechaIngreso)
				.conFechaDeSalida(fechaSalida)
				.build();

		// act
		carro.calcularValorAPagar();
		// assert
		assertEquals(totalAPagar, carro.getTotalAPagar());
	}
}
