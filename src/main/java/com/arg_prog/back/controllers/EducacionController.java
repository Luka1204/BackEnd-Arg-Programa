/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.controllers;

import com.arg_prog.back.models.Educacion;
import com.arg_prog.back.services.EducacionService;
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
@RequestMapping("/api/educacion")/*MAPEO DE PETICIONES AL SERVIDOR EN LA TABLA  EDUCACION*/
public class EducacionController {
    public final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    
    @GetMapping /*PETICION GET PARA OBTENER TODAS LAS EDUCACIONES*/
    
    public ResponseEntity <List <Educacion>> obetenerEducacion(){    /*METODO DE TIPO RESPUESTA DE ENTIDAD PARA OBETNER UNA LISTA CON TODAS LAS EDUCACIONES*/
        List <Educacion> educaciones =educacionService.searchEducacion();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);/*Retorna una respuesta de entidad, que se la pasa por parametro */
    }                                                           /*la entidad (En este caso educacion) y el estatus HTTP que va a devolver*/
    
    @PutMapping
    public ResponseEntity<Educacion> actualizarEducacion(@RequestBody Educacion educacion){     /*Actualizamos la eduacion pidiendo x parametro un cuerpo de solicitud verificando si exite la persona,*/
        Educacion editEducacion = educacionService.updateEducacion(educacion);                    /*en caso de que exista creamos un objeto que tenga com instancia nuestro servicio con el metodo update del mismo*/
        return new ResponseEntity<>(editEducacion, HttpStatus.OK);                                /*la entidad (En este caso educacion) y el estatus HTTP que va a devolver*/
    }
    
    @PostMapping
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){    /*METODO PARA AGREGAR UNA EDUCACION PIDIENDO X PARAMETRO UN CUERPO DE SOLICITUD Y LA EDUCACION A AGREGAR*/
        Educacion nuevaEducacion = educacionService.createEducacion(educacion);     
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> eliminarEducacion(@PathVariable Long id){                      /*METODO PARA ELIMINAR UNA EDUCACION X ID*/
        educacionService.deleteEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    
    }
}
