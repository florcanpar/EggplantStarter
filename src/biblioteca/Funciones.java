package biblioteca;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class Funciones {

    public static void menuInicioSesion() {
        String morado = "\033[35m", colorNormal = "\u001B[0m";
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
                2.- Registrar.
                3.- Salir.""" + colorNormal);
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
                System.out.println("Inserta tu correo:");
                String correoUsuarioDestinatario = leerString();
                System.out.println("Se le ha enviado un código de verificación a su correo.");
                String codigoGenerado = correoEnviar(correoUsuarioDestinatario);
                System.out.println("Inserte el código: ");
                String codigoInsertaUsuario = leerString();
                if (codigoInsertaUsuario.equals(codigoGenerado)){
                    System.out.println(verde + "Bienvenido " + ADMIN_USUARIO + colorNormal);
                    return true;
                } else {
                    System.out.println(rojo + "Código incorrecto." + colorNormal);
                    return admin;
                }
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

    public static void mostrarProyecto(String[][] proyecto, int opcion, String[][] recompensas) {
        String  verde = "\033[32m", morado = "\033[35m",amarillo = "\033[33m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "  " + proyecto[opcion][0] + " " + morado + "  |");
        System.out.println("┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println("Nombre: " + proyecto[opcion][0]);
        System.out.println("Descripción: " + proyecto[opcion][1]);
        System.out.println("Categoría: " + proyecto[opcion][2]);
        System.out.println("Cantidad Necesaria: " + proyecto[opcion][3]);
        System.out.println("Cantidad Financiada: " + proyecto[opcion][4]);
        System.out.println("Fecha de inicio de Inversiones: " + proyecto[opcion][5]);
        System.out.println("Fecha final de Inversiones: " + proyecto[opcion][6]);

        System.out.println("Recompensas: ");
        System.out.println("Recompensa 1: " + recompensas[opcion][0]);
        System.out.println("Precio: " + recompensas[opcion][1] + "€");
        System.out.println("Recompensa 2: " + recompensas[opcion][2]);
        System.out.println("Precio: " + recompensas[opcion][3] + "€");
        System.out.println("Recompensa 3: " + recompensas[opcion][4]);
        System.out.println("Precio: " + recompensas[opcion][5] + "€");
        System.out.println("Gráfico de barras de cantidad financiada: \n" +
                verde + "▓ " + colorNormal + ": Parte financiada.\n" +
                "░ : Parte por financiar.");
        graficoBarras(Integer.parseInt(proyecto[opcion][3]),Integer.parseInt(proyecto[opcion][4]));
    }

    public static void mostrarResumenProyecto(String[][] proyecto, int opcion) {
        String rojo = "\033[31m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "  " + proyecto[opcion][0] + morado + "  |");
        System.out.println("┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println("Nombre: " + proyecto[opcion][0]);
        System.out.println("Categoría: " + proyecto[opcion][2]);
        System.out.println("Cantidad Necesaria: " + proyecto[opcion][3]);
        System.out.println("Cantidad Financiada: " + proyecto[opcion][4]);
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

    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        /**
         * Código que nos facilita Eladio para enviar el correo desde java.
         * @author: Flor Canillo
         */
        String remitente = "florcanillopardo@gmail.com";
        String clave = "xulk rmhy kpaa kbom";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception me) {
            me.printStackTrace();
        }
    }
    public static String correoEnviar(String correoUsuarioDestinatario){
        /**
         * Aquí especifico el destinatario, asunto y cuerpo del correo.
         * Llamo a la función enviarConGMail para que se mande el correo.
         * @param codigo en esta variable se almacena lo que hace la función Contrasenia.
         * @param destinatario es el destinatario del correo, en este caso he utilizado mi correo personal.
         * @param asunto es el asunto del correo.
         * @param cuerpo es el cuerpo del correo.
         * @return devuelve el código de verificación.
         * @author: Flor Canillo
         */
        String codigo = Contrasenia();
        String destinatario = correoUsuarioDestinatario; // Destinatario del mensaje
        String asunto = "[Eggplant Starter] Código de verificación.";
        String cuerpo = "<h1>Este es el código</h1>" + codigo;
        enviarConGMail(destinatario, asunto, cuerpo);
        return codigo;
    }
    public static String Contrasenia(){
        /**
         * Aquí genero el un código aleatorio entre 1000 y 9999.
         * @param codigoFinal paso el código a un string.
         * @param codigoVerificacion genero el número aleatorio.
         * @return devuelve el código de verificación pasado a string.
         * @author: Flor Canillo
         */
        int codigoVerificacion = (int)(Math.random()*9000)+1000;
        String codigoFinal = Integer.toString(codigoVerificacion);
        return codigoFinal;
    }
    public static void menuCambiarProyectos(){
        String  verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres cambiar? "+ morado +"|");
        System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde +"1." + colorNormal +"Primer proyecto.");
        System.out.println(verde +"2." + colorNormal +"Segundo proyecto.");
        System.out.println(verde +"3." + colorNormal +"Tercer proyecto.");
        System.out.println(verde +"4." + colorNormal +"Volver.");
    }
    public static void menuCambiarProyectosCaracteristicas(){
        String  verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";

        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
        System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde +"0." + colorNormal +"Nombre");
        System.out.println(verde +"1." + colorNormal +"Descripción.");
        System.out.println(verde +"2." + colorNormal +"Categoría.");
        System.out.println(verde +"3." + colorNormal +"Cantidad Necesaria.");
        System.out.println(verde +"4." + colorNormal +"Cantidad Financiada.");
        System.out.println(verde +"5." + colorNormal +"Fecha de Inicio de inversiones.");
        System.out.println(verde +"6." + colorNormal +"Fecha de finalización de inversiones.");
        System.out.println(verde +"7." + colorNormal +"Recompensas.");
        System.out.println(verde +"8." + colorNormal +"Volver.");
    }
    public static void menuCambiarRecompensa(){
        String  verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";

        System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
        System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+colorNormal);
        System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
        System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
        System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
        System.out.println(verde +"4." + colorNormal +"Volver.");
    }
    public static void inicializarArrayBidimensionalString(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "";
            }
        }
    }
    public static void inicializarArrayBidimensionalBoolean(Boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = false;
            }
        }
    }
    public static Boolean hayHuecoGestorInversor(String tipoUsuarioRegistro, String[][] gestorDatos, String[][] inversorDatos){
        if (tipoUsuarioRegistro.equalsIgnoreCase("G")){
            for (int i = 0; i < gestorDatos.length; i++) {
                if (gestorDatos[i][0].isEmpty()) return true;
            }
        } else if (tipoUsuarioRegistro.equalsIgnoreCase("I")) {
            for (int i = 0; i < inversorDatos.length; i++) {
                if (inversorDatos[i][0].isEmpty()) return true;
            }
        }
        return false;
    }
    public static int posicionGestorInversorRegistro(String tipoUsuarioRegistro, String[][] gestorDatos, String[][] inversorDatos){
        int posicion=0;
        if (tipoUsuarioRegistro.equalsIgnoreCase("G")){
            for (int i = 0; i < gestorDatos.length; i++) {
                if (!(gestorDatos[i][0].isEmpty())) posicion++;
            }
        } else if (tipoUsuarioRegistro.equalsIgnoreCase("I")) {
            for (int i = 0; i < inversorDatos.length; i++) {
                if (!(inversorDatos[i][0].isEmpty())) posicion++;
            }
        }
        return posicion;
    }
    public static boolean usuarioAdmin(int tipoUsuarioIS, String usuario, String contraseña, String[][] adminDatos, String[][] gestorDatos, String[][] inversorDatos){
        Boolean correcto=false;

        if (tipoUsuarioIS==1){
            for (int i = 0; i < adminDatos.length; i++) {
                if (usuario.equals(adminDatos[i][0]) && contraseña.equals(adminDatos[i][1])) return true;
            }
        } else if (tipoUsuarioIS==2) {
            for (int i = 0; i < gestorDatos.length; i++) {
                if (usuario.equals(gestorDatos[i][0])  && contraseña.equals(gestorDatos[i][1])) return true;
            }
        } else if (tipoUsuarioIS==3) {
            for (int i = 0; i < inversorDatos.length; i++) {
                if (usuario.equals(inversorDatos[i][0])  && contraseña.equals(inversorDatos[i][1])) return true;
            }
        }
        return correcto;
    }
    public static int posicionAdminGestorInversorIS(int tipoUsuarioIS, String usuario, String[][] adminDatos, String[][] gestorDatos, String[][] inversorDatos){
        int posicion=-1;
        if (tipoUsuarioIS==1){
            for (int i = 0; i < adminDatos.length; i++) {
                if (usuario.equals(adminDatos[i][0])) return i;
            }
        } else if (tipoUsuarioIS==2) {
            for (int i = 0; i < gestorDatos.length; i++) {
                if (usuario.equals(gestorDatos[i][0])) return i;
            }
        } else if (tipoUsuarioIS==3) {
            for (int i = 0; i < inversorDatos.length; i++) {
                if (usuario.equals(inversorDatos[i][0])) return i;
            }
        }
        return posicion;
    }
    public static int cuantosGestoresHay(String[][] gestorDatos){
        int cant = 0;
        for (int i = 0; i < gestorDatos.length; i++) {
            if (!gestorDatos[i][0].isEmpty()) cant++;
        }
        return cant;
    }
    public static int cuantosInversoresHay(String[][] inversorDatos){
        int cant = 0;
        for (int i = 0; i < inversorDatos.length; i++) {
            if (!inversorDatos[i][0].isEmpty()) cant++;
        }
        return cant;
    }
    public static void mostrarUsuarioBloqueados(Boolean[][] bloqueosUsuarios, String[][] gestorDatos, String[][] inversorDatos){
        int cantGestores=cuantosGestoresHay(gestorDatos);
        int cantInversores=cuantosInversoresHay(inversorDatos);
        for (int i = 0; i < cantGestores; i++) {
            System.out.print(i+". "+gestorDatos[i][0]+": ");
            if (bloqueosUsuarios[i][0]) System.out.print("Bloqueado");
            else System.out.print("Desbloqueado");
            System.out.println();
        }
        for (int i = cantGestores; i < (cantGestores)+cantInversores; i++) {
            System.out.print(i+". "+inversorDatos[i-cantGestores][0]+": ");
            if (bloqueosUsuarios[(gestorDatos.length+i)-cantGestores][0]) System.out.print("Bloqueado");
            else System.out.print("Desbloqueado");
            System.out.println();
        }
        System.out.println(cantInversores+cantGestores+". Salir.");
    }
    public static int cuantosProyectosHay(String[][] proyectos){
        int cant = 0;
        for (int i = 0; i < proyectos.length; i++) {
            if (!proyectos[i][0].isEmpty()) cant++;
        }
        return cant;
    }
    public static void mostrarProyectosDisponibles(String[][] proyectos){
        for (int i = 0; i < proyectos.length; i++) {
            if (proyectos[i][0].isEmpty()) System.out.println(i+". Proyecto Disponible.");
        }
        System.out.println(proyectos.length+". Salir");
    }
    public static void mostrarProyectosCreados(String[][] proyectos){
        for (int i = 0; i < proyectos.length; i++) {
            if (!proyectos[i][0].isEmpty()) System.out.println(i+". Proyecto Disponible.");
        }
        System.out.println(proyectos.length+". Salir");
    }
}
