import java.util.Scanner;
public class login {
     Scanner sc = new Scanner(System.in);
    String Usuario;
    String Contraseña;

    
    public void guardarUsuario(){
        System.out.println("Ingresar Usuario");
        Usuario=sc.nextLine();
        System.out.println("Ingresar Contraseña");
        Contraseña=sc.nextLine();
    }
     
    public void compararusuario(){
        String USUARIO;
        String CONTRASEÑA;
        System.out.println("Ingresar usuario");
        USUARIO=sc.nextLine();
        System.out.println("Ingresar Contraseña");
        CONTRASEÑA=sc.nextLine();
        if(Usuario.equals(USUARIO) && Contraseña.equals(CONTRASEÑA)){
            System.out.println("Bienvenido"); 
        }else{
            System.out.println("Usuario o contraseña incorrecta");
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

