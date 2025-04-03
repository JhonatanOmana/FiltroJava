/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtrokonoha.service;

import com.mycompany.filtrokonoha.model.MisionNinja;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Uniminuto Tibu
 */
public class FileManager {
    private static final String FILE_PATH = "misiones_completadas.txt";
    
    public void guardarMisionesCompletadas(List<MisionNinja>misiones){
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH)))
                    m.getIdMision(),m.getFechaInicio(),m.getFechaFin())
                    
                    ));
            
        }
    }
    
}
