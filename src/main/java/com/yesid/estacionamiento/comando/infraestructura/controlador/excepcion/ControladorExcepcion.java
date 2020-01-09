package com.yesid.estacionamiento.comando.infraestructura.controlador.excepcion;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yesid.estacionamiento.comando.dominio.excepcion.DiaNoHabilExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.EspacioNoDiponibleExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.NoExisteExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.NoPermitidoExcepcion;
import com.yesid.estacionamiento.comando.dominio.excepcion.YaIngresadoExcepcion;

@ControllerAdvice
public class ControladorExcepcion extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {DiaNoHabilExcepcion.class, EspacioNoDiponibleExcepcion.class, NoPermitidoExcepcion.class})
	public ResponseEntity<Object> conflicto(RuntimeException excepcion, WebRequest request) {
		String bodyOfResponse = excepcion.getMessage();
        return handleExceptionInternal(excepcion, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);		
	}
	
	@ExceptionHandler(NoExisteExcepcion.class)
	public ResponseEntity<Object> noExiste(NoExisteExcepcion excepcion, WebRequest request) {
		String bodyOfResponse = excepcion.getMessage();
        return handleExceptionInternal(excepcion, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);		
	}
	
	@ExceptionHandler(YaIngresadoExcepcion.class)
	public ResponseEntity<Object> duplicado(RuntimeException excepcion, WebRequest request) {
		String bodyOfResponse = excepcion.getMessage();
        return handleExceptionInternal(excepcion, bodyOfResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);		
	}
}
