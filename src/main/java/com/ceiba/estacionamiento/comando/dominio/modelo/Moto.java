package com.ceiba.estacionamiento.comando.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

public class Moto extends Vehiculo{

	public Moto(String placa, Date fechaIngreso, String cilindraje) {
		super(placa, fechaIngreso, cilindraje);
	}

	@Override
	public void validarIngreso() {
		
		Calendar calendario = utilitarioFecha.obtenerCalendario();
		int diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK);
		char primeraLetraPLaca = this.getPlaca().charAt(0);
		
		if(primeraLetraPLaca == 'A' && (diaDeLaSemana != Calendar.MONDAY || diaDeLaSemana != Calendar.SUNDAY)) {
			throw new VigilanteExcepcion(Constantes.DIA_NO_HABIL);
		}
	}

	@Override
	public BigDecimal obtenerValorAPagar() {
		LocalDate fechaIngreso = this.getFechaIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaSalida = this.getFechaSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int cantidadHoras = Period.between(fechaIngreso, fechaSalida).getDays();
		//if(cantidadHoras > )
		return null;
	}
}
