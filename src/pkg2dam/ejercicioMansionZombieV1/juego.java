/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;


public class juego {
    
    private int numMaxHabitaciones;
    private int numIntentos;
    private int habitacionActual;
    private int numeroZombies;

    public juego(int numMaxHabitaciones, int numIntentos, int habitacionActual, int numeroZombies) {
        
        this.numMaxHabitaciones = numMaxHabitaciones;
        this.numIntentos = 3;
        this.habitacionActual = 1;
        this.numeroZombies = 1;
    }

    public int getNumMaxHabitaciones() {
        return numMaxHabitaciones;
    }

    public int getNumIntentos() {
        return numIntentos;
    }

    public int getHabitacionActual() {
        return habitacionActual;
    }

    public int getNumeroZombies() {
        return numeroZombies;
    }

    public void setNumMaxHabitaciones(int numMaxHabitaciones) {
        this.numMaxHabitaciones = numMaxHabitaciones;
    }

    public void setNumIntentos(int numIntentos) {
        this.numIntentos = numIntentos;
    }

    public void setHabitacionActual(int habitacionActual) {
        this.habitacionActual = habitacionActual;
    }

    public void setNumeroZombies(int numeroZombies) {
        this.numeroZombies = numeroZombies;
    }
    
    
    
}
