package biblioteca;

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
}
