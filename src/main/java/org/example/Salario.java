package org.example;

public class Salario extends Empleado{

    private double salario;
    public Salario(String nombre, String direccion, String phone, double salario) {
        super(nombre, direccion, phone);
        setSalario(salario);
    }

    public void setSalario(double salarioNuevo) {
        if (salarioNuevo > 0.0) {
            salario = salarioNuevo;
        }
    }

    public double getSalario() {
        return salario;
    }
}
