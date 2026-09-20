/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;

import java.util.Scanner;
import javax.xml.xpath.XPathVariableResolver;

public class Main {
    

    public static void main(String[] args) {
        
        superviviente s = new superviviente();
        juego j = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("BIENVENIDO A LA MANSIÓN ZOMBIE. ELIGE DIFICULTAD: ");
        System.out.println("1. FÁCIL (5 HABITACIONES)");
        System.out.println("2. DIFÍCIL (10 HABITACIONES");
        int opcion = sc.nextInt();
        
        if (opcion == 1) {
            
            j = new juegoFacil();
            
            
        } else if(opcion == 2) {
            
            j = new juegoDificil();
            
        }else {
            
            System.out.println("opcion incorrecta...");
            return;
        }
        
        GestorJuego x = new GestorJuego(sc, s, j);
        
        x.turno();
        
        sc.close();
        
    }
    
}
