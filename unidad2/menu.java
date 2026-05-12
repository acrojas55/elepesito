import java.util.Scanner;
public class menu {
Scanner sc = new Scanner(System.in);
public void menus(){
    int opcion;
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
            System.out.println("0 = crar usuario");
            System.out.println("1 = modificar usuario");
            System.out.println("2 = eliminar usuario");
            System.out.println("3 = listar usuarios");
            int opciones=sc.nextInt();

            switch (opciones) {
                case 0:
                    System.out.println("crear usuario");
                    break;
                case 1:
                    System.out.println("modificar usuario");
                    break;
                case 2:
                    System.out.println("eliminar usuario");
                    break;
                case 3:
                    System.out.println("listar usuarios");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }

         break;
        case 1:
            System.out.println("configuracion");
          break;
        case 2:
            System.out.println("transacciones");           
            break;
        case 3:
            System.out.println("consultas");  
            break;
        case 4:
            System.out.println("reportes");
            break;
        case 5:
            System.out.println("salir");    
        } 
}
public static void main(String[] args){
    menu menu1= new menu();
    menu1.menus();
}

}
