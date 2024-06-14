package com.jao.spring.ejemplo.beans;

public class GestorSaludos {
	Saludo saludo;
	String idioma;
	//2. constructores
    public GestorSaludos(Saludo saludo, String idioma){
        System.out.println("Ejecutando constructor GestorSaludos");
        this.saludo = saludo;
        this.idioma = idioma;
    }
}
