public class Administrador extends Usuario {
    public static final String ROL = "Administrador";

    public Administrador(String nombre, String apellido, String usuario, String contrasena) {
        super(nombre, apellido, ROL, usuario, contrasena);
    }

    public boolean puedeAccederModulo(int opcion) {
        return opcion >= 0 && opcion <= 4;
    }

    public boolean puedeRealizarTransaccion(int opcion) {
        return opcion >= 0 && opcion <= 5;
    }
}
