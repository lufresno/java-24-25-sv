import java.util.Random;
import java.util.Scanner;

public class Main {

    static int MAX_FILAS = 10;
    static int MAX_COLUMNAS = 10;

    static char[][] tableroYoda = new char[MAX_FILAS][MAX_COLUMNAS];
    static char[][] tableroVader = new char[MAX_FILAS][MAX_COLUMNAS];
    static char[][] tableroYodaCopia = new char[MAX_FILAS][MAX_COLUMNAS];
    static char[][] tableroVaderCopia = new char[MAX_FILAS][MAX_COLUMNAS];

    //Para poder "vectorizar" cada movimiento, vamos a definir dos conjuntos:

    //Nuestro array de teclas posibles: (por simplicidad, sólo consideraré las mayúsculas)
    static final char[] teclas = {'W', 'A', 'S', 'D', 'Q', 'R', 'E', 'B'};

    //Nuestra matriz de movimientos asociados a cada tecla, en formato (cambio de fila, cambio de columna):
    static final int[][] movimientos = {
            {-1, 0},    // W (arriba)
            {0, -1},    // A (izquierda)
            {1, 0},     // S (abajo)
            {0, 1},     // D (derecha)
            {-1, -1},   // Q (arriba izquierda)
            {-1, 1},    // R (arriba derecha)
            {1, 1},     // E (abajo derecha)
            {1, -1}     // B (abajo izquierda)
    };

    static final char YODA = 'Y';
    static final char VADER = 'V';
    static final char MAUL = 'D';
    static final char R2D2 = 'R';
    static final char LIBRE = 'L';
    static final char META = 'F';
    static final char MURO = 'M';
    static final char POCIMA = 'P';

    /*Como nos interesará más tarde, vamos a meter en un vector los enemigos que habrán de randomizarse tras cada
    movimiento. */

    static char[] enemigosYoda = {MAUL, MURO};
    static char[] enemigosVader = {R2D2, MURO};

    //Variables bandera para el bucle que hace funcionar el juego.
    static int vidasYoda = 3;
    static int vidasVader = 3;
    static boolean acabado = false;

    //Funcionalidad de pócimas.
    static boolean pocimaActivaYoda = false;
    static boolean pocimaActivaVader = false;

    //Llamamos a las funciones importadas que necesitaremos en el código.
    static Random random = new Random();
    static Scanner leer = new Scanner(System.in);


    //Vamos a empezar creando las funciones que iniciarán el juego.

