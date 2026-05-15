public class Configuracion {
    private final LectorConsola lector;

    public Configuracion(LectorConsola lector) {
        this.lector = lector;
    }

    public void mostrar() {
        VistaConsola.encabezado("Configuracion");
        VistaConsola.opcion(0, "tipo de servicio");
        VistaConsola.opcion(1, "precio de cada servicio");
        VistaConsola.opcion(2, "marcas de vehiculo");
        VistaConsola.opcion(3, "datos del taller");
        VistaConsola.opcion(4, "impuestos");
        VistaConsola.saltoPagina();

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
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void tipoServicio() {
        VistaConsola.seccion("Tipo de servicio");
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
                VistaConsola.info("Servicios adicionales");
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void precioServicio() {
        VistaConsola.seccion("Precio de cada servicio");
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
                VistaConsola.info("Servicios adicionales: desde 45 soles");
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void marcasVehiculo() {
        VistaConsola.seccion("Marcas de vehiculo");
        VistaConsola.opcion(0, "toyota");
        VistaConsola.opcion(1, "volkswagen");
        VistaConsola.opcion(2, "chevrolet");
        VistaConsola.opcion(3, "honda");
        VistaConsola.opcion(4, "yamaha");
        VistaConsola.opcion(5, "bajaj");
        VistaConsola.opcion(6, "otros");

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
                VistaConsola.info("La marca del vehiculo es: " + marcaVehiculo);
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void datosTaller() {
        VistaConsola.seccion("Datos del taller");
        VistaConsola.info("CAR CENTER TARAPOTO");
        VistaConsola.info("Ubicacion: Jr. libertad 238, tarapoto");
        VistaConsola.info("Descripcion: Taller de coches con rapida solucion de problemas y acceso a repuestos.");
    }

    private void impuestos() {
        VistaConsola.seccion("Impuestos");
        VistaConsola.opcion(0, "ver tasa de IGV actual");
        VistaConsola.opcion(1, "activar IGV en facturacion");
        VistaConsola.opcion(2, "configurar detraccion (10% para montos > S/ 700)");

        int opcionImpuesto = lector.leerEntero("escoger opcion");

        switch(opcionImpuesto) {
            case 0:
                double igv = 18;
                VistaConsola.info("Tasa IGV actual: " + igv + "%");
                break;
            case 1:
                VistaConsola.exito("Se activa el IGV");
                break;
            case 2:
                double monto = lector.leerDecimal("escribir el monto");
                if(monto > 700) {
                    double descuento = monto * 0.1;
                    double total = monto - descuento;
                    VistaConsola.info("El monto a pagar es = " + total);
                } else {
                    VistaConsola.info("No aplica detraccion");
                }
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void mostrarServicios() {
        VistaConsola.opcion(0, "mantenimiento preventivo");
        VistaConsola.opcion(1, "reparaciones mecanicas");
        VistaConsola.opcion(2, "servicios electricos y electronicos");
        VistaConsola.opcion(3, "servicios de carroceria y pintura");
        VistaConsola.opcion(4, "servicios de neumaticos");
        VistaConsola.opcion(5, "servicios de diagnostico y asesoria");
        VistaConsola.opcion(6, "servicios especializados");
        VistaConsola.opcion(7, "servicios adicionales");
    }
}
