import java.util.List;

public class Seguridad {
    private final LectorConsola lector;
    private final List<Usuario> usuarios;

    public Seguridad(LectorConsola lector, List<Usuario> usuarios) {
        this.lector = lector;
        this.usuarios = usuarios;
    }

    public void mostrar() {
        System.out.println("seguridad");
        System.out.println("0 = crear usuario");
        System.out.println("1 = modificar usuario");
        System.out.println("2 = eliminar usuario");
        System.out.println("3 = listar usuarios");

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
                System.out.println("opcion no valida");
                break;
        }
    }

    private void crearUsuario() {
        System.out.println("crear usuario");
        String nombre = lector.leerTexto("ingresar nombre");
        String apellido = lector.leerTexto("ingresar apellido");
        String rol = lector.leerTexto("ingresar rol");
        String usuario = lector.leerTexto("ingresar usuario");
        String contrasena = lector.leerTexto("ingresar contrasena");

        usuarios.add(new Usuario(nombre, apellido, rol, usuario, contrasena));
        System.out.println("usuario creado exitosamente");
        System.out.println("usuario es " + nombre + " con el rol de " + rol);
    }

    private void modificarUsuario() {
        System.out.println("modificar usuario");

        if(usuarios.isEmpty()) {
            System.out.println("no hay usuarios registrados");
            return;
        }

        listarUsuarios();
        int posicion = lector.leerEntero("que numero de usuario desea modificar?") - 1;

        if(posicion < 0 || posicion >= usuarios.size()) {
            System.out.println("posicion no valida");
            return;
        }

        Usuario usuarioModificado = usuarios.get(posicion);
        System.out.println("0 = nombre");
        System.out.println("1 = apellido");
        System.out.println("2 = rol");
        System.out.println("3 = usuario");
        System.out.println("4 = contrasena");

        int dato = lector.leerEntero("ingresar del 0 al 4 que dato desea modificar");

        switch(dato) {
            case 0:
                usuarioModificado.setNombre(lector.leerTexto("ingresar nuevo nombre"));
                break;
            case 1:
                usuarioModificado.setApellido(lector.leerTexto("ingresar nuevo apellido"));
                break;
            case 2:
                usuarioModificado.setRol(lector.leerTexto("ingresar nuevo rol"));
                break;
            case 3:
                usuarioModificado.setUsuario(lector.leerTexto("ingresar nuevo usuario"));
                break;
            case 4:
                usuarioModificado.setContrasena(lector.leerTexto("ingresar nueva contrasena"));
                break;
            default:
                System.out.println("dato no valido");
                return;
        }

        System.out.println("usuario modificado exitosamente");
    }

    private void eliminarUsuario() {
        System.out.println("eliminar usuario");

        if(usuarios.isEmpty()) {
            System.out.println("no hay usuarios registrados");
            return;
        }

        listarUsuarios();
        int posicion = lector.leerEntero("que numero de usuario desea eliminar?") - 1;

        if(posicion < 0 || posicion >= usuarios.size()) {
            System.out.println("posicion no valida");
        } else {
            usuarios.remove(posicion);
            System.out.println("usuario eliminado exitosamente");
        }
    }

    private void listarUsuarios() {
        System.out.println("listar usuarios");

        if(usuarios.isEmpty()) {
            System.out.println("no hay usuarios registrados");
            return;
        }

        for(int i = 0; i < usuarios.size(); i++) {
            System.out.println("usuario " + (i + 1));
            usuarios.get(i).mostrar();
        }
    }
}
