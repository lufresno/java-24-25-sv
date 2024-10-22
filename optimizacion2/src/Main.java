import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Primero vamos a ver qué pretende hacer el programa. Una vez entendido, podremos hacer que funcione.

        //Definimos una matriz de dimensión 10x9.
        int filas = 10;
        int columnas = 9;
        int tablero[][] = new int[filas][columnas];

        //Llamamos al método random.
        Random random= new Random();

        //Generamos números aleatorios entre el 0-9 y les sumamos las decenas correspondientes para que en cada columna haya 10-19, en la siguiente 20-29, ...
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //int numAleatorio= random.nextInt(10)+10*(j+1); //10 - 19
                int numAleatorio = random.nextInt(10*(j+1),(10*(j+1)+10));
                tablero[i][j] = numAleatorio;
            }
        }

        //Aplicamos por columnas el método burbuja para mostrar en orden ascendente los números. Das varias vueltas asegurando que vayan a acabar ordenados.
        int cont = 0;
        do {
            for (int i = 0; i < filas -1; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (tablero[i][j] > tablero[i + 1][j]) {
                        int aux;
                        aux = tablero[i][j];
                        tablero[i][j] = tablero[i + 1][j];
                        tablero[i + 1][j] = aux;
                    }
                }
            }
            cont++;
        }while (cont < filas);


        /*Este era un método diferente de burbuja usando for en lugar de do while, pero, a efectos prácticos y sabiendo que se va a ejecutar mínimo 1 vez, es lo mismo que
        el anterior.

        for (int j = 0; j < columnas; j++) {
            for (int i = 0; i < filas; i++) {
                for (int k = 0; k < filas - 1; k++) {
                    if(tablero[k][j] > tablero[k + 1][j]){
                        int aux = tablero[k][j];
                        tablero[k][j] = tablero[k + 1][j];
                        tablero[k + 1][j] = aux;
                    }
                }
            }

        } */

        /*Ambos bloques que vamos a ver ahora son métodos diferentes de ordenar las columnas. El primero continuamente compara sólo con el
        siguiente número (elemento fila x columna y con fila x+1, columna y) sin dar varias vueltas, así que aunque será rápido, es incompleto. Puede fallar.

       for (int i = 0; i < filas-1; i++) { // [0,0][1,0], [1,0][2,0]
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j]>tablero[i+1][j]){
                    int aux = tablero[i+1][j];
                    tablero[i][j] = tablero[i + 1][j];
                    tablero[i + 1][j] = aux;
                }
            }
        } */

       /* En este método sin embargo, aunque más lento, te aseguras de un ordenamiento completo en la columna ya que compara todos con todos. No obstante, por la forma
       en la que hemos construido la matriz, ya sabemos que con que estén ordenados dentro de la misma columna, no te vas a encontrar un número más grande a la derecha de
       cada columna (van cambiando las decenas en orden ascendente), así que es ineficiente. Si hubieramos asignado valores aleatorios sin criterio a toda la matriz, sería
       el método correcto y completo para ordenarla.

        for (int columna = 0; columna < 9; columna++) {

            for (int i = 0; i < filas - 1; i++) {
                for (int j = i; j < filas; j++) {
                    if (tablero[i][columna] > tablero[j][columna]) {
                        int aux = tablero[i][columna];
                        tablero[i][columna] = tablero[j][columna];
                        tablero[j][columna] = aux;
                    }
                }
            }

        } */

        //Imprimimos la matriz por pantalla
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

        //Por tanto, con esas partes comentadas, ya hemos hecho el programa funcional y eficiente.
    }
}