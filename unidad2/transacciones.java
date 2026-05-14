import java.util.List;

public class Transacciones {
    private final LectorConsola lector;
    private final List<Vehiculo> vehiculos;

    public Transacciones(LectorConsola lector, List<Vehiculo> vehiculos) {
        this.lector = lector;
        this.vehiculos = vehiculos;
    }

    public void mostrar() {
        System.out.println("transacciones");
        System.out.println("0 = registrar vehiculo");
        System.out.println("1 = registrar salida de vehiculo");
        System.out.println("2 = registrar pago");
        System.out.println("3 = generar factura o boleta");
        System.out.println("4 = registrar observaciones del cliente");
        System.out.println("5 = enlistar vehiculos");

        int opcion = lector.leerEntero("Presionar del 0 al 5 para ingresar a cada opcion");

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
                System.out.println("opcion no valida");
                break;
        }
    }

    private void registrarVehiculo() {
        System.out.println("registrar vehiculo");
        String placa = lector.leerTexto("ingresar la placa del vehiculo");

        if(buscarPorPlaca(placa) != null) {
            System.out.println("ya existe un vehiculo registrado con esa placa");
            return;
        }

        String modelo = lector.leerTexto("ingresar el modelo del vehiculo");
        int anio = lector.leerEntero("ingresar el anio del vehiculo");
        double cilindrada = lector.leerDecimal("escribir la cilindrada del vehiculo");

        Vehiculo vehiculo = new Vehiculo(placa, modelo, anio, cilindrada);
        vehiculo.agregarHistorial("Vehiculo registrado en el taller");
        vehiculos.add(vehiculo);
        System.out.println("vehiculo registrado exitosamente");
    }

    private void registrarSalida() {
        System.out.println("registrar salida de vehiculo");
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
        System.out.println("el vehiculo sale del taller la fecha " + fecha);
        System.out.println("y la hora de salida es de: " + horaSalida);
    }

    private void registrarPago() {
        System.out.println("registrar pago");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        double montoPagar = lector.leerDecimal("ingresar el monto de pago");
        System.out.println("0 = yape");
        System.out.println("1 = plin");
        System.out.println("2 = credito");
        System.out.println("3 = debito");
        System.out.println("4 = efectivo");

        int opcionPago = lector.leerEntero("ingresar del 0 al 4 para escoger el metodo de pago");
        String metodoPago = obtenerMetodoPago(opcionPago);

        if(metodoPago == null) {
            System.out.println("no se escogio el metodo de pago");
            return;
        }

        vehiculo.registrarPago(montoPagar, metodoPago);
        System.out.println("se paga el total de: " + montoPagar + " con " + metodoPago);
    }

    private void generarComprobante() {
        System.out.println("generar factura o boleta");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        int opcionGenerar = lector.leerEntero("escoger entre 0 = factura o 1 = boleta");

        switch(opcionGenerar) {
            case 0:
                System.out.println("-----------factura---------");
                System.out.println("----CAR CENTER TARAPOTO----");
                System.out.println("-Jr. libertad 238, tarapoto-");
                vehiculo.mostrar();
                break;
            case 1:
                System.out.println("----------boleta-----------");
                System.out.println("----CAR CENTER TARAPOTO----");
                vehiculo.mostrar();
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void registrarObservacion() {
        System.out.println("registrar observaciones del cliente");
        Vehiculo vehiculo = pedirVehiculoPorPlaca();

        if(vehiculo == null) {
            return;
        }

        String observacion = lector.leerTexto("ingresar observacion");
        vehiculo.agregarObservacion(observacion);
        System.out.println("observacion: " + observacion);
    }

    private void listarVehiculos() {
        System.out.println("enlistar vehiculos");

        if(vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
            return;
        }

        for(int i = 0; i < vehiculos.size(); i++) {
            System.out.println("vehiculo " + (i + 1));
            vehiculos.get(i).mostrar();
        }
    }

    private Vehiculo pedirVehiculoPorPlaca() {
        if(vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
            return null;
        }

        String placa = lector.leerTexto("ingresar la placa del vehiculo");
        Vehiculo vehiculo = buscarPorPlaca(placa);

        if(vehiculo == null) {
            System.out.println("no se encontro un vehiculo con esa placa");
        }

        return vehiculo;
    }

    private Vehiculo buscarPorPlaca(String placaBuscada) {
        for(Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getPlaca().equalsIgnoreCase(placaBuscada)) {
                return vehiculo;
            }
        }

        return null;
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
