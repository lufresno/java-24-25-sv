import java.util.Arrays;

public class Main {

    public static void rellenarArrayAscendente(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void mostrarArray(int[] array, String mensaje) {
        System.out.println(mensaje + ": " + Arrays.toString(array));
    }

    public static void mostrarArrayInverso(int[] array) {
        System.out.print("Array en orden inverso: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void rellenarArrayConPares(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
    }

    public static void mostrarElementosDeDosEnDos(int[] array) {
        System.out.print("Elementos de dos en dos: ");
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + ", " + (i + 1 < array.length ? array[i + 1] : " ") + "] ");
        }
        System.out.println();
    }

    public static void rellenarArrayConImpares(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }
    }

    public static void duplicarCadaElemento(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }

    public static int calcularSumaElementos(int[] array) {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        return suma;
    }

    public static int encontrarValorMaximo(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    public static int encontrarValorMinimo(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[10];

        rellenarArrayAscendente(array);
        mostrarArray(array, "Array en orden ascendente");

        mostrarArrayInverso(array);

        rellenarArrayConPares(array);
        mostrarArray(array, "Array con números pares");

        mostrarElementosDeDosEnDos(array);

        rellenarArrayConImpares(array);
        mostrarArray(array, "Array con números impares");

        duplicarCadaElemento(array);
        mostrarArray(array, "Array con cada elemento duplicado");

        int suma = calcularSumaElementos(array);
        System.out.println("Suma de todos los elementos: " + suma);

        int max = encontrarValorMaximo(array);
        int min = encontrarValorMinimo(array);
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }
}
