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
        String usuario;
        String contraseña;
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
        double carteraInversor1=0;
        double carteraInversor2=0;
        double dineroAnadido=0;

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

                        do {
                            System.out.println("\n Menu Administrador ");
                            System.out.println("1.Panel de control");
                            System.out.println("2.Proyectos");
                            System.out.println("3.Configuracion");
                            System.out.println("4.Cerrar sesion");
                            opcion = s.nextInt();
                            switch (opcion) {
                                case 1: {
                                    System.out.println("Has ingresado a: Panel de Control");
                                    System.out.println("Opciones de bloquear/desbloquear al usuario");
                                    do {
                                        System.out.println("1. Bloquear/Desbloquear");
                                        System.out.println("2. Volver al menu Administrador");
                                        opcion = s.nextInt();
                                        switch (opcion){
                                            case 1 :
                                                System.out.println("Bloquear Usuario");
                                                if (opcion == 1) {
                                                    nombreUsuario = s.nextLine();
                                                    if (nombreUsuario.equals("Bloqueado")) {
                                                        bloqueado = true;
                                                        System.out.println("El usuario ha sido bloqueado");
                                                    }
                                                    System.out.println("Desbloquear Usuario");
                                                }else if (opcion == 2){
                                                    nombreUsuario = s.nextLine();
                                                    if (nombreUsuario.equals("Desbloqueado")){
                                                        bloqueado = false;
                                                        System.out.println("El usuario esta activo");
                                                    }
                                                    break;
                                                }
                                            case 2:
                                                System.out.println("Volver al menu Administrador ");
                                                break;
                                            default:
                                                System.out.println("Esta opcion no existe");
                                        }
                                    }while (opcion != 2);
                                }
                                break;
                                case 2: {
                                    System.out.println("Has ingresado a: Proyectos");
                                    do {
                                        System.out.println("1. Listado de Proyectos");
                                        System.out.println("2. Categoria del Proyecto");
                                        System.out.println("3. Cantidad necesaria y Cantidad Financiada");
                                        System.out.println("4. Mostrar Proyecto");
                                        System.out.println("5. Vuelta al menu Administrador");
                                        opcion = s.nextInt();
                                        switch (opcion){
                                            case 1 :
                                                System.out.println("Este es el listado de todos los proyectos del gestor");
                                                nombreProyectoGestor = s.nextLine();
                                                System.out.println(nombreProyectoGestor);
                                                break;
                                            case 2 :
                                                System.out.println("Escriba la categoria de su Proyecto, Ejemplo (arte, tecnología, cine, música, juegos, comida, moda… )");
                                                categoria = s.nextLine();
                                                System.out.println("Categoria:" + categoria);
                                                break;
                                            case 3 :
                                                System.out.println("Introduzca la cantidad necesaria par el proyecto: "  + cantidadNecesaria);
                                                cantidadNecesaria = s.nextFloat();
                                                System.out.println("Introduzca la cantidad Financiada" + cantidadFinanciada);
                                                cantidadFinanciada = s.nextFloat();
                                                break;
                                            case 4 :
                                                System.out.println("Este es su proyecto");
                                                System.out.println("En este apartado le aparecera todo su proyeto y la informacion de el");
                                                System.out.println("Ademas de las opciones de poder cambiar sus datos o eleminarlo");
                                                proyecto = s.nextInt();
                                                System.out.println(proyecto);
                                                break;
                                            case 5:
                                                System.out.println("Vuelta al mennu Administrador ");
                                                break;
                                            default:
                                                System.out.println("Esta opcion no existe o no se ha encontrado el proyecto");
                                        }
                                    } while (opcion != 5);
                                }
                                break;
                                case 3: {
                                    System.out.println("Has ingresado a: Configuración");
                                    do {
                                        System.out.println("1. Cambio de Usuario");
                                        System.out.println("2. Cambio de Contraseña");
                                        System.out.println("3. Vuelta al menu Administrador");
                                        opcion = s.nextInt();
                                        switch (opcion) {
                                            case 1:
                                                do {
                                                    System.out.println("Introduzca su antiguo usuario");
                                                    usuario = s.nextLine();
                                                }while (usuario.equals(ADMIN_USUARIO));
                                                System.out.println("Introduzca su nuevo usario");
                                                ADMIN_USUARIO = s.nextLine();
                                                break;
                                            case 2:
                                                System.out.println("Introduzca su antigua contraseña");
                                                passwordAntiguo = s.nextLine();
                                                System.out.println("Introduzca su nueva contrasña");
                                                passwordNuevo = s.nextLine();
                                                passwordAntiguo = passwordNuevo;
                                                break;
                                            case 3:
                                                System.out.println("Vuelta al menu Administrador");
                                            default:
                                                System.out.println("No existe esta opcion");
                                        }
                                    }while (opcion != 3) ;
                                }
                                break;
                                case 4: {
                                    System.out.println("Cerrando sesión...");
                                    break;
                                }
                                default:
                                    System.out.println("Esa opcion no existe");
                            }
                        } while (opcion != 4);
                    } else if (gestor && !bloquearGestor) {
                        System.out.println("gestor");
                    } else if (inversor1 && !bloquearInversor1) {
                        do {
                            System.out.println("""
                                    MENU INVERSOR1\s
                                    1. Mis Inversiones.
                                    2. Proyectos.
                                    3. Cartera Digital.
                                    4. Invitar amigos.
                                    5. Configuración.
                                    6. Salir.""");
                            opcion = Integer.parseInt(s.nextLine());
                            switch (opcion){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    do {
                                        System.out.println("""                                            
                                                CARTERA DIGITAL
                                                1. Mostrar saldo actual.
                                                2. Añadir saldo.
                                                3. Salir.""");
                                        opcion = Integer.parseInt(s.nextLine());
                                        switch (opcion){
                                            case 1:
                                                System.out.println(carteraInversor1);
                                                break;
                                            case 2:
                                                do {
                                                    System.out.println("¿Cuánto dinero quieres añadir?");
                                                    dineroAnadido = Double.parseDouble(s.nextLine());
                                                    if (dineroAnadido<0) System.out.println("La cantidad añadida debe ser mayor a 0");
                                                    else carteraInversor1+=dineroAnadido;
                                                }while (dineroAnadido<=0);
                                                break;
                                            case 3:
                                                System.out.println("Saliendo");
                                                break;
                                        }
                                    }while (opcion!=3);
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    do {
                                        System.out.println("""
                                                CONFIGURACIÓN
                                                1. Cambiar usuario.
                                                2. Cambiar contraseña.
                                                3. Salir""");
                                        opcion = Integer.parseInt(s.nextLine());
                                        switch (opcion){
                                            case 1:
                                                System.out.print("Escribe la contraseña");
                                                contraseña = s.nextLine();
                                                if (contraseña.equals(INVERSOR1_CONTRASEÑA)){
                                                    System.out.print("Nuevo usuario: ");
                                                    INVERSOR1_USUARIO=s.nextLine();
                                                }
                                                else System.out.println("La contraseña es incorrecta");
                                                break;
                                            case 2:
                                                System.out.print("Escribe la contraseña:");
                                                contraseña = s.nextLine();
                                                if (contraseña.equals(INVERSOR1_CONTRASEÑA)){
                                                    System.out.print("Nueva contraseña: ");
                                                    INVERSOR1_CONTRASEÑA=s.nextLine();
                                                }
                                                else System.out.println("La contraseña es incorrecta");
                                                break;
                                            case 3:
                                                break;
                                        }
                                    }while (opcion!=3);
                                    break;
                                case 6:
                                    System.out.println("Saliendo");
                                    break;
                            }
                        }while (opcion!=6);
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