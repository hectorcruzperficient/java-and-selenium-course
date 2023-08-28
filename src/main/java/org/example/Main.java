package org.example;

import org.example.polimorfismo.Animal;
import org.example.polimorfismo.Gato;
import org.example.polimorfismo.Perro;

public class Main {
    public static void main(String[] args) {

        // Programacion orientada a objetos
        // Objetos
        // Clases
        // Metodos
        // Herencia          - Es un mecanismo por el cual una clase permite heredar caracteristicas (metodos y atributos) a otra clase
        // Abstraccion       - Consiste en seleccionar datos de un conjunto mas grande para mostrar solo los detalles relevantes del objeto
        // Polimorfismo
        // Encapsulamiento   - 


        // Objeto
        // Instancia de una clase con datos especificos. Objetos normalmente puede corresponder a objetos reales.

        // Clase
        // Tipo de dato definido por el usuario que se utiliza como borrador para objetos individuales. Contiene atributos y metodos.


//        Coche coche1 = new Coche();
//        Coche coche2 = new Coche("rojo", "honda", "2020", "hibrido", 4, 5);
//
//        coche1.llantas = coche2.llantas;
//        coche1.marca = coche2.marca;
//        coche1.color = "azul";
//
//        coche1.acelerar();
//        coche2.encender();
//
//        System.out.println("El coche 1 tiene " + coche1.llantas + " llantas");
//        System.out.println("El coche 2 tiene " + coche2.llantas + " llantas");
//
//        System.out.println("El coche 1 es " + coche1.marca);
//        System.out.println("El coche 2 es " + coche2.marca);

//        CocheDeportivo porsche = new CocheDeportivo();
//
//        porsche.encender();
//        porsche.acelerar();
//        porsche.setModoTurbo();
//        porsche.frenar();
//        porsche.apagar();


//        Empleado neto = new Salario("Ernesto", "Avenida Siempre Viva 123", "12345678", 50000);
//        System.out.println("El salario de: " + neto.nombre + " es: " + neto.getSalario());

//        Persona hombre1 = new Persona();
//
//        hombre1.setNombre("Ernesto");
//
//        System.out.println("El nombre de la persona es: " + hombre1.getNombre());

        Animal toto = new Perro();
        toto.comer();
        toto.makeNoise();
        toto.makeNoise(true);


        Animal misifus = new Gato();
        misifus.makeNoise();
        misifus.makeNoise(true);
    }
}