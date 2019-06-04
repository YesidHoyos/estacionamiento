package com.ceiba.estacionamiento.comando.dominio;

import java.util.Date;

public class Carro extends Vehiculo implements IVehiculoService{

	public Carro() {
	}
	
	public Carro(String placa, Date fechaIngreso, Date fechaSalida) {
		super(placa, fechaIngreso, fechaSalida);
	}

	@Override
	public void validarIngreso() {
		char primeraLetraPLaca = this.getPlaca().charAt(0);
		
		/*if(primeraLetraPLaca == 'A' && ) {
			throw ;
		}*/
	}

	@Override
	public void sacarVehiculo() {
		// TODO Auto-generated method stub
		
	}
}
