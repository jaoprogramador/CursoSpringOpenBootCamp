package com.example.jao.batch.demo.processor;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.jao.batch.demo.model.Empleado;

public class EmpleadoItemProcessor implements ItemProcessor <Empleado, Empleado>{

	private static final Logger LOG= LoggerFactory.getLogger(EmpleadoItemProcessor.class);
	private static int contador = 1; 
	
	@Override
	public Empleado process(Empleado item) throws Exception {
		int idGenerado = contador++; 
		String nombre=item.getNombre().toUpperCase();
	    String apellidos= item.getApellidos().toUpperCase();
	    String telefono= item.getTelefono().toUpperCase();
	    String dni= item.getDni().toUpperCase();
	    String sexo= item.getSexo();
	    String profesion= item.getProfesion().toUpperCase();
	    Empleado empleadoMayus = new Empleado( idGenerado, nombre, apellidos, telefono, dni, sexo ,profesion);
	    LOG.info("EmpleadoItemProcessor:::CONVIRTIENDO --"+item+" a ---"+empleadoMayus);
	    return empleadoMayus;
	}

}
