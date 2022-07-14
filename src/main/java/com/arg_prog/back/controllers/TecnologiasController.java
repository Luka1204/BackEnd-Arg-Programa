/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.controllers;

import com.arg_prog.back.models.Tecnologias;
import com.arg_prog.back.services.TecnologiasService;
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
@RequestMapping("/api/tecnologias")
public class TecnologiasController {
    public final TecnologiasService tecnologiasService;

    public TecnologiasController(TecnologiasService tecnologiasService) {
        this.tecnologiasService = tecnologiasService;
    }
    
    @GetMapping
    public ResponseEntity<List<Tecnologias>> obtenerTecnologias(){
        List<Tecnologias> tecnologias = tecnologiasService.serachTecnologias();
        return new ResponseEntity(tecnologias, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Tecnologias> actualizarTecnologias(@RequestBody Tecnologias tecnologias){
        Tecnologias actualizarTecnologias = tecnologiasService.updateTecnologias(tecnologias);
        return new ResponseEntity(actualizarTecnologias, HttpStatus.OK);      
    }
    
    @PostMapping
    public ResponseEntity<Tecnologias> agregarTecnologias(@RequestBody Tecnologias tecnologias){
        Tecnologias nuevaTecnologia = tecnologiasService.updateTecnologias(tecnologias);
        return new ResponseEntity(nuevaTecnologia, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTecnologia(@PathVariable Long id){
        tecnologiasService.deleteTecnologias(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
