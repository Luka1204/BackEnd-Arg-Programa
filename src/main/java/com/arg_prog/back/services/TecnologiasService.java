/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arg_prog.back.services;

import com.arg_prog.back.models.Tecnologias;
import com.arg_prog.back.repository.TecnologiasRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TecnologiasService {
    private TecnologiasRepo tecnologiasRepo;

    @Autowired
    public TecnologiasService(TecnologiasRepo tecnologiasRepo) {
        this.tecnologiasRepo = tecnologiasRepo;
    }
    
    public Tecnologias createTecnologias(Tecnologias tecnologias){
        return tecnologiasRepo.save(tecnologias);
    }
    
    public List <Tecnologias> serachTecnologias(){
        return tecnologiasRepo.findAll();
    }
    
    public Tecnologias updateTecnologias(Tecnologias tecnologias){
        return tecnologiasRepo.save(tecnologias);
    }
    
    public void deleteTecnologias(Long id){
        tecnologiasRepo.deleteById(id);
    }
    
    
    
}
