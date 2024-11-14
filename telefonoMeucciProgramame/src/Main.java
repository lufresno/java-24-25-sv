import java.util.Scanner;

public class Main {

    // Arreglos paralelos para símbolos romanos y sus valores
    private static final String[] simbolosRomanos = {"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final int[] valores = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Procesar cada línea de entrada hasta que no haya más líneas
        while (scanner.hasNextLine()) {
            String numeroRomano = scanner.nextLine();
            if (numeroRomano.isEmpty()) {
                break; // Finalizar si la entrada está vacía
            }

            // Calcula las combinaciones válidas para el número romano
            int combinaciones = contarCombinaciones(numeroRomano);
            System.out.println(combinaciones);
        }
        scanner.close();
    }

    // Función para contar combinaciones válidas
    public static int contarCombinaciones(String numeroRomano) {
        int n = numeroRomano.length();
        int[] memo = new int[n + 1]; // Array para almacenar combinaciones posibles
        memo[0] = 1; // Punto de partida para las combinaciones

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < simbolosRomanos.length; j++) {
                String simbolo = simbolosRomanos[j];
                int len = simbolo.length();

                // Si el segmento actual coincide con el símbolo romano
                if (i >= len && numeroRomano.substring(i - len, i).equals(simbolo)) {
                    memo[i] += memo[i - len]; // Sumar combinaciones posibles
                }
            }
        }
        return memo[n];
    }
}