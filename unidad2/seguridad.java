import java.util.ArrayList;
import java.util.Scanner;

public class seguridad {
    public void mostrar(Scanner sc, ArrayList<Usuarios> listaUsuarios) {
        System.out.println("seguridad");
        System.out.println("presionar del 0 al 3 para ingresar a cada opcion");
        System.out.println("0 = crear usuario");
        System.out.println("1 = modificar usuario");
        System.out.println("2 = eliminar usuario");
        System.out.println("3 = listar usuarios");
        int opcion = sc.nextInt();

        switch(opcion) {
            case 0:
                crearUsuario(sc, listaUsuarios);
                break;
            case 1:
                modificarUsuario(sc, listaUsuarios);
                break;
            case 2:
                eliminarUsuario(sc, listaUsuarios);
                break;
            case 3:
                listarUsuarios(listaUsuarios);
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void crearUsuario(Scanner sc, ArrayList<Usuarios> listaUsuarios) {
        System.out.println("crear usuario");
        sc.nextLine();

        System.out.println("ingresar nombre");
        String nombre = sc.nextLine();
        System.out.println("ingresar apellido");
        String apellido = sc.nextLine();
        System.out.println("ingresar rol");
        String rol = sc.nextLine();
        System.out.println("ingresar usuario");
        String usuario = sc.nextLine();
        System.out.println("ingresar contrasena");
        String contrasena = sc.nextLine();

        listaUsuarios.add(new Usuarios(nombre, apellido, rol, usuario, contrasena));
        System.out.println("usuario creado exitosamente");
        System.out.println("usuario es " + nombre + " con el rol de " + rol);
    }

    private void modificarUsuario(Scanner sc, ArrayList<Usuarios> listaUsuarios) {
        System.out.println("modificar usuario");

        if(listaUsuarios.isEmpty()) {
            System.out.println("no hay usuarios registrados");
            return;
        }

        listarUsuarios(listaUsuarios);
        System.out.println("que numero de usuario desea modificar?");
        int pos = sc.nextInt() - 1;

        if(pos < 0 || pos >= listaUsuarios.size()) {
            System.out.println("posicion no valida");
            return;
        }

        Usuarios usuarioModificado = listaUsuarios.get(pos);
        System.out.println("ingresar del 0 al 4 que dato desea modificar");
        System.out.println("0 = nombre");
        System.out.println("1 = apellido");
        System.out.println("2 = rol");
        System.out.println("3 = usuario");
        System.out.println("4 = contrasena");
        int dato = sc.nextInt();
        sc.nextLine();

        switch(dato) {
            case 0:
                System.out.println("ingresar nuevo nombre");
                usuarioModificado.nombre = sc.nextLine();
                break;
            case 1:
                System.out.println("ingresar nuevo apellido");
                usuarioModificado.apellido = sc.nextLine();
                break;
            case 2:
                System.out.println("ingresar nuevo rol");
                usuarioModificado.rol = sc.nextLine();
                break;
            case 3:
                System.out.println("ingresar nuevo usuario");
                usuarioModificado.usuario = sc.nextLine();
                break;
            case 4:
                System.out.println("ingresar nueva contrasena");
                usuarioModificado.contrasena = sc.nextLine();
                break;
            default:
                System.out.println("dato no valido");
                return;
        }

        System.out.println("usuario modificado exitosamente");
    }

    private void eliminarUsuario(Scanner sc, ArrayList<Usuarios> listaUsuarios) {
        System.out.println("eliminar usuario");

        if(listaUsuarios.isEmpty()) {
            System.out.println("no hay usuarios registrados");
            return;
        }

        listarUsuarios(listaUsuarios);
        System.out.println("que numero de usuario desea eliminar?");
        int posEliminar = sc.nextInt() - 1;

        if(posEliminar < 0 || posEliminar >= listaUsuarios.size()) {
            System.out.println("posicion no valida");
        } else {
            listaUsuarios.remove(posEliminar);
            System.out.println("usuario eliminado exitosamente");
        }
    }

    private void listarUsuarios(ArrayList<Usuarios> listaUsuarios) {
        System.out.println("listar usuarios");

        if(listaUsuarios.isEmpty()) {
            System.out.println("no hay usuarios registrados");
        } else {
            for(int i = 0; i < listaUsuarios.size(); i++) {
                System.out.println("usuario " + (i + 1));
                listaUsuarios.get(i).mostrarUsuario();
            }
        }
    }
}
