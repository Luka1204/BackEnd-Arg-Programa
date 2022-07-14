/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.models.Experiencia;
import com.arg_prog.back.repository.ExperienciaRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    private final ExperienciaRepo experienciaRepo;

    @Autowired
    public ExperienciaService(ExperienciaRepo experienciaRepo) {
        this.experienciaRepo = experienciaRepo;
    }
    
    public Experiencia createExperiencia(Experiencia experiencia){
        return experienciaRepo.save(experiencia);
    }
    
    public List <Experiencia> searchExperiencia(){
        return experienciaRepo.findAll();
    } 
    
    public Experiencia updateExperiencia(Experiencia experiencia){
        return experienciaRepo.save(experiencia);
    }
    
    public void deleteExperiencia(Long id){
        experienciaRepo.deleteById(id);
    }
    
}
