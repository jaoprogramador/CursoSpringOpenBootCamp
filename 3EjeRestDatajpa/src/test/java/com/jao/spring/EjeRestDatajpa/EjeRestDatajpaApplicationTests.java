package com.jao.spring.EjeRestDatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jao.spring.ejemplo.entities.Disco;
import com.jao.spring.ejemplo.service.DiscoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EjeRestDatajpaApplicationTests {

	@Test
	void contextLoads() {
		Disco disco = new Disco(1L, "Girls and Boys", "Blur", 10, (double) 15, 1995);
		DiscoService discoService = new DiscoService();
		String info=discoService.infoDisco(disco);
		System.out.println("Info del Servicio disco INFO"+info);
		//comprobaciones aserciones
		//===========================
		assertTrue(!info.isEmpty());//se ha introducido la info
		
		assertTrue(disco.getAnioLanzamiento() > 2000);//discos millenials
		
		assertTrue(!disco.getAutor().isEmpty() );//tiene que tener autor
	}

	

}
