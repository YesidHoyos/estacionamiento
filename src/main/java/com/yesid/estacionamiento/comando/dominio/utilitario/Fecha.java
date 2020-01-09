package com.yesid.estacionamiento.comando.dominio.utilitario;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Fecha {
	
	public Calendar obtenerFechaActual() {
		return Calendar.getInstance();
	}

}
