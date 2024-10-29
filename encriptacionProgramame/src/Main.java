import java.util.Scanner;

public class Main {
    static Scanner read= new Scanner(System.in);
    private static char calculateChar(char c,int d){
        //Si es una letra minúscula. Marcamos que en los límites pase al otro lado del abecedario.
        //Es decir, operamos la suma en módulo 26.
        if (('a' <= c) && (c <= 'z')){
            char newChar = (char) (c + d);
            if (newChar > 'z') newChar -= 26;
            if (newChar < 'a') newChar += 26;
            return newChar;
        }
        //Aplicamos a mayúsculas también.
        if (('A' <= c) && (c <= 'Z')){
            char newChar = (char) (c + d);
            if (newChar > 'Z') newChar -= 26;
            if (newChar < 'A') newChar += 26;
            return newChar;
        }
        return c;
        //Si no es una de esas letras, la devuelve igual.
    }

    private static boolean isVowel(char c) {
        if (c % 2 != 0) {
            switch (c) {
                case 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u':
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String line;
        boolean finish = false;
        boolean primeraVez= true;
        do{
            //Repetiremos el bucle mientras se cumpla que la variable bandera no salte.
            //Leemos cada línea y la vamos analizando SIN GUARDAR nada más que las vocales que van saliendo.
            int nVowels= 0;
            line= read.nextLine();
            //Que ponga un salto de linea en la primera para separar enunciado y respuesta al usuario.
            if (primeraVez){
                System.out.println();
            }
            primeraVez= false;
            //Que se quede el primer carácter para calcular la distancia EN MINÚSCULAS entre este y la 'p'.
            int distance =  'p' - Character.toLowerCase(line.charAt(0));

            //Ahora vamos trabajando carácter a carácter.
            for(int i = 1;i < line.length();i++){
                //En cada carácter calculamos su traducción. De no estar encriptado, distanica=0 entonces no pasará nada.
                char newChar = calculateChar(line.charAt(i),distance);

                //Comprobamos el caso específico de que sea FIN, y de serlo, disparamos la bandera.
                if (i>=3){
                    if((calculateChar(line.charAt(i-2),distance) == 'F') &&
                            (calculateChar(line.charAt(i-1),distance) == 'I') &&
                            (calculateChar(line.charAt(i),distance)== 'N')){
                        finish = true;
                        break;
                    }
                }

                //Si nos hemos encontrado una vocal, la contamos.
                if (isVowel(newChar)){
                    nVowels++;
                }
            }
            System.out.println(nVowels);

        }while(!finish);
        System.exit(0);
    }
}