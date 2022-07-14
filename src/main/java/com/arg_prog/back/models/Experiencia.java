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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id_experiencia;
    private String nombreEmpresa;
    private String fecha_inicio;
    private String fecha_final;
    private String ciudad;
    private String info_desc;
    private String puesto;

    public Experiencia() {
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    

    public Experiencia(Long id_experiencia, String nombreEmpresa, String fecha_inicio, String fecha_final, String ciudad, String info_desc, String puesto) {
        this.id_experiencia = id_experiencia;
        this.nombreEmpresa = nombreEmpresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.ciudad = ciudad;
        this.info_desc = info_desc;
        this.puesto = puesto;
    }

    public Long getId_experiencia() {
        return id_experiencia;
    }

    public void setId_experiencia(Long id_experiencia) {
        this.id_experiencia = id_experiencia;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getInfo_desc() {
        return info_desc;
    }

    public void setInfo_desc(String info_desc) {
        this.info_desc = info_desc;
    }


   

    
}
