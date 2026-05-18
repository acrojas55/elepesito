import java.util.List;

public class Login {
    private final List<Usuario> usuarios;

    public Login(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(LectorConsola lector) {
        String usuario = lector.leerTexto("Ingresar usuario");
        String contrasena = lector.leerTexto("Ingresar contrasena");

        for(Usuario usuarioRegistrado : usuarios) {
            if(usuarioRegistrado.validarCredenciales(usuario, contrasena)) {
                VistaConsola.saltoPagina();
                VistaConsola.exito("Bienvenido " + usuarioRegistrado.getNombre());
                VistaConsola.info("Rol: " + usuarioRegistrado.getRol());
                return usuarioRegistrado;
            }
        }

        VistaConsola.error("Usuario o contrasena incorrecta");
        return null;
    }
}
