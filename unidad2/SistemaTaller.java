import java.util.ArrayList;
import java.util.List;

public class SistemaTaller {
    private final LectorConsola lector;
    private final List<Usuario> usuarios;
    private final List<Vehiculo> vehiculos;
    private final Login login;
    private final Menu menu;

    public SistemaTaller() {
        this.lector = new LectorConsola();
        this.usuarios = new ArrayList<>();
        this.vehiculos = new ArrayList<>();

        cargarUsuariosPredeterminados();
        cargarVehiculosPredeterminados();

        this.login = new Login(usuarios);
        this.menu = new Menu(lector, usuarios, vehiculos);
    }

    public void iniciar() {
        VistaConsola.encabezado("Login del sistema", "Car Center Tarapoto");
        Usuario usuarioAutenticado = login.autenticar(lector);

        if(usuarioAutenticado != null) {
            VistaConsola.pausa(lector);
            menu.mostrar(usuarioAutenticado);
        } else {
            VistaConsola.error("No se puede ingresar al menu");
        }
    }

    private void cargarUsuariosPredeterminados() {
        Usuario administrador = new Administrador("Administrador", "Sistema", "admin", "admin123");

        usuarios.add(administrador);
    }

    private void cargarVehiculosPredeterminados() {
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota Corolla", 2020, 1.8);
        vehiculo.agregarHistorial("Vehiculo ingresado al taller como registro predeterminado");
        vehiculos.add(vehiculo);
    }
}
