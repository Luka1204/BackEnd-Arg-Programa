/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.arg_prog.back.repository;

import com.arg_prog.back.models.Tecnologias;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luka
 */
public interface TecnologiasRepo extends JpaRepository<Tecnologias,Long>{
    
}
