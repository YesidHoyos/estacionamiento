package com.ceiba.estacionamiento.comando.dominio;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.utilitario.Constantes;

@Component
public class VehiculoFabrica {
	
	public IVehiculoService getVehiculo(String tipo, String placa, String cilindraje) {
		switch (tipo) {
		case Constantes.CARRO: 
			return new Carro(placa, new Date(), cilindraje);
		case Constantes.MOTO:
			return new Moto(placa, new Date(), cilindraje);
		default:
			return null;
		}
	}

}
