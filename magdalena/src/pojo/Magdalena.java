package pojo;

public class Magdalena {
    //ATRIBUTOS
    private String sabor;
    private String color;
    private boolean cocinada;

    //CONSTRUCTOR
    public Magdalena(String sabor, String color, boolean cocinada){
        System.out.println("Sabor: " + sabor);
        System.out.println("Color: " + color);
        this.sabor= sabor;
        this.color= color;
    }

    //MÉTODO
    public void cocinar(){
        this.cocinada= true;
        System.out.println("La magdalena de sabor: "+ sabor+ " y color: " + color+ " se está cocinando.");
    }

    public void envolver(){
        System.out.println("La magdalena de sabor: "+ sabor+ " y color: " + color+ " se está envolviendo.");
    }
}
