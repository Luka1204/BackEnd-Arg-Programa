/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.controllers;

import com.arg_prog.back.models.Proyectos;
import com.arg_prog.back.services.ProyectosService;
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
@RequestMapping("/api/proyectos")/*MAPEO DE PETICIONES AL SERVIDOR EN LA TABLA  PROYECTOS*/
public class ProyectoController {
    public final ProyectosService proyectosService;

    public ProyectoController(ProyectosService proyectosService) {
        this.proyectosService = proyectosService;
    }
    
    @GetMapping
    public ResponseEntity<List <Proyectos>> obtenerProyectos(){
        List <Proyectos> proyectos = proyectosService.searchProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    @PutMapping
     public ResponseEntity<Proyectos>actualizarProyectos(@RequestBody Proyectos proyecto){
        Proyectos editProyectos = proyectosService.updateProyectos(proyecto);
        return new ResponseEntity<>(editProyectos, HttpStatus.OK);
    }
    
    @PostMapping
       public ResponseEntity<Proyectos>agregarProyectos(@RequestBody Proyectos proyecto){
        Proyectos nuevosProyectos = proyectosService.createProyecto(proyecto);
        return new ResponseEntity<>(nuevosProyectos, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
     public ResponseEntity<?> eliminarProyecto(@PathVariable Long id){
        proyectosService.deleteProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
