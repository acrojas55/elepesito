import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    Scanner sc = new Scanner(System.in);
    ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
    ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();

    seguridad moduloSeguridad = new seguridad();
    configuracion moduloConfiguracion = new configuracion();
    transacciones moduloTransacciones = new transacciones();
    consultas moduloConsultas = new consultas();
    reportes moduloReportes = new reportes();

    public void menus() {
        int opcion;

        do {
            System.out.println("ingresar una opcion del 0 al 5");
            System.out.println("0 = seguridad");
            System.out.println("1 = configuracion");
            System.out.println("2 = transacciones");
            System.out.println("3 = consultas");
            System.out.println("4 = reportes");
            System.out.println("5 = salir");
            opcion = sc.nextInt();

            switch(opcion) {
                case 0:
                    moduloSeguridad.mostrar(sc, listaUsuarios);
                    break;
                case 1:
                    moduloConfiguracion.mostrar(sc);
                    break;
                case 2:
                    moduloTransacciones.mostrar(sc, listaVehiculo);
                    break;
                case 3:
                    moduloConsultas.mostrar(sc, listaVehiculo);
                    break;
                case 4:
                    moduloReportes.mostrar(sc, listaVehiculo);
                    break;
                case 5:
                    System.out.println("salir");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        } while(opcion != 5);
    }

    public static void main(String[] args) {
        menu menu1 = new menu();
        menu1.menus();
    }
}
