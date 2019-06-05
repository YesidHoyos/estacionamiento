package com.ceiba.estacionamiento.comando.dominio;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.estacionamiento.comando.dominio.excepcion.VigilanteExcepcion;
import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;
import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

public class Moto extends Vehiculo implements IVehiculoService{
	
	private UtilitarioFecha utilitarioFecha;
	
	public void setUtilitarioFecha(UtilitarioFecha utilitarioFecha) {
		this.utilitarioFecha = utilitarioFecha;
	}

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
	public void sacarVehiculo() {
		// TODO Auto-generated method stub
		
	}
}
