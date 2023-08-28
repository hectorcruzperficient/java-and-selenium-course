package org.example.polimorfismo;

public class Gato extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("El gato esta maullando");
    }

    @Override
    public void makeNoise(boolean aullar) {
        System.out.println("El gato esta ronroneando");
    }
}
