/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.models.Proyectos;
import com.arg_prog.back.repository.ProyectosRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    private final ProyectosRepo proyectosRepo;

    public ProyectosService(ProyectosRepo proyectosRepo) {
        this.proyectosRepo = proyectosRepo;
    }
    
    public Proyectos createProyecto(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }
    
    public List <Proyectos> searchProyectos(){
        return proyectosRepo.findAll();
    }
    
    public Proyectos updateProyectos(Proyectos proyectos){
        return proyectosRepo.save(proyectos);
    }
    
    public void deleteProyectos(Long id){
        proyectosRepo.deleteById(id);
    }
}
