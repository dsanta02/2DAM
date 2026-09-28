/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;

import java.util.Scanner;

public class GestorJuego implements accionesJugador{

    Scanner sc;
    superviviente Superviviente;
    juego juego;

    public GestorJuego(Scanner sc, superviviente Superviviente, juego juego) {
        this.sc = sc;
        this.Superviviente = Superviviente;
        this.juego = juego;
    }

    
    
@Override
    public void turno() {
    

    int opcion;

    do {
        
  
        if (juego.getNumeroZombies() > 0) {
            System.out.println("PV:" + Superviviente.getPuntosVidaActuales() +
                    " armas:" + Superviviente.getCantidadArmas() +
                    " proteccion:" + Superviviente.getCantidadProteccion());
            System.out.println("la habitacion " + juego.getHabitacionActual() +
                    " contiene " + juego.getNumeroZombies() + " zombies");
            System.out.println("elija una de las siguientes acciones:");
            System.out.println("1. combatir");   
        }
        if(juego.getNumeroZombies() ==  0){
            
        System.out.println("2. buscar por la habitacion (" + juego.getNumIntentos() + ")");
        System.out.println("3. curarse");
        if (juego.getHabitacionActual() == juego.getNumMaxHabitaciones()) {
            System.out.println("4. salir de la mansion");
        } else {
            System.out.println("4. avanzar a la otra habitacion");
        }
            
        }


        opcion = sc.nextInt();

        if (opcion == 1) {

            if (juego.getNumeroZombies() > 0) {

                Zombie z = new Zombie(juego);

                combate(z);

                if (z.getPuntosVida() <= 0) {
                    juego.setNumeroZombies(
                            juego.getNumeroZombies() - 1
                    );
                }


            } else {
                System.out.println("No hay zombies para combatir");
            }

        } else if (opcion == 2) {

            if (juego.getNumeroZombies() == 0) {

                buscarHabitacion();

            } else {

                System.out.println("No puedes buscar, hay zombies");
            }

        } else if (opcion == 3) {

            if (juego.getNumeroZombies() == 0) {

                curarse();

            } else {

                System.out.println("No puedes curarte, hay zombies");
            }

        } else if (opcion == 4) {

            if (juego.getNumeroZombies() == 0) {

                avanzar();

            } else{
                
                System.out.println("No puedes avanzar, hay zombies");
            }
        }

    } while (Superviviente.getPuntosVidaActuales() > 0 && juego.getHabitacionActual() <= juego.getNumMaxHabitaciones());
}
@Override
    public void combate(Zombie z) {
        
        int ronda = 1;

        System.out.println("el zombie tiene " + z.puntosAtaque + " puntos de ataque");
        System.out.println("el zombie tiene " + z.puntosVida + " puntos de vida");
        System.out.println("--RONDA " + ronda);

    while (z.getPuntosVida() > 0 && Superviviente.getPuntosVidaActuales()> 0) {

        int tiroDado = (int) (Math.random() * Superviviente.getPuntosAtaque()) + 1;

        int ataqueSuperviviente = tiroDado + Superviviente.getCantidadArmas();

        int tiroDadoZombie = (int) (Math.random() * z.getPuntosAtaque()) + 1;


        int ataqueZombie = tiroDadoZombie - Superviviente.getCantidadProteccion();




        System.out.println("El superviviente ataca con " + ataqueSuperviviente);
        System.out.println("el zombie ataca con valor " + ataqueZombie);
        System.out.println("--RONDA " + ronda);
        System.out.println("el superviviente ataca con " + Superviviente.getPuntosAtaque());
        
        

        z.setPuntosVida(z.getPuntosVida() - ataqueSuperviviente);

        if (z.getPuntosVida() <= 0) {

            System.out.println("has eliminado al zombie....");

        } else {



            if (ataqueZombie < 0) {
                ataqueZombie = 0;
            }

            System.out.println("El zombie ataca con " + ataqueZombie);

            Superviviente.setPuntosVidaActuales(
                    Superviviente.getPuntosVidaActuales() - ataqueZombie
            );

            if (Superviviente.getPuntosVidaActuales()<= 0) {
                System.out.println("El superviviente ha muerto");
            }
            
            ronda = ronda +1 ;
        }
    }
}
@Override 
    public void buscarHabitacion () {
        
        int dado = (int) (Math.random()* 100) + 1;
        int armas = Superviviente.getCantidadArmas();
        int numIntentos = juego.getNumIntentos() - 1;
        juego.setNumIntentos(numIntentos);
        int proteccion = Superviviente.getCantidadProteccion();
        
        System.out.println("OPCION 2:");
        
        if (dado <=100 && dado >=96) {
            
            System.out.println("ha encontrado un arma!!");
            armas = armas + 1;
            Superviviente.setCantidadArmas(armas);
            
        } else if (dado <= 95 && dado >=91){
            
            System.out.println("ha encontrado una proteccion!!");
            proteccion = proteccion + 1;
            Superviviente.setCantidadProteccion(proteccion);
            
        } else if(dado <= 90 && dado >=76){
            
            if(Superviviente.isBotiquinLleva()) {
                System.out.println("ya tiene un botiquin, no puede tener mas de 1");
            } else {
                Superviviente.setBotiquinLleva(true);
                System.out.println("he encontrado un botiquin!!");
            }
            
        } else {
            

            int dado2 = (int) (Math.random()* 100) + 1;
                    
            if (dado2 >= 1 && dado2 <= 40) {
            System.out.println("vaya!!, ha hecho ruido...");
            System.out.println("¡cuidado!");
            System.out.println("... por suerte nadie te ha escuchado al otro lado"
                    + "esta vez....");
            } else if(dado2 >= 41 && dado2 <= 80) {
                juego.setNumeroZombies(juego.getNumeroZombies() + 1);
                System.out.println("ha aperecido un zombie!!!");

            } else {
                juego.setNumeroZombies(juego.getNumeroZombies() + 2);
                System.out.println("vaya han aparecido 2 ZOMBIEEES!!!");
            }
        }
        
        if(numIntentos <= 0) {
            System.out.println("se le acabaron los intentos....");
        }
        
    }
@Override
    public void curarse() {

    int puntosVida = Superviviente.getPuntosVidaActuales();

    if (juego.getNumeroZombies() == 0 && Superviviente.isBotiquinLleva()) {

        puntosVida = puntosVida + 4;

        if (puntosVida > Superviviente.getPuntosVida()) {
            puntosVida = Superviviente.getPuntosVida();
        }

        Superviviente.setPuntosVidaActuales(puntosVida);
        Superviviente.setBotiquinLleva(false);

        System.out.println("se ha curado 4 puntos....");
        System.out.println("le queda " + Superviviente.getPuntosVidaActuales() + " puntos de vida");
    } else {
        System.out.println("no puede curarse, NO TIENE BOTIQUIN!!!");
    }
}
@Override
    public void avanzar( ) {
        
        int busquedas = juego.getNumIntentos();
        int numHabitacion = juego.getHabitacionActual();
        
        if(numHabitacion < juego.getNumMaxHabitaciones())
            busquedas = 3;
            juego.setNumIntentos(busquedas);
            juego.setNumeroZombies(1);
            juego.setHabitacionActual(numHabitacion + 1);
            
            System.out.println("ha avanzado de habitacion a la " + juego.getHabitacionActual() );
            
        }

}
           


    


