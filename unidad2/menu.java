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

    public void mostrar(Usuario usuarioAutenticado) {
        int opcion;

        do {
            mostrarOpciones(usuarioAutenticado);
            opcion = lector.leerEntero("Ingresar una opcion del 0 al 5");
            ejecutarOpcion(opcion, usuarioAutenticado);
            if(opcion != 5) {
                VistaConsola.pausa(lector);
            }
        } while(opcion != 5);
    }

    private void mostrarOpciones(Usuario usuarioAutenticado) {
        VistaConsola.encabezado("Car Center Tarapoto", "Menu disponible para rol: " + usuarioAutenticado.getRol());
        mostrarOpcionSiTienePermiso(0, "seguridad", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(1, "configuracion", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(2, "transacciones", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(3, "consultas", usuarioAutenticado);
        mostrarOpcionSiTienePermiso(4, "reportes", usuarioAutenticado);
        VistaConsola.opcionSalida(5);
        VistaConsola.saltoPagina();
    }

    private void ejecutarOpcion(int opcion, Usuario usuarioAutenticado) {
        if(opcion != 5 && !tienePermiso(usuarioAutenticado, opcion)) {
            VistaConsola.error("No tiene permiso para ingresar a esta opcion");
            return;
        }

        switch(opcion) {
            case 0:
                seguridad.mostrar();
                break;
            case 1:
                configuracion.mostrar();
                break;
            case 2:
                transacciones.mostrar(usuarioAutenticado);
                break;
            case 3:
                consultas.mostrar();
                break;
            case 4:
                reportes.mostrar();
                break;
            case 5:
                VistaConsola.exito("Gracias por usar el sistema. Hasta pronto.");
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void mostrarOpcionSiTienePermiso(int opcion, String nombre, Usuario usuarioAutenticado) {
        if(tienePermiso(usuarioAutenticado, opcion)) {
            VistaConsola.opcion(opcion, nombre);
        }
    }

    private boolean tienePermiso(Usuario usuarioAutenticado, int opcion) {
        String rol = usuarioAutenticado.getRol();

        if(Rol.ADMINISTRADOR.equalsIgnoreCase(rol)) {
            return true;
        }

        switch(opcion) {
            case 0:
                return false;
            case 1:
                return Rol.GERENTE.equalsIgnoreCase(rol);
            case 2:
                return Rol.GERENTE.equalsIgnoreCase(rol) || Rol.RECEPCIONISTA.equalsIgnoreCase(rol) || Rol.MECANICO.equalsIgnoreCase(rol);
            case 3:
                return Rol.GERENTE.equalsIgnoreCase(rol) || Rol.RECEPCIONISTA.equalsIgnoreCase(rol) || Rol.MECANICO.equalsIgnoreCase(rol);
            case 4:
                return Rol.GERENTE.equalsIgnoreCase(rol);
            default:
                return false;
        }
    }
}
