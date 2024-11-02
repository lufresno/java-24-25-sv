import java.util.Scanner;
import java.util.Random;

public class Main {

    //Declaramos los arrays a nivel clase.
    static String [][] tableroOculto= new String [10][10];
    static String [][] tableroVisible= new String [10][10];
    static String[] numUsuario= new String [10];

    //Declaramos las constantes a nivel clase.
    static final int INTENTOS_USUARIO= 10;
    static final int MAX_FILAS= 10;
    static final int MAX_COLUMNAS=10;

    //Cargamos las funciones a utilizar.
    static Random aleatorio= new Random();
    static Scanner leer= new Scanner(System.in);

    public static void generarTableroOculto() {
        //1º) Tendremos que rellenar un tablero que el usuario no ve con números (pasados a tipo String). Pueden estar repetidos.
        //Este tablero solo servirá para el programa y comparar con los números del usuario. No se muestra.
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroOculto[i][j]= String.valueOf(aleatorio.nextInt(89));
            }
        }
    }
    public static void generarTableroVisible() {
        //2º) Ahora tenemos que rellenar el tablero que sí ve el usuario. Al principio, a falta de que haya acertado el usuario, serán todos libres (XX).
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroVisible[i][j]= "XX";
            }
        }
    }
    public static void mostrarTablero(String[][] tablero) {
        //3º) Creamos la función que imprimirá por consola el tablero deseado.
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void pedirNumUsuarios() {
        //4º) Pedimos los números a adivinar al usuario y los guardamos en un array.
        for (int i = 0; i < INTENTOS_USUARIO; i++) {
            System.out.printf("Introduce tu número " +(i+1) + " :");
            numUsuario[i]= String.valueOf(leer.nextInt());
        }
    }
    public static void comprobarNumUsuarios() {
        //5º) Generamos una función que busque cada número del usuario en nuestra matriz de aleatorios. De estar, marcará en la misma posición que se lo ha encontrado originalmente
        //en la matriz que enseñamos al usuario. Así daremos la sensación de haber "revelado" la casilla al adivinarla.
        for (int k = 0; k < INTENTOS_USUARIO; k++) { //este bucle nos recorre las posiciones del array de los intentos del usuario.
            for (int i = 0; i < MAX_FILAS; i++) { //y estos dos bucles recorren la matriz para comparar.
                for (int j = 0; j < MAX_COLUMNAS; j++) {
                    if ((tableroOculto[i][j].equals(numUsuario[k]))){
                        tableroVisible[i][j]= numUsuario[k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //Inicializamos nuestras matrices.
        generarTableroOculto();
        generarTableroVisible();

        //Le damos un primer vistazo.
        mostrarTablero(tableroVisible);


        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------");

        //Pedimos al usuario su porra.
        System.out.println("Me vas a introducir 10 números para intentar adivinar si está en el tablero. Si está, se revelará en su posición. ");
        pedirNumUsuarios();

        System.out.println("------------------------------------------------");

        //Comprobamos los números uno a uno.
        for (int i = 0; i < INTENTOS_USUARIO; i++) {
            comprobarNumUsuarios();
        }

        System.out.println();
        System.out.println();

        //Enseñamos el resultado.
        System.out.println("El tablero ha quedado de la forma: ");
        mostrarTablero(tableroVisible);
    }
}