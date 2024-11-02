import java.util.Scanner;

public class Main {
    static Scanner read= new Scanner(System.in);
    static int []barCode= new int[12]; //Nuestra cadena de números será un array de dim 13
    static int type, controlDigit; //Definimos el tipo de código (EAN-8= 8, EAN-13= 13)

    private static int typeBarCode(Integer[] barCode) {
        // Comprobar si el primer elemento es null y cortar el programa
        if (barCode[0] == null) {
            return 0; // Corta el programa si el primer dígito es null
        }

        // Rellenar con ceros a la izquierda hasta que el array tenga una longitud de 12
        for (int i = 0; i < 12; i++) {
            if (i < (12 - barCode.length) || barCode[i - (12 - barCode.length)] == null) {
                barCode[i] = 0; // Rellenar con 0s en las posiciones anteriores
            }
        }

        int nFilled = 0; // Contador para los elementos llenos

        // Contar cuántas posiciones están llenas (no son null)
        for (int i = 0; i < 12; i++) {
            if (barCode[i] != null) { // Comprueba si el elemento no es null
                nFilled++;
            }
        }

        // Determina el tipo basado en cuántas posiciones están llenas
        switch (nFilled) {
            case 1, 2, 3, 4, 5, 6, 7, 8:
                return 8; // Si hay 8 posiciones llenas o menos (sin null), es EAN-8

            case 9, 10, 11, 12:
                return 13; // Si hay entre 9 y 12 llenas, es EAN-13
        }

        return 0; // En caso de que haya algo raro que no entre en nada
    }

    private static int getControlDigit(Integer[] barCode) {
        int totalSum= 0;

        // Recorriendo el array de derecha a izquierda
        for (int i = 11; i >= 0; i--) {
            if ((11 - i) % 2 == 0) { // Posiciones impares
                totalSum += barCode[i]; // Añade el dígito directamente
            } else { // Posiciones pares
                totalSum += barCode[i] * 3; // Añade el dígito multiplicado por 3
            }
        }

        //Ahora encontramos el múltiplo de 10 más cercano a la suma
        double multiple= totalSum;
        int roundedMultiple= (int) (multiple + 0.5);

        return roundedMultiple;
    }

    public static void main(String[] args) {
        Integer []barCode= new Integer[12];

        do {
            for (int i = 0; i < barCode.length; i++) { //Leemos las posiciones del código
                barCode[i]= read.nextInt();
            }
            type= typeBarCode(barCode); //Definimos el tipo de Código, y rellenamos de 0s si es necesario
            controlDigit= getControlDigit(barCode); //Calculamos el dígito de control

        } while (type!=0);
    }
}