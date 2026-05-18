import java.util.List;
import java.util.ArrayList;

public class Menu {
    private final LectorConsola lector;
    private final List<ModuloSistema> modulos;

    public Menu(LectorConsola lector, List<Usuario> usuarios, List<Vehiculo> vehiculos) {
        this.lector = lector;
        this.modulos = new ArrayList<>();
        this.modulos.add(new Seguridad(lector, usuarios));
        this.modulos.add(new Configuracion(lector));
        this.modulos.add(new Transacciones(lector, vehiculos));
        this.modulos.add(new Consultas(lector, vehiculos));
        this.modulos.add(new Reportes(lector, vehiculos));
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

        for(ModuloSistema modulo : modulos) {
            if(modulo.tienePermiso(usuarioAutenticado)) {
                VistaConsola.opcion(modulo.getCodigo(), modulo.getNombre());
            }
        }

        VistaConsola.opcionSalida(5);
        VistaConsola.saltoPagina();
    }

    private void ejecutarOpcion(int opcion, Usuario usuarioAutenticado) {
        if(opcion == 5) {
            VistaConsola.exito("Gracias por usar el sistema. Hasta pronto.");
            return;
        }

        for(ModuloSistema modulo : modulos) {
            if(modulo.getCodigo() == opcion) {
                if(modulo.tienePermiso(usuarioAutenticado)) {
                    modulo.mostrar(usuarioAutenticado);
                } else {
                    VistaConsola.error("No tiene permiso para ingresar a esta opcion");
                }
                return;
            }
        }

        VistaConsola.error("Opcion no valida");
    }
}
