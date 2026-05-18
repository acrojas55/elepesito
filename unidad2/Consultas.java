import java.util.List;

public class Consultas extends ModuloBase {
    private final LectorConsola lector;
    private final List<Vehiculo> vehiculos;

    public Consultas(LectorConsola lector, List<Vehiculo> vehiculos) {
        super(3, "consultas");
        this.lector = lector;
        this.vehiculos = vehiculos;
    }

    public void mostrar(Usuario usuarioAutenticado) {
        VistaConsola.encabezado("Consultas");
        VistaConsola.opcion(0, "buscar vehiculo por placa");
        VistaConsola.opcion(1, "ver vehiculos en espera");
        VistaConsola.opcion(2, "ver historial de reparaciones de un vehiculo");
        VistaConsola.opcion(3, "ver tecnicos disponibles");
        VistaConsola.opcion(4, "consultar servicios mas solicitados");
        VistaConsola.saltoPagina();

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
                verTecnicosDisponibles();
                break;
            case 4:
                verServiciosMasSolicitados();
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void buscarVehiculoPorPlaca() {
        VistaConsola.seccion("Buscar vehiculo por placa");

        if(vehiculos.isEmpty()) {
            VistaConsola.info("No hay vehiculos registrados");
            return;
        }

        String placaBuscada = lector.leerTexto("ingresar la placa del vehiculo");
        Vehiculo vehiculo = Vehiculo.buscarPorPlaca(vehiculos, placaBuscada);

        if(vehiculo == null) {
            VistaConsola.error("No se encontro un vehiculo con esa placa");
            return;
        }

        VistaConsola.exito("Vehiculo encontrado");
        vehiculo.mostrar();
    }

    private void verVehiculosEnEspera() {
        VistaConsola.seccion("Ver vehiculos en espera");

        if(vehiculos.isEmpty()) {
            VistaConsola.info("No hay vehiculos en espera");
            return;
        }

        boolean hayVehiculosEnEspera = false;

        for(int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).estaPendiente()) {
                if(hayVehiculosEnEspera) {
                    System.out.println();
                }

                System.out.println("vehiculo " + (i + 1));
                vehiculos.get(i).mostrar();
                hayVehiculosEnEspera = true;
            }
        }

        if(!hayVehiculosEnEspera) {
            VistaConsola.info("No hay vehiculos en espera");
        }
    }

    private void verHistorial() {
        VistaConsola.seccion("Ver historial de reparaciones de un vehiculo");

        if(vehiculos.isEmpty()) {
            VistaConsola.info("No hay vehiculos registrados");
            return;
        }

        String placaBuscada = lector.leerTexto("ingresar la placa del vehiculo");
        Vehiculo vehiculo = Vehiculo.buscarPorPlaca(vehiculos, placaBuscada);

        if(vehiculo == null) {
            VistaConsola.error("No se encontro un vehiculo con esa placa");
            return;
        }

        VistaConsola.info("Historial del vehiculo:");
        vehiculo.mostrar();
        vehiculo.mostrarHistorial();
    }

    private void verTecnicosDisponibles() {
        VistaConsola.seccion("Ver tecnicos disponibles");
        VistaConsola.info("Tecnico 1: Carlos");
        VistaConsola.info("Tecnico 2: Luis");
        VistaConsola.info("Tecnico 3: Pedro");
    }

    private void verServiciosMasSolicitados() {
        VistaConsola.seccion("Consultar servicios mas solicitados");
        VistaConsola.info("1. cambio de aceite y filtro");
        VistaConsola.info("2. revision de frenos");
        VistaConsola.info("3. alineacion y balanceo");
    }
}
