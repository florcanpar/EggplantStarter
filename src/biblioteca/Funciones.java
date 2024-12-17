package biblioteca;

import java.util.Scanner;

public class Funciones {

    public static void menuInicioSesion(){
        String morado= "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + """
                    ⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⠀⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⠀⢿⡄⠀⢀⣦⠀⠀⠀⠀⠀⠀⠀⠀BIENVENIDO⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠀⢰⣾⣷⣴⣾⣿⣴⣿⠏⠀⠀⠀⠀⠀⠀⠀ A⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠈⢻⣿⣿⣿⡿⠿⢿⡟⢿⣆⠀⠀⠀⠀ EGGPLANT⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠺⡿⠻⠟⠀⠀⠀⠀⠀⢻⡄⠀⠀⠀⠀⠀STARTER⠀⠀⠀⠀⠀⠀⠀⠀⠀
                    ⠀⠀⠰⡇⠀⠀⠀⠀⠀⠀⠀⠈⠻⣦⣄⣀⣀⣀⣠⣤⣤⣶⣦⣤⣄⡀⠀⠀⠀⠀
                    ⠀⠀⠀⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⢉⣽⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀
                    ⠀⠀⠀⠸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀
                    ⠀⠀⠀⠀⢻⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀
                    ⠀⠀⠀⠀⠀⠻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀
                    ⠀⠀⠀⠀⠀⠀⠙⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⡿⠛⣿⠇⠀
                    ⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⣠⣾⠋⠀⠀
                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠳⠶⣦⣤⣄⣀⣀⣀⣀⣤⣤⡶⠾⠋⠁⠀⠀⠀
                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀
                    
                    Seleccione una opción:\s
                    1.- Iniciar sesión.
                    2.- Salir.""" + colorNormal);
    }
    /**
     * Muestra el menú principal para el inversor.
     * @author: David Galán
     */
    public static void menuInversor() {
        String verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"╭ ─────┉─────"+ amarillo +" • "+ morado +"─────┉───── ╮");
        System.out.println(verde +"  ┈ ⋞ 〈 "+ azul +"MENÚ INVERSOR"+ verde +" 〉 ⋟ ┈");
        System.out.println(morado +"╰ ─────┉─────"+ amarillo +" • "+ morado +"─────┉───── ╯"+ colorNormal);
        System.out.println(verde + "1."+ colorNormal +"Mis Inversiones.");
        System.out.println(verde + "2."+ colorNormal +"Proyectos.");
        System.out.println(verde + "3."+ colorNormal +"Cartera digital.");
        System.out.println(verde + "4."+ colorNormal +"Invitar amigos.");
        System.out.println(verde + "5."+ colorNormal +"Configuración.");
        System.out.println(verde + "6."+ colorNormal +"Salir.");
    }
    /**
     * Muestra el menú para crear recompensas para un proyecto.
     * @author: David Galán
     */
    public static void menuCrearRecompensa() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + " ¿Qué recompensa quieres crear? " + morado + " |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde +"1." + colorNormal + "Recompensa 1.");
        System.out.println(verde +"2." + colorNormal + "Recompensa 2.");
        System.out.println(verde +"3." + colorNormal + "Recompensa 3.");
        System.out.println(verde +"4." + colorNormal + "Volver.");
    }
    /**
     * Muestra el menú de la cartera digital para el usuario.
     * @author: David Galán
     */
    public static void menuCarteraDigital() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "   Cartera Digital " + morado + "   |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Mostrar Saldo Actual.");
        System.out.println(verde + "2." + colorNormal + "Añadir saldo.");
        System.out.println(verde + "3." + colorNormal + "Salir.");
    }
    /**
     * Muestra el menú para invitar amigos y gestionar referidos.
     * @author: David Galán
     */
    public static void menuInvitarAmigos() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "    Invitar Amigo " + morado + "    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde+"1."+ colorNormal +"Mostrar lista de amigos referidos.");
        System.out.println(verde+"2."+ colorNormal +"Añadir un amigo.");
        System.out.println(verde+"3."+ colorNormal +"Salir.");
    }
    /**
     * Muestra el menú para iniciar la creación de proyectos.
     * @author: David Galán
     */
    public static void menuCrearProyectos(){
        String  verde = "\033[32m", colorNormal = "\u001B[0m";
        System.out.println("¿Qué proyecto quieres empezar?");
        System.out.println(verde+"1."+ colorNormal + "Primer proyecto.");
        System.out.println(verde+"2."+ colorNormal + "Segundo proyecto.");
        System.out.println(verde+"3."+ colorNormal + "Tercero proyecto.");
        System.out.println(verde+"4."+ colorNormal + "Salir.");
    }
    /**
     * Muestra el menú principal para el gestor de proyectos.
     * @author: David Galán
     */
    public static void mostrarMenuGestor() {
        String verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"╭ ────┉────"+ amarillo +" • "+ morado +"────┉──── ╮");
        System.out.println(verde +" ┈ ⋞ 〈 "+ azul +"MENÚ GESTOR"+ verde +" 〉 ⋟ ┈");
        System.out.println(morado +"╰ ────┉────"+ amarillo +" • "+ morado +"────┉──── ╯"+ colorNormal);
        System.out.println(verde +"1."+ colorNormal +" Mis proyectos.");
        System.out.println(verde +"2."+ colorNormal +" Configuración.");
        System.out.println(verde +"3."+ colorNormal +" Cerrar sesión.");
    }
    /**
     * Muestra el menú de gestión de proyectos para el gestor.
     * @author: David Galán
     */
    public static void mostrarMenuProyectosGestor() {
        String verde = "\033[32m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + verde + "    Proyectos" + morado + "     |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde +"1." + colorNormal + "Ver Proyectos.");
        System.out.println(verde +"2." + colorNormal + "Crear Proyectos.");
        System.out.println(verde +"3." + colorNormal + "Modificar Proyectos.");
        System.out.println(verde +"4." + colorNormal + "Eliminar Proyectos.");
        System.out.println(verde +"5." + colorNormal + "Volver al Menú Gestor.");
    }
    /**
     * Muestra el menú para eliminar proyectos existentes.
     * @author: David Galán
     */
    public static void menuEliminarProyectos() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "¿Qué proyecto quieres eliminar? " + morado + "|");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
        System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
        System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
        System.out.println(verde +"4." + colorNormal + "Volver.");
    }
    /**
     * Muestra el menú de configuración para cambiar usuario o contraseña.
     * @author: David Galán
     */
    public static void menuConfiguracionUsuarioContrasena() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "   Configuración" + morado + "    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde +"1."+ colorNormal +" Cambio de Usuario.");
        System.out.println(verde +"2."+ colorNormal +" Cambio de Contraseña.");
        System.out.println(verde +"3."+ colorNormal +" Salir.");
    }
    /**
     * Muestra el menú de gestión de proyectos para el administrador.
     * @author: David Galán
     */
    public static void menuProyectosAdmin() {
        String verde = "\033[32m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + verde + "    Proyectos" + morado + "     |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Ver Proyectos");
        System.out.println(verde + "2." + colorNormal + "Modificar Proyectos");
        System.out.println(verde + "3." + colorNormal + "Eliminar Proyectos");
        System.out.println(verde + "4." + colorNormal + "Volver al Menú Administrador");
    }
    /**
     * Muestra el menú para visualizar proyectos específicos.
     * @author: David Galán
     */
    public static void menuVerProyectos() {
        String verde = "\033[32m", morado = "\033[35m", amarillo = "\033[33m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "¿Qué proyecto quieres ver? " + morado + " |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Primer proyecto.");
        System.out.println(verde + "2." + colorNormal + "Segundo proyecto.");
        System.out.println(verde + "3." + colorNormal + "Tercer proyecto.");
        System.out.println(verde + "4." + colorNormal + "Volver.");
    }
    /**
     * Muestra el menú principal para el administrador.
     * @author: David Galán
     */
    public static void menuAdmin() {
        String verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m",
                morado = "\033[35m", cyan = "\033[36m", colorNormal = "\u001B[0m";
        System.out.println(morado + "╭ ──────┉──────" + amarillo + " • " + morado + "──────┉────── ╮");
        System.out.println(verde + "  ┈ ⋞ 〈 " + azul + "MENÚ ADMINISTRADOR" + verde + " 〉 ⋟ ┈");
        System.out.println(morado + "╰ ──────┉──────" + amarillo + " • " + morado + "──────┉────── ╯" + colorNormal);
        System.out.println(verde + "1." + cyan + "Panel de control");
        System.out.println(verde + "2." + cyan + "Proyectos");
        System.out.println(verde + "3." + cyan + "Configuración");
        System.out.println(verde + "4." + cyan + "Cerrar sesión" + colorNormal);
    }
    /**
     * Muestra el menú del panel de control para el administrador.
     * @author: David Galán
     */
    public static void menuPanelDeControl() {
        String verde = "\033[32m", azul = "\033[34m", rojo = "\033[31m",
                morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + verde + "      Has ingresado" + morado + "        |");
        System.out.println("| " + azul + "   al Panel de Control" + morado + "     |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println("Opciones de " + rojo + "bloquear" + azul + "/" + verde + "desbloquear" + colorNormal + " al usuario:");
    }
    /**
     * Valida si un usuario y contraseña corresponden al administrador.
     * @param usuario El nombre de usuario ingresado.
     * @param contrasena La contraseña ingresada.
     * @param ADMIN_USUARIO El nombre de usuario del administrador.
     * @param ADMIN_CONTRASENA La contraseña del administrador.
     * @param admin Estado actual del usuario como administrador.
     * @param verde Color verde para mensajes.
     * @param colorNormal Color normal para mensajes.
     * @param rojo Color rojo para mensajes de error.
     * @return Verdadero si las credenciales son correctas, falso en caso contrario.
     * @author: David Galán
     */
    public static boolean validarAdmin(String usuario, String contrasena, String ADMIN_USUARIO, String ADMIN_CONTRASENA, boolean admin, String verde, String colorNormal, String rojo) {
        if (usuario.equals(ADMIN_USUARIO)) {
            if (contrasena.equals(ADMIN_CONTRASENA)) {
                System.out.println(verde + "Bienvenido " + ADMIN_USUARIO + colorNormal);
                return true;
            } else {
                System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + " Vuelva a intentarlo.");
                return admin;
            }
        }
        return admin;
    }
    /**
     * Lee un entero desde la entrada estándar.
     * @return El entero leído.
     * @author: David Galán
     */
    public static int leerInt() {
        Scanner s = new Scanner(System.in);
        return Integer.parseInt(s.nextLine());
    }
    /**
     * Lee un número decimal desde la entrada estándar.
     * @return El número decimal leído.
     * @author: David Galán
     */
    public static double leerDouble() {
        Scanner s = new Scanner(System.in);
        return Double.parseDouble(s.nextLine());
    }
    /**
     * Lee una cadena de texto desde la entrada estándar.
     * @return La cadena de texto leída.
     * @author: David Galán
     */
    public static String leerString() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    /**
     * Muestra un listado de usuarios para gestionar su acceso desde el panel de control.
     * @param GESTOR_USUARIO Nombre del usuario gestor.
     * @param INVERSOR1_USUARIO Nombre del primer usuario inversor.
     * @param INVERSOR2_USUARIO Nombre del segundo usuario inversor.
     * @author: David Galán
     */
    public static void listadoPanelDeCotrol(String GESTOR_USUARIO, String INVERSOR1_USUARIO, String INVERSOR2_USUARIO) {
        String verde = "\033[32m", azul = "\033[34m", rojo = "\033[31m",
                morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + rojo + "   Bloquear" + azul + "/" + verde + "Desbloquear" + morado + "    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + " Usuario " + GESTOR_USUARIO);
        System.out.println(verde + "2." + colorNormal + " Usuario " + INVERSOR1_USUARIO);
        System.out.println(verde + "3." + colorNormal + " Usuario " + INVERSOR2_USUARIO);
        System.out.println(verde + "4." + colorNormal + " Volver al menu Administrador" + colorNormal);
    }
    /**
     * Pinta el gráfico de barras
     * @param cantidadNecesaria Cantidad necesaria para financiar el proyecto.
     * @param cantidadFinanciada Cantidad ya financiada.
     * @author: David Galán
     */
    public static void graficoBarras(double cantidadNecesaria, double cantidadFinanciada){
        String verde = "\033[32m", colorNormal = "\u001B[0m";
        int graficoBarras = (int) ((cantidadFinanciada * 100) / cantidadNecesaria);
        System.out.print("[");
        for (int x = 0; x < graficoBarras; x++) {
            System.out.print(verde + "▓" + colorNormal);
        }
        for (int y = 0; y < (100 - graficoBarras); y++) {
            System.out.print("░");
        }
        System.out.print("]" + graficoBarras + "%");
        System.out.println();
    }
    /**
     * Muestra los detalles completos de un proyecto.
     * @param nombreProyecto Nombre del proyecto.
     * @param descripcion Descripción del proyecto.
     * @param categoria Categoría del proyecto.
     * @param cantidadNecesaria Cantidad necesaria para financiar el proyecto.
     * @param cantidadFinanciada Cantidad ya financiada.
     * @param fechaInicio Fecha de inicio del proyecto.
     * @param fechaFinal Fecha de finalización del proyecto.
     * @param recompensa1 Primera recompensa ofrecida.
     * @param precioRecompensa1 Precio de la primera recompensa.
     * @param recompensa2 Segunda recompensa ofrecida.
     * @param precioRecompensa2 Precio de la segunda recompensa.
     * @param recompensa3 Tercera recompensa ofrecida.
     * @param precioRecompensa3 Precio de la tercera recompensa.
     * @author: David Galán
     */
    public static void mostrarProyecto(String nombreProyecto, String descripcion, String categoria, double cantidadNecesaria, double cantidadFinanciada, String fechaInicio, String fechaFinal, String recompensa1, int precioRecompensa1, String recompensa2, int precioRecompensa2, String recompensa3, int precioRecompensa3) {
        String  verde = "\033[32m", morado = "\033[35m",amarillo = "\033[33m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "  " + nombreProyecto + " " + morado + "  |");
        System.out.println("┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println("Nombre: " + nombreProyecto);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Categoría: " + categoria);
        System.out.println("Cantidad Necesaria: " + cantidadNecesaria);
        System.out.println("Cantidad Financiada: " + cantidadFinanciada);
        System.out.println("Fecha de inicio de Inversiones: " + fechaInicio);
        System.out.println("Fecha final de Inversiones: " + fechaFinal);

        System.out.println("Recompensas: ");
        System.out.println("Recompensa 1: " + recompensa1);
        System.out.println("Precio: " + precioRecompensa1 + "€");
        System.out.println("Recompensa 2: " + recompensa2);
        System.out.println("Precio: " + precioRecompensa2 + "€");
        System.out.println("Recompensa 3: " + recompensa3);
        System.out.println("Precio: " + precioRecompensa3 + "€");
        System.out.println("Gráfico de barras de cantidad financiada: \n" +
                verde + "▓ " + colorNormal + ": Parte financiada.\n" +
                "░ : Parte por financiar.");
        graficoBarras(cantidadNecesaria,cantidadFinanciada);
    }
    /**
     * Muestra un resumen de un proyecto con los detalles básicos.
     * @param nombreProyecto Nombre del proyecto.
     * @param categoriaProyecto Categoría del proyecto.
     * @param cantidadNecesaria Cantidad necesaria para financiar el proyecto.
     * @param cantidadFinanciada Cantidad financiada hasta el momento.
     * @author: David Galán
     */
    public static void mostrarResumenProyecto(String nombreProyecto, String categoriaProyecto, double cantidadNecesaria, double cantidadFinanciada) {
        String rojo = "\033[31m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "  " + nombreProyecto + morado + "  |");
        System.out.println("┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println("Nombre: " + nombreProyecto);
        System.out.println("Categoría: " + categoriaProyecto);
        System.out.println("Cantidad Necesaria: " + cantidadNecesaria);
        System.out.println("Cantidad Financiada: " + cantidadFinanciada);
        System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
    }
    /**
     * Cambia la contraseña del usuario si la ingresada es correcta.
     * @param contrasenaBuena La contraseña actual válida.
     * @return La nueva contraseña si el cambio es exitoso, la misma contraseña en caso contrario.
     * @author: David Galán
     */
    public static String cambiarUsuarioContrasena(String contrasenaBuena) {
        String amarillo = "\033[33m", colorNormal = "\u001B[0m";
        System.out.print("Escribe la contraseña: ");
        String contrasena = leerString();
        if (contrasena.equals(contrasenaBuena)) {
            System.out.print("Nueva contraseña: ");
            contrasenaBuena = leerString();
            return contrasenaBuena;
        } else {
            System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
            return contrasenaBuena;
        }
    }
}
