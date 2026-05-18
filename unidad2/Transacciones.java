import java.util.List;

public class Transacciones extends ModuloBase {
    private final LectorConsola lector;
    private final List<Vehiculo> vehiculos;

    public Transacciones(LectorConsola lector, List<Vehiculo> vehiculos) {
        super(2, "transacciones");
        this.lector = lector;
        this.vehiculos = vehiculos;
    }

    public void mostrar(Usuario usuarioAutenticado) {
        VistaConsola.encabezado("Transacciones", "Rol activo: " + usuarioAutenticado.getRol());
        mostrarOpcionSiTienePermiso(0, "registrar vehiculo", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(1, "registrar salida de vehiculo", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(2, "registrar pago", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(3, "generar factura o boleta", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(4, "registrar observaciones del cliente", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(5, "enlistar vehiculos", usuarioAutenticado);
        VistaConsola.saltoPagina();

        int opcion = lector.leerEntero("Presionar del 0 al 5 para ingresar a cada opcion");

        if(!usuarioAutenticado.puedeRealizarTransaccion(opcion)) {
            VistaConsola.error("No tiene permiso para ingresar a esta opcion con el rol " + usuarioAutenticado.getRol());
            return;
        }

        switch(opcion) {
            case 0:
                registrarVehiculo();
                break;
            case 1:
                registrarSalida();
                break;
            case 2:
                registrarPago();
                break;
            case 3:
                generarComprobante();
                break;
            case 4:
                registrarObservacion();
                break;
            case 5:
                listarVehiculos();
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void mostrarOpcionSiTienePermiso(int opcion, String nombre, Usuario usuarioAutenticado) {
        if(usuarioAutenticado.puedeRealizarTransaccion(opcion)) {
            VistaConsola.opcion(opcion, nombre);
        }
    }

    private void registrarVehiculo() {
        VistaConsola.seccion("Registrar vehiculo");
        String placa = lector.leerTexto("ingresar la placa del vehiculo");

        if(Vehiculo.buscarPorPlaca(vehiculos, placa) != null) {
            VistaConsola.error("Ya existe un vehiculo registrado con esa placa");
            return;
        }

        String modelo = lector.leerTexto("ingresar el modelo del vehiculo");
        int anio = lector.leerEntero("ingresar el anio del vehiculo");
        double cilindrada = lector.leerDecimal("escribir la cilindrada del vehiculo");

        Vehiculo vehiculo = new Vehiculo(placa, modelo, anio, cilindrada);
        vehiculo.agregarHistorial("Vehiculo registrado en el taller");
        vehiculos.add(vehiculo);
        VistaConsola.exito("Vehiculo registrado exitosamente");
    }

    private void registrarSalida() {
        VistaConsola.seccion("Registrar salida de vehiculo");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        int dia = lector.leerEntero("ingresar el dia");
        String mes = lector.leerTexto("ingresar el mes");
        int anio = lector.leerEntero("ingresar el anio");
        int hora = lector.leerEntero("ingresar la hora");
        int minutos = lector.leerEntero("ingresar los minutos");
        String fecha = dia + "/" + mes + "/" + anio;
        String horaSalida = hora + ":" + minutos;

        vehiculo.registrarSalida(fecha, horaSalida);
        VistaConsola.exito("Salida registrada");
        VistaConsola.info("Fecha: " + fecha + " | Hora: " + horaSalida);
    }

    private void registrarPago() {
        VistaConsola.seccion("Registrar pago");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        double montoPagar = lector.leerDecimal("ingresar el monto de pago");
        VistaConsola.opcion(0, "yape");
        VistaConsola.opcion(1, "plin");
        VistaConsola.opcion(2, "credito");
        VistaConsola.opcion(3, "debito");
        VistaConsola.opcion(4, "efectivo");

        int opcionPago = lector.leerEntero("ingresar del 0 al 4 para escoger el metodo de pago");
        String metodoPago = obtenerMetodoPago(opcionPago);

        if(metodoPago == null) {
            VistaConsola.error("No se escogio el metodo de pago");
            return;
        }

        vehiculo.registrarPago(montoPagar, metodoPago);
        VistaConsola.exito("Pago registrado");
        VistaConsola.info("Total: S/ " + montoPagar + " | Metodo: " + metodoPago);
    }

    private void generarComprobante() {
        VistaConsola.seccion("Generar factura o boleta");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        int opcionGenerar = lector.leerEntero("escoger entre 0 = factura o 1 = boleta");

        switch(opcionGenerar) {
            case 0:
                VistaConsola.seccion("Factura");
                VistaConsola.info("CAR CENTER TARAPOTO");
                VistaConsola.info("Jr. libertad 238, tarapoto");
                vehiculo.mostrar();
                break;
            case 1:
                VistaConsola.seccion("Boleta");
                VistaConsola.info("CAR CENTER TARAPOTO");
                vehiculo.mostrar();
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void registrarObservacion() {
        VistaConsola.seccion("Registrar observaciones del cliente");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        String observacion = lector.leerTexto("ingresar observacion");
        vehiculo.agregarObservacion(observacion);
        VistaConsola.exito("Observacion registrada");
        VistaConsola.info("Observacion: " + observacion);
    }

    private void listarVehiculos() {
        VistaConsola.seccion("Enlistar vehiculos");

        if(vehiculos.isEmpty()) {
            VistaConsola.info("No hay vehiculos registrados");
            return;
        }

        for(int i = 0; i < vehiculos.size(); i++) {
            if(i > 0) {
                System.out.println();
            }

            System.out.println("vehiculo " + (i + 1));
            vehiculos.get(i).mostrar();
        }
    }

    private Vehiculo pedirVehiculoPorPlaca() {
        if(vehiculos.isEmpty()) {
            VistaConsola.info("No hay vehiculos registrados");
            return null;
        }

        String placa = lector.leerTexto("ingresar la placa del vehiculo");
        Vehiculo vehiculo = Vehiculo.buscarPorPlaca(vehiculos, placa);

        if(vehiculo == null) {
            VistaConsola.error("No se encontro un vehiculo con esa placa");
        }

        return vehiculo;
    }

    private String obtenerMetodoPago(int opcionPago) {
        switch(opcionPago) {
            case 0:
                return "yape";
            case 1:
                return "plin";
            case 2:
                return "credito";
            case 3:
                return "debito";
            case 4:
                return "efectivo";
            default:
                return null;
        }
    }
}
