/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;

import java.util.Scanner;
import javax.xml.xpath.XPathVariableResolver;

public class Main {
    

    public static void main(String[] args) {
        
        superviviente s = new superviviente(20, 20, 4, false, 0, 0);
        juego j = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("eliga una opcion: ");
        System.out.println("1. Facil");
        System.out.println("2. Dificil");
        int opcion = sc.nextInt();
        
        if (opcion == 1) {
            
            j = new juegoFacil(5, 3, 1, 1);
            
            
        } else if(opcion == 2) {
            
            j = new juegoDificil(10, 3, 1, 1);
            
        }else {
            
            System.out.println("opcion incorrecta...");
            return;
        }
        
        GestorJuego x = new GestorJuego(sc, s, j);
        
        x.turno();
        
        sc.close();
        
    }
    
}
