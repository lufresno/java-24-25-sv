import java.util.Scanner;

/*La diferencia entre String y StringBuilder es que el SB es una clase variable.
Un string es fijo e inmutable, así que cada modificación crea un objeto nuevo,
mientras que el SB se adapta al contenido de la variable en ese momento, lo cual
lo hace más óptimo (en memoria).*/

public class Main {

    public static void iniciarJuego(String[] palabras) {
        Scanner scanner = new Scanner(System.in);
        String[] respuestas = new String[palabras.length];

        for (int i = 0; i < palabras.length; i++) {
            mostrarPalabra(palabras[i]);
            respuestas[i] = palabras[i];

            if (!verificarRespuesta(scanner, respuestas, i)) {
                System.out.println("Intenta de nuevo desde el inicio.");
                i = -1;
            } else {
                System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
            }
        }

        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }

    public static void mostrarPalabra(String palabra) {
        System.out.println("Palabra a memorizar: " + palabra);
        System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
    }

    public static boolean verificarRespuesta(Scanner scanner, String[] respuestas, int hasta) {
        String entrada = scanner.nextLine();
        String secuenciaCorrecta = obtenerSecuencia(respuestas, hasta);

        if (!entrada.equals(secuenciaCorrecta)) {
            System.out.println("¡Incorrecto! La secuencia era: " + secuenciaCorrecta);
            return false;
        }
        return true;
    }

    public static String obtenerSecuencia(String[] respuestas, int hasta) {
        StringBuilder secuencia = new StringBuilder();
        for (int j = 0; j <= hasta; j++) {
            secuencia.append(respuestas[j]).append(" ");
        }
        return secuencia.toString().trim();
    }
    public static void main(String[] args) {
        String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};
        iniciarJuego(palabras);
    }
}
