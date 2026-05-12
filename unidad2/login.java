import java.util.Scanner;
public class login {
     Scanner sc = new Scanner(System.in);
    String Usuario;
    String contrasena;

    
    public void guardarUsuario(){
        System.out.println("Ingresar Usuario");
        Usuario=sc.nextLine();
        System.out.println("Ingresar contrasena");
        contrasena=sc.nextLine();
    }
     
    public void compararusuario(){
        String USUARIO;
        String CONTRASENA;
        System.out.println("Ingresar usuario");
        USUARIO=sc.nextLine();
        System.out.println("Ingresar contrasena");
        CONTRASENA=sc.nextLine();
        if(Usuario.equals(USUARIO) && contrasena.equals(CONTRASENA)){
            System.out.println("Bienvenido"); 
        }else{
            System.out.println("Usuario o contrasena incorrecta");
        }
}
public static void main(String[] args) {
    login loginadmin= new login();
    login gerente= new login();
    System.out.println("-----ADMINISTRADOR-----");
    loginadmin.guardarUsuario();
    loginadmin.compararusuario();
    System.out.println("-----GERENTE-----");
    gerente.guardarUsuario();
    gerente.compararusuario();

}
}

