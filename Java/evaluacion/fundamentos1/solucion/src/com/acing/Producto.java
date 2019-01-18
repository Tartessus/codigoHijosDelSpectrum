package com.acing;

// Tipo para manejar los datos de los productos
public class Producto implements Comerciable, Identificable {
    int id;
    String descripcion;
    double precio;
    // Creo un tipo Marca para poder gestionarla mejor en el futuro
    Marca marca;
    
    // No usare setters para que no se pueda cambiar el valor una vez creado
    // Otra opcion seria poner los setters privados,
    // pero no hacen falta ni lo piden
    @Override
    public int getId() {
        return id;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    // Tengo que crearlo explicitamente o no lo tendre por
    // haber implementado otros
    public Producto(){
    	this(null, "Sin descripcion", .0);
    }
    
    public Producto(int id, Marca marca, String descripcion, double precio) {
        super();
        this.id = id;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public Producto(Marca marca, String descripcion, double precio) {
    	// Reutilizo el codigo del constructor que admite el id
    	// Le pongo -1 pues es un id que no pueden tener mientras
    	// almacen se implemente como pide la practica
        this(-1, marca, descripcion, precio);
    }

    @Override
    public String toString() {
        return getDescripcion() + " - " + getMarca();
    }
    
    
}
