/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import com.arg_prog.back.models.Tecnologias;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {
    @Id
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String email;
    private String imageURL;
    private String posicion;
    private String telefono;
    private String descripcion;
    private String fecha_nac;
    private String ciudad;
    private int edad;
    
    private String propuestaSkills;
    private String propuestaProfesional;

    public Persona() {
    }

    public Persona(Long id_persona, String nombre, String apellido, String email, String imageURL, String posicion, String telefono, String descripcion, String fecha_nac, String ciudad, int edad, String propuestaSkills, String propuestaProfesional) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imageURL = imageURL;
        this.posicion = posicion;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.fecha_nac = fecha_nac;
        this.ciudad = ciudad;
        this.edad = edad;
        this.propuestaSkills = propuestaSkills;
        this.propuestaProfesional = propuestaProfesional;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPropuestaSkills(){
        return propuestaSkills;
    }
    
    public void setPropuestaSkills(String propuestaSkills){
        this.propuestaSkills = propuestaSkills;
    }
    
     public String getPropuestaProfesional(){
        return propuestaProfesional;
    }
    
    public void setPropuestaProfesional(String propuestaProfesional){
        this.propuestaProfesional = propuestaProfesional;
    }
    

    
    
    
    
    
    
}
