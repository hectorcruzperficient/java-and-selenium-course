package Actividades;

public class Actividad1 {
    // Actividad: Crear un arreglo unidimensional de 4 posiciones:
    // Nombre
    // Apellido
    // Edad
    // Correo
    // Imprimir el arreglo concatenando los valores

    public static void main(String[] args) {
        String[] array = new String[4];
        array[0] = "Hector";
        array[1] = "Cruz";
        array[2] = "33";
        array[3] = "hectora.cruzm@perficient.com";

        System.out.println("Nombre: " + array[0] + " " + array[1] + "\nEdad: " + array[2]
                + "\nCorreo: " + array[3]);
    }
}
