public class Usuario {
    private String nombre;
    private String apellido;
    private String rol;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String apellido, String rol, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public boolean validarCredenciales(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Rol: " + rol);
        System.out.println("Usuario: " + usuario);
    }
}
