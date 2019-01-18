package com.acing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Carrito {
	// Al Carrito le da igual la Marca o el ID,
	// con que tenga getDescripcion() y getPrecio() los Productos es suficiente
    Collection<Comerciable> productos = new ArrayList<>();
    
    public Collection<Comerciable> getProductos() {
        return productos;
    }

    // No se pide que sea generico, basta con ponerle un tipo que
    // sirva para todos los casos de la practica
    public boolean addProducto(Comerciable producto) {
    	// Simplemente devuelvo el resultado de Collection.add
        return getProductos().add(producto);
    }
    
    public double getValorCarrito() {
        double total = 0;
        // Uso el tipo mas basico para lo que necesito: getPrecio()
        for (Comerciable comerciable : getProductos()) {
            total += comerciable.getPrecio();
        }
        
        return total;
    }
    
    public String getInformeCarrito() {
        String informe = "";
        ((List<Comerciable>)productos).sort(new Comparator<Comerciable>() {
            @Override
            public int compare(Comerciable p1, Comerciable p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });
        
        for (Comerciable comerciable : productos) {
            informe += comerciable + " " + comerciable.getPrecio() +" euros\n";
        }
        // Esta seria la mejor forma, pero se podria dejar con mas decimales si no lo piden
        informe += String.format("\tEl total es: %.2f euros\n", getValorCarrito());
        
        return informe;
    }
}
