/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.models.Persona;
import com.arg_prog.back.repository.PersonaRepo;
import com.arg_prog.back.exceptions.UserNotFoundException;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {
    private final PersonaRepo personaRepo; /*Instanciamos el repositorio que vamos a utilizar*/

    public PersonaService(PersonaRepo personaRepo) {    /*Creamos nuestro constructor con la instancia de sus atributos*/
        this.personaRepo = personaRepo;
    }
   public Persona createPersona(Persona persona){       /*Metodo para crear una persona*/
       return personaRepo.save(persona);
   }
   public List <Persona> serachPersona(){               /*Metodo para traer a todas las Personas*/
       return personaRepo.findAll();
   }
   public Persona updatePersona(Persona persona){       /*Metodo para actualizar los datos de la persona*/
       return personaRepo.save(persona);
   }
   
   public void deletePersona(Long id){                  /*Metodo pra eliminar a una persona x ID*/
       personaRepo.deleteById(id);
   }

   public Persona getPersonaByID(Long id){              /*Metodo para encontrar a una persona por ID. En caso de que no esxista lanza una excepcion*/
       return personaRepo.findById(id).orElseThrow( () -> new UserNotFoundException("Educacion no encontrado"));
   }
}
