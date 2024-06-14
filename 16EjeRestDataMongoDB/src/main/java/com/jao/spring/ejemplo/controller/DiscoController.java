package com.jao.spring.ejemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jao.spring.ejemplo.entities.Disco;
import com.jao.spring.ejemplo.repository.DiscoMngRepository;

import ch.qos.logback.classic.Logger;

@RestController
public class DiscoController {
	private final Logger log =(Logger) LoggerFactory.getLogger(DiscoController.class);
	  // atributos
    private DiscoMngRepository discoRepository;
    // contructores

    public DiscoController(DiscoMngRepository discoRepository) {
        this.discoRepository = discoRepository;
    }


    // CRUD sobre la entidad Disco

    // Buscar todos los libros (lista de libros)

    /**
     * http://localhost:8081/api/discos
     * @return
     */
    @GetMapping("/api/discos")
    public List<Disco> findAll(){
        // recuperar y devolver los libros de base de datos
        return discoRepository.findAll();
    }


    /**
     * Request
     * Response
     * @param id
     * @return
     */
    // buscar un solo libro en base de datos segun su id
    @GetMapping("/api/discos/{id}")
    public ResponseEntity<Disco> findOneById(@PathVariable Long id){

        Optional<Disco> DiscoOpt = discoRepository.findById(id); // 3456546456435
        // opcion 1
        if(DiscoOpt.isPresent())
            return ResponseEntity.ok(DiscoOpt.get());
        else
            return ResponseEntity.notFound().build();

        // opcion 2
//        return DiscoOpt.orElse(null);
         //return DiscoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    // crear un nuevo libro en base de datos
    @PostMapping("/api/discos")
    public ResponseEntity create(@RequestBody Disco disco, @RequestHeader HttpHeaders headers){
    	//obtenemos las cabeceras por si queremos capturar con que explorador
		//se ejecuta y caparlo por vulnerabilidades de seguridad
        System.out.println(headers.get("User-Agent"));
        // guardar el libro recibido por par�metro en la base de datos
        
        if(disco.getId() != 0 ){// si existe el ID no es una creación
        	log.warn("intentando crear un Disco con ID:::"+disco.getId());
        	System.out.println("intentando crear un Disco con ID:::"+disco.getId());
        	ResponseEntity.badRequest().build();
        }
        Disco result = discoRepository.save(disco); 
        return  ResponseEntity.ok(result);
       }


    // actualizar un libro existente en base de datos
    @PutMapping("/api/discos")
    public ResponseEntity<Disco> update(@RequestBody Disco disco){  
    	if(disco.getId() == 0){
    		log.warn("intentando actualizar un Disco que no existe");
    		ResponseEntity.badRequest().build();
    	}
        // guardar el libro recibido por par�metro en la base de datos
    
    	Disco result = discoRepository.save(disco); 
    return  ResponseEntity.ok(result);
    }

    /**
     * Request
     * Response
     * @param id
     * @return
     */
    // borrar un solo libro en base de datos segun su id
    @DeleteMapping("/api/discos/{id}")
    public ResponseEntity<Disco> deleteOneById(@PathVariable Long id){

        if(!discoRepository.existsById(id)){
        	log.warn("intentando actualizar un Disco que no existe");
    		ResponseEntity.notFound().build();
        }
        discoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    // borrar TODOS los libros en base de datos
    @DeleteMapping("/api/discos")
    public ResponseEntity<Disco> deleteAll(){
    	log.info("lanzando el borrado de TODA la tabla");        
        discoRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }

    
}
