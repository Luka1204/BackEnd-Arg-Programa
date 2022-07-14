/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.arg_prog.back.repository;

import com.arg_prog.back.models.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luka
 */
public interface EducacionRepo extends JpaRepository<Educacion,Long> {
    
}
