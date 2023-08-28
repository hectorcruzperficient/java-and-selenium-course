package org.example.polimorfismo;

public abstract class Animal {

    public abstract void makeNoise();

    public abstract void makeNoise(boolean aullar);

    public void comer() {
        System.out.println("El animal esta comiendo");
    }

}
