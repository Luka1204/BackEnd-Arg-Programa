/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.controllers;

import com.arg_prog.back.models.Persona;
import com.arg_prog.back.services.PersonaService;
import static org.hibernate.criterion.Projections.id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/persona")/*MAPEO DE PETICIONES AL SERVIDOR EN LA TABLA PERSONA*/
public class PersonaController {
    public final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    @GetMapping("/{id}") /*PETICION GET PARA OBTENER EL ID DE LA PERSONA QUE ESTA USANDO EL PORTFOLIO*/
    
    public ResponseEntity<Persona> obetenerPersona(@PathVariable Long id){    /*METODO PARA OBETNER A LA PERSONA*/
        Persona persona = personaService.getPersonaByID(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona){     /*Actualizamos el usuario pidiendo x parametro un cuerpo de solicitud verificando si exite la persona,*/
        Persona editPersona = personaService.updatePersona(persona);                    /*en caso de que exista creamos un objeto que tenga com instancia nuestro servicio con el metodo update del mismo*/
        return new ResponseEntity<>(editPersona, HttpStatus.OK);
    }
    
    
    
    
    
    
    
}
