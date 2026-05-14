import java.util.List;

public class Menu {
    private final LectorConsola lector;
    private final List<Usuario> usuarios;
    private final List<Vehiculo> vehiculos;
    private final Seguridad seguridad;
    private final Configuracion configuracion;
    private final Transacciones transacciones;
    private final Consultas consultas;
    private final Reportes reportes;

    public Menu(LectorConsola lector, List<Usuario> usuarios, List<Vehiculo> vehiculos) {
        this.lector = lector;
        this.usuarios = usuarios;
        this.vehiculos = vehiculos;
        this.seguridad = new Seguridad(lector, usuarios);
        this.configuracion = new Configuracion(lector);
        this.transacciones = new Transacciones(lector, vehiculos);
        this.consultas = new Consultas(lector, vehiculos);
        this.reportes = new Reportes(lector, vehiculos);
    }

    public void mostrar() {
        int opcion;

        do {
            mostrarOpciones();
            opcion = lector.leerEntero("Ingresar una opcion del 0 al 5");
            ejecutarOpcion(opcion);
        } while(opcion != 5);
    }

    private void mostrarOpciones() {
        System.out.println("0 = seguridad");
        System.out.println("1 = configuracion");
        System.out.println("2 = transacciones");
        System.out.println("3 = consultas");
        System.out.println("4 = reportes");
        System.out.println("5 = salir");
    }

    private void ejecutarOpcion(int opcion) {
        switch(opcion) {
            case 0:
                seguridad.mostrar();
                break;
            case 1:
                configuracion.mostrar();
                break;
            case 2:
                transacciones.mostrar();
                break;
            case 3:
                consultas.mostrar();
                break;
            case 4:
                reportes.mostrar();
                break;
            case 5:
                System.out.println("salir");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }
}
