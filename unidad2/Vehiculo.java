import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private final String placa;
    private final String modelo;
    private final int anio;
    private final double cilindrada;
    private boolean pendiente;
    private double totalPagado;
    private final List<String> historial;
    private final List<String> observaciones;

    public Vehiculo(String placa, String modelo, int anio, double cilindrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.cilindrada = cilindrada;
        this.pendiente = true;
        this.totalPagado = 0;
        this.historial = new ArrayList<>();
        this.observaciones = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public boolean estaPendiente() {
        return pendiente;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void registrarSalida(String fecha, String hora) {
        this.pendiente = false;
        agregarHistorial("Salida registrada: " + fecha + " a las " + hora);
    }

    public void registrarPago(double monto, String metodoPago) {
        this.totalPagado += monto;
        agregarHistorial("Pago registrado: S/ " + monto + " con " + metodoPago);
    }

    public void agregarObservacion(String observacion) {
        observaciones.add(observacion);
        agregarHistorial("Observacion del cliente: " + observacion);
    }

    public void agregarHistorial(String detalle) {
        historial.add(detalle);
    }

    public void mostrarHistorial() {
        if(historial.isEmpty()) {
            System.out.println("no hay historial registrado");
            return;
        }

        for(int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void mostrar() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Anio: " + anio);
        System.out.println("Cilindrada: " + cilindrada);
        System.out.println("Estado: " + (pendiente ? "pendiente" : "atendido"));
        System.out.println("Total pagado: S/ " + totalPagado);
    }
}
