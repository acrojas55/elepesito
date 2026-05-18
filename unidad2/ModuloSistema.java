public interface ModuloSistema {
    int getCodigo();

    String getNombre();

    boolean tienePermiso(Usuario usuario);

    void mostrar(Usuario usuario);
}
