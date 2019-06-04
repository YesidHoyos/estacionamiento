package com.ceiba.estacionamiento.comando.dominio;

import org.springframework.stereotype.Component;

@Component
public class VehiculoFabrica {
	
	public IVehiculoService getVehiculo(String tipo) {
		switch (tipo) {
		case "carro": 
			return new Carro();
		case "moto":
			System.out.println("Crea objeto Moto");
			return new Moto();
		default:
			System.out.println("nulo");
			return null;
		}
	}

}
