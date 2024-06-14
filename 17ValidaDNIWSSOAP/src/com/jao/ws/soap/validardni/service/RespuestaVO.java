package com.jao.ws.soap.validardni.service;

import java.io.Serializable;

public class RespuestaVO implements Serializable {

	private static final long serialVersionUID = 8117708467851282846L;
	String dni;
	String mensaje;
	boolean isValido=false;
	
	public RespuestaVO(String dni, String mensaje, boolean isValido) {
		super();
		this.dni = dni;
		this.mensaje = mensaje;
		this.isValido = isValido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isValido() {
		return isValido;
	}
	public void setValido(boolean isValido) {
		this.isValido = isValido;
	}
	
}
