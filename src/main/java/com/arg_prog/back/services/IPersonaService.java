/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.models.Persona;
import com.arg_prog.back.repository.PersonaRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IPersonaService {
    public IPersonaService PersonaService(PersonaRepo personaRepo);
    
    public Persona createPersona(Persona persona);
    
    public List <Persona> searchPersona();
    
    public void deletePersona(Long id);
    
    public Persona updatePersona(Persona persona);
    
    public Persona getPersonaByID(Long id);

    
}
