package org.example.polimorfismo;

public class Perro extends Animal{


    @Override
    public void makeNoise() {
        System.out.println("El perro esta ladrando");
    }

    @Override
    public void makeNoise(boolean aullar){
        System.out.println("El perro esta aullando");
    }
}
