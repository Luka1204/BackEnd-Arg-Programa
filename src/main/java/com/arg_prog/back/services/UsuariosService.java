/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.exceptions.UserNotFoundException;
import com.arg_prog.back.models.Usuarios;
import com.arg_prog.back.repository.UsuariosRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuariosService {
    private final UsuariosRepo usuarioRepo ;
    @Autowired
    public UsuariosService(UsuariosRepo userRepo){ this.usuarioRepo = userRepo; }
    
        public Usuarios addUsuario(Usuarios usuario){
            return usuarioRepo.save(usuario);
        }
        
        public List<Usuarios> buscarUsuario(){
            return usuarioRepo.findAll();
        }
    
       public Usuarios getUsuarioByID(Integer id){              /*Metodo para encontrar a una persona por ID. En caso de que no esxista lanza una excepcion*/
       return usuarioRepo.findById(id).orElseThrow( () -> new UserNotFoundException("Educacion no encontrado"));
   }
       
        public Usuarios updateUsuario(Usuarios usuario){
        return usuarioRepo.save(usuario);
    }
    
    public void deleteUsuario(Integer id){
        usuarioRepo.deleteById(id);
    }
}
