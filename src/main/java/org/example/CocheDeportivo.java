package org.example;

public class CocheDeportivo extends Coche{

    boolean modoTurbo;
    CocheDeportivo(){
        super();
    }

    public void setModoTurbo(){
        modoTurbo = true;
        System.out.println("El modo turbo esta activado");
    }
}
