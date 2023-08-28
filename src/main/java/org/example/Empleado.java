package org.example;

public abstract class Empleado {

    String nombre;
    String direccion;
    String phone;

    public Empleado(String nombre, String direccion, String phone){
        this.nombre = nombre;
        this.direccion = direccion;
        this.phone = phone;
    }

    public double pago(){
        return 0.0;
    }

    public void enviarCorreo() {
        System.out.println("El pago se envi por correo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract double getSalario();
}
