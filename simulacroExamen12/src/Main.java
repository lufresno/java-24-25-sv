public class Main {
    public static void main(String[] args) {
        int[] numeros = {4, 2, 9, 1, 5, 3};
        int objetivo = 5;
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                encontrado = true;
                break;
            }
        }

        System.out.println(encontrado ? "Número encontrado" : "Número no encontrado");
    }
}
