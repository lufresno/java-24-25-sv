import pojo.CarritoDeCompras;
import pojo.Producto;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto magdalena = new Producto("Magdalena de chocolate", 1.50);
        Producto croissant = new Producto("Croissant", 1.20);
        Producto galleta = new Producto("Galleta de avena", 0.80);

        // Crear un carrito
        CarritoDeCompras carrito = new CarritoDeCompras();

        // Agregar productos al carrito
        carrito.agregarProducto(magdalena);
        carrito.agregarProducto(croissant);
        carrito.agregarProducto(galleta);

        //Añadimos uno más para comprobar que al no caber en la dim del array del carrito, no se añadiría.
        Producto extra= new Producto("extra", 30.00);
        carrito.agregarProducto(extra);

        // Mostrar contenido del carrito
        carrito.mostrarCarrito();

        // Calcular y mostrar el total redondeado
        System.out.println("Total a pagar: " + carrito.calcularTotal() + "€");
    }
}
