
import java.util.Scanner;

public class Main {

    static Scanner read= new Scanner(System.in);

    private static char calculateChar(char c,int d){
        //Si es minuscula
        if (('a' <= c) && (c <= 'z')){
            char newChar = (char) (c + d);
            if (newChar > 'z') newChar -= 26;
            if (newChar < 'a') newChar += 26;
            return newChar;
        }
        //Si es mayuscula
        if (('A' <= c) && (c <= 'Z')){
            char newChar = (char) (c + d);
            if (newChar > 'Z') newChar -= 26;
            if (newChar < 'A') newChar += 26;
            return newChar;
        }
        return c;
    }

    public static boolean contarVocales(char c) {

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
            int nVocales= 0;
            line= read.nextLine();
            if (primeraVez){
                System.out.println();
            }
            primeraVez= false;
            int distance =  'p' - Character.toLowerCase(line.charAt(0));
            for(int i = 1;i < line.length();i++){

                char newChar = calculateChar(line.charAt(i),distance);

                if (i>=3){
                    if((calculateChar(line.charAt(i-2),distance) == 'F') &&
                            (calculateChar(line.charAt(i-1),distance) == 'I') &&
                            (calculateChar(line.charAt(i),distance)== 'N')){
                        finish = true;
                        break;
                    }
                }


                if (contarVocales(newChar)){
                    nVocales++;
                }

                //Comprobar si ha habido un fin


            }
            System.out.println(nVocales);

        }while(!finish);
        System.exit(0);

    }
}