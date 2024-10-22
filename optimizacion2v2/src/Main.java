import java.util.Random;

public class Main {
    static int FILAS=10;
    static int COLUMNAS=10;
    static int [][]tablero= new int [FILAS][COLUMNAS];

    static Random random= new Random();

    private static void cargarTablero(){
        //Generamos números aleatorios entre el 0-9 y les sumamos las decenas correspondientes para que en cada columna haya 10-19, en la siguiente 20-29, ...
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                //int numAleatorio= random.nextInt(10)+10*(j+1); //10 - 19
                int numAleatorio = random.nextInt(10*(j+1),(10*(j+1)+10));
                tablero[i][j] = numAleatorio;
            }
        }
    }

    private static void metodoBurbujaColumnas(){
        //Aplicamos por columnas el método burbuja para mostrar en orden ascendente los números. Das varias vueltas asegurando que vayan a acabar ordenados.
        int cont = 0;
        do {
            for (int i = 0; i < FILAS -1; i++) {
                for (int j = 0; j < COLUMNAS; j++) {
                    if (tablero[i][j] > tablero[i + 1][j]) {
                        int aux;
                        aux = tablero[i][j];
                        tablero[i][j] = tablero[i + 1][j];
                        tablero[i + 1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont < FILAS);
    }

    private static void mostrarMatriz(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        cargarTablero();
        metodoBurbujaColumnas();
        mostrarMatriz();

    }
}