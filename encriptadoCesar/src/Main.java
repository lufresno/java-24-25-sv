import java.util.Scanner;

public class Main {
    static int numLineas;
    static String []cadenas= new String [numLineas];

    public static int obtenerDistancia(int fila){

        /*Para obtener la distancia a aplicar, vamos a restar el código ASCII de la primera letra (EN MINÚSCULA)
        de cada fila y el código ASCII de la p. */

        int distancia;
        distancia = ((cadenas[fila].toLowerCase()).charAt(0)) - 'p';
        return distancia;
    }

    public static String descifrarCadena(String input){
        return "FIN";
    }

    public static int contarVocales(int fila){

        char caracter;
        int vocales= 0;
        String cadenaActual= cadenas[fila];

        for (int i= 0; i< cadenaActual.length(); i++) {
            caracter= cadenaActual.charAt(i);
            if ( caracter % 2 != 0) {
                switch (caracter) {
                    case 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u':
                        vocales++;
                        break;
                }
            }
        }
        return vocales;
    }


    public static void leerTexto() {
        String input= "fin";
        while (descifrarCadena(input)!= "FIN"){

        }
    }

    public static void main(String[] args){
        leerTexto();
    }
}