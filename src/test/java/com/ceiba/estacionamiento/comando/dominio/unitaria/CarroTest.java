package com.ceiba.estacionamiento.comando.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.estacionamiento.comando.dominio.Carro;
import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;
import com.ceiba.estacionamiento.comando.testdatabuilder.CarroTestDataBuilder;

import junit.framework.Assert;

public class CarroTest {
	
	private static final String DIA_MIERCOLES = "03/05/2019";
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	Carro carro = null;

	@Autowired
	UtilitarioFecha utilitarioFecha;
	
	@Before
	public void setUp() {
		carro = new CarroTestDataBuilder().build();
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
		} catch (VigilanteExcepcion e) {
			//assert
			assertEquals(Constantes.DIA_NO_HABIL, e.getMessage());
		}
		
	}
}
