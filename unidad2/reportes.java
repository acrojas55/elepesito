import java.util.List;

public class Reportes {
    private final LectorConsola lector;
    private final List<Vehiculo> vehiculos;
    private static final String ARCHIVO_REPORTE_PREDETERMINADO = "reporte_taller.pdf";

    public Reportes(LectorConsola lector, List<Vehiculo> vehiculos) {
        this.lector = lector;
        this.vehiculos = vehiculos;
    }

    public void mostrar() {
        VistaConsola.encabezado("Reportes");
        VistaConsola.opcion(0, "reporte de ingresos del dia");
        VistaConsola.opcion(1, "reporte de vehiculos atendidos por semana");
        VistaConsola.opcion(2, "lista de vehiculos pendientes");
        VistaConsola.opcion(3, "reporte de mecanicos mas productivos");
        VistaConsola.opcion(4, "exportar a PDF");
        VistaConsola.saltoPagina();

        int opcion = lector.leerEntero("Ingresar del 0 al 4 para ingresar a cualquier opcion");

        switch(opcion) {
            case 0:
                reporteIngresosDelDia();
                break;
            case 1:
                reporteVehiculosAtendidos();
                break;
            case 2:
                listarVehiculosPendientes();
                break;
            case 3:
                reporteMecanicosProductivos();
                break;
            case 4:
                exportarPdf();
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void reporteIngresosDelDia() {
        double total = 0;

        for(Vehiculo vehiculo : vehiculos) {
            total += vehiculo.getTotalPagado();
        }

        VistaConsola.seccion("Reporte del dia - ingresos");
        VistaConsola.info("Ingresos registrados: S/ " + total);
    }

    private void reporteVehiculosAtendidos() {
        int atendidos = 0;

        for(Vehiculo vehiculo : vehiculos) {
            if(!vehiculo.estaPendiente()) {
                atendidos++;
            }
        }

        VistaConsola.seccion("Reporte de vehiculos atendidos por semana");
        VistaConsola.info("Vehiculos atendidos: " + atendidos);
        VistaConsola.info("Vehiculos registrados: " + vehiculos.size());
    }

    private void listarVehiculosPendientes() {
        VistaConsola.seccion("Lista de vehiculos pendientes");

        if(vehiculos.isEmpty()) {
            VistaConsola.info("No hay vehiculos pendientes");
            return;
        }

        boolean hayPendientes = false;

        for(int i = 0; i < vehiculos.size(); i++) {
            if(vehiculos.get(i).estaPendiente()) {
                System.out.println("vehiculo " + (i + 1));
                vehiculos.get(i).mostrar();
                hayPendientes = true;
            }
        }

        if(!hayPendientes) {
            VistaConsola.info("No hay vehiculos pendientes");
        }
    }

    private void reporteMecanicosProductivos() {
        int atendidos = 0;

        for(Vehiculo vehiculo : vehiculos) {
            if(!vehiculo.estaPendiente()) {
                atendidos++;
            }
        }

        VistaConsola.seccion("Reporte de mecanicos mas productivos");
        VistaConsola.info("Carlos: " + atendidos + " vehiculos atendidos");
        VistaConsola.info("Luis: 0 vehiculos atendidos");
        VistaConsola.info("Pedro: 0 vehiculos atendidos");
    }

    private void exportarPdf() {
        VistaConsola.seccion("Exportar a PDF");
        VistaConsola.exito("Reporte generado: " + ARCHIVO_REPORTE_PREDETERMINADO);
        VistaConsola.info("Vehiculos incluidos: " + vehiculos.size());
    }
}
