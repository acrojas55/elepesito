import java.util.ArrayList;
import java.util.Scanner;

public class consultas {
    public void mostrar(Scanner sc, ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("consultas");
        System.out.println("presionar del 0 al 4 para ingresar a cada opcion");
        System.out.println("0 = buscar vehiculo por placa");
        System.out.println("1 = ver vehiculos en espera");
        System.out.println("2 = ver historial de reparaciones de un vehiculo");
        System.out.println("3 = ver mecanicos disponibles");
        System.out.println("4 = consultar servicios mas solicitados");
        int opcion = sc.nextInt();

        switch(opcion) {
            case 0:
                buscarVehiculoPorPlaca(sc, listaVehiculo);
                break;
            case 1:
                verVehiculosEnEspera(listaVehiculo);
                break;
            case 2:
                verHistorial(sc, listaVehiculo);
                break;
            case 3:
                verMecanicosDisponibles();
                break;
            case 4:
                verServiciosMasSolicitados();
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void buscarVehiculoPorPlaca(Scanner sc, ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("buscar vehiculo por placa");

        if(listaVehiculo.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
            return;
        }

        sc.nextLine();
        System.out.println("ingresar la placa del vehiculo");
        String placaBuscar = sc.nextLine();
        boolean encontrado = false;

        for(int i = 0; i < listaVehiculo.size(); i++) {
            if(listaVehiculo.get(i).placa.equalsIgnoreCase(placaBuscar)) {
                System.out.println("vehiculo encontrado:");
                listaVehiculo.get(i).mostrarVehiculo();
                encontrado = true;
            }
        }

        if(!encontrado) {
            System.out.println("no se encontro un vehiculo con esa placa");
        }
    }

    private void verVehiculosEnEspera(ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("ver vehiculos en espera");

        if(listaVehiculo.isEmpty()) {
            System.out.println("no hay vehiculos en espera");
        } else {
            for(int i = 0; i < listaVehiculo.size(); i++) {
                System.out.println("vehiculo " + (i + 1));
                listaVehiculo.get(i).mostrarVehiculo();
            }
        }
    }

    private void verHistorial(Scanner sc, ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("ver historial de reparaciones de un vehiculo");

        if(listaVehiculo.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
            return;
        }

        sc.nextLine();
        System.out.println("ingresar la placa del vehiculo");
        String placaBuscar = sc.nextLine();

        for(int i = 0; i < listaVehiculo.size(); i++) {
            if(listaVehiculo.get(i).placa.equalsIgnoreCase(placaBuscar)) {
                System.out.println("historial del vehiculo:");
                listaVehiculo.get(i).mostrarVehiculo();
                System.out.println("por ahora no hay reparaciones registradas");
                return;
            }
        }

        System.out.println("no se encontro un vehiculo con esa placa");
    }

    private void verMecanicosDisponibles() {
        System.out.println("ver mecanicos disponibles");
        System.out.println("mecanico 1: Carlos");
        System.out.println("mecanico 2: Luis");
        System.out.println("mecanico 3: Pedro");
    }

    private void verServiciosMasSolicitados() {
        System.out.println("consultar servicios mas solicitados");
        System.out.println("1. cambio de aceite y filtro");
        System.out.println("2. revision de frenos");
        System.out.println("3. alineacion y balanceo");
    }
}
