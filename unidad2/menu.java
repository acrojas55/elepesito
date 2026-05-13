import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
public class menu {
Scanner sc = new Scanner(System.in);
ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
ArrayList<Vehiculo> listaVehiculo= new ArrayList<>();
String placa;
String modelo;
int anio;
double cilindrada;

/**
 * 
 */
public void menus(){
    int opcion;
    do {
    System.out.println("ingresar una opcion del 0 al 5");
    System.out.println("0 = seguridad");
    System.out.println("1 = configuracion");
    System.out.println("2 = transacciones");
    System.out.println("3 = consultas");
    System.out.println("4 = reportes");
    System.out.println("5 = salir");
    opcion=sc.nextInt();
    switch(opcion){
        case 0:
            System.out.println("seguridad");
            System.out.println("presionar del 0 al 3 para ingresar a cada opcion");
            System.out.println("0 = crear usuario");
            System.out.println("1 = modificar usuario");
            System.out.println("2 = eliminar usuario");
            System.out.println("3 = listar usuarios");
            int opciones=sc.nextInt();

            switch (opciones) {
                case 0:
                    System.out.println("crear usuario");
                    String nombre =  ""  ;
                    String apellido="";
                    String rol="";
                    String usuario= "";
                    String contrasena="";
                    sc.nextLine();
                    System.out.println("ingresar nombre");
                    nombre=sc.nextLine();
                    System.out.println("ingresar apellido");
                    apellido=sc.nextLine();
                    System.out.println("ingresar rol");
                    rol=sc.nextLine();
                    System.out.println("ingresar usuario");
                    usuario=sc.nextLine();
                    System.out.println("ingresar contrasena");
                    contrasena=sc.nextLine();
                    listaUsuarios.add(new Usuarios(nombre, apellido, rol, usuario, contrasena));
                    for(int i=0 ; i<listaUsuarios.size(); i++) {
                        listaUsuarios.get(i).mostrarUsuario();
                    }
                    System.out.println("usuario creado exitosamente");
                    System.out.println("usuario es " +nombre + " con el rol de   " +rol);
                    break;
                case 1:
                    System.out.println("modificar usuario");
                    System.out.println("que numero de usuario desea modificar?");
                    int pos = sc.nextInt() - 1;
                    if(pos < 0 || pos >= listaUsuarios.size()) {
                        System.out.println("posicion no valida");
                    } else {
                        Usuarios usuarioModificado = listaUsuarios.get(pos);
                        System.out.println("ingresar del 0 al 4 que dato desea modificar");
                        System.out.println("0 = nombre ");
                        System.out.println("1 = apellido");
                        System.out.println("2 = rol");
                        System.out.println("3 = usuario");
                        System.out.println("4 = contraseña");
                        int dato = sc.nextInt();
                        sc.nextLine();
                        switch(dato) {
                            case 0:
                                System.out.println("ingresar nuevo nombre");
                                usuarioModificado.nombre = sc.nextLine();
                                break;
                            case 1:
                                System.out.println("ingresar nuevo apellido");
                                usuarioModificado.apellido = sc.nextLine();
                                break;
                            case 2:
                                System.out.println("ingresar nuevo rol");
                                usuarioModificado.rol = sc.nextLine();
                                break;
                            case 3:
                                System.out.println("ingresar nueva usuario");
                                usuarioModificado.usuario = sc.nextLine();
                                break;
                            case 4:
                                System.out.println("ingresar nueva contrasena");
                                usuarioModificado.contrasena = sc.nextLine();
                                break;
                            default:
                                System.out.println("dato no valido");
                                break;
                        }
                        System.out.println("usuario modificado exitosamente");
                    }

                    break;
                case 2:
                    System.out.println("eliminar usuario");
                    if(listaUsuarios.isEmpty()) {
                        System.out.println("no hay usuarios registrados");
                    } else {
                        for(int i=0 ; i<listaUsuarios.size(); i++) {
                            System.out.println("usuario " +(i+1));
                            listaUsuarios.get(i).mostrarUsuario();
                        }
                        System.out.println("que numero de usuario desea eliminar?");
                        int posEliminar = sc.nextInt() - 1;
                        if(posEliminar < 0 || posEliminar >= listaUsuarios.size()) {
                            System.out.println("posicion no valida");
                        } else {
                            listaUsuarios.remove(posEliminar);
                            System.out.println("usuario eliminado exitosamente");
                        }
                    }

                    break;
                case 3:
                    System.out.println("listar usuarios");
                    if(listaUsuarios.isEmpty()) {
                        System.out.println("no hay usuarios registrados");
                    } else {
                        for(int i=0 ; i<listaUsuarios.size(); i++) {
                            System.out.println("usuario " +(i+1));
                            listaUsuarios.get(i).mostrarUsuario();
                        }
                    }
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }

         break;
        case 1:
            System.out.println("configuracion");
            System.out.println("presionar del 0 al 4 para las opciones");
            System.out.println("0 = tipo de servicio");
            System.out.println("1 = precio de cada servicio");
            System.out.println("2 = marcas de vehiculo");
            System.out.println("3 = Datos del taller");
            System.out.println("4 = Impuestos");
            int opcioness = sc.nextInt();
            switch (opcioness) {
                case 0: 
                    System.out.println("tipo de servicio");
                    System.out.println("presionar del 0 al 8 para ingresar a cada opcion");
                    System.out.println("0 = mantenimiento preventivo");
                    System.out.println("1 = reparaciones mecanicas");
                    System.out.println("2=servicios electricos y electronicos");
                    System.out.println("3= servicios de carroceria y pintura");
                    System.out.println("4= servicios de neumaticos ");
                    System.out.println("5= servicios de diagnostico y asesoria");
                    System.out.println("6= servicios especializados");
                    System.out.println("7= servicios adicionales");
                    int opcionservicio= sc.nextInt();
                    switch (opcionservicio) {
                        case 0:
                            System.out.println("mantenimiento preventivo");
                            System.out.println("presionar del 0 al 6 para ingresar a cada opcion");
                            System.out.println("0= cambio de aceite y fitro ");
                            System.out.println("1= revision y ajustes de frenos");
                            System.out.println("2= alienacion y balanceo de ruedas");
                            System.out.println("3= rotacion de neumaticos");
                            System.out.println("4= revision de niveles"); // liquido refrigerante, direccion hidraulica, limpiaparabrisas
                            System.out.println("5= cambio de bujias ");
                            System.out.println("6= revision de sistema electrico");// bateria, alterador, cables
                            int opcionmantenimientopreventivo= sc.nextInt();
                            switch (opcionmantenimientopreventivo) {
                                case 0:
                                    System.out.println("al coche se le realiza elcambio de aceite y filtro");
                                    break;
                                case 1:
                                    System.out.println("al coche se realiza la revision y ajustes de frenos");
                                    break;
                                case 2:
                                    System.out.println("al coche se realiza la alienacion y balanceo de ruedas");
                                    break;
                                case 3:
                                    System.out.println("al coche se realiza la rotacion de neumaticos");
                                    break;
                                case 4:
                                    System.out.println("al coche se realiza la revision de niveles");
                                    break;
                                case 5:
                                    System.out.println("al coche se realiza el cambio de bujias");
                                    break;
                                case 6:
                                    System.out.println("al coche se realiza la revision de sistema electrico");
                                    break;
                            }
                            break;
                        case 1:
                            System.out.println("reparaciones mecanicas");
                            System.out.println("presionar del 0 al 5 para ingresar a cada opcion");
                            System.out.println("0 = sistema de frenos");//reparacon de bombas, calipers, cilindros)
                            System.out.println("1 = sistema de suspension y direccion");
                            System.out.println("2 = sistema de escape");
                            System.out.println("3 = sistema de refrigeracion ");
                            System.out.println("4 = motor ");
                            System.out.println("5 = caja de cambios");
                            int opcionreparacionmecanica= sc.nextInt();
                            switch (opcionreparacionmecanica) {
                                case 0:
                                    System.out.println("al coche se realiza la reparacion del sistema de frenos");
                                    break;
                                case 1:
                                    System.out.println("al coche se realiza la reparacion del sistema de suspension y direccion");
                                    break;
                                case 2:
                                    System.out.println("al coche se realiza la reparacion del sistema de escape");
                                    break;
                                case 3:
                                    System.out.println("al coche se realiza la reparacion del sistema de refrigeracion");
                                    break;
                                case 4:
                                    System.out.println("al coche se realiza la reparacion del motor");
                                    break;
                                case 5:
                                    System.out.println("al coche se realiza la reparacion de la caja de cambios");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            } 
                            break;
                        case 2:
                            System.out.println("servicios electricos y electronicos");
                            System.out.println("ingresar del 0 al 5 para ingresar a cada opcion");
                            System.out.println("0= reparacion del sistema de luces");
                            System.out.println("1= reparacion de altenador y motor de arranque");
                            System.out.println("2= revision y cambio de fusibles reles y sensores");
                            System.out.println("3= reparacion de sistemas de iluminacion");
                            System.out.println("4= electricidad del tablero"); 
                            System.out.println("5= reparacion de sistema de climatizacion");
                            int opcionservicioelectrico= sc.nextInt();
                            switch (opcionservicioelectrico) {
                                case 0:
                                    System.out.println("al coche se realiza la reparacion del sistema de luces");
                                    break;
                                case 1:
                                    System.out.println("al coche se realiza la reparacion de altenador y motor de arranque");
                                    break;
                                case 2:
                                    System.out.println("al coche se realiza la revision y cambio de fusibles reles y sensores");
                                    break;
                                case 3:
                                    System.out.println("al coche se realiza la reparacion de sistemas de iluminacion");
                                    break;
                                case 4:
                                    System.out.println("al coche se realiza la electricidad del tablero");
                                    break;
                                case 5:
                                    System.out.println("al coche se realiza la reparacion de sistema de climatizacion");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }

                            break;
                        case 3:
                            System.out.println("servicios de carroceria y pintura");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = reparacion de abolladuras y rayones");
                            System.out.println("1 = retoque de pintura ");
                            System.out.println("2 = cambio de parachoques, espejos y vidrios");
                            System.out.println("3 = reparacion de chasis(enderezar)");
                            int opcioncarroceria= sc.nextInt();
                            switch (opcioncarroceria){
                                case 0:
                                    System.out.println("al coche se le realiza la reparacion de abolladuras y rayones");
                                    break;
                                case 1:
                                    System.out.println("al coche se le realiza el retoque de pintura");
                                    break;
                                case 2:
                                    System.out.println("al coche se le realiza el cambio de parachoques, espejos y vidrios");
                                    break;
                                case 3:
                                    System.out.println("al coche se le realiza la reparacion de chasis(enderezar)");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("servicios de neumaticos ");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = cambio y reparacion de neumaticos");
                            System.out.println("1 = venta e instalacion de neumaticos nuevos");
                            System.out.println("2 = montaje y desmontaje de llantas");
                            System.out.println("3 = presion y nitrogeno de neumaticos");
                            int opcionneumaticos= sc.nextInt();
                            switch (opcionneumaticos){
                                case 0:
                                    System.out.println("al coche se le realiza el cambio o reparacion de neumaticos");
                                    break;
                                case 1:
                                    System.out.println("al coche se le realiza la venta e instalacion de neumaticos nuevos");
                                    break;
                                case 2:
                                    System.out.println("al coche se le realiza el montaje y desmontaje de llantas");
                                    break;
                                case 3:
                                    System.out.println("al coche se le realiza la presion y nitrogeno de neumaticos");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;

                            }
                            break;
                        case 5:
                            System.out.println("servicios de diagnostico y asesoria");
                            System.out.println("ingresar del 0 al 3 para ingresar cada opcion");
                            System.out.println("0 = pruebas de compresion, fugas y emisiones contaminantes");
                            System.out.println("1 = prueba de bateria y sistema de carga");
                            System.out.println("2 = inspeccion previa a la compra de un vehiculo usado");
                            System.out.println("3 = revision tecnica vehicular ");
                            int opciondiagnostico= sc.nextInt();
                            switch (opciondiagnostico){
                                case 0:
                                    System.out.println("al coche se le realiza pruebas de compresion, fugas y emisiones contaminantes");
                                    break;
                                case 1:
                                    System.out.println("al coche se le realiza la prueba de bateria y sistema de carga");
                                    break;
                                case 2:
                                    System.out.println("al coche se le realiza la inspeccion previa a la compra de un vehiculo usado");
                                    break;
                                case 3:
                                    System.out.println("al coche se le realiza la revision tecnica vehicular ");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 6:
                            System.out.println("servicios especializados");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println(" 0 = motores diesel"); // inyectores, bombas inyectora, turbo
                            System.out.println("1 = gas natural vehiculo (GNV");//Revision de tuberias, regulador, cilindro
                            System.out.println("2 = vehiculos hibridos y electricos");// bateria de alto voltaje, inversiones
                            System.out.println("3 = aire acondicionado"); // recarga de gas, deteccion de fuga
                            int opcionservicioespecializado= sc.nextInt();
                            switch(opcionservicioespecializado){
                                case 0:
                                    System.out.println("al coche se le realiza la reparacion de motor diesel ");
                                    break;
                                case 1:
                                    System.out.println("al coche se le realiza la revision de gas natural vehiculo (GNV)");
                                    break;
                                case 2:
                                    System.out.println("al coche se le realiza la reparacion de vehiculos hibridos y electricos");
                                    break;
                                case 3:
                                    System.out.println("al coche se le realiza la recarga de gas y deteccion de fuga en el aire acondicionado");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 7:
                            System.out.println("servicios adicionales");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = lavado y detallado de vehiculo");
                            System.out.println("1 = cera y protectores de parabrisas");
                            System.out.println("2 = limpieza de tapiceria");
                            System.out.println("3 = instalacion de accesorios");
                            int opcionsserviciosadicionales = sc.nextInt();
                            switch (opcionsserviciosadicionales) {
                                case 0:
                                    System.out.println("al coche se le realiza el lavado y detallado");
                                    break;
                                case 1:
                                    System.out.println("al coche se le aplica cera y protectores de parabrisas");
                                    break;
                                case 2:
                                    System.out.println("al coche se le realiza la limpieza de tapiceria");
                                    break;
                                case 3:
                                    System.out.println("al coche se le realiza la instalacion de accesorios");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("opcion no valida");
                            break;
                    }
                    break;
                case 1:
                    System.out.println("precio de cada servicio");
                    System.out.println("tipo de servicio");
                    System.out.println("presionar del 0 al 7 para ingresar a cada opcion");
                    System.out.println("0 = mantenimiento preventivo");
                    System.out.println("1 = reparaciones mecanicas");
                    System.out.println("2=servicios electricos y electronicos");
                    System.out.println("3= servicios de carroceria y pintura");
                    System.out.println("4= servicios de neumaticos ");
                    System.out.println("5= servicios de diagnostico y asesoria");
                    System.out.println("6= servicios especializados");
                    System.out.println("7= servicios adicionales");
                    int opcionservicioPrecio = sc.nextInt();
                    switch (opcionservicioPrecio) {
                        case 0:
                            System.out.println("mantenimiento preventivo");
                            System.out.println("presionar del 0 al 6 para ingresar a cada opcion");
                            System.out.println("0= cambio de aceite y fitro ");
                            System.out.println("1= revision y ajustes de frenos");
                            System.out.println("2= alienacion y balanceo de ruedas");
                            System.out.println("3= rotacion de neumaticos");
                            System.out.println("4= revision de niveles"); // liquido refrigerante, direccion hidraulica, limpiaparabrisas
                            System.out.println("5= cambio de bujias ");
                            System.out.println("6= revision de sistema electrico");// bateria, alterador, cables
                            int montopagarservicios= sc.nextInt();
                            switch (montopagarservicios) {
                                case 0: 
                                    System.out.println("el precio del cambio de aceite y filtro es de 145 soles");
                                    break;
                                case 1: 
                                    System.out.println("el precio de la revision y ajustes de frenos es de 50 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio de la alienacion y balanceo de ruedas es de 75 soles ");
                                    break;
                                case 3: 
                                    System.out.println("el precio de la rotacion de neumaticos es de 45 soles");          
                                    break;
                                case 4:
                                    System.out.println("el precio de la revision de niveles es de 40 soles");
                                    break;
                                case 5:
                                    System.out.println("el precio  de cambios de bujias es de 25 soles");
                                    break;
                                case 6: 
                                    System.out.println("el precio de la revision de sistema electrico es de 60 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 1:
                            System.out.println("reparaciones mecanicas");
                            System.out.println("presionar del 0 al 5 para ingresar a cada opcion");
                            System.out.println("0 = sistema de frenos");
                            System.out.println("1 = sistema de suspension y direccion");
                            System.out.println("2 = sistema de escape");
                            System.out.println("3 = sistema de refrigeracion ");
                            System.out.println("4 = motor ");
                            System.out.println("5 = caja de cambios");
                            int montopagarreparacion = sc.nextInt();
                            switch (montopagarreparacion) {
                                case 0:
                                    System.out.println("el precio de la reparacion del sistema de frenos es de 180 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio de la reparacion del sistema de suspension y direccion es de 220 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio de la reparacion del sistema de escape es de 160 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de la reparacion del sistema de refrigeracion es de 190 soles");
                                    break;
                                case 4:
                                    System.out.println("el precio de la reparacion del motor es de 450 soles");
                                    break;
                                case 5:
                                    System.out.println("el precio de la reparacion de la caja de cambios es de 500 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("servicios electricos y electronicos");
                            System.out.println("ingresar del 0 al 5 para ingresar a cada opcion");
                            System.out.println("0= reparacion del sistema de luces");
                            System.out.println("1= reparacion de altenador y motor de arranque");
                            System.out.println("2= revision y cambio de fusibles reles y sensores");
                            System.out.println("3= reparacion de sistemas de iluminacion");
                            System.out.println("4= electricidad del tablero");
                            System.out.println("5= reparacion de sistema de climatizacion");
                            int montopagarelectrico = sc.nextInt();
                            switch (montopagarelectrico) {
                                case 0:
                                    System.out.println("el precio de la reparacion del sistema de luces es de 90 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio de la reparacion de alternador y motor de arranque es de 250 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio de la revision y cambio de fusibles, reles y sensores es de 80 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de la reparacion de sistemas de iluminacion es de 120 soles");
                                    break;
                                case 4:
                                    System.out.println("el precio de la electricidad del tablero es de 150 soles");
                                    break;
                                case 5:
                                    System.out.println("el precio de la reparacion de sistema de climatizacion es de 210 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("servicios de carroceria y pintura");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = reparacion de abolladuras y rayones");
                            System.out.println("1 = retoque de pintura ");
                            System.out.println("2 = cambio de parachoques, espejos y vidrios");
                            System.out.println("3 = reparacion de chasis(enderezar)");
                            int montopagarcarroceria = sc.nextInt();
                            switch (montopagarcarroceria) {
                                case 0:
                                    System.out.println("el precio de la reparacion de abolladuras y rayones es de 170 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio del retoque de pintura es de 130 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio del cambio de parachoques, espejos y vidrios es de 300 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de la reparacion de chasis es de 600 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("servicios de neumaticos ");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = cambio y reparacion de neumaticos");
                            System.out.println("1 = venta e instalacion de neumaticos nuevos");
                            System.out.println("2 = montaje y desmontaje de llantas");
                            System.out.println("3 = presion y nitrogeno de neumaticos");
                            int montopagarneumaticos = sc.nextInt();
                            switch (montopagarneumaticos) {
                                case 0:
                                    System.out.println("el precio del cambio y reparacion de neumaticos es de 70 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio de la venta e instalacion de neumaticos nuevos es de 280 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio del montaje y desmontaje de llantas es de 60 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de presion y nitrogeno de neumaticos es de 25 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("servicios de diagnostico y asesoria");
                            System.out.println("ingresar del 0 al 3 para ingresar cada opcion");
                            System.out.println("0 = pruebas de compresion, fugas y emisiones contaminantes");
                            System.out.println("1 = prueba de bateria y sistema de carga");
                            System.out.println("2 = inspeccion previa a la compra de un vehiculo usado");
                            System.out.println("3 = revision tecnica vehicular ");
                            int montopagardiagnostico = sc.nextInt();
                            switch (montopagardiagnostico) {
                                case 0:
                                    System.out.println("el precio de pruebas de compresion, fugas y emisiones contaminantes es de 140 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio de la prueba de bateria y sistema de carga es de 50 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio de la inspeccion previa a la compra de un vehiculo usado es de 180 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de la revision tecnica vehicular es de 120 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 6:
                            System.out.println("servicios especializados");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = motores diesel");
                            System.out.println("1 = gas natural vehiculo (GNV)");
                            System.out.println("2 = vehiculos hibridos y electricos");
                            System.out.println("3 = aire acondicionado");
                            int montopagarespecializado = sc.nextInt();
                            switch (montopagarespecializado) {
                                case 0:
                                    System.out.println("el precio de la reparacion de motores diesel es de 550 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio de la revision de gas natural vehiculo (GNV) es de 200 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio de la reparacion de vehiculos hibridos y electricos es de 650 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de aire acondicionado es de 170 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        case 7:
                            System.out.println("servicios adicionales");
                            System.out.println("ingresar del 0 al 3 para ingresar a cada opcion");
                            System.out.println("0 = lavado y detallado de vehiculo");
                            System.out.println("1 = cera y protectores de parabrisas");
                            System.out.println("2 = limpieza de tapiceria");
                            System.out.println("3 = instalacion de accesorios");
                            int montopagaradicionales = sc.nextInt();
                            switch (montopagaradicionales) {
                                case 0:
                                    System.out.println("el precio del lavado y detallado de vehiculo es de 80 soles");
                                    break;
                                case 1:
                                    System.out.println("el precio de cera y protectores de parabrisas es de 45 soles");
                                    break;
                                case 2:
                                    System.out.println("el precio de la limpieza de tapiceria es de 100 soles");
                                    break;
                                case 3:
                                    System.out.println("el precio de la instalacion de accesorios es de 90 soles");
                                    break;
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("opcion no valida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("marcas de vehiculo");
                    System.out.println("ingresar del 0 a 6 para escoger una opcion ");
                    System.out.println("0 = toyota");
                    System.out.println("1 = volswagen");
                    System.out.println("2 = chevrolet");
                    System.out.println("3 = honda");
                    System.out.println("4 =  yamaha");
                    System.out.println("5 = bajaj");
                    System.out.println("6 = otros");
                    int opcionmarca= sc.nextInt();
                    switch(opcionmarca){
                        case 0:
                            System.out.println("el coche pertence a la marca toyota");
                            break;
                        case 1:
                            System.out.println("el coche pertenece a volswagen");
                            break;
                        case 2:
                            System.out.println("el coche pertenece a chevrolet");
                            break;
                        case 3:
                            System.out.println("la moto pertenece honda");    
                            break;
                        case 4:
                            System.out.println("la moto pertenece a yamaha");
                            break;
                        case 5:
                            System.out.println("la moto pertenece a bajaj");
                            break;
                        case 6:
                            System.out.println("agregar la marca del vehiculo");
                            String marcavehiculo = sc.nextLine();
                            System.out.println("la marca del vehiculo es : " +marcavehiculo );
                    }
                    break;
                    default:
                        System.out.println("es una opcion invalida");
                case 3:
                    System.out.println("Datos del taller");
                    System.out.println("-------CAR CENTER TARAPOTO-----");
                    String ubicacion=" Jr. libertad 238, tarapoto ";
                    String descripcion="Taller de coches con rápida solución de problemas y acceso a repuestos.";
                    System.out.println("ubicacion: " +ubicacion);
                    System.out.println("descripcion: "+descripcion);
                    break;
                case 4:
                    System.out.println("Impuestos");
                    System.out.println("=== CONFIGURACION DE IMPUESTOS ===");
                    System.out.println("0 = Ver tasa de IGV actual");
                    System.out.println("1 = Activar/Desactivar IGV en facturacion");
                    System.out.println("2 = Configurar detraccion (10% para montos > S/ 700)");
                    int impuestoOpt = sc.nextInt();
    
    switch (impuestoOpt) {
        case 0:
            double igv=18;
            System.out.println("Tasa IGV actual: " + igv + "%");
            break;
        case 1:
            boolean igvs =true;
            if(igvs == true){
                System.out.println("se aciva el igv");
            }else{
                System.out.println("no se activa el igv");
            }
        case 2:
            System.out.println("escribir el monto");
            double monto= sc.nextDouble();
            if(monto>700){
                double descuento= monto*0.1;
                double total= monto - descuento;
                System.out.println("el monto a pagar es = "+total);
            }    
    }
    break;
                    
                }
          break;
        case 2:
            System.out.println("transacciones");      
            System.out.println("presionar del 0 al 6 para ingresar a cada opcion");     
            System.out.println("0 = registrar vehiculo");
            System.out.println("1 = Registrar salida de vehiculo");
            System.out.println("2 = Registrar pago ");
            System.out.println("3 = Generar factura o boleta");
            System.out.println("4 = Registrar observarciones del cliente");
            System.out.println("5 = Enlistar vehiculos");
            int opcionestransacciones = sc.nextInt();
            switch (opcionestransacciones) {
                case 0:
                    System.out.println("registrar vehiculo");
                    sc.nextLine();
                    System.out.println("ingresar la placa del vehiculo");
                    placa= sc.nextLine();
                    System.out.println("ingresar el modelo del vehiculo");
                    modelo= sc.nextLine();
                    System.out.println("ingresar el anio del vehiculo");
                    anio=sc.nextInt();
                    System.out.println("escribir la cilindrada del vehiculo");
                    cilindrada= sc.nextDouble();
                    listaVehiculo.add(new Vehiculo(placa,modelo,anio,cilindrada));
                    for(int j=0 ; j< listaVehiculo.size() ; j++){
                     listaVehiculo.get(j).mostrarVehiculo();

                    }
                    break;
                case 1:
                    System.out.println("Registrar salida de vehiculo");
                    int dia;
                    String mes;
                    int anioSalida;
                    int hora;
                    int minutos;
                    System.out.println("ingresar el dia, mes y anio ");
                    dia= sc.nextInt();
                    sc.nextLine();
                    mes= sc.nextLine();
                    anioSalida= sc.nextInt();
                    System.out.println("ingresar la hora y minuto que sale el vehiculo del taller");
                    hora= sc.nextInt();
                    minutos= sc.nextInt();
                    System.out.println("el vehiculo sale del taller la fecha " +dia+ "/" +mes+ "/" +anioSalida);
                    System.out.println("y la hora de salida es de : "+hora+ ": "+minutos);
                    break;
                case 2:
                    System.out.println("Registrar pago ");
                    System.out.println("ingresar el monto de pago ");
                    double montopagar=sc.nextDouble();
                    System.out.println("ingresar del 0 al 4 para escoger el metodo de pago");
                    System.out.println(" 0 = yape");
                    System.out.println("1 = plin");
                    System.out.println("2 = credito");
                    System.out.println("3 = debito");
                    System.out.println("4 = efectivo ");
                    int opcionpago= sc.nextInt();
                    switch (opcionpago) {
                        case 0:
                            System.out.println("se paga el total de : "+montopagar+ "con yape");
                            break;
                        case 1:
                            System.out.println("se paga el total de : "+montopagar+ "con plin" );   
                            break;
                        case 2:
                            System.out.println("se paga el total de : "+montopagar+ "con credito");
                            break;
                        case 3:
                            System.out.println("se paga el total de : "+montopagar +"con debito");       
                            break;
                        case 4:
                            System.out.println("se paga el total de : "+montopagar+ "con efectivo");    
                            default:
                            System.out.println("no se escogio el metodo de pago");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Generar factura o boleta");
                    System.out.println("escoger entre 0 = factura o 1 boleta para generar ");
                    int opciongenerar= sc.nextInt();
                    switch (opciongenerar) {
                        case 0:
                            System.out.println("-----------factura---------");
                            System.out.println("----CAR CENTER TARAPOTO----");
                            System.out.println("-Jr. libertad 238, tarapoto-");
                            System.out.println("d/m/a= 13/05/26"             );
                            System.out.println("============================");
                            System.out.println("=============================");
                            break;
                        case 1:
                            System.out.println("----------boleta-----------");
                    
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Registrar observarciones del cliente");
                    String observacion= sc.nextLine();
                    System.out.println("observacion:"+observacion);
                    break;
                case 5:
                    System.out.println("en listar vehiculo");
                    if(listaVehiculo.isEmpty()) {
                        System.out.println("no hay vehiculos registrados");
                    } else {
                        for(int i=0 ; i<listaVehiculo.size(); i++) {
                            System.out.println("vehiculo " +(i+1));
                            listaVehiculo.get(i).mostrarVehiculo();
                        }
                    }
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
            break;
                case 3:
                    System.out.println("consultas");
                    System.out.println("presionar del 0 al 4 para ingresar a cada opcion");
                    System.out.println("0 = buscar vehiculo por placa");
                    System.out.println("1 = ver vehiculos en espera");
                    System.out.println("2 = ver historial de reparaciones de un vehiculo");
                    System.out.println("3 = ver mecanicos disponibles");
                    System.out.println("4 = consultar servicios mas solicitados");
                    int opcionconsultas = sc.nextInt();

                switch (opcionconsultas) {
                    case 0:
                    System.out.println("buscar vehiculo por placa");
                        if(listaVehiculo.isEmpty()) {
                        System.out.println("no hay vehiculos registrados");
                        } else {
                        sc.nextLine();
                        System.out.println("ingresar la placa del vehiculo");
                        String placaBuscar = sc.nextLine();
                        boolean encontrado = false;

                        for(int i = 0; i < listaVehiculo.size(); i++) {
                        if(listaVehiculo.get(i).placa.equalsIgnoreCase(placaBuscar)) {
                        System.out.println("vehiculo encontrado:");
                        listaVehiculo.get(i).mostrarVehiculo();
                        encontrado = true;
                            }
                        }

                        if(encontrado == false) {
                        System.out.println("no se encontro un vehiculo con esa placa");
                            }
                        }
                        break;

                        case 1:
                        System.out.println("ver vehiculos en espera");

                        if(listaVehiculo.isEmpty()) {
                        System.out.println("no hay vehiculos en espera");
                        } else {
                        for(int i = 0; i < listaVehiculo.size(); i++) {
                        System.out.println("vehiculo " + (i + 1));
                        listaVehiculo.get(i).mostrarVehiculo();
                            }
                        }
                        break;

                        case 2:
                        System.out.println("ver historial de reparaciones de un vehiculo");
                        System.out.println("por ahora no hay historial registrado");
                        break;

                        case 3:
                        System.out.println("ver mecanicos disponibles");
                        System.out.println("mecanico 1: Carlos");
                        System.out.println("mecanico 2: Luis");
                        System.out.println("mecanico 3: Pedro");
                        break;

                        case 4:
                        System.out.println("consultar servicios mas solicitados");
                        System.out.println("1. cambio de aceite y filtro");
                        System.out.println("2. revision de frenos");
                        System.out.println("3. alineacion y balanceo");
                        break;

                        default:
                        System.out.println("opcion no valida");
                        break;
                        }
                        break;
                        case 4:
                        System.out.println("reportes");
                        System.out.println("ingresar del 0 al 4 para ingresar a cualquier opcion");
                        System.out.println("0 = reporte de ingresos del dia");
                        System.out.println("1 = reporte de vehiculos atendidos por semana");
                        System.out.println("2 = lista de vehiculos pendientes");
                        System.out.println("3 = reporte de mecanicos mas productivos");
                        System.out.println("4 = exportar a PDF");
                        int opcionreportes= sc.nextInt();
                        switch (opcionreportes) {
                        case 0:
                        System.out.println("reportes del dia-ingresos");
                        break;
                        case 1:
                        System.out.println("reporte de vehiculos atendidos por semana");
                        break;
                        case 2:
                        System.out.println("lista de vehiculos pendientes");
                        break;
                        case 3:
                        System.out.println("reporte de mecanicos mas productivos");
                        break;
                        case 4:
                        System.out.println("exportar a PDF");
                        break;
                        default:
                        System.out.println("opcion no valida");
                        break;
                         }
                         break;
                        case 5:
                        System.out.println("salir");    
                       } 
    } while(opcion != 5);
}
public static void main(String[] args){
    menu menu1= new menu();
    menu1.menus();
}

}
