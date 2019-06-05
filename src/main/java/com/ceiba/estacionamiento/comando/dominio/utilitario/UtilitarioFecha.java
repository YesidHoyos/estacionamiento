package com.ceiba.estacionamiento.comando.dominio.utilitario;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class UtilitarioFecha {
	
	public Calendar obtenerCalendario() {
		return Calendar.getInstance();
	}

}
