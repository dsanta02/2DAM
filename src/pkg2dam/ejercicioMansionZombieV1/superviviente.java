/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;


public class superviviente {


    private int puntosVida;
    private int puntosVidaActuales;
    private int puntosAtaque;
    private boolean botiquinLleva;
    private int cantidadArmas;
    private int cantidadProteccion;

    public superviviente(int puntosVida, int puntosVidaActuales, int puntosAtaque, boolean botiquinLleva, int cantidadArmas, int cantidadProteccion) {
        this.puntosVida = 20;
        this.puntosVidaActuales = 20;
        this.puntosAtaque = 4;
        this.botiquinLleva = false;
        this.cantidadArmas = 0;
        this.cantidadProteccion = 0;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getPuntosVidaActuales() {
        return puntosVidaActuales;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public boolean isBotiquinLleva() {
        return botiquinLleva;
    }

    public int getCantidadArmas() {
        return cantidadArmas;
    }

    public int getCantidadProteccion() {
        return cantidadProteccion;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setPuntosVidaActuales(int puntosVidaActuales) {
        this.puntosVidaActuales = puntosVidaActuales;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public void setBotiquinLleva(boolean botiquinLleva) {
        this.botiquinLleva = botiquinLleva;
    }

    public void setCantidadArmas(int cantidadArmas) {
        this.cantidadArmas = cantidadArmas;
    }

    public void setCantidadProteccion(int cantidadProteccion) {
        this.cantidadProteccion = cantidadProteccion;
    }
    
    
    
    
    
    
}
