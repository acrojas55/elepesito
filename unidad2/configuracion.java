public class Configuracion {
    private final LectorConsola lector;

    public Configuracion(LectorConsola lector) {
        this.lector = lector;
    }

    public void mostrar() {
        System.out.println("configuracion");
        System.out.println("0 = tipo de servicio");
        System.out.println("1 = precio de cada servicio");
        System.out.println("2 = marcas de vehiculo");
        System.out.println("3 = datos del taller");
        System.out.println("4 = impuestos");

        int opcion = lector.leerEntero("Presionar del 0 al 4 para las opciones");

        switch(opcion) {
            case 0:
                tipoServicio();
                break;
            case 1:
                precioServicio();
                break;
            case 2:
                marcasVehiculo();
                break;
            case 3:
                datosTaller();
                break;
            case 4:
                impuestos();
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void tipoServicio() {
        System.out.println("tipo de servicio");
        mostrarServicios();
        int opcionServicio = lector.leerEntero("escoger servicio");

        switch(opcionServicio) {
            case 0:
                System.out.println("mantenimiento preventivo");
                break;
            case 1:
                System.out.println("reparaciones mecanicas");
                break;
            case 2:
                System.out.println("servicios electricos y electronicos");
                break;
            case 3:
                System.out.println("servicios de carroceria y pintura");
                break;
            case 4:
                System.out.println("servicios de neumaticos");
                break;
            case 5:
                System.out.println("servicios de diagnostico y asesoria");
                break;
            case 6:
                System.out.println("servicios especializados");
                break;
            case 7:
                System.out.println("servicios adicionales");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void precioServicio() {
        System.out.println("precio de cada servicio");
        mostrarServicios();
        int opcionServicio = lector.leerEntero("escoger servicio");

        switch(opcionServicio) {
            case 0:
                System.out.println("mantenimiento preventivo: desde 80 soles");
                break;
            case 1:
                System.out.println("reparaciones mecanicas: desde 150 soles");
                break;
            case 2:
                System.out.println("servicios electricos y electronicos: desde 60 soles");
                break;
            case 3:
                System.out.println("carroceria y pintura: desde 120 soles");
                break;
            case 4:
                System.out.println("servicios de neumaticos: desde 25 soles");
                break;
            case 5:
                System.out.println("diagnostico y asesoria: desde 50 soles");
                break;
            case 6:
                System.out.println("servicios especializados: desde 170 soles");
                break;
            case 7:
                System.out.println("servicios adicionales: desde 45 soles");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void marcasVehiculo() {
        System.out.println("marcas de vehiculo");
        System.out.println("0 = toyota");
        System.out.println("1 = volkswagen");
        System.out.println("2 = chevrolet");
        System.out.println("3 = honda");
        System.out.println("4 = yamaha");
        System.out.println("5 = bajaj");
        System.out.println("6 = otros");

        int opcionMarca = lector.leerEntero("ingresar del 0 a 6 para escoger una opcion");

        switch(opcionMarca) {
            case 0:
                System.out.println("el vehiculo pertenece a toyota");
                break;
            case 1:
                System.out.println("el vehiculo pertenece a volkswagen");
                break;
            case 2:
                System.out.println("el vehiculo pertenece a chevrolet");
                break;
            case 3:
                System.out.println("el vehiculo pertenece a honda");
                break;
            case 4:
                System.out.println("el vehiculo pertenece a yamaha");
                break;
            case 5:
                System.out.println("el vehiculo pertenece a bajaj");
                break;
            case 6:
                String marcaVehiculo = lector.leerTexto("agregar la marca del vehiculo");
                System.out.println("la marca del vehiculo es: " + marcaVehiculo);
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void datosTaller() {
        System.out.println("datos del taller");
        System.out.println("-------CAR CENTER TARAPOTO-----");
        System.out.println("ubicacion: Jr. libertad 238, tarapoto");
        System.out.println("descripcion: Taller de coches con rapida solucion de problemas y acceso a repuestos.");
    }

    private void impuestos() {
        System.out.println("impuestos");
        System.out.println("0 = ver tasa de IGV actual");
        System.out.println("1 = activar IGV en facturacion");
        System.out.println("2 = configurar detraccion (10% para montos > S/ 700)");

        int opcionImpuesto = lector.leerEntero("escoger opcion");

        switch(opcionImpuesto) {
            case 0:
                double igv = 18;
                System.out.println("tasa IGV actual: " + igv + "%");
                break;
            case 1:
                System.out.println("se activa el IGV");
                break;
            case 2:
                double monto = lector.leerDecimal("escribir el monto");
                if(monto > 700) {
                    double descuento = monto * 0.1;
                    double total = monto - descuento;
                    System.out.println("el monto a pagar es = " + total);
                } else {
                    System.out.println("no aplica detraccion");
                }
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void mostrarServicios() {
        System.out.println("0 = mantenimiento preventivo");
        System.out.println("1 = reparaciones mecanicas");
        System.out.println("2 = servicios electricos y electronicos");
        System.out.println("3 = servicios de carroceria y pintura");
        System.out.println("4 = servicios de neumaticos");
        System.out.println("5 = servicios de diagnostico y asesoria");
        System.out.println("6 = servicios especializados");
        System.out.println("7 = servicios adicionales");
    }
}
