package com.jao.spring.ejemplo.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// CONCEPTO 1: cómo obtener beans de Spring
		//Instanciar el contenedor de clases-beans
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        MensajeService mensajeService=(MensajeService)context.getBean("serviceJAO");        
        System.out.println("CONCEPTO 1: RES desde main "+mensajeService.holaJAO());
        
        // Opción 2. Crear un objeto de forma normal
         //Calculadora service = new Calculadora();
        MensajeService menService= new MensajeService();
        System.out.println("CONCEPTO 2: RES desde main sin Spring "+mensajeService.holaJAO());
        // Opción 3. Recibir un objeto de Spring
        context.getBean("gestorSaludos");
        GestorSaludos gestorSaludos= (GestorSaludos) context.getBean("gestorSaludos");
        System.out.println("CONCEPTO 3: Con Spring capturamos un VO dentro de otro VO "+gestorSaludos.saludo.holaMundo());

        // CONCEPTO 3: scope o alcance
        // los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación
        // podemos cambiarlo a scope="prototype" si queremos que se cree un nuevo objeto cada vez
        // verificarlo viendo cómo se ejecuta varias veces un constructor


    }

}
