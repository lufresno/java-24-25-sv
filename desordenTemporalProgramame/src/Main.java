import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de habitantes
            int habitantes = scanner.nextInt();
            if (habitantes == 0) break; // Termina si el número de habitantes es 0

            // Leer las edades reales de los habitantes
            int[] edades = new int[habitantes];
            for (int i = 0; i < habitantes; i++) {
                edades[i] = scanner.nextInt();
            }

            // Calcular el desorden usando el conteo de inversiones
            long desordenTotal = contarInversiones(edades);

            // Imprimir el desorden total
            System.out.println(desordenTotal);
        }

        scanner.close();
    }

    // Método para contar inversiones usando Merge Sort
    public static long contarInversiones(int[] arr) {
        int[] tempArray = new int[arr.length];
        return mergeSortAndCount(arr, tempArray, 0, arr.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] tempArray, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Contar las inversiones en la mitad izquierda
            count += mergeSortAndCount(arr, tempArray, left, mid);

            // Contar las inversiones en la mitad derecha
            count += mergeSortAndCount(arr, tempArray, mid + 1, right);

            // Contar las inversiones mientras se fusionan ambas mitades
            count += mergeAndCount(arr, tempArray, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int[] tempArray, int left, int mid, int right) {
        int i = left; // Índice para la mitad izquierda
        int j = mid + 1; // Índice para la mitad derecha
        int k = left; // Índice para el array temporal
        long count = 0;

        // Fusionar los dos subarrays mientras contamos inversiones
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tempArray[k++] = arr[i++];
            } else {
                tempArray[k++] = arr[j++];
                count += (mid + 1) - i; // Todas las posiciones desde i a mid son inversiones
            }
        }

        // Copiar los elementos restantes de la mitad izquierda (si los hay)
        while (i <= mid) {
            tempArray[k++] = arr[i++];
        }

        // Copiar los elementos restantes de la mitad derecha (si los hay)
        while (j <= right) {
            tempArray[k++] = arr[j++];
        }

        // Copiar los elementos del array temporal al original
        for (i = left; i <= right; i++) {
            arr[i] = tempArray[i];
        }

        return count;
    }
}