    //1º) Inicializamos los tableros y sus copias.
    private static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j] = LIBRE;
            }
        }
    }

    //2º) Creamos la función que rellenará los tableros visibles de personajes y enemigos.
    private static void ponerPersonaje(char[][] tablero, char personaje, int nPersonajes) {
        int filaAl, columnaAl;
        for (int i = 0; i < nPersonajes; i++) {
            do {
                filaAl = random.nextInt(MAX_FILAS);
                columnaAl = random.nextInt(MAX_COLUMNAS);
            } while (tablero[filaAl][columnaAl] != LIBRE);
            tablero[filaAl][columnaAl] = personaje;
        }
    }

    /*3º) Definimos la función que nos permita a lo largo del juego, cuando sea necesario, copiar los
    cambios del tablero original y visible a la copia oculta que requerimos nosotros. */
    private static void copiarTablero(char[][] tableroOriginal, char[][] tableroCopia) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroCopia[i][j] = tableroOriginal[i][j];
            }
        }
    }

    //4º) Una función que nos sirva para mostrar cada matriz 10x10 presente en el juego.
    private static void mostrarMatriz(char[][] tablero) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 5º) Definimos dos funciones que nos permita calcular en cualquier tablero la posición de su personaje principal.
    private static int obtenerFilaJugador(char[][] tablero, char personaje) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (tablero[i][j] == personaje) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int obtenerColumnaJugador(char[][] tablero, char personaje) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (tablero[i][j] == personaje) {
                    return j;
                }
            }
        }
        return -1;
    }

    //6º) Antes de mover el jugador, tenemos que comprobar dónde va a ir a parar.
    private static boolean comprobarEnemigos(char personaje, int nuevaFila, int nuevaColumna) {
        switch (personaje) {
            case YODA:
                switch (tableroYodaCopia[nuevaFila][nuevaColumna]) {
                    case MURO:
                        System.out.println("Te has chocado con un muro. Te mantienes en el sitio.");
                        return false;
                    case MAUL:
                        vidasYoda--;
                        System.out.println("Pierdes una vida. Tienes: " + vidasYoda);
                        return true;
                    case LIBRE:
                        return true;
                    case META:
                        System.out.println("Yoda ha ganado. ¡Enhorabuena!");
                        acabado = true;
                        return true;
                    case POCIMA:
                        System.out.println("¡Yoda ha recogido una pócima!");
                        pocimaActivaYoda = true;
                        return true;
                }
                break;

            case VADER:
                switch (tableroVaderCopia[nuevaFila][nuevaColumna]) {
                    case MURO:
                        System.out.println("Te has chocado con un muro. Te mantienes en el sitio.");
                        return false;
                    case R2D2:
                        vidasVader--;
                        System.out.println("Pierdes una vida. Tienes: " + vidasVader);
                        return true;
                    case LIBRE:
                        return true;
                    case META:
                        System.out.println("Vader ha ganado. ¡Enhorabuena!");
                        acabado = true;
                        return true;
                    case POCIMA:
                        System.out.println("¡Vader ha recogido una pócima!");
                        pocimaActivaVader = true;
                        return true;
                }
                break;
        }
        return false;
    }

    //7º) Ahora, ponemos a funcionar el movimiento de cada personaje en su tablero.
    private static void movimientoJugador(char[][] tablero, char personaje, char movimiento, int cantidadMovimiento) {
        //Almacenamos la posición del personaje a mover.
        int filaPersonaje = obtenerFilaJugador(tablero, personaje);
        int columnaPersonaje = obtenerColumnaJugador(tablero, personaje);

        for (int i = 0; i < teclas.length; i++) {
            //Comprobamos cuál de las teclas de nuestro array ha pulsado nuestro jugador.
            if (movimiento == teclas[i]) {
                /*Ahora, vas a la matriz y lo mueves "tantas filas" y "tantas columnas" como dicta el vector
                 asociado a esa tecla. Además, al estar en una matriz de 10x10 efecto "infinito", trabajamos
                 esta suma de coordenadas en módulo 10. */
                int nuevaFila = (filaPersonaje + movimientos[i][0] * cantidadMovimiento + MAX_FILAS) % MAX_FILAS;
                int nuevaColumna = (columnaPersonaje + movimientos[i][1] * cantidadMovimiento + MAX_COLUMNAS) % MAX_COLUMNAS;

                /*Hacemos uso de nuestra función de comprobación. Devolverá verdadero o falso según el personaje
                se mueva (pierda vida o no) o no (si se choca con un muro). Que sí se mueva se considerará
                un "movimiento permitido". */
                // Actualizamos el tablero de copia antes de comprobar
                copiarTablero(tablero, personaje == YODA ? tableroYodaCopia : tableroVaderCopia);
                boolean movimientoPermitido = comprobarEnemigos(personaje, nuevaFila, nuevaColumna);

                if (movimientoPermitido) {
                    /*En caso de poder pasar y no ser un muro, actualizamos la posición y lo copiamos a nuestra
                    matriz oculta. */
                    tablero[filaPersonaje][columnaPersonaje] = LIBRE;
                    tablero[nuevaFila][nuevaColumna] = personaje;

                    copiarTablero(tableroYoda, tableroYodaCopia);
                    copiarTablero(tableroVader, tableroVaderCopia);
                }
                break;
            }
        }
    }

    //8º) Tras cada movimiento, queremos volver a randomizar los enemigos en el tablero.
    private static void saltarEnemigos(char[][] tablero, char[][] tableroCopia, char[] enemigos) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                for (char enemigo : enemigos) {
                    if (tablero[i][j] == enemigo) {
                        int nuevaFila, nuevaColumna;
                        do {
                            nuevaFila = random.nextInt(MAX_FILAS);
                            nuevaColumna = random.nextInt(MAX_COLUMNAS);
                        } while (tablero[nuevaFila][nuevaColumna] != LIBRE); //Aseguras que no hubiera nada.

                        tablero[nuevaFila][nuevaColumna] = enemigo;
                        tablero[i][j] = LIBRE;

                        tableroCopia[nuevaFila][nuevaColumna] = enemigo;
                        tableroCopia[i][j] = LIBRE;

                        break;
                    }
                }
            }
        }
    }

    //9º) Condensamos el proceso de inicializar matrices en un único proceso.
    private static void iniciarTodo() {
        inicializarTablero(tableroYoda);
        inicializarTablero(tableroVader);

        inicializarTablero(tableroYodaCopia);
        inicializarTablero(tableroVaderCopia);

        tableroYoda[9][9] = META;
        tableroVader[9][9] = META;

        ponerPersonaje(tableroYoda, YODA, 1);
        ponerPersonaje(tableroYoda, MAUL, 5);
        ponerPersonaje(tableroYoda, MURO, 5);
        ponerPersonaje(tableroYoda, POCIMA, 5);

        ponerPersonaje(tableroVader, VADER, 1);
        ponerPersonaje(tableroVader, R2D2, 5);
        ponerPersonaje(tableroVader, MURO, 5);
        ponerPersonaje(tableroVader, POCIMA, 5);

        copiarTablero(tableroYoda, tableroYodaCopia);
        copiarTablero(tableroVader, tableroVaderCopia);
    }

    public static void main(String[] args) {

        iniciarTodo();

        String direccionYoda, direccionVader;
        char teclaYoda, teclaVader;
        int cantidadYoda, cantidadVader;

        //Empieza el juego.
        do {
            //------------------------------------------Turno Yoda----------------------------------------------------------------
            System.out.println("Turno del Jugador Yoda. Esta es tu situación actual: ");
            mostrarMatriz(tableroYoda);

            if (pocimaActivaYoda) {

                System.out.println("Yoda tiene una pócima activa. Elige una celda libre para intercambiar posiciones (formato: fila,columna): ");
                String posicion = leer.nextLine();
                int nuevaFila = Integer.parseInt(posicion.split(",")[0]);
                int nuevaColumna = Integer.parseInt(posicion.split(",")[1]);

                if (tableroYoda[nuevaFila][nuevaColumna] == LIBRE) {

                    int filaActual = obtenerFilaJugador(tableroYoda, YODA);
                    int columnaActual = obtenerColumnaJugador(tableroYoda, YODA);

                    tableroYoda[filaActual][columnaActual] = LIBRE;
                    tableroYoda[nuevaFila][nuevaColumna] = YODA;


                    tableroYodaCopia[filaActual][columnaActual] = LIBRE;
                    tableroYodaCopia[nuevaFila][nuevaColumna] = YODA;

                    pocimaActivaYoda = false;
                } else {
                    System.out.println("Esa celda no está libre. Pierdes el turno de intercambio.");
                }
            } else {

                System.out.println("¿Cuál quieres que sea tu cantidad y dirección de movimiento? (Ejemplo: 3W)");
                direccionYoda = leer.nextLine();
                int idx = 0;
                while (idx < direccionYoda.length() && Character.isDigit(direccionYoda.charAt(idx))) {
                    idx++;
                }
                cantidadYoda = Integer.parseInt(direccionYoda.substring(0, idx));
                teclaYoda = direccionYoda.charAt(idx);
                movimientoJugador(tableroYoda, YODA, teclaYoda, cantidadYoda);
            }


            saltarEnemigos(tableroYoda, tableroYodaCopia, enemigosYoda);
            System.out.println("\nLos enemigos han saltado a nuevas posiciones:");
            mostrarMatriz(tableroYoda);


            if (vidasYoda <= 0 || acabado) break;

            //---------------------------------------Turno Vader----------------------------------------------------------------
            System.out.println("Turno del Jugador Vader. Esta es tu situación actual: ");
            mostrarMatriz(tableroVader);

            if (pocimaActivaVader) {

                System.out.println("Vader tiene una pócima activa. Elige una celda libre para intercambiar posiciones (formato: fila,columna): ");
                String posicion = leer.nextLine();
                int nuevaFila = Integer.parseInt(posicion.split(",")[0]);
                int nuevaColumna = Integer.parseInt(posicion.split(",")[1]);

                if (tableroVader[nuevaFila][nuevaColumna] == LIBRE) {

                    int filaActual = obtenerFilaJugador(tableroVader, VADER);
                    int columnaActual = obtenerColumnaJugador(tableroVader, VADER);

                    tableroVader[filaActual][columnaActual] = LIBRE;
                    tableroVader[nuevaFila][nuevaColumna] = VADER;


                    tableroVaderCopia[filaActual][columnaActual] = LIBRE;
                    tableroVaderCopia[nuevaFila][nuevaColumna] = VADER;

                    pocimaActivaVader = false;
                } else {
                    System.out.println("Esa celda no está libre. Pierdes el turno de intercambio.");
                }
            } else {

                System.out.println("¿Cuál quieres que sea tu cantidad y dirección de movimiento? (Ejemplo: 2A)");
                direccionVader = leer.nextLine();
                int idx = 0;
                while (idx < direccionVader.length() && Character.isDigit(direccionVader.charAt(idx))) {
                    idx++;
                }
                cantidadVader = Integer.parseInt(direccionVader.substring(0, idx));
                teclaVader = direccionVader.charAt(idx);
                movimientoJugador(tableroVader, VADER, teclaVader, cantidadVader);
            }


            saltarEnemigos(tableroVader, tableroVaderCopia, enemigosVader);
            System.out.println("\nLos enemigos han saltado a nuevas posiciones:");
            mostrarMatriz(tableroVader);

        } while (vidasVader > 0 && vidasYoda > 0 && !acabado);

        System.out.println("El juego ha terminado.");
        System.out.println("Tablero final de Yoda:");
        mostrarMatriz(tableroYoda);
        System.out.println("\nTablero final de Vader:");
        mostrarMatriz(tableroVader);
    }
}
