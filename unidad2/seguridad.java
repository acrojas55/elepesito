import java.util.List;

public class Seguridad {
    private final LectorConsola lector;
    private final List<Usuario> usuarios;

    public Seguridad(LectorConsola lector, List<Usuario> usuarios) {
        this.lector = lector;
        this.usuarios = usuarios;
    }

    public void mostrar() {
        VistaConsola.encabezado("Seguridad");
        VistaConsola.opcion(0, "crear usuario");
        VistaConsola.opcion(1, "modificar usuario");
        VistaConsola.opcion(2, "eliminar usuario");
        VistaConsola.opcion(3, "listar usuarios");
        VistaConsola.saltoPagina();

        int opcion = lector.leerEntero("Presionar del 0 al 3 para ingresar a cada opcion");

        switch(opcion) {
            case 0:
                crearUsuario();
                break;
            case 1:
                modificarUsuario();
                break;
            case 2:
                eliminarUsuario();
                break;
            case 3:
                listarUsuarios();
                break;
            default:
                VistaConsola.error("Opcion no valida");
                break;
        }
    }

    private void crearUsuario() {
        VistaConsola.seccion("Crear usuario");
        String nombre = lector.leerTexto("ingresar nombre");
        String apellido = lector.leerTexto("ingresar apellido");
        String rol = seleccionarRol();
        String usuario = lector.leerTexto("ingresar usuario");
        String contrasena = lector.leerTexto("ingresar contrasena");

        usuarios.add(new Usuario(nombre, apellido, rol, usuario, contrasena));
        VistaConsola.exito("Usuario creado exitosamente");
        VistaConsola.info("Usuario: " + nombre + " | Rol: " + rol);
    }

    private void modificarUsuario() {
        VistaConsola.seccion("Modificar usuario");

        if(usuarios.isEmpty()) {
            VistaConsola.info("No hay usuarios registrados");
            return;
        }

        listarUsuarios();
        int posicion = lector.leerEntero("que numero de usuario desea modificar?") - 1;

        if(posicion < 0 || posicion >= usuarios.size()) {
            VistaConsola.error("Posicion no valida");
            return;
        }

        Usuario usuarioModificado = usuarios.get(posicion);
        VistaConsola.opcion(0, "nombre");
        VistaConsola.opcion(1, "apellido");
        VistaConsola.opcion(2, "rol");
        VistaConsola.opcion(3, "usuario");
        VistaConsola.opcion(4, "contrasena");

        int dato = lector.leerEntero("ingresar del 0 al 4 que dato desea modificar");

        switch(dato) {
            case 0:
                usuarioModificado.setNombre(lector.leerTexto("ingresar nuevo nombre"));
                break;
            case 1:
                usuarioModificado.setApellido(lector.leerTexto("ingresar nuevo apellido"));
                break;
            case 2:
                usuarioModificado.setRol(seleccionarRol());
                break;
            case 3:
                usuarioModificado.setUsuario(lector.leerTexto("ingresar nuevo usuario"));
                break;
            case 4:
                usuarioModificado.setContrasena(lector.leerTexto("ingresar nueva contrasena"));
                break;
            default:
                VistaConsola.error("Dato no valido");
                return;
        }

        VistaConsola.exito("Usuario modificado exitosamente");
    }

    private void eliminarUsuario() {
        VistaConsola.seccion("Eliminar usuario");

        if(usuarios.isEmpty()) {
            VistaConsola.info("No hay usuarios registrados");
            return;
        }

        listarUsuarios();
        int posicion = lector.leerEntero("que numero de usuario desea eliminar?") - 1;

        if(posicion < 0 || posicion >= usuarios.size()) {
            VistaConsola.error("Posicion no valida");
        } else {
            usuarios.remove(posicion);
            VistaConsola.exito("Usuario eliminado exitosamente");
        }
    }

    private void listarUsuarios() {
        VistaConsola.seccion("Listar usuarios");

        if(usuarios.isEmpty()) {
            VistaConsola.info("No hay usuarios registrados");
            return;
        }

        for(int i = 0; i < usuarios.size(); i++) {
            System.out.println("usuario " + (i + 1));
            usuarios.get(i).mostrar();
        }
    }

    private String seleccionarRol() {
        VistaConsola.opcion(0, "Administrador");
        VistaConsola.opcion(1, "Gerente");
        VistaConsola.opcion(2, "Recepcionista");
        VistaConsola.opcion(3, "Mecanico");

        int opcionRol = lector.leerEntero("seleccionar rol");

        switch(opcionRol) {
            case 0:
                return Rol.ADMINISTRADOR;
            case 1:
                return Rol.GERENTE;
            case 2:
                return Rol.RECEPCIONISTA;
            case 3:
                return Rol.MECANICO;
            default:
                VistaConsola.info("Rol no valido, se asigna Recepcionista");
                return Rol.RECEPCIONISTA;
        }
    }
}
