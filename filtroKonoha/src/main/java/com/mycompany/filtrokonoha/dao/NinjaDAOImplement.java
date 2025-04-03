/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtrokonoha.dao;

import com.mycompany.filtrokonoha.db.DatabaseConnection;
import com.mycompany.filtrokonoha.model.Habilidad;
import com.mycompany.filtrokonoha.model.Mision;
import com.mycompany.filtrokonoha.model.MisionNinja;
import com.mycompany.filtrokonoha.model.Ninja;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uniminuto Tibu
 */
public abstract class NinjaDAOImplement implements NinjaDAO  {
    Ninja ninja = new Ninja();

    @Override
    public List<Ninja> listarNinjas() {
        List<Ninja> ninjas = new ArrayList<>();
        String sqlNinja = "SELECT * FROM Ninja";
        String sqlHabilidad = "SELECT * FROM Habilidad WHERE ID_Ninja = ? ";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmtNinja= conn.prepareStatement(sqlNinja);
                ResultSet rsNinja = stmtNinja.executeQuery()){
            while (rsNinja.next()){
               
                
            ninja.setId(rsNinja.getInt("ID"));
            ninja.setNombre(rsNinja.getString("Nombre"));
            ninja.setRango(rsNinja.getString("Rango"));
            ninja.setAldea(rsNinja.getString("Aldea"));
            }
            
            
            
            try (PreparedStatement stmtHabilidad = conn.prepareStatement(sqlHabilidad)){
                stmtHabilidad.setInt(1,ninja.getId());
                ResultSet rsHabilidad = stmtHabilidad.executeQuery();
                
                List<Habilidad> habilidades = new ArrayList<>();
                
                while (rsHabilidad.next()){
                    Habilidad habilidad = new Habilidad();
                    
                    habilidad.setIdNinja(rsHabilidad.getInt("ID_ninja"));
                    habilidad.setNombre(rsHabilidad.getString("Nombre"));
                    habilidad.setDescripcion(rsHabilidad.getNString("Descripcion"));
                    
                    
                    habilidades.add(habilidad);
                }               
                ninja.setHabilidades(habilidades);
            }
            ninja.add(ninja);
        
     
        } catch (SQLException e) {
            System.out.println("Error l listar ninjas" +e.getMessage());
        }
        return ninjas;
        }

        @Override
        public List<Mision> listarMisionesDisponibles(int idNinja){
            List<Mision> misiones = new ArrayList<>();
            String sql = "SELECT * FROM Mision m WHERE m.ID NOT IN (SELECT ID_Mision FROM MisionNinja WHERE ID_Ninja = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                    PreparedStatement  stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, idNinja);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    Mision mision = new Mision();
                    mision.setId(rs.getInt("ID"));
                    
                    mision.setDescripcion(rs.getString("Descripcion"));
                    mision.setRnago(rs.getString("Rango"));
                    mision.setRecompensa(rs.getDouble("Recompensa"));
                    
                    misiones.add(mision);
                }
                
                
            } catch (SQLException e) {
                System.err.println("Error al listar misiones disponibles" +e.getMessage());
                  
            }
            return misiones;   
        }

    @Override
    public List<MisionNinja> listarMisionesCompletadas(int idNinja){
        List<MisionNinja> misiones = new ArrayList<>();
        String sql ="SELECT * FROM MisionesNinja WHERE ID_Ninja = ? AND FechaFin IS NOT NULL";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement  stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, idNinja);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                MisionNinja mn = new MisionNinja();
                
                mn.setIdNinja(rs.getInt("ID_Ninja"));
                mn.setIdMision(rs.getInt("ID_Mision"));
                mn.setFechaInicio(rs.getDate("FechaInicio").toLocalDate());
                mn.setFechaFin(rs.getDate("FechaFin").toLocalDate());
                
                misiones.add(mn);
                
                
            }
            
            
        } catch (SQLException e) {
            System.err.println("Error al listar las misiones completadas "+e.getMessage());  
        }
        return misiones;
    }

    @Override
    public void asignarMision(int idNinja, int idMision){
        String sql = "UPDATE MisionNinja SET FechaFin = ? WHERE ID_Ninja = ? AND ID_Mision = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement  stmt = conn.prepareStatement(sql)){
           stmt.setInt(1, idNinja);
           stmt.setInt(2, idMision);
           stmt.setDate(3, Date.valueOf(LocalDate.now()));
           stmt.executeUpdate();
   
    }   catch (SQLException e) {
        System.err.println("Error al asignar mision"+e.getMessage());
               
    }
       
}

    @Override
    public void completarMision(int idNinja, int idMision){
        String sql = "UPDATE MisionNinja SET FechaFin = ? WHERE ID_Ninja = ? AND ID_Mision = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement  stmt = conn.prepareStatement(sql)){
            stmt.setDate(1, Date.valueOf(LocalDate.now()));
            stmt.setInt(2, idNinja);
            stmt.setInt(3, idMision);
            stmt.executeUpdate();
            
            
        } catch (SQLException e) {
            System.err.println("Error al completar mision");
            
        }
            
            
            
               
    
    
    
    
        

        

    }    

    
   
       
    
}