import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcion;
        String ADMIN_USUARIO = "admin";
        String ADMIN_CONTRASEÑA = "adminpass";
        String GESTOR_USUARIO = "gestor";
        String GESTOR_CONTRASEÑA = "gestorpass";
        String INVERSOR1_USUARIO = "inversor1";
        String INVERSOR1_CONTRASEÑA = "inversor1pass";
        String INVERSOR2_USUARIO = "inversor2";
        String INVERSOR2_CONTRASEÑA = "inversor2pass";
        String usuario = "";
        String contraseña = "";
        int contadorFallosGestor = 0;
        int contadorFallosInversor1 = 0;
        int contadorFallosInversor2 = 0;
        int contadorTotal = 0;
        boolean bloquearGestor = false;
        boolean bloquearInversor1 = false;
        boolean bloquearInversor2 = false;
        boolean admin = false;
        boolean gestor = false;
        boolean inversor1 = false;
        boolean inversor2= false;

        do {
            System.out.println("""
                    Seleccione una opción:\s
                    1.- Iniciar sesión.
                    2.- Salir.""");
            opcion=Integer.parseInt(s.nextLine());
            switch (opcion){
                case 1:
                    do {
                        if (contadorTotal>2) contadorTotal=0;
                        gestor = admin = inversor1 = inversor2 = false;
                        System.out.print("Usuario: ");
                        usuario = s.nextLine();
                        System.out.print("Contraseña: ");
                        contraseña = s.nextLine();
                        contadorTotal++;
                        // VALIDACIÓN DE GESTOR
                        if (usuario.equals(GESTOR_USUARIO) && contraseña.equals(GESTOR_CONTRASEÑA) && !bloquearGestor){
                            System.out.println("Bienvenido " + GESTOR_USUARIO);
                            gestor = true;
                            contadorFallosGestor = 0;
                        } else if (usuario.equals(GESTOR_USUARIO) && !(contadorFallosGestor > 2)) {
                            System.out.println("Vuelva a intentarlo");
                            contadorFallosGestor++;
                        }
                        if (usuario.equals(GESTOR_USUARIO) && contadorFallosGestor>2){
                            System.out.println("Usuario " + GESTOR_USUARIO + " bloqueado.");
                            bloquearGestor = true;
                        }
                        // VALIDACIÓN DE INVERSOR1
                        if (usuario.equals(INVERSOR1_USUARIO) && contraseña.equals(INVERSOR1_CONTRASEÑA) && !bloquearInversor1){
                            System.out.println("Bienvenido " + INVERSOR1_USUARIO);
                            contadorFallosInversor1 = 0;
                            inversor1 = true;
                        }else if (usuario.equals(INVERSOR1_USUARIO) && !(contadorFallosInversor1>2)){
                            System.out.println("Vuelva a intentarlo");
                            contadorFallosInversor1++;
                        }
                        if (usuario.equals(INVERSOR1_USUARIO) && contadorFallosInversor1>2) {
                            System.out.println("Usuario " + INVERSOR1_USUARIO + " bloqueado.");
                            bloquearInversor1 = true;
                        }
                        // VALIDACIÓN DE INVERSOR2
                        if (usuario.equals(INVERSOR2_USUARIO) && contraseña.equals(INVERSOR2_CONTRASEÑA) && !bloquearInversor2){
                            inversor2 = true;
                            contadorFallosInversor2 =0;
                            System.out.println("Bienvenido " + INVERSOR2_USUARIO);
                        }else if (usuario.equals(INVERSOR2_USUARIO) && !(contadorFallosInversor2>2)){
                            System.out.println("Vuelva a intentarlo");
                            contadorFallosInversor2++;
                        }
                        if (usuario.equals(INVERSOR2_USUARIO) && contadorFallosInversor2>2){
                            System.out.println("Usuario " + INVERSOR2_USUARIO + " bloqueado.");
                            bloquearInversor2 = true;
                        }
                        // VALIDACIÓN DE ADMIN
                        if (usuario.equals(ADMIN_USUARIO) && contraseña.equals(ADMIN_CONTRASEÑA)){
                            System.out.println("Bienvenido " + ADMIN_USUARIO);
                            admin = true;
                        }else if (usuario.equals(ADMIN_USUARIO)){
                            System.out.println("Vuelva a intentarlo");
                        }
                    }while (!gestor && !inversor1 && !inversor2 && !admin && !(contadorTotal == 3));

                    if (admin){
                        System.out.println("admin");
                    } else if (gestor && !bloquearGestor) {
                        System.out.println("gestor");
                    } else if (inversor1 && !bloquearInversor1) {
                        System.out.println("inversor1");
                    } else if (inversor2 && !bloquearInversor2){
                        System.out.println("inversor2");
                    }
                case 2: // se pone case 2 para que no salga el mensaje de default al pulsar 2
                    break;
                default:
                    System.out.println("Vuelve a intentarlo");
            }
        }while(opcion!=2);
    }
}