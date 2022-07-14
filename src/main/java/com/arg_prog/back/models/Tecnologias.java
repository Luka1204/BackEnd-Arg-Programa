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
public class Tecnologias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tecnologias;
    
    private String nombre;
    private int porcentaje_dominado;
    private String tipo;

 

    public Tecnologias() {
    }

    public Tecnologias(Long id_tecnologias, String nombre, int porcentaje_dominado, String tipo) {
        this.id_tecnologias = id_tecnologias;
        this.nombre = nombre;
        this.porcentaje_dominado = porcentaje_dominado;
        this.tipo= tipo;
    }

   public Long getId_tecnologias() {
        return id_tecnologias;
    }

    public void setId_tecnologias(Long id_tecnologias) {
        this.id_tecnologias = id_tecnologias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje_dominado() {
        return porcentaje_dominado;
    }

    public void setPorcentaje_dominado(int porcentaje_dominado) {
        this.porcentaje_dominado = porcentaje_dominado;
    }


   
    
}
