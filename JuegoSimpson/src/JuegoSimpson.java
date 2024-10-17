
import java.util.Random;
import java.util.Scanner;

public class JuegoSimpson {
    private static final char HOMER = 'H';
    private static final char MURO = 'M';
    //declaramos las variables y funciones que serán importantes y están a nivel programa completo
    public static char [][] tableroSimp= new char[10][10];
    public static final int MAX_FILAS= 10;
    public static final int MAX_COLUMNAS= 10;
    public static int bartFila;
    public static int bartColumna;
    public static int vidasBart;

    static Random aleatorio= new Random();
    static Scanner leer= new Scanner(System.in);

    public static void mostrarTablero() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(" [" + tableroSimp[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void llenarLibresTablero() {
        //  1º) Queremos la funión que nos inicie por primera vez el tablero, inicializando todas las casillas como Libres [L] y la última (9,9) con el Final [F].
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroSimp[i][j]= 'L';
            }
        }
        tableroSimp[9][9]= 'F';
    }

    public static void cargarBart() {
        // 2º) Ahora vamos a asignar de forma aleatoria la casilla donde estará colocado Bart [B]

       do {
           bartFila= aleatorio.nextInt(10);
           bartColumna= aleatorio.nextInt(10);
       } while (tableroSimp[bartFila][bartColumna]!= 'L'); //yo sé que esta casilla estará libre, pero lo hago así para reutilizar el método con los Homers y Muros, y para evitar que me lo coloque ya en el Final.
        tableroSimp[bartFila][bartColumna]= 'B';
    }

    public static void cargarObstaculo (int numeroObstaculos, char tipoObstaculo) {
        /* 3º) Queremos una función que nos cargue Homers [H] (10 en total) y Muros [M] (5 en total) siempre y cuando la casilla esté libre (no Bart, no Final).
           Como lo que es el algoritmo (repite esto tantas veces mientras la casilla sea Libre), creo un método general para todos los obstáculos (Homer y Muros).
           Además, si queremos cambiar el número de obstáculos (p.e: ahora quieres 20 Homers), no tenemos que cambiar el código entero, sino el parámetro de entrada y ya.
         */
        int obsFila, obsColumna; //Variables locales porque no harán falta más allá de asignar la posición aquí.

        for (int i = 0; i < numeroObstaculos; i++) {
            do {
                obsFila= aleatorio.nextInt(10);
                obsColumna= aleatorio.nextInt(10);
            } while (tableroSimp[obsFila][obsColumna]!= 'L');
            tableroSimp[obsFila][obsColumna]= tipoObstaculo;
        }
    }

        /* 4º) Esta función tendrá como parámetro de entrada un carácter (W, A, S, D). Servirán para subir, bajar, izq. o dcha. Suponemos que solo se introducirán mayúsculas porque no recuerdo cómo se pasa a mayus.
        aquí jaja.
        En cada tecla ha de contemplarse que:
        - La casilla está Libre: se intercambia Bart por el Libre.
        - La casilla tiene un Homer: Bart ocupa la posición de Homer, Homer desaparece, las vidas bajan en 1 (vidasBart--).
        - La casilla es un Muro: no puedes pasar, no resta vidas.
        - La casilla es el Final: se acaba el juego, mensaje de enhorabuena (se dispara bool meta).
        */

