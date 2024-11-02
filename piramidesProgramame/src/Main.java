import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {

    static int numLineas;
    static final int numYears = 3;
    static int[][] cadenaYears;
    static String input;

    static Scanner leer = new Scanner(System.in);

    public static void llenarArrays(int numLineas) {

        for (int i = 0; i < numLineas; i++) {
            input = leer.nextLine();

            if (input.isEmpty()) {
                continue;
            }

            String[] partes = input.split(" ");

            for (int j = 0; j < numYears; j++) {
                cadenaYears[i][j] = Integer.parseInt(partes[j]);
            }
        }
    }

    public static int medirDistancia(int x, int y) {
        // Excluimos el 0 y contamos posiciones entre los valores
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            return Math.abs(x) + Math.abs(y) - 1; // El -1 ignora el cruce por 0
        } else {
            return Math.abs(x - y); // Distancia normal si ambos son positivos o negativos
        }
    }

    public static String devolverCercano(int i) {
        int a = cadenaYears[i][0];
        int b = cadenaYears[i][1];
        int c = cadenaYears[i][2];

        int distanciaA = medirDistancia(a, b);
        int distanciaC = medirDistancia(c, b);

        if (distanciaA == distanciaC) {
            return "EMPATE";
        } else if (distanciaA < distanciaC) {
            return String.valueOf(a);
        } else {
            return String.valueOf(c);
        }
    }


    public static void main(String[] args) {
        numLineas = leer.nextInt();
        leer.nextLine();
        cadenaYears = new int[numLineas][numYears];

        llenarArrays(numLineas);

        for (int i = 0; i < numLineas; i++) {
            System.out.print(devolverCercano(i));
            System.out.println();
        }
    }
}