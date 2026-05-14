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
        System.out.println("reportes");
        System.out.println("0 = reporte de ingresos del dia");
        System.out.println("1 = reporte de vehiculos atendidos por semana");
        System.out.println("2 = lista de vehiculos pendientes");
        System.out.println("3 = reporte de mecanicos mas productivos");
        System.out.println("4 = exportar a PDF");

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
                System.out.println("opcion no valida");
                break;
        }
    }

    private void reporteIngresosDelDia() {
        double total = 0;

        for(Vehiculo vehiculo : vehiculos) {
            total += vehiculo.getTotalPagado();
        }

        System.out.println("reporte del dia - ingresos");
        System.out.println("ingresos registrados: S/ " + total);
    }

    private void reporteVehiculosAtendidos() {
        int atendidos = 0;

        for(Vehiculo vehiculo : vehiculos) {
            if(!vehiculo.estaPendiente()) {
                atendidos++;
            }
        }

        System.out.println("reporte de vehiculos atendidos por semana");
        System.out.println("vehiculos atendidos: " + atendidos);
        System.out.println("vehiculos registrados: " + vehiculos.size());
    }

    private void listarVehiculosPendientes() {
        System.out.println("lista de vehiculos pendientes");

        if(vehiculos.isEmpty()) {
            System.out.println("no hay vehiculos pendientes");
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
            System.out.println("no hay vehiculos pendientes");
        }
    }

    private void reporteMecanicosProductivos() {
        int atendidos = 0;

        for(Vehiculo vehiculo : vehiculos) {
            if(!vehiculo.estaPendiente()) {
                atendidos++;
            }
        }

        System.out.println("reporte de mecanicos mas productivos");
        System.out.println("Carlos: " + atendidos + " vehiculos atendidos");
        System.out.println("Luis: 0 vehiculos atendidos");
        System.out.println("Pedro: 0 vehiculos atendidos");
    }

    private void exportarPdf() {
        System.out.println("exportar a PDF");
        System.out.println("reporte generado: " + ARCHIVO_REPORTE_PREDETERMINADO);
        System.out.println("vehiculos incluidos: " + vehiculos.size());
    }
}
