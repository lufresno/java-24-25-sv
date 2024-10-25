import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {

    static int numLineas;
    static final int numYears= 3;
    static int[][] cadenaYears;
    static String input;

    static Scanner leer= new Scanner(System.in);

    public static void llenarArrays(int numLineas) {

        for (int i = 0; i < numLineas; i++) {//Vamos a leer tantas vueltas como líneas introduzca el usuario (y será la cantidad de líneas de la matriz).

            input= leer.nextLine();//Primero, lee en forma de String la entrada.

            if (input.isEmpty()){ //Excluímos el caso de encontrarnos con simplemente un salto de línea o línea vacía.
                continue;
            }

            //Ahora convertimos nuestro String en una línea de enteros, para poder introducirlos en la matriz.
            String []partes = input.split(" ");

            for (int j = 0; j < numYears; j++) {
                cadenaYears[i][j]= Integer.parseInt(partes[j]);
            }
        }
    }


    public static int medirDistancia(int x, int y) {
        return abs(x-y);
    }

    public static String  devolverCercano(int i) {
        int a= cadenaYears[i][0];
        int b= cadenaYears[i][1];
        int c= cadenaYears[i][2];

        if (medirDistancia(a,b) < medirDistancia(b,c)) {
            return String.valueOf(a);
        } else if (medirDistancia(c,b) < medirDistancia(a,b)) {
            return String.valueOf(c);
        } else {
            return "EMPATE";
        }
    }

    public static void main(String[] args) {
        numLineas= leer.nextInt();
        leer.nextLine();
        cadenaYears = new int[numLineas][numYears];


        llenarArrays(numLineas);

        for (int i = 0; i < numLineas; i++) {
            System.out.print(devolverCercano(i));
            System.out.println();
        }
    }

}