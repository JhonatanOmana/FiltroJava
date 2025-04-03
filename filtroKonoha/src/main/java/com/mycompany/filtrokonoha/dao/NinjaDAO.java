/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtrokonoha.dao;

import com.mycompany.filtrokonoha.model.Mision;
import com.mycompany.filtrokonoha.model.MisionNinja;
import com.mycompany.filtrokonoha.model.Ninja;
import java.util.List;




/**
 *
 * @author Uniminuto Tibu
 */
public interface NinjaDAO {
    List<Ninja> listarNinjas();
    Ninja buscarNinja(int id);
    List<Mision> listarMisionesDisponibles(int idNinja);
    List<MisionNinja> listarMisionesCompletadas(int idNinja);
    void asignarMision(int idNinja,int idMision);
    void completarMision(int idNinja, int idMision); 
}
