package com.ceiba.estacionamiento.comando.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.estacionamiento.comando.dominio.Carro;

public class CarroTestDataBuilder {
	
	private static final String PLACA = "ABC123";
	private static final Date FECHA_INGRESO = getFecha();
	private static final String CILINDRAJE = "1500cc";
	
	private static Date getFecha() {
		String fechaString = "27/02/2016";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formato.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return fecha;
	}
	
	private String placa;
	private Date fechaIngreso;
	private String cilindraje;
	
	public CarroTestDataBuilder(){
		this.placa = PLACA;
		this.fechaIngreso = FECHA_INGRESO;
		this.cilindraje = CILINDRAJE;
	}
	
	public CarroTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public CarroTestDataBuilder conFechaDeIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	public CarroTestDataBuilder conCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Carro build() {
		return new Carro(this.placa,this.fechaIngreso, this.cilindraje);
	}
}
