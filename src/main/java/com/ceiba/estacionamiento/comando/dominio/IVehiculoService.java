package com.ceiba.estacionamiento.comando.dominio;

import com.ceiba.estacionamiento.comando.dominio.utilitario.UtilitarioFecha;

public interface IVehiculoService {
	
	public void validarIngreso();
	public void sacarVehiculo();
	public void setUtilitarioFecha(UtilitarioFecha utilitarioFecha);

}
