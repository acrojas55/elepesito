import java.util.ArrayList;
import java.util.Scanner;

public class transacciones {
    public void mostrar(Scanner sc, ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("transacciones");
        System.out.println("presionar del 0 al 5 para ingresar a cada opcion");
        System.out.println("0 = registrar vehiculo");
        System.out.println("1 = registrar salida de vehiculo");
        System.out.println("2 = registrar pago");
        System.out.println("3 = generar factura o boleta");
        System.out.println("4 = registrar observaciones del cliente");
        System.out.println("5 = enlistar vehiculos");
        int opcion = sc.nextInt();

        switch(opcion) {
            case 0:
                registrarVehiculo(sc, listaVehiculo);
                break;
            case 1:
                registrarSalida(sc);
                break;
            case 2:
                registrarPago(sc);
                break;
            case 3:
                generarComprobante(sc);
                break;
            case 4:
                registrarObservacion(sc);
                break;
            case 5:
                listarVehiculos(listaVehiculo);
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void registrarVehiculo(Scanner sc, ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("registrar vehiculo");
        sc.nextLine();

        System.out.println("ingresar la placa del vehiculo");
        String placa = sc.nextLine();
        System.out.println("ingresar el modelo del vehiculo");
        String modelo = sc.nextLine();
        System.out.println("ingresar el anio del vehiculo");
        int anio = sc.nextInt();
        System.out.println("escribir la cilindrada del vehiculo");
        double cilindrada = sc.nextDouble();

        listaVehiculo.add(new Vehiculo(placa, modelo, anio, cilindrada));
        System.out.println("vehiculo registrado exitosamente");
    }

    private void registrarSalida(Scanner sc) {
        System.out.println("registrar salida de vehiculo");
        System.out.println("ingresar el dia");
        int dia = sc.nextInt();
        sc.nextLine();
        System.out.println("ingresar el mes");
        String mes = sc.nextLine();
        System.out.println("ingresar el anio");
        int anio = sc.nextInt();
        System.out.println("ingresar la hora");
        int hora = sc.nextInt();
        System.out.println("ingresar los minutos");
        int minutos = sc.nextInt();

        System.out.println("el vehiculo sale del taller la fecha " + dia + "/" + mes + "/" + anio);
        System.out.println("y la hora de salida es de: " + hora + ":" + minutos);
    }

    private void registrarPago(Scanner sc) {
        System.out.println("registrar pago");
        System.out.println("ingresar el monto de pago");
        double montoPagar = sc.nextDouble();
        System.out.println("ingresar del 0 al 4 para escoger el metodo de pago");
        System.out.println("0 = yape");
        System.out.println("1 = plin");
        System.out.println("2 = credito");
        System.out.println("3 = debito");
        System.out.println("4 = efectivo");
        int opcionPago = sc.nextInt();

        switch(opcionPago) {
            case 0:
                System.out.println("se paga el total de: " + montoPagar + " con yape");
                break;
            case 1:
                System.out.println("se paga el total de: " + montoPagar + " con plin");
                break;
            case 2:
                System.out.println("se paga el total de: " + montoPagar + " con credito");
                break;
            case 3:
                System.out.println("se paga el total de: " + montoPagar + " con debito");
                break;
            case 4:
                System.out.println("se paga el total de: " + montoPagar + " con efectivo");
                break;
            default:
                System.out.println("no se escogio el metodo de pago");
                break;
        }
    }

    private void generarComprobante(Scanner sc) {
        System.out.println("generar factura o boleta");
        System.out.println("escoger entre 0 = factura o 1 = boleta");
        int opcionGenerar = sc.nextInt();

        switch(opcionGenerar) {
            case 0:
                System.out.println("-----------factura---------");
                System.out.println("----CAR CENTER TARAPOTO----");
                System.out.println("-Jr. libertad 238, tarapoto-");
                break;
            case 1:
                System.out.println("----------boleta-----------");
                System.out.println("----CAR CENTER TARAPOTO----");
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    private void registrarObservacion(Scanner sc) {
        System.out.println("registrar observaciones del cliente");
        sc.nextLine();
        String observacion = sc.nextLine();
        System.out.println("observacion: " + observacion);
    }

    private void listarVehiculos(ArrayList<Vehiculo> listaVehiculo) {
        System.out.println("enlistar vehiculos");

        if(listaVehiculo.isEmpty()) {
            System.out.println("no hay vehiculos registrados");
        } else {
            for(int i = 0; i < listaVehiculo.size(); i++) {
                System.out.println("vehiculo " + (i + 1));
                listaVehiculo.get(i).mostrarVehiculo();
            }
        }
    }
}
