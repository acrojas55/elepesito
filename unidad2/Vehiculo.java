public class Vehiculo {
    String placa;
    String modelo;
    int anio;
    double cilindrada;

    public Vehiculo(String placa, String modelo, int anio, double cilindrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.cilindrada = cilindrada;
    }

    public void mostrarVehiculo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Anio: " + anio);
        System.out.println("Cilindrada: " + cilindrada);
    }
}
