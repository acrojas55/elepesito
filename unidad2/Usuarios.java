public class Usuarios {
    String nombre;
    String apellido;
    String rol;
    String usuario;
    String contrasena;

    public Usuarios(String nombre, String apellido, String rol, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public void mostrarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Rol: " + rol);
        System.out.println("Usuario: " + usuario);
    }
}
