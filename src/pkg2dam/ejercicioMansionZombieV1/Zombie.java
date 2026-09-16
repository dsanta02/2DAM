/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;

import java.math.*;

public class Zombie {
    
    int puntosVida;
    int puntosAtaque;


    public Zombie(juego j) {
        
        this.puntosVida = numeroAleatorio() + 2 + j.getHabitacionActual() - 1;
        this.puntosAtaque = numeroAleatorio() + 2 + j.getHabitacionActual() - 1;
    }
    
    public int numeroAleatorio () {
        
        int num;
        num = (int) (Math.random()*2);
        return num;
        
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }


    
    
    
}
