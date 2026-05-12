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
