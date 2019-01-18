package com.acing;

// Nos da la flexibilidad para poder usarlo con
// otros tipos no relacionados como com.examen.Product3rdParty
// Con esta interfaz es suficiente para getValorCarrito() y getInformeCarrito()
public interface Comerciable {

    String getDescripcion();

    double getPrecio();

}