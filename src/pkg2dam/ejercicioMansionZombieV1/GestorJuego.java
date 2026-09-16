/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2dam.ejercicioMansionZombieV1;

import java.util.Scanner;

public class GestorJuego {

    Scanner sc;
    superviviente Superviviente;
    juego juego;

    public GestorJuego(Scanner sc, superviviente Superviviente, juego juego) {
        this.sc = sc;
        this.Superviviente = Superviviente;
        this.juego = juego;
    }

public void turno() {

    int opcion;

    do {

        System.out.println("1. combatir");
        System.out.println("2. buscar");
        System.out.println("3. curarse");
        System.out.println("4. avanzar");

        opcion = sc.nextInt();

        if (opcion == 1) {

            if (juego.getNumeroZombies() > 0) {

                Zombie z = new Zombie(juego);

                combate(z);

                juego.setNumeroZombies(
                        juego.getNumeroZombies() - 1
                );

            } else {

                System.out.println("No hay zombies para combatir");
            }

        } else if (opcion == 2) {

            if (juego.getNumeroZombies() == 0) {

                buscarHabitacion(Superviviente, juego);

            } else {

                System.out.println("No puedes buscar, hay zombies");
            }

        } else if (opcion == 3) {

            if (juego.getNumeroZombies() == 0) {

                curarse(Superviviente, juego);

            } else {

                System.out.println("No puedes curarte, hay zombies");
            }

        } else if (opcion == 4) {

            if (juego.getNumeroZombies() == 0) {

                avanzar(juego);

            } else {

                System.out.println("No puedes avanzar, hay zombies");
            }
        }

    } while (opcion != 4);
}

    public void combate(Zombie z) {


    while (z.getPuntosVida() > 0 && Superviviente.getPuntosVidaActuales()> 0) {

        int tiroDado = (int) (Math.random() * Superviviente.getPuntosAtaque()) + 1;

        int ataqueSuperviviente = tiroDado + Superviviente.getCantidadArmas();

        System.out.println("El superviviente ataca con " + ataqueSuperviviente);

        z.setPuntosVida(z.getPuntosVida() - ataqueSuperviviente);

        if (z.getPuntosVida() <= 0) {

            System.out.println("Zombie muerto");

        } else {


            int tiroDadoZombie = (int) (Math.random() * z.getPuntosAtaque()) + 1;


            int ataqueZombie = tiroDadoZombie - Superviviente.getCantidadProteccion();

            if (ataqueZombie < 0) {
                ataqueZombie = 0;
            }

            System.out.println("El zombie ataca con " + ataqueZombie);

            Superviviente.setPuntosVida(
                    Superviviente.getPuntosVidaActuales()- ataqueZombie
            );


            if (Superviviente.getPuntosVidaActuales()<= 0) {
                System.out.println("El superviviente ha muerto");
            }
        }
    }
}
    
    public void buscarHabitacion (superviviente s, juego j) {
        
        int dado = (int) (Math.random()* 100) + 1;
        int armas = s.getCantidadArmas();
        int numIntentos = j.getNumIntentos() - 1;
        j.setNumIntentos(numIntentos);
        int proteccion = s.getCantidadProteccion();
        
        if (dado <=100 && dado >=96) {
            
            System.out.println("ha encontrado un arma!!");
            armas = armas + 1;
            s.setCantidadArmas(armas);
            
        } else if (dado <= 95 && dado >=91){
            
            System.out.println("ha encontrado una proteccion!!");
            proteccion = proteccion + 1;
            s.setCantidadProteccion(proteccion);
            
        } else if(dado <= 90 && dado >=76){
            
            if(s.isBotiquinLleva()) {
                System.out.println("ya tiene un botiquin, no puede tener mas de 1");
            } else {
                s.setBotiquinLleva(true);
                System.out.println("he encontrado un botiquin!!");
            }
            
        } else {
            
            System.out.println("vaya!!, ha hecho ruido...");
            System.out.println("tire otra vez los dados");
            int dado2 = (int) (Math.random()* 100) + 1;
                    
            if (dado2 >= 1 && dado2 <= 40) {
                System.out.println("no ha pasado nada.....");
            } else if(dado2 >= 41 && dado2 <= 80) {
                System.out.println("ha aperecido un zombie!!!");
              Zombie z1 = new Zombie(j);
              combate(z1);
            } else {
                Zombie z2 = new Zombie(j);
                combate(z2);
                Zombie z3 = new Zombie(j);
                combate(z3);
            }
        }
        
        if(numIntentos <= 0) {
            System.out.println("se le acabaron los intentos");
        }
        
    }
    
public void curarse(superviviente s, juego j) {

    int puntosVida = s.getPuntosVidaActuales();

    if (j.getNumeroZombies() == 0 && s.isBotiquinLleva()) {

        puntosVida = puntosVida + 4;

        if (puntosVida > s.getPuntosVida()) {
            puntosVida = s.getPuntosVida();
        }

        s.setPuntosVidaActuales(puntosVida);
        s.setBotiquinLleva(false);

        System.out.println("se ha curado 4 puntos");
    } else {
        System.out.println("no puede curarse");
    }
}
    public void avanzar(juego j ) {
        
        int busquedas = j.getNumIntentos();
        int numHabitacion = j.getHabitacionActual();
        
        if(numHabitacion < j.getNumMaxHabitaciones() ) {
            
            busquedas = 3;
            j.setNumIntentos(busquedas);
            j.setNumeroZombies(1);
            j.setHabitacionActual(numHabitacion + 1);
            
            System.out.println("ha avanzado de habitacion a la " + j.getHabitacionActual() );
            
        }
            
    }
           
}

    


