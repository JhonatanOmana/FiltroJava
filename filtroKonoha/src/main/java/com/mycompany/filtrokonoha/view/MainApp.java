/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.filtrokonoha.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    public void showSupplyMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. listarNinjas ");
            System.out.println("2. listar Misiones Disponibles");
            System.out.println("3. listar Misiones Completadas");
            System.out.println("4. asignar Mision");
            System.out.print("Seleccione una opción: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        listarNinjas();
                        break;
                    case 2:
                        listarMisionesCompletadas();
                        break;
                    case 3:
                        listarMisionesCompletadas();
                        break;    
                    case 4:
                        asignarMision();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido");
            }
        }
    }

    private void listarNinjas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
