/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.controllers;

import com.arg_prog.back.models.Usuarios;
import com.arg_prog.back.services.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    public UsuariosService userService;

    public UsuariosController(UsuariosService userServicio) {
        this.userService = userServicio;
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuarios> obtenerUsuario(@PathVariable Integer id){
        Usuarios usuario = userService.getUsuarioByID(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
            }
    
    @PutMapping("/update")
    public ResponseEntity<Usuarios> editarUsuario(@RequestBody Usuarios usuario){
         Usuarios editUsuario = userService.updateUsuario(usuario);
        return new ResponseEntity<>(editUsuario, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id){
        userService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    

}
