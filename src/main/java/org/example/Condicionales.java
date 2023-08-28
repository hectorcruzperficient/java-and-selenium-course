package org.example;

public class Condicionales {

    // Tema 4: Condicionales
    // if
    // if else
    // if else if
    // nested if
    // switch
    public static void main(String[] args) {

        // Variables
        int limiteDeVelocidad = 80; // km/hr
        int velocidadActual = 60;
        boolean isCarretera = false;

        if (isCarretera == true) {
            limiteDeVelocidad = 120;
            if (velocidadActual > limiteDeVelocidad) {
                System.out.println("Vas a exceso de velocidad");
            } else {
                System.out.println("Vas dentro del limite de velocidad");
            }
        } else if (velocidadActual > limiteDeVelocidad) {
            System.out.println("Vas a exceso de velocidad");
        } else {
            System.out.println("Vas dentro del limite de velocidad");
        }


        String iniciales = "DO";

        switch (iniciales) {
            case "PC":
                System.out.println("Pablo Contreras");
                break;
            case "DO":
                System.out.println("David Oliva");
                break;
            case "EA":
                System.out.println("Ernesto Anaya");
                break;
            default:
                System.out.println("Desconocido");
                break;
        }
    }
}
