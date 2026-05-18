public abstract class ModuloBase implements ModuloSistema {
    private final int codigo;
    private final String nombre;

    public ModuloBase(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tienePermiso(Usuario usuario) {
        return usuario.puedeAccederModulo(codigo);
    }
}
