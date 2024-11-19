
import java.util.Random;

public class SopaLetras {
    static String palabras []= {"helada", "mesa", "patata"};
    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static char sopaLetras[][]= new char[10][10];
    static char sopaLetrasCopia[][]= new char[10][10];
    static int MAX_FILAS= 10;
    static int MAX_COLUMNAS= 10;

    static Random random = new Random();

    static void rellenarMatriz(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                int numAl= random.nextInt(26);
                sopaLetras[i][j]= letras[numAl];
            }
        }
    }

    static void rellenarMatrizCopia(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                sopaLetrasCopia[i][j]= '0';
            }
        }
    }

    public static void mostrarMatriz(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(sopaLetras[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarMatrizCopia(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(sopaLetrasCopia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rellenarMatriz();
        rellenarMatrizCopia();
        mostrarMatriz();
        System.out.println();
        mostrarMatrizCopia();

        for (int i = 0; i < 3; i++) {
            int filaAl= 0;
            int colAl= 0;
            //1º)   casilla inicial libre
            do {
                filaAl= random.nextInt(10);
                colAl=  random.nextInt(10);
            } while(sopaLetrasCopia[filaAl][colAl]!='0');
            //2º)   no superar límites
            if (colAl + (palabras[i].length()-1)>10){
              i--;
            } else{
                boolean isLibre = true;
                int max= colAl + (palabras[i].length()-1);
                for (int z = colAl; z <=max; z++) {
                    if(sopaLetrasCopia[filaAl][z]!='0'){
                        isLibre= false;
                        break;
                    }
                }
                if(isLibre){ // PUEDO EMPEZAR A ESCRIBIR !!!,
                    int contador = 0;
                    for (int z = colAl; z <=max; z++) {
                        sopaLetras[filaAl][z]= palabras[i].charAt(contador);
                        sopaLetrasCopia[filaAl][z]= palabras[i].charAt(contador);
                        contador++;
                    }
                }
            }
        }
        System.out.println();
        mostrarMatriz();
        System.out.println();
        mostrarMatrizCopia();
    }
}