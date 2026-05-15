public class VistaConsola {
    private static final int ANCHO = 64;
    private static final String LINEA = repetir("=", ANCHO);
    private static final String LINEA_SUAVE = repetir("-", ANCHO);

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for(int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public static void saltoPagina() {
        System.out.println();
        System.out.println(LINEA_SUAVE);
        System.out.println();
    }

    public static void encabezado(String titulo) {
        limpiarPantalla();
        System.out.println(LINEA);
        System.out.println(centrar(titulo.toUpperCase()));
        System.out.println(LINEA);
        System.out.println();
    }

    public static void encabezado(String titulo, String subtitulo) {
        encabezado(titulo);
        System.out.println(centrar(subtitulo));
        System.out.println();
        System.out.println(LINEA_SUAVE);
        System.out.println();
    }

    public static void seccion(String titulo) {
        System.out.println();
        System.out.println(LINEA_SUAVE);
        System.out.println(centrar(titulo.toUpperCase()));
        System.out.println(LINEA_SUAVE);
    }

    public static void opcion(int numero, String texto) {
        System.out.printf("  [%d] %-52s%n", numero, capitalizar(texto));
    }

    public static void opcionSalida(int numero) {
        System.out.printf("  [%d] %-52s%n", numero, "Salir");
    }

    public static void info(String mensaje) {
        System.out.println("[INFO] " + mensaje);
    }

    public static void exito(String mensaje) {
        System.out.println("[OK] " + mensaje);
    }

    public static void error(String mensaje) {
        System.out.println("[ERROR] " + mensaje);
    }

    public static void pausa(LectorConsola lector) {
        System.out.println();
        lector.leerTexto("Presione ENTER para continuar...");
    }

    private static String centrar(String texto) {
        if(texto.length() >= ANCHO) {
            return texto;
        }

        int espaciosIzquierda = (ANCHO - texto.length()) / 2;
        return repetir(" ", espaciosIzquierda) + texto;
    }

    private static String capitalizar(String texto) {
        if(texto == null || texto.isEmpty()) {
            return "";
        }

        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }

    private static String repetir(String texto, int veces) {
        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i < veces; i++) {
            resultado.append(texto);
        }

        return resultado.toString();
    }
}
