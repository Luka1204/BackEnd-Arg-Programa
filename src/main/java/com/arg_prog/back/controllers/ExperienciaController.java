/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.controllers;

import com.arg_prog.back.models.Experiencia;
import com.arg_prog.back.services.ExperienciaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/experiencia")/*MAPEO DE PETICIONES AL SERVIDOR EN LA TABLA  EDUCACION*/
public class ExperienciaController {
    public final ExperienciaService experienciaService; /*Declaramos el servicio de la clase con la que estemos trabajando*/

    public ExperienciaController(ExperienciaService experienciaService) { /*Declaramos el controlador pasando por parametro e instanciando los datos que utiliza*/
        this.experienciaService = experienciaService;
    }
    
    @GetMapping
    public ResponseEntity <List<Experiencia>> obtenerExperiencia(){                 /*Declaramos nuestro metodo para obtener la experiencia de la persona*/
        List <Experiencia> experiencias= experienciaService.searchExperiencia();    /*utilizando el servicio experiencia, con su meetodo buscar experiencia*/
        
        return new ResponseEntity<>(experiencias, HttpStatus.OK);       /*Retorna una respuesta de entidad, que se la pasa por parametro */
                                                                        /*la entidad (En este caso educacion) y el estatus HTTP que va a devolver*/
    }
    
    @PutMapping
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){
        Experiencia editExperiencia = experienciaService.updateExperiencia(experiencia);
        return new ResponseEntity<>(editExperiencia, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Experiencia> agregarExperiencia(@RequestBody Experiencia experiencia){
        Experiencia nuevaExperiencia = experienciaService.createExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Experiencia> eliminarExperiencia(@PathVariable Long id){
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
