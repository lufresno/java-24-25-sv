import java.util.Random;


public class Main {
    //definimos tablero y variables del tablero
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static char[][] tablero = new char[MAX_FILAS][MAX_COLUMNAS];

    //llamamos al método random
    static Random rand = new Random();

    //nos llenamos un array de palabras de 5 letras
    static String[] palabras = {"CASAS", "PERRO", "LIBRO", "OREJA", "PANDA"};


    private static void inicializarTablero() {
        // 1º) iniciamos el tablero en letras aleatorias
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tablero[i][j] = (char) (rand.nextInt(26) + 'A'); // Genera caracteres de 'A' a 'Z'
            }
        }
    }


    private static void insertarPalabras() {
        // 2º) (cuando quepan) metemos en posiciones aleatorias del tablero nuestras palabras
        for (String palabra : palabras) { //recorre cada elemento del array palabras
            boolean colocada = false;
            while (!colocada) {
                //generas tu posición aleatoria como punto de partida
                int filaAl = rand.nextInt(MAX_FILAS);
                int columnaAl = rand.nextInt(MAX_COLUMNAS);
                //llamas a la función para ver dónde cabe (si cabe)
                String direccion = siCaber(filaAl, columnaAl, palabra.length());

                //siempre que quepa, llamas a la función que lo escribe en esa dirección
                if (!direccion.equals("0")) {
                    colocada = insertarPalabraEnDireccion(filaAl, columnaAl, palabra, direccion);
                }
            }
        }
    }


    private static String siCaber(int fila, int columna, int longitud) {
        // 3º) Comprobamos si cabe, y si sí, en qué dirección

        //Direcciones "normales"
        if (columna + longitud <= MAX_COLUMNAS) return "HorDer";
        if (columna - longitud >= -1) return "HorIzq";
        if (fila + longitud <= MAX_FILAS) return "VerAb";
        if (fila - longitud >= -1) return "VerAr";

        //Direcciones diagonales
        if (fila + longitud <= MAX_FILAS && columna + longitud <= MAX_COLUMNAS) return "DiaAbDer";
        if (fila + longitud <= MAX_FILAS && columna - longitud >= -1) return "DiaAbIzq";
        if (fila - longitud >= -1 && columna + longitud <= MAX_COLUMNAS) return "DiaArDer";
        if (fila - longitud >= -1 && columna - longitud >= -1) return "DiaArIzq";

        //Si no ha entrado en ninguna, devuelve 0
        return "0";
    }



    private static boolean insertarPalabraEnDireccion(int fila, int columna, String palabra, String direccion) {
        // 4º) Cuando sabemos que cabe en x dirección, la escribimos en esa dirección
        switch (direccion) {
            case "DiaAbDer":
                if (fila + palabra.length() <= MAX_FILAS && columna + palabra.length() <= MAX_COLUMNAS) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna + i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "DiaAbIzq":
                if (fila + palabra.length() <= MAX_FILAS && columna - palabra.length() >= -1) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna - i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "DiaArDer":
                if (fila - palabra.length() >= -1 && columna + palabra.length() <= MAX_COLUMNAS) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila - i][columna + i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "DiaArIzq":
                if (fila - palabra.length() >= -1 && columna - palabra.length() >= -1) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila - i][columna - i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "HorDer":
                if (columna + palabra.length() <= MAX_COLUMNAS) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][columna + i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "HorIzq":
                if (columna - palabra.length() >= -1) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila][columna - i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "VerAb":
                if (fila + palabra.length() <= MAX_FILAS) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila + i][columna] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
            case "VerAr":
                if (fila - palabra.length() >= -1) {
                    for (int i = 0; i < palabra.length(); i++) {
                        tablero[fila - i][columna] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
        }

        return false;
    }

    private static void imprimirTablero() {
        // 5º) Mostramos el tablero
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        inicializarTablero();
        System.out.println("Tablero inicial:");
        imprimirTablero();

        insertarPalabras();

        System.out.println("\nTablero con palabras insertadas:");
        imprimirTablero();
    }
}
