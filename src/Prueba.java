import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);


        String nombreUsuario;
        String contrasena;
        int vueltas = 0;
        int opciones;
        int intentos = 0;
        int proyecto = 0;
        String nombreProyectoGestor;
        float cantidadNecesaria = 0;
        float cantidadFinanciada = 0;
        String categoria;
        String bloquear;
        String desbloquear;
        String UserAntiguo;
        String UserNuevo;
        String passwordAntiguo;
        String passwordNuevo;
        int opcionesCambioUser = 0;
        int opcionesCambioContra = 0;
        int opcionesCambio = 0;
        int opcionesProyectos = 0;
        boolean bloqueado = true;


        do {
            System.out.println("\n Menu Administrador ");
            System.out.println("1.Panel de control");
            System.out.println("2.Proyectos");
            System.out.println("3.Configuracion");
            System.out.println("4.Cerrar sesion");
            opciones = s.nextInt();
            switch (opciones) {
                case 1: {
                    System.out.println("Has ingresado a: Panel de Control");
                    System.out.println("Opciones de bloquear/desbloquear al usuario");
                    do {
                        System.out.println("1. Bloquear/Desbloquear");
                        System.out.println("2. Volver al menu Administrador");
                        opciones = s.nextInt();
                        switch (opciones){
                            case 1 :
                                System.out.println("Bloquear Usuario");
                                if (opciones == 1) {
                                    nombreUsuario = s.nextLine();
                                    if (nombreUsuario.equals("Bloqueado")) {
                                        bloqueado = true;
                                        System.out.println("El usuario ha sido bloqueado");
                                    }
                                    System.out.println("Desbloquear Usuario");
                                }else if (opciones == 2){
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
                    }while (opciones != 2);
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
                        opcionesProyectos = s.nextInt();
                        switch (opcionesProyectos){
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
                    } while (opcionesProyectos != 5);
                }
                break;
                case 3: {
                    System.out.println("Has ingresado a: Configuración");
                    do {
                        System.out.println("1. Cambio de Usuario");
                        System.out.println("2. Cambio de Contraseña");
                        System.out.println("3. Vuelta al menu Administrador");
                        opcionesCambio = s.nextInt();
                        switch (opcionesCambio) {
                            case 1:
                                System.out.println("Introduzca su antiguo usuario");
                                UserAntiguo = s.nextLine();
                                System.out.println("Introduzca su nuevo usario");
                                UserNuevo = s.nextLine();
                                UserAntiguo = UserNuevo;
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
                    }while (opcionesCambio != 3) ;
                }
                break;
                case 4: {
                    System.out.println("Cerrando sesión...");
                    break;
                }
                default:
                    System.out.println("Esa opcion no existe");
            }
        } while (opciones != 4);
    }
}
