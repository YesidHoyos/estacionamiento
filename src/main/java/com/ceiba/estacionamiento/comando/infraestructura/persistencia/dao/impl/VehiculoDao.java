package com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.estacionamiento.comando.dominio.IVehiculoService;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.builder.VehiculoBuilder;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.IVehiculoDao;
import com.ceiba.estacionamiento.comando.infraestructura.persistencia.dao.jpa.IVehiculoJPA;

@Component
public class VehiculoDao implements IVehiculoDao{
	
	@Autowired
	IVehiculoJPA vehiculoJPA;
	
	public void setVehiculoJPA(IVehiculoJPA vehiculoJPA) {
		this.vehiculoJPA = vehiculoJPA;
	}

	@Override
	public void registrarIngresoVehiculo(IVehiculoService vehiculo) {
		vehiculoJPA.save(VehiculoBuilder.convertirAEntidad(vehiculo));
	}
	
	@Override
	public IVehiculoService obtenerVehiculoIngresado(String placa) {
		return VehiculoBuilder.convertirADominio(vehiculoJPA.findByPlaca(placa));
	}
	
	@Override
	public boolean existeVehiculoEnParqueadero(String placa) {
		return (vehiculoJPA.existeVehiculoEnParqueadero(placa) == 1);
	}
	
	@Override
	public void registrarSalidavehiculo(String placa) {
		vehiculoJPA.retirarVehiculo(placa);
	}
	
	@Override
	public int contarVehiculosEnParqueadero() {
		return vehiculoJPA.countVehiculosTipoCarro();
	}
	
	@Override
	public int contarMotosEnParquedero() {
		return vehiculoJPA.countVehiculosTipoMoto();
	}
	
	@Override
	public void eliminarTodos() {
		vehiculoJPA.deleteAll();
	}
}
