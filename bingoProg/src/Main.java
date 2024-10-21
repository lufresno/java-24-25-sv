import java.util.Random;

public class Main {
    static String[][] matriz= new String[3][9];
    static String[] ganadores= new String[15];
    static final int MAX_FILAS= 3;
    static final int MAX_COLUMNAS=9;
    static int valor;

    static Random aleatorio= new Random();

    public static void generarTablero(){
        int decenas;

        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                decenas= (j+1)*10;
                do {
                    valor= aleatorio.nextInt(10) + decenas;
                } while (numRepetido(j, valor));
                matriz[i][j]= String.valueOf(valor);
            }
        }
    }

    public static void generarGanadores(){

        for (int i=0; i<15; i++){
            ganadores[i]= String.valueOf(aleatorio.nextInt(9,101));
            System.out.print(ganadores[i] + " ");
        }
    }

    public static boolean numRepetido(int j, int valor) {

        for (int i = 0; i < MAX_FILAS; i++) {
            if (matriz[i][j]!=null && matriz[i][j].equals(String.valueOf(valor))){
                return true;
            }
        }
        return false;
    }

    public static void mostrarTablero(){

        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void comprobarTachar(){
        for (int k = 0; k < 15; k++) {
            for (int i=0; i<MAX_FILAS; i++){
                for (int j=0; j<MAX_COLUMNAS; j++){
                    if (matriz[i][j].equals(ganadores[k])) {
                        matriz[i][j]= "XX";
                    }
                }
            }
        }

    }

    public static void ordenarColumnas() {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            for (int k = 0; k < MAX_FILAS - 1; k++) {
                for (int i = 0; i < MAX_FILAS - 1; i++) {
                    int valorActual = Integer.parseInt(matriz[i][j]);
                    int valorSiguiente = Integer.parseInt(matriz[i + 1][j]);

                    if (valorActual > valorSiguiente) {
                        String aux = matriz[i][j];
                        matriz[i][j] = matriz[i + 1][j];
                        matriz[i + 1][j] = aux;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        generarTablero();
        ordenarColumnas();
        System.out.println("Bienvenido. Este es tu cartón de bingo: ");
        mostrarTablero();

        System.out.println("-------------------------------------------------------------");

        System.out.println("Los números ganadores son: ");
        generarGanadores();
        System.out.println();

        System.out.println("-------------------------------------------------------------");
        System.out.println("Tu cartón quedaría: ");
        comprobarTachar();
        mostrarTablero();

    }

}
