import java.util.ArrayList;
import java.util.Scanner;

public class reportes {
    public void mostrar(Scanner sc, ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("reportes");
        System.out.println("ingresar del 0 al 4 para ingresar a cualquier opcion");
        System.out.println("0 = reporte de ingresos del dia");
        System.out.println("1 = reporte de vehiculos atendidos por semana");
        System.out.println("2 = lista de vehiculos pendientes");
        System.out.println("3 = reporte de mecanicos mas productivos");
        System.out.println("4 = exportar a PDF");
        int opcion = sc.nextInt();

        switch(opcion) {
            case 0:
                System.out.println("reporte del dia - ingresos");
                System.out.println("por ahora no hay ingresos registrados");
                break;
            case 1:
                System.out.println("reporte de vehiculos atendidos por semana");
                System.out.println("vehiculos registrados: " + listaVehiculo.size());
                break;
            case 2:
                listarVehiculosPendientes(listaVehiculo);
                break;
            case 3:
                System.out.println("reporte de mecanicos mas productivos");
                System.out.println("por ahora no hay datos de productividad registrados");
                break;
            case 4:
                System.out.println("exportar a PDF");
                System.out.println("opcion en desarrollo");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void listarVehiculosPendientes(ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("lista de vehiculos pendientes");

        if(listaVehiculo.isEmpty()) {
            System.out.println("no hay vehiculos pendientes");
        } else {
            for(int i = 0; i < listaVehiculo.size(); i++) {
                System.out.println("vehiculo " + (i + 1));
                listaVehiculo.get(i).mostrarVehiculo();
            }
        }
    }
}
