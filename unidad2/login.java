import java.util.List;

public class Login {
    private final List<Usuario> usuarios;

    public Login(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean autenticar(LectorConsola lector) {
        String usuario = lector.leerTexto("Ingresar usuario");
        String contrasena = lector.leerTexto("Ingresar contrasena");

        for(Usuario usuarioRegistrado : usuarios) {
            if(usuarioRegistrado.validarCredenciales(usuario, contrasena)) {
                System.out.println("Bienvenido");
                return true;
            }
        }

        System.out.println("Usuario o contrasena incorrecta");
        return false;
    }
}
