package pojo;
public class CarritoDeCompras {
    private Producto[] productos; // Array de productos
    private int contador; // Lleva el seguimiento de cuántos productos hay en el carrito para no pasarnos de la dimensión del array.

    // Constructor
    public CarritoDeCompras() {
        productos = new Producto[3]; // Inicializa un array con 3 posiciones
        contador = 0; // Inicialmente no hay productos
    }

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto) {
        if (contador < productos.length) {
            productos[contador] = producto;
            contador++;
        } else {
            System.out.println("El carrito está lleno. No se pueden agregar más productos.");
            System.out.println();
        }
    }

    // Método para calcular el total de los productos en el carrito
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getPrecio();
        }
        // Redondear a 2 decimales
        return Math.round(total * 100.0) / 100.0;
    }

    // Método para mostrar los productos en el carrito
    public void mostrarCarrito() {
        System.out.println("Productos en el carrito:");
        for (int i = 0; i < contador; i++) {
            System.out.println("- " + productos[i].getNombre() + ": " + productos[i].getPrecio() + "€");
        }
    }
}
