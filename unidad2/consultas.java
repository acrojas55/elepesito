import java.util.List;

public class Consultas {
    private final LectorConsola lector;
    private final List<Vehiculo> vehiculos;

    public Consultas(LectorConsola lector, List<Vehiculo> vehiculos) {
        this.lector = lector;
        this.vehiculos = vehiculos;
    }

    public void mostrar() {
        System.out.println("consultas");
        System.out.println("0 = buscar vehiculo por placa");
        System.out.println("1 = ver vehiculos en espera");
        System.out.println("2 = ver historial de reparaciones de un vehiculo");
        System.out.println("3 = ver mecanicos disponibles");
        System.out.println("4 = consultar servicios mas solicitados");

        int opcion = lector.leerEntero("Presionar del 0 al 4 para ingresar a cada opcion");

        switch(opcion) {
            case 0:
                buscarVehiculoPorPlaca();
                break;
            case 1:
                verVehiculosEnEspera();
                break;
            case 2:
                verHistorial();
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

    private void buscarVehiculoPorPlaca() {
        System.out.println("buscar vehiculo por placa");

        if(vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
            return;
        }

        String placaBuscada = lector.leerTexto("ingresar la placa del vehiculo");
        Vehiculo vehiculo = buscarPorPlaca(placaBuscada);

        if(vehiculo == null) {
            System.out.println("no se encontro un vehiculo con esa placa");
            return;
        }

        System.out.println("vehiculo encontrado:");
        vehiculo.mostrar();
    }

    private void verVehiculosEnEspera() {
        System.out.println("ver vehiculos en espera");

        if(vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos en espera");
            return;
        }

        boolean hayVehiculosEnEspera = false;

        for(int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).estaPendiente()) {
                System.out.println("vehiculo " + (i + 1));
                vehiculos.get(i).mostrar();
                hayVehiculosEnEspera = true;
            }
        }

        if(!hayVehiculosEnEspera) {
            System.out.println("no hay vehiculos en espera");
        }
    }

    private void verHistorial() {
        System.out.println("ver historial de reparaciones de un vehiculo");

        if(vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
            return;
        }

        String placaBuscada = lector.leerTexto("ingresar la placa del vehiculo");
        Vehiculo vehiculo = buscarPorPlaca(placaBuscada);

        if(vehiculo == null) {
            System.out.println("no se encontro un vehiculo con esa placa");
            return;
        }

        System.out.println("historial del vehiculo:");
        vehiculo.mostrar();
        vehiculo.mostrarHistorial();
    }

    private Vehiculo buscarPorPlaca(String placaBuscada) {
        for(Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getPlaca().equalsIgnoreCase(placaBuscada)) {
                return vehiculo;
            }
        }

        return null;
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
