package com.acing;

import com.examen.Product3rdParty;

public class ProductoExterno extends Product3rdParty implements Comerciable {

    public ProductoExterno(String description, double price) {
        super(description, price);
    }

    @Override
    public String getDescripcion() {
        return getDescription();
    }

    @Override
    public double getPrecio() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "[PRUEBA EXTERNA] " + getDescripcion();
    }

}
