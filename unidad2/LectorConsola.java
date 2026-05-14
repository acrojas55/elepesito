import java.util.Scanner;

public class LectorConsola {
    private final Scanner scanner;

    public LectorConsola() {
        this.scanner = new Scanner(System.in);
    }

    public String leerTexto(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        while(true) {
            System.out.println(mensaje);

            if(scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Debe ingresar un numero valido");
            scanner.nextLine();
        }
    }

    public double leerDecimal(String mensaje) {
        while(true) {
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim().replace(",", ".");

            try {
                return Double.parseDouble(entrada);
            } catch(NumberFormatException e) {
                System.out.println("Debe ingresar un numero decimal valido");
            }
        }
    }
}
