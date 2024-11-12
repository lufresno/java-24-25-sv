/*El error es que intentas acceder a una posición que no existe en la matriz.
La matriz solo tiene dos filas (índices 0 y 1), pero el código intenta acceder a la fila 2,
que no está ahí. Esto causa un error de "fuera de límites" cuando se ejecuta.*/

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6}
        };

        System.out.println("Elemento en la posición (1,2): " + matriz[1][2]);
    }
}
