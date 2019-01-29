package com.app;

import java.util.ArrayList;
import java.util.Collection;

import com.acing.Carrito;
import com.acing.Comerciable;
import com.acing.Identificable;
import com.acing.Marca;
import com.acing.Producto;
import com.acing.ProductoExterno;

public class App {
    // Nos piden crear la coleccion con estos modificadores
    // variable de clase (static)
    // inmutable (final) y
    // que solo se vea en la clase (private)
    // Lo correcto es escribir el nombre en mayusculas para constantes
    private final static Collection<Producto> PRODUCTOS = new ArrayList<>();
    private Carrito carrito;
    int[] almacen;
    
    public Carrito getCarrito() {
		return carrito;
    }
    
    public int[] getAlmacen() {
	return almacen;
    }

    public void setAlmacenHastaId(int id) {
	almacen = new int[id + 1];
    }

    public App() {
	super();
	carrito = new Carrito();
    }

    public static void main(String[] args) {
        
        Producto refresco = new Producto(1, new Marca("Coca Cola"), "12 latas de Refresco", 6.01);
        Producto leche = new Producto(2, new Marca("President"), "Leche Semidesnatada 1 litro", .72);
        Producto dentifrico = new Producto(5, new Marca("Oral B"), "Dentifrico", 1.99);
        Producto agua = new Producto(8, new Marca("Font Vella"), "6 botellas 1,5 litros", 2.99);
        
        App app = new App();
        
        // Agrego los dos primeros
        app.getCarrito().addProducto(refresco);
        app.getCarrito().addProducto(leche);
        
        // Vemos que funciona
        // Mejor tener las String extras apartadas del metodo que genera el informe
        System.out.println("Contenido carrito es:\n" + app.getCarrito().getInformeCarrito());

        // Vemos que se actualice correctamente con otro Producto mas
        app.getCarrito().addProducto(dentifrico);
        System.out.println("Contenido carrito es:\n" + app.getCarrito().getInformeCarrito());
        
        // Comprobamos que nuestro diseno funciona con la libreria externa
        Comerciable libro = new ProductoExterno("Crime & Punishment", 0.46);
        app.getCarrito().addProducto(libro);
        System.out.println("Contenido carrito es:\n" + app.getCarrito().getInformeCarrito());
        
	// Pongo todos los productos en la Collection que me piden
	PRODUCTOS.add(refresco);
        PRODUCTOS.add(leche);
        PRODUCTOS.add(dentifrico);
        PRODUCTOS.add(agua);
	
        // Compruebo que funciona el metodo
        int maximoID = getMaximoId(PRODUCTOS);
        System.out.println("Maximo id es: " + maximoID);
		
        // Se creara un array de la dimension correcta con los indices que necesitamos
        app.setAlmacenHastaId(maximoID);
        // Cargo las existencias en el indice que corresponde con el id
        // Tambien podria hacerme un metodo "establecerExistencias(identificable, cantidad)"
        app.getAlmacen()[1] = 8;
        app.getAlmacen()[2] = 3;
        app.getAlmacen()[5] = 0;
        app.getAlmacen()[8] = 1;
        
        app.addToCarrito(dentifrico);
        System.out.println("Contenido carrito es:\n" + app.getCarrito().getInformeCarrito());
        app.addToCarrito(agua);
        System.out.println("Contenido carrito es:\n" + app.getCarrito().getInformeCarrito());
    }
    
    // Usando wildcards seria asi
    private static int getMaximoId(Collection<? extends Identificable> productos) {
    // Pero tambien podria hacerse con un tipo variable con esta otra definicion
    //private static <T extends Identificable> int getMaximoId(Collection<T> productos) {
    	// Empiezo en un valor incorrecto y que debe actualizarse si hay productos
        int maximoId = -1;
        for (Identificable producto : productos) {
            if(maximoId < producto.getId()) {
                maximoId = producto.getId();
	    }
        }
        
        return maximoId;
    }

    // Aqui necesito que sea un tipo que implemente las dos interfaces
    public <T extends Identificable & Comerciable> boolean addToCarrito(T producto) {
        boolean agregado = false;
	String mensaje;
        if(cantidadEnAlmacenDe(producto) > 0) {
            agregado = getCarrito().addProducto(producto);
	    if(agregado) {
	        getAlmacen()[producto.getId()]--;
                mensaje = "Quedan " + cantidadEnAlmacenDe(producto) + " de " + producto;
	    }
            else{
		mensaje = "Ocurrió un error al añadir " + producto;
	    }
        }
        else {
            mensaje = "No hay existencias de " + producto;
        }
	System.out.println(mensaje);
        
        return agregado;
    }

    private int cantidadEnAlmacenDe(Identificable producto) {
	return getAlmacen()[producto.getId()];
    }
}
