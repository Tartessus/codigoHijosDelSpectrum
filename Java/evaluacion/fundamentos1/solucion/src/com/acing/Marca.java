package com.acing;

public class Marca {
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public Marca(String nombre) {
        super();
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
}
