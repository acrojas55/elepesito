public abstract class Usuario extends Persona {
    private final String rol;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String rol, String usuario, String contrasena) {
        super(nombre, apellido);
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public boolean validarCredenciales(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    public abstract boolean puedeAccederModulo(int opcion);

    public abstract boolean puedeRealizarTransaccion(int opcion);

    public void mostrar() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Rol: " + rol);
        System.out.println("Usuario: " + usuario);
    }
}
