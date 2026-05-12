import java.util.ArrayList;
import java.util.Scanner;
public class menu {
Scanner sc = new Scanner(System.in);
ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
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
                            break;
                        case 5:
                            System.out.println("servicios de diagnostico y asesoria");
                            break;
                        case 6:
                            System.out.println("servicios especializados");
                            break;
                        case 7:
                            System.out.println("servicios adicionales");
                            break;
                        default:
                            System.out.println("opcion no valida");
                            break;
                    }
                    break;
                case 1:
                    System.out.println("precio de cada servicio");
                    break;
                case 2:
                    System.out.println("marcas de vehiculo");
                    break;
                case 3:
                    System.out.println("Datos del taller");
                    break;
                case 4:
                    System.out.println("Impuestos");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
          break;
        case 2:
            System.out.println("transacciones");      
            System.out.println("presionar del 0 al 5 para ingresar a cada opcion");     
            System.out.println("0 = registrar vehiculo");
            System.out.println("1 = Asignar mecanico al vehiculo");
            System.out.println("2 = Registrar salida de vehiculo");
            System.out.println("3 = Registrar pago ");
            System.out.println("4 = Generar factura o boleta");
            System.out.println("5 = Registrar observarciones del cliente");
            int opcionestransacciones = sc.nextInt();
            switch (opcionestransacciones) {
                case 0:
                    System.out.println("registrar vehiculo");
                    break;
                case 1:
                    System.out.println("Asignar mecanico al vehiculo");
                    break;
                case 2:
                    System.out.println("Registrar salida de vehiculo");
                    break;
                case 3:
                    System.out.println("Registrar pago ");
                    break;
                case 4:
                    System.out.println("Generar factura o boleta");
                    break;
                case 5:
                    System.out.println("Registrar observarciones del cliente");
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
                System.out.println("2 = ver historial de reparaciones de un vehiculo ");
                System.out.println("3 = ver mecanicos disponibles ");
                System.out.println("4 = consultar servicios mas solicitados");
                int opcionconsultas = sc.nextInt();
                switch (opcionconsultas) {
                    case 0 :
                        System.out.println("buscar vehiculo por placa");
                        break;
                    case 1:
                        System.out.println("ver vehiculos en espera");
                        break;
                    case 2:
                        System.out.println("ver historial de reparaciones de un vehiculo ");
                        break;
                    case 3:
                        System.out.println("ver mecanicos disponibles ");
                        break;
                    case 4:
                        System.out.println("consultar servicios mas solicitados");
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
