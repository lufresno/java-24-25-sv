import java.util.Random;
//cacaculopedopis
public class Main {
    static int MAX_FILAS=10;
    static int MAX_COLUMNAS=10;
    static char [][] tableroYoda= new char [MAX_FILAS][MAX_COLUMNAS];
    static char [][] tableroVader= new char [MAX_FILAS][MAX_COLUMNAS];
    static char [][] tableroYodaCopia= new char [MAX_FILAS][MAX_COLUMNAS];
    static char [][] tableroVaderCopia= new char [MAX_FILAS][MAX_COLUMNAS];

    static final char YODA= 'Y';
    static final char VADER= 'V';
    static final char MAUL= 'D';
    static final char R2D2= 'R';
    static final char LIBRE= 'L';
    static final char META= 'F';
    static final char MURO= 'M';

    static char[] enemigosYoda= {MAUL, MURO};
    static char[] enemigosVader= {R2D2, MURO};

    static int vidasJ1= 3;
    static int vidasJ2= 3;

    static Random random= new Random();

    private static void inicializarTablero(char [][]tablero) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j]= LIBRE;
            }
        }
    }

    private static void ponerPersonaje(char [][]tablero, char personaje, int nPersonajes) {
        int filaAl, columnaAl;
        for (int i = 0; i < nPersonajes; i++) {
            do {
                filaAl= random.nextInt(MAX_FILAS);
                columnaAl= random.nextInt(MAX_COLUMNAS);
            } while (tablero[filaAl][columnaAl]!= LIBRE);
            tablero[filaAl][columnaAl]= personaje;
        }
    }

    private static void mostrarMatriz(char [][]tablero){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void resetPersonajesYoda() {
        for (char enemigo : enemigosYoda) {
            limpiarPersonajes(tableroYoda, enemigo);
            saltoPersonajes(tableroYoda, enemigo, 5);
        }
    }

    private static void resetPersonajesVader(){
        for (char enemigo : enemigosVader) {
            limpiarPersonajes(tableroVader, enemigo);
            saltoPersonajes(tableroVader, enemigo, 5);
        }
    }

    private static void limpiarPersonajes(char[][] tablero, char personaje) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (tablero[i][j] == personaje) {
                    tablero[i][j] = LIBRE;
                }
            }
        }
    }


    private static void saltoPersonajes(char [][]tablero, char personaje, int nPersonajes){
        for (int k = 0; k < nPersonajes; k++) {
            int filaAl, columnaAl;
            do {
                filaAl= random.nextInt(MAX_FILAS);
                columnaAl= random.nextInt(MAX_COLUMNAS);
            } while (tablero[filaAl][columnaAl] != LIBRE);
            tablero[filaAl][columnaAl] = personaje;
        }
    }


    private static boolean isPosicionRepetida(char[][] tablero, char personaje, int filaAl, int columnaAl) {
        if (tablero[filaAl][columnaAl]== personaje) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        inicializarTablero(tableroYoda);
        inicializarTablero(tableroVader);
        tableroYoda[9][9]= META;
        tableroVader[9][9]= META;

        ponerPersonaje(tableroYoda, YODA, 1);
        ponerPersonaje(tableroVader, VADER, 1);
        ponerPersonaje(tableroYoda, MAUL, 5);
        ponerPersonaje(tableroVader, R2D2, 5);
        ponerPersonaje(tableroYoda, MURO, 5);
        ponerPersonaje(tableroVader, MURO, 5);

        mostrarMatriz(tableroYoda);
        System.out.println();
        mostrarMatriz(tableroVader);

        System.out.println(vidasJ1);
        System.out.println(vidasJ2);

        resetPersonajesYoda();
        resetPersonajesVader();

        mostrarMatriz(tableroYoda);
        mostrarMatriz(tableroVader);
    }

}