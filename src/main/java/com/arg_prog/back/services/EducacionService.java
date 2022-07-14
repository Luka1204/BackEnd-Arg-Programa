/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.exceptions.UserNotFoundException;
import com.arg_prog.back.models.Educacion;
import com.arg_prog.back.repository.EducacionRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService{
    private final EducacionRepo educacionRepo;
    
    @Autowired
    public EducacionService(EducacionRepo educacionRepo){
        this.educacionRepo = educacionRepo;
    }
    
    public Educacion createEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    
    public List <Educacion> searchEducacion(){
        return educacionRepo.findAll();
    }
    
    public Educacion updateEducacion(Educacion educacion){
        return educacionRepo.save(educacion);
    }
    
    public void deleteEducacion(Long id ){
        educacionRepo.deleteById(id);
    }
    
    public Educacion getEducacionByID(Long id){
        return educacionRepo.findById(id).orElseThrow( () -> new UserNotFoundException("usuario no encontrado"));
    }
    
}


