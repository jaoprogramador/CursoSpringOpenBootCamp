package com.jao.spring.EjeRestDatajpa;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.jao.spring.ejemplo.entities.Disco;
//anotación para indicar que vamos a hacer peticios HTTP
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiscoControllerTest {
	//Esta clase que la proporciona "org.springframework.boot.test.web.client." es para testear llamadas REST tipo GET, POST,PUT..
	private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;
    
    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
    /*@DisplayName("Comprobar hola mundo desde controladores Spring REST")
    @Test
    public void hello() {
        ResponseEntity<String> response  =
                testRestTemplate.getForEntity("/hola", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Kaixo JAO que tal vamos!!! Hasta luego!", response.getBody());
    }

	@Test
	public void testDiscoController() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testFindAll() {
		ResponseEntity<Disco[]> response  =
	            testRestTemplate.getForEntity("/api/discos", Disco[].class);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(200, response.getStatusCodeValue());

	        List<Disco> discos = Arrays.asList(response.getBody());
	        System.out.println(discos.size());


	}

	/*@Test
	public void testFindOneById() {
		ResponseEntity<Disco> response  =
                testRestTemplate.getForEntity("/api/discos/1", Disco.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        
	}

	@Test
	public void testCreate() {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       
        String json ="{\"titulo\":\"KK\",\"autor\":\"BadBunny\",\"numCanciones\":4,\"precio\":1.99,\"anioLanzamiento\":\"2019\"}";

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Disco> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Disco.class);

        Disco result = response.getBody();

        assertEquals(1L, result.getId()+"");
        assertEquals("Disco creado desde Spring Test", result.getTitulo());

	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOneById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}*/

}
