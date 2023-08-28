package org.example;

public class Arreglos {

    // Tema 6: Arreglos
    // Tipos de arreglos
    // 1- Unidmensional
    // 2- Bidimnesional
    // 3- Multidimensional
    public static void main(String[] args) {

        String Arreglo[];
        Arreglo = new String[10];

        Arreglo[0] = "A";
        Arreglo[1] = "B";
        Arreglo[2] = "C";
        Arreglo[3] = "D";
        Arreglo[4] = "E";
        Arreglo[5] = "F";
        Arreglo[6] = "G";
        Arreglo[7] = "H";
        Arreglo[8] = "I";
        Arreglo[9] = "J";

        for (int i = 0; i < Arreglo.length; i++) {
            System.out.println(Arreglo[i]);
        }

        String[] Arreglo2 = {"L", "M", "Mi", "J", "V", "S", "D"};
        System.out.println(Arreglo2[3]);

        String[][] nombres = new String[6][6];
        nombres[0][0] = "Pablo";
        nombres[0][1] = "Contreras";
        nombres[1][0] = "Liliana";
        nombres[1][1] = "Galan";
        nombres[2][0] = "Hector";
        nombres[2][1] = "Cruz";
        nombres[3][0] = "Alejandro";
        nombres[3][1] = "Castellanos";
        nombres[4][0] = "Juan";
        nombres[4][1] = "Nahle";
        nombres[5][0] = "Ernesto";
        nombres[5][1] = "Anaya";

        System.out.println("Mi nombre es: " + nombres[1][0] + " " + nombres[1][1]);

    }
    // Actividad: Crear un arreglo unidimensional de 4 posiciones:
    // Nombre
    // Apellido
    // Edad
    // Correo
    // Imprimir el arreglo concatenando los valores
}
