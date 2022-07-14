/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_proyectos;


    private String nombre;
    private String imagenURL;
    private String enlace;

    public Proyectos() {
    }

    public Proyectos(Long id_proyectos, String nombre, String imagenURL, String enlace) {
        this.id_proyectos = id_proyectos;
        this.nombre = nombre;
        this.imagenURL = imagenURL;
        this.enlace = enlace;
    }
    public Long getId_proyectos() {
        return id_proyectos;
    }

    public void setId_proyectos(Long id_proyectos) {
        this.id_proyectos = id_proyectos;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    
    
}
