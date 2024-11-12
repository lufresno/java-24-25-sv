import java.util.Random;

public class Main {
    static final int MAX_FILAS = 3;
    static final int MAX_COLUMNAS = 9;
    static int[][] matriz = new int[MAX_FILAS][MAX_COLUMNAS];
    static Random random = new Random();
    // Llenar la matriz de acuerdo al rango en cada columna
    public static void imprimirMatriz() {
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }
    // Imprimir la matriz
    public static void rellenarMatriz() {
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;     	// valor máximo para la columna actual

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }
        }
    }
    //Método burbuja
    public static void ordenarColumnas(){
        int aux;
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            for (int k = 0; k < MAX_FILAS - 1; k++) {
                for (int i = 0; i < MAX_FILAS - k - 1; i++) {
                    if (matriz[i][j] > matriz[i + 1][j]) {
                        aux = matriz[i][j];
                        matriz[i][j] = matriz[i + 1][j];
                        matriz[i + 1][j] = aux;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        rellenarMatriz();
        ordenarColumnas();
        imprimirMatriz();

    }
}
