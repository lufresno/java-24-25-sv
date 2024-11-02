import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            long bloques = scanner.nextLong();
            if (bloques == 0) {
                break; // Termina la entrada
            }

            int niveles = 0; // Contador de niveles
            long bloquesUsados = 0; // Contador de bloques usados
            int n = 1; // Comenzamos en el nivel 1

            // Calcular cuántos niveles se pueden construir
            while (bloquesUsados + (2 * n - 1) * (2 * n - 1) <= bloques) {
                long bloquesNivel = (2 * n - 1) * (2 * n - 1); // Bloques necesarios para el nivel n
                bloquesUsados += bloquesNivel; // Sumar los bloques del nivel actual
                niveles++; // Aumentar el número de niveles
                n++; // Aumentar para el siguiente nivel
            }

            System.out.println(niveles); // Imprimir el número de niveles construidos
        }

        scanner.close(); // Cerrar el Scanner al final del programa
    }
}
