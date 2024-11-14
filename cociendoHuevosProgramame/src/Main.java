import java.util.Scanner;

public class Main {

    public static String conjugarPresente(String verbo, String persona) {
        String raiz = verbo.substring(0, verbo.length() - 2);
        String terminacion = "";
        if (verbo.endsWith("ar")) {
            switch (persona) {
                case "yo": terminacion = "o"; break;
                case "tu": terminacion = "as"; break;
                case "el": terminacion = "a"; break;
                case "nosotros": terminacion = "amos"; break;
                case "vosotros": terminacion = "ais"; break;
                case "ellos": terminacion = "an"; break;
            }
        } else if (verbo.endsWith("er")) {
            switch (persona) {
                case "yo": terminacion = "o"; break;
                case "tu": terminacion = "es"; break;
                case "el": terminacion = "e"; break;
                case "nosotros": terminacion = "emos"; break;
                case "vosotros": terminacion = "eis"; break;
                case "ellos": terminacion = "en"; break;
            }
        } else if (verbo.endsWith("ir")) {
            switch (persona) {
                case "yo": terminacion = "o"; break;
                case "tu": terminacion = "es"; break;
                case "el": terminacion = "e"; break;
                case "nosotros": terminacion = "imos"; break;
                case "vosotros": terminacion = "is"; break;
                case "ellos": terminacion = "en"; break;
            }
        }
        return persona + " " + raiz + terminacion;
    }

    public static String conjugarPreterito(String verbo, String persona) {
        String raiz = verbo.substring(0, verbo.length() - 2);
        String terminacion = "";
        if (verbo.endsWith("ar")) {
            switch (persona) {
                case "yo": terminacion = "e"; break;
                case "tu": terminacion = "aste"; break;
                case "el": terminacion = "o"; break;
                case "nosotros": terminacion = "amos"; break;
                case "vosotros": terminacion = "asteis"; break;
                case "ellos": terminacion = "aron"; break;
            }
        } else if (verbo.endsWith("er") || verbo.endsWith("ir")) {
            switch (persona) {
                case "yo": terminacion = "i"; break;
                case "tu": terminacion = "iste"; break;
                case "el": terminacion = "io"; break;
                case "nosotros": terminacion = "imos"; break;
                case "vosotros": terminacion = "isteis"; break;
                case "ellos": terminacion = "ieron"; break;
            }
        }
        return persona + " " + raiz + terminacion;
    }

    public static String conjugarFuturo(String verbo, String persona) {
        String terminacion = "";
        if (verbo.endsWith("ar") || verbo.endsWith("er") || verbo.endsWith("ir")) {
            switch (persona) {
                case "yo": terminacion = "e"; break;
                case "tu": terminacion = "as"; break;
                case "el": terminacion = "a"; break;
                case "nosotros": terminacion = "emos"; break;
                case "vosotros": terminacion = "eis"; break;
                case "ellos": terminacion = "an"; break;
            }
        }
        return persona + " " + verbo + terminacion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean primeraEntrada = true;
        boolean primerSalto = true;
        while (true) {
            String verbo = scanner.next();
            String tiempo = scanner.next();
            if (tiempo.equals("T")) break;
            if (!primeraEntrada) {
                System.out.println();
            }
            primeraEntrada = false;
            if (primerSalto) {
                System.out.println();
                primerSalto = false;
            }
            String[] personas = {"yo", "tu", "el", "nosotros", "vosotros", "ellos"};
            for (String persona : personas) {
                switch (tiempo) {
                    case "A":
                        System.out.println(conjugarPresente(verbo, persona));
                        break;
                    case "P":
                        System.out.println(conjugarPreterito(verbo, persona));
                        break;
                    case "F":
                        System.out.println(conjugarFuturo(verbo, persona));
                        break;
                }
            }
        }
        scanner.close();
    }
}
