package pojo;


public class Producto {
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter del nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter del precio del producto
    public double getPrecio() {
        return precio;
    }

    // Setter del precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
