import java.util.Scanner;

public class Main {

    public static int calcularSumaPares(int n) {
        int suma = 0;
        for (int i = 2; i <= n; i += 2) {
            suma += i;
        }
        return suma;
    }

    public static void mostrarResultado(int n, int suma) {
        System.out.println("La suma de los números pares de 1 a " + n + " es: " + suma);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero positivo: ");
        int n = scanner.nextInt();

        int suma = calcularSumaPares(n);
        mostrarResultado(n, suma);

        scanner.close();
    }
}
