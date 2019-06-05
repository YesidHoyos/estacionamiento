package com.ceiba.estacionamiento.comando.dominio.utilitario;

import java.math.BigDecimal;

public class Constantes {
	
	public static final String CARRO = "carro";
	public static final String MOTO = "moto";
	public static final int TIPO_CARRO = 1;
	public static final int TIPO_MOTO = 2;
	public static final BigDecimal VALOR_HORA_MOTO = new BigDecimal("500");
	public static final BigDecimal VALOR_HORA_CARRO = new BigDecimal("1000");
	public static final BigDecimal VALOR_DIA_MOTO = new BigDecimal("4000");
	public static final BigDecimal VALOR_DIA_CARRO = new BigDecimal("8000");
	public static final String SIN_ESPACIO_DISPONIBLE_CARROS = "No hay disponibilidad de parqueo para carros";
	public static final String SIN_ESPACIO_DISPONIBLE_MOTOS = "No hay disponibilidad de parqueo para motos";
	public static final String VEHICULO_NO_PERMITIDO = "El tipo de vehiculo no es permitido";
	public static final String DIA_NO_HABIL = "No se permite el ingreso del vehiculo en día no habil";

}