        public static void movimiento (char movimiento) {
            switch (movimiento) {
                case 'W': // Movimiento hacia arriba
                    if (bartFila > 0) {
                        switch (tableroSimp[bartFila-1][bartColumna]) {
                            case 'L':
                                tableroSimp[bartFila-1][bartColumna] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartFila--; // Actualizar la posición de Bart
                                break;
                            case 'H':
                                tableroSimp[bartFila-1][bartColumna] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartFila--;
                                vidasBart--;
                                System.out.println("Has perdido una vida. Ahora tienes: " + vidasBart);
                                break;
                            case 'M':
                                System.out.println("Has chocado con un muro. Prueba otra dirección.");
                                break;
                            case 'F':
                                System.out.println("Enhorabuena, has ganado!!!!!!");
                                System.exit(0);
                                break;
                        }
                    }
                    break;

                case 'A': // Movimiento hacia la izquierda
                    if (bartColumna > 0) {
                        switch (tableroSimp[bartFila][bartColumna-1]) {
                            case 'L':
                                tableroSimp[bartFila][bartColumna-1] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartColumna--; // Actualizar la posición de Bart
                                break;
                            case 'H':
                                tableroSimp[bartFila][bartColumna-1] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartColumna--;
                                vidasBart--;
                                System.out.println("Has perdido una vida. Ahora tienes: " + vidasBart);
                                break;
                            case 'M':
                                System.out.println("Has chocado con un muro. Prueba otra dirección.");
                                break;
                            case 'F':
                                System.out.println("Enhorabuena, has ganado!!!!!!");
                                System.exit(0);
                                break;
                        }
                    }
                    break;

                case 'S': // Movimiento hacia abajo
                    if (bartFila < MAX_FILAS - 1) {
                        switch (tableroSimp[bartFila+1][bartColumna]) {
                            case 'L':
                                tableroSimp[bartFila+1][bartColumna] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartFila++; // Actualizar la posición de Bart
                                break;
                            case 'H':
                                tableroSimp[bartFila+1][bartColumna] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartFila++;
                                vidasBart--;
                                System.out.println("Has perdido una vida. Ahora tienes: " + vidasBart);
                                break;
                            case 'M':
                                System.out.println("Has chocado con un muro. Prueba otra dirección.");
                                break;
                            case 'F':
                                System.out.println("Enhorabuena, has ganado!!!!!!");
                                System.exit(0);
                                break;
                        }
                    }
                    break;

                case 'D': // Movimiento hacia la derecha
                    if (bartColumna < MAX_COLUMNAS - 1) {
                        switch (tableroSimp[bartFila][bartColumna+1]) {
                            case 'L':
                                tableroSimp[bartFila][bartColumna+1] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartColumna++; // Actualizar la posición de Bart
                                break;
                            case 'H':
                                tableroSimp[bartFila][bartColumna+1] = 'B';
                                tableroSimp[bartFila][bartColumna] = 'L';
                                bartColumna++;
                                vidasBart--;
                                System.out.println("Has perdido una vida. Ahora tienes: " + vidasBart);
                                break;
                            case 'M':
                                System.out.println("Has chocado con un muro. Prueba otra dirección.");
                                break;
                            case 'F':
                                System.out.println("Enhorabuena, has ganado!!!!!!");
                                System.exit(0);
                                break;
                        }
                    }
                    break;
            }
        }



    public static void main(String[] args) {
        vidasBart= 3;
        char movimiento;

        llenarLibresTablero();
        cargarBart();
        cargarObstaculo(10, HOMER);
        cargarObstaculo(5, MURO);

        do {
            //1º) Enseñamos tablero
            System.out.println("Esta es la posición actual del tablero: ");
            mostrarTablero();
            //2º) Preguntamos qué hace
            System.out.println("¿Qué quieres hacer ahora?");
            movimiento= leer.next().charAt(0);
            movimiento(movimiento);

        } while (vidasBart>0);
    }
}

/*

ESQUEMA DEL PROGRAMA: LUCÍA NAVARRO FRESNO

¿qué ha de hacer el programa?

1º) en términos de manejo, lo que enseñas al usuario:
[ ] ir preguntando al usuario movimientos
[ ] ejecuta el movimiento
[ ] te enseña el tablero                            ---> esto es un bucle!! durará mientras 1. queden vidas y 2. no hayas tocado la meta
[ ] te vuelve a preguntar movimiento

2º) en términos de lo que tienes que ir haciendo por detrás
[X] inicializas la matriz como libres menos la casilla 9,9, que será la meta  ----> cada una de estas instrucciones será una función, porque cada una será una acción recurrente
[X] cargas el bart (que yo considero el centro del programa)
[X] cargas los homers                                                    ----> los dos obtáculos van en pack en la misma función
[X] cargas muros
[X] movimientos W, A, S, D                                     ----> una misma función, con un switch gordo?

NOTAS:
1) ahora mismo dudo de si la función random incluía desde el 0 hasta el valor entre paréntesis o no. yo creo que no, así que lo marco hasta 10 para que llegue hasta nueve desde el 0.

 */