package org.example;

public class Coche {
    // Caracteristicas de un objeto
    // 1- Estado: se representa con instancias de variables
    // 2- Comportamiento: se representa con metodos
    // 3- Identidad: permite que los objetos interactuen entre si

    // Atributos
    String color;
    String marca;
    String modelo;
    String motor;
    int llantas;
    int asientos;

    // Constructor
    // 1- Tiene el mismo nombre que la clase
    // 2- No se hereda
    // 3- No puede devolver ningun valor
    // 4- Puede haber mas de un constructor por clase (sobrecarga)
    // 5- Puede no definirse de manera explicita

    // Constructor vacio
    public Coche(){}

    // Constructor con datos
    public Coche(String color, String marca, String modelo, String motor, int llantas, int asientos) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.llantas = llantas;
        this.asientos = asientos;
    }

    // Metodos
    public void encender() {
        System.out.println("El coche esta encendido");
    }

    public void apagar() {
        System.out.println("El coche esta apagado");
    }

    public void acelerar() {
        System.out.println("El coche esta acelerando");
    }

    public void frenar() {
        System.out.println("El coche esta frenando");
    }
}
