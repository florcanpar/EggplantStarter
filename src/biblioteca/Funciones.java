package biblioteca;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

import static biblioteca.FuncionesCadenas.*;
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
     *
     * @author: David Galán
     */
    public static void menuInversor() {
        String verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "╭ ─────┉─────" + amarillo + " • " + morado + "─────┉───── ╮");
        System.out.println(verde + "  ┈ ⋞ 〈 " + azul + "MENÚ INVERSOR" + verde + " 〉 ⋟ ┈");
        System.out.println(morado + "╰ ─────┉─────" + amarillo + " • " + morado + "─────┉───── ╯" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Mis Inversiones.");
        System.out.println(verde + "2." + colorNormal + "Proyectos.");
        System.out.println(verde + "3." + colorNormal + "Cartera digital.");
        System.out.println(verde + "4." + colorNormal + "Invitar amigos.");
        System.out.println(verde + "5." + colorNormal + "Configuración.");
        System.out.println(verde + "6." + colorNormal + "Salir.");
    }
    /**
     * Muestra el menú para crear recompensas para un proyecto.
     *
     * @author: David Galán
     */
    public static void menuCrearRecompensa() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + " ¿Qué recompensa quieres crear? " + morado + " |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "0." + colorNormal + "Recompensa 1.");
        System.out.println(verde + "1." + colorNormal + "Recompensa 2.");
        System.out.println(verde + "2." + colorNormal + "Recompensa 3.");
        System.out.println(verde + "3." + colorNormal + "Volver.");
    }

    /**
     * Muestra el menú de la cartera digital para el usuario.
     *
     * @author: David Galán
     */
    public static void menuCarteraDigital() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "   Cartera Digital " + morado + "   |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Mostrar Saldo Actual.");
        System.out.println(verde + "2." + colorNormal + "Añadir saldo.");
        System.out.println(verde + "3." + colorNormal + "Salir.");
    }

    /**
     * Muestra el menú para invitar amigos y gestionar referidos.
     *
     * @author: David Galán
     */
    public static void menuInvitarAmigos() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "    Invitar Amigo " + morado + "    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Mostrar lista de amigos referidos.");
        System.out.println(verde + "2." + colorNormal + "Añadir un amigo.");
        System.out.println(verde + "3." + colorNormal + "Salir.");
    }

    /**
     * Muestra el menú principal para el gestor de proyectos.
     *
     * @author: David Galán
     */
    public static void mostrarMenuGestor() {
        String verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "╭ ────┉────" + amarillo + " • " + morado + "────┉──── ╮");
        System.out.println(verde + " ┈ ⋞ 〈 " + azul + "MENÚ GESTOR" + verde + " 〉 ⋟ ┈");
        System.out.println(morado + "╰ ────┉────" + amarillo + " • " + morado + "────┉──── ╯" + colorNormal);
        System.out.println(verde + "1." + colorNormal + " Mis proyectos.");
        System.out.println(verde + "2." + colorNormal + " Configuración.");
        System.out.println(verde + "3." + colorNormal + " Cerrar sesión.");
    }

    /**
     * Muestra el menú de gestión de proyectos para el gestor.
     *
     * @author: David Galán
     */
    public static void mostrarMenuProyectosGestor() {
        String verde = "\033[32m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + verde + "    Proyectos" + morado + "     |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Ver Proyectos.");
        System.out.println(verde + "2." + colorNormal + "Crear Proyectos.");
        System.out.println(verde + "3." + colorNormal + "Modificar Proyectos.");
        System.out.println(verde + "4." + colorNormal + "Eliminar Proyectos.");
        System.out.println(verde + "5." + colorNormal + "Volver al Menú Gestor.");
    }

    /**
     * Muestra el menú de configuración para cambiar usuario o contraseña.
     *
     * @author: David Galán
     */
    public static void menuConfiguracionUsuarioContrasena() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "   Configuración" + morado + "    |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + " Cambio de Usuario.");
        System.out.println(verde + "2." + colorNormal + " Cambio de Contraseña.");
        System.out.println(verde + "3." + colorNormal + " Salir.");
    }

    /**
     * Muestra el menú de gestión de proyectos para el administrador.
     *
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
     * Muestra el menú principal para el administrador.
     *
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
     *
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
     * Lee un entero desde la entrada estándar.
     *
     * @return El entero leído.
     * @author: David Galán
     */
    public static int leerInt() {
        Scanner s = new Scanner(System.in);
        return Integer.parseInt(s.nextLine());
    }

    /**
     * Lee un número decimal desde la entrada estándar.
     *
     * @return El número decimal leído.
     * @author: David Galán
     */
    public static double leerDouble() {
        Scanner s = new Scanner(System.in);
        return Double.parseDouble(s.nextLine());
    }

    /**
     * Lee una cadena de texto desde la entrada estándar.
     *
     * @return La cadena de texto leída.
     * @author: David Galán
     */
    public static String leerString() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    /**
     * Pinta el gráfico de barras
     *
     * @param cantidadNecesaria  Cantidad necesaria para financiar el proyecto.
     * @param cantidadFinanciada Cantidad ya financiada.
     * @author: David Galán
     */
    public static void graficoBarras(double cantidadNecesaria, double cantidadFinanciada) {
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
     * Muestra la información detallada de un proyecto, incluidas sus recompensas.
     *
     * @param proyecto   Matriz bidimensional que contiene los datos de los proyectos.
     * @param opcion     Índice del proyecto que se desea mostrar.
     * @param recompensas Matriz bidimensional que contiene las recompensas asociadas a los proyectos.
     * @author David Galán
     */
    public static void mostrarProyecto(String[][] proyecto, int opcion, String[][] recompensas) {
        String verde = "\033[32m", morado = "\033[35m", amarillo = "\033[33m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━┓");
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
        graficoBarras(Integer.parseInt(proyecto[opcion][3]), Integer.parseInt(proyecto[opcion][4]));
    }

    /**
     * Muestra un resumen de la información básica de un proyecto.
     *
     * @param proyecto Matriz bidimensional que contiene los datos de los proyectos.
     * @param opcion   Índice del proyecto que se desea mostrar.
     * @author David Galán
     */
    public static void mostrarResumenProyecto(String[][] proyecto, int opcion) {
        String rojo = "\033[31m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "  " + proyecto[opcion][0] + morado + "  |");
        System.out.println("┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println("Nombre: " + proyecto[opcion][0]);
        System.out.println("Categoría: " + proyecto[opcion][2]);
        System.out.println("Cantidad Necesaria: " + proyecto[opcion][3]);
        System.out.println("Cantidad Financiada: " + proyecto[opcion][4]);
        System.out.println("Para ver el proyecto detallado, inserte " + rojo + "[X]." + colorNormal);
    }

    /**
     * Cambia la contraseña del usuario si la ingresada es correcta.
     *
     * @param contrasenaBuena La contraseña actual válida.
     * @return La nueva contraseña si el cambio es exitoso, la misma contraseña en caso contrario.
     * @author: David Galán
     */
    public static void cambiarUsuarioContrasena(String contrasenaBuena, int opcion, String[][] adminDatos, String[][] gestorDatos, String[][] inversorDatos, int tipoUsuarioIS, int posicion) {
        String amarillo = "\033[33m", colorNormal = "\u001B[0m";
        System.out.print("Escribe la contraseña: ");
        String contrasena = leerString();
        if (contrasena.equals(contrasenaBuena)) {
            if (tipoUsuarioIS == 1) {
                if (opcion == 1) {
                    System.out.print("Nuevo usuario: ");
                    adminDatos[posicion][0] = leerString();
                } else if (opcion == 2) {
                    System.out.print("Nueva Contraseña: ");
                    adminDatos[posicion][1] = leerString();
                } else System.out.println("Contraseña fallida.");
            } else if (tipoUsuarioIS == 2) {
                if (opcion == 1) {
                    System.out.print("Nuevo usuario: ");
                    gestorDatos[posicion][0] = leerString();
                } else if (opcion == 2) {
                    System.out.print("Nueva Contraseña: ");
                    gestorDatos[posicion][1] = leerString();
                } else System.out.println("Contraseña fallida.");
            } else if (tipoUsuarioIS == 3) {
                if (opcion == 1) {
                    System.out.print("Nuevo usuario: ");
                    inversorDatos[posicion][0] = leerString();
                } else if (opcion == 2) {
                    System.out.print("Nueva Contraseña: ");
                    inversorDatos[posicion][1] = leerString();
                } else System.out.println("Contraseña fallida.");
            }
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

    public static String correoEnviar(String correoUsuarioDestinatario) {
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

    public static String Contrasenia() {
        /**
         * Aquí genero el un código aleatorio entre 1000 y 9999.
         * @param codigoFinal paso el código a un string.
         * @param codigoVerificacion genero el número aleatorio.
         * @return devuelve el código de verificación pasado a string.
         * @author: Flor Canillo
         */
        int codigoVerificacion = (int) (Math.random() * 9000) + 1000;
        String codigoFinal = Integer.toString(codigoVerificacion);
        return codigoFinal;
    }

    /**
     * Muestra un menú para seleccionar el proyecto que se desea modificar.
     *
     * Este menú presenta una lista numerada de proyectos y una opción para volver al menú principal.
     *
     * @author David Galán
     */
    public static void menuCambiarProyectos() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";
        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + "¿Qué proyecto quieres cambiar? " + morado + "|");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "1." + colorNormal + "Primer proyecto.");
        System.out.println(verde + "2." + colorNormal + "Segundo proyecto.");
        System.out.println(verde + "3." + colorNormal + "Tercer proyecto.");
        System.out.println(verde + "4." + colorNormal + "Volver.");
    }

    /**
     * Muestra un menú para seleccionar las características del proyecto a modificar.
     *
     * Este menú incluye opciones para cambiar diversas propiedades del proyecto, como nombre,
     * descripción, categoría, y fechas, entre otras. También incluye una opción para volver.
     *
     * @author David Galán
     */
    public static void menuCambiarProyectosCaracteristicas() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";

        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + " ¿Qué quieres cambiar? " + morado + " |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "0." + colorNormal + "Nombre");
        System.out.println(verde + "1." + colorNormal + "Descripción.");
        System.out.println(verde + "2." + colorNormal + "Categoría.");
        System.out.println(verde + "3." + colorNormal + "Cantidad Necesaria.");
        System.out.println(verde + "4." + colorNormal + "Cantidad Financiada.");
        System.out.println(verde + "5." + colorNormal + "Fecha de Inicio de inversiones.");
        System.out.println(verde + "6." + colorNormal + "Fecha de finalización de inversiones.");
        System.out.println(verde + "7." + colorNormal + "Recompensas.");
        System.out.println(verde + "8." + colorNormal + "Volver.");
    }

    /**
     * Muestra un menú para seleccionar la recompensa específica que se desea modificar.
     *
     * Este menú incluye opciones para cambiar hasta tres recompensas diferentes y una opción para volver.
     *
     * @author David Galán
     */
    public static void menuCambiarRecompensa() {
        String verde = "\033[32m", amarillo = "\033[33m", morado = "\033[35m", colorNormal = "\u001B[0m";

        System.out.println(morado + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("| " + amarillo + " ¿Qué recompensa quieres cambiar? " + morado + " |");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
        System.out.println(verde + "0." + colorNormal + "Recompensa 1.");
        System.out.println(verde + "1." + colorNormal + "Recompensa 2.");
        System.out.println(verde + "2." + colorNormal + "Recompensa 3.");
        System.out.println(verde + "3." + colorNormal + "Volver.");
    }

    /**
     * Inicializa todos los elementos de un array bidimensional de cadenas a una cadena vacía.
     *
     * @param array El array bidimensional de tipo {@code String} a inicializar.
     * @author David Galán
     */
    public static void inicializarArrayBidimensionalString(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "";
            }
        }
    }

    /**
     * Inicializa todos los elementos de un array bidimensional de enteros a cero.
     *
     * @param array El array bidimensional de tipo {@code int} a inicializar.
     * @author David Galán
     */
    public static void inicializarArrayBidimensionalInt(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    /**
     * Inicializa un array bidimensional de tipo Boolean estableciendo todos sus valores en false.
     *
     * @param array Matriz bidimensional de tipo Boolean que será inicializada.
     */
    public static void inicializarArrayBidimensionalBoolean(Boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = false;
            }
        }
    }

    /**
     * Verifica si hay espacio disponible en la matriz de datos de gestores o inversores.
     *
     * @param tipoUsuarioRegistro Tipo de usuario ("G" para gestores, "I" para inversores).
     * @param gestorDatos         Matriz bidimensional con datos de gestores.
     * @param inversorDatos       Matriz bidimensional con datos de inversores.
     * @return true si hay espacio disponible, false en caso contrario.
     */
    public static Boolean hayHuecoGestorInversor(String tipoUsuarioRegistro, String[][] gestorDatos, String[][] inversorDatos) {
        if (tipoUsuarioRegistro.equalsIgnoreCase("G")) {
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

    /**
     * Calcula la posición del próximo registro disponible para un gestor o inversor.
     *
     * @param tipoUsuarioRegistro Tipo de usuario ("G" para gestores, "I" para inversores).
     * @param gestorDatos         Matriz bidimensional con datos de gestores.
     * @param inversorDatos       Matriz bidimensional con datos de inversores.
     * @return La posición del próximo registro disponible.
     */
    public static int posicionGestorInversorRegistro(String tipoUsuarioRegistro, String[][] gestorDatos, String[][] inversorDatos) {
        int posicion = 0;
        if (tipoUsuarioRegistro.equalsIgnoreCase("G")) {
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

    /**
     * Verifica si un usuario con las credenciales proporcionadas es administrador, gestor o inversor.
     *
     * @param tipoUsuarioIS Tipo de usuario (1 para administrador, 2 para gestor, 3 para inversor).
     * @param usuario       Nombre de usuario.
     * @param contraseña    Contraseña del usuario.
     * @param adminDatos    Matriz bidimensional con datos de administradores.
     * @param gestorDatos   Matriz bidimensional con datos de gestores.
     * @param inversorDatos Matriz bidimensional con datos de inversores.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public static boolean usuarioAdmin(int tipoUsuarioIS, String usuario, String contraseña, String[][] adminDatos, String[][] gestorDatos, String[][] inversorDatos) {
        Boolean correcto = false;

        if (tipoUsuarioIS == 1) {
            for (int i = 0; i < adminDatos.length; i++) {
                if (usuario.equals(adminDatos[i][0]) && contraseña.equals(adminDatos[i][1])) return true;
            }
        } else if (tipoUsuarioIS == 2) {
            for (int i = 0; i < gestorDatos.length; i++) {
                if (usuario.equals(gestorDatos[i][0]) && contraseña.equals(gestorDatos[i][1])) return true;
            }
        } else if (tipoUsuarioIS == 3) {
            for (int i = 0; i < inversorDatos.length; i++) {
                if (usuario.equals(inversorDatos[i][0]) && contraseña.equals(inversorDatos[i][1])) return true;
            }
        }
        return correcto;
    }

    /**
     * Obtiene la posición de un usuario administrador, gestor o inversor en la matriz correspondiente.
     *
     * @param tipoUsuarioIS Tipo de usuario (1 para administrador, 2 para gestor, 3 para inversor).
     * @param usuario       Nombre de usuario.
     * @param adminDatos    Matriz bidimensional con datos de administradores.
     * @param gestorDatos   Matriz bidimensional con datos de gestores.
     * @param inversorDatos Matriz bidimensional con datos de inversores.
     * @return La posición del usuario en la matriz, o 0 si no se encuentra.
     */
    public static int posicionAdminGestorInversorIS(int tipoUsuarioIS, String usuario, String[][] adminDatos, String[][] gestorDatos, String[][] inversorDatos) {
        int posicion = 0;
        if (tipoUsuarioIS == 1) {
            for (int i = 0; i < adminDatos.length; i++) {
                if (usuario.equals(adminDatos[i][0])) return i;
            }
        } else if (tipoUsuarioIS == 2) {
            for (int i = 0; i < gestorDatos.length; i++) {
                if (usuario.equals(gestorDatos[i][0])) return i;
            }
        } else if (tipoUsuarioIS == 3) {
            for (int i = 0; i < inversorDatos.length; i++) {
                if (usuario.equals(inversorDatos[i][0])) return i;
            }
        }
        return posicion;
    }

    /**
     * Calcula cuántos gestores existen en el sistema.
     *
     * @param gestorDatos Matriz bidimensional que contiene los datos de los gestores.
     * @return La cantidad de gestores registrados.
     */
    public static int cuantosGestoresHay(String[][] gestorDatos) {
        int cant = 0;
        for (int i = 0; i < gestorDatos.length; i++) {
            if (!gestorDatos[i][0].isEmpty()) cant++;
        }
        return cant;
    }

    /**
     * Calcula cuántos inversores existen en el sistema.
     *
     * @param inversorDatos Matriz bidimensional que contiene los datos de los inversores.
     * @return La cantidad de inversores registrados.
     */
    public static int cuantosInversoresHay(String[][] inversorDatos) {
        int cant = 0;
        for (int i = 0; i < inversorDatos.length; i++) {
            if (!inversorDatos[i][0].isEmpty()) cant++;
        }
        return cant;
    }

    /**
     * Muestra el estado de bloqueo de los usuarios (gestores e inversores).
     *
     * @param bloqueosUsuarios Matriz bidimensional que indica si un usuario está bloqueado.
     * @param gestorDatos Matriz bidimensional que contiene los datos de los gestores.
     * @param inversorDatos Matriz bidimensional que contiene los datos de los inversores.
     */
    public static void mostrarUsuarioBloqueados(Boolean[][] bloqueosUsuarios, String[][] gestorDatos, String[][] inversorDatos) {
        int cantGestores = cuantosGestoresHay(gestorDatos);
        int cantInversores = cuantosInversoresHay(inversorDatos);
        for (int i = 0; i < cantGestores; i++) {
            System.out.print(i + ". " + gestorDatos[i][0] + ": ");
            if (bloqueosUsuarios[i][0]) System.out.print("Bloqueado");
            else System.out.print("Desbloqueado");
            System.out.println();
        }
        for (int i = cantGestores; i < (cantGestores) + cantInversores; i++) {
            System.out.print(i + ". " + inversorDatos[i - cantGestores][0] + ": ");
            if (bloqueosUsuarios[(gestorDatos.length + i) - cantGestores][0]) System.out.print("Bloqueado");
            else System.out.print("Desbloqueado");
            System.out.println();
        }
        System.out.println(cantInversores + cantGestores + ". Salir.");
    }

    /**
     * Calcula cuántos proyectos existen en el sistema.
     *
     * @param proyectos Matriz bidimensional que contiene los datos de los proyectos.
     * @return La cantidad de proyectos registrados.
     */
    public static int cuantosProyectosHay(String[][] proyectos) {
        int cant = 0;
        for (int i = 0; i < proyectos.length; i++) {
            if (!proyectos[i][0].isEmpty()) cant++;
        }
        return cant;
    }

    /**
     * Muestra una lista de proyectos disponibles (sin registrar datos).
     *
     * @param proyectos Matriz bidimensional que contiene los datos de los proyectos.
     */
    public static void mostrarProyectosDisponibles(String[][] proyectos) {
        for (int i = 0; i < proyectos.length; i++) {
            if (proyectos[i][0].isEmpty()) System.out.println(i + ". Proyecto Disponible.");
        }
        System.out.println(proyectos.length + ". Salir");
    }

    /**
     * Muestra una lista de proyectos creados (registrados con datos).
     *
     * @param proyectos Matriz bidimensional que contiene los datos de los proyectos.
     */
    public static void mostrarProyectosCreados(String[][] proyectos) {
        for (int i = 0; i < proyectos.length; i++) {
            if (!proyectos[i][0].isEmpty()) System.out.println(i + ". Proyecto Disponible.");
        }
        System.out.println(proyectos.length + ". Salir");
    }

    /**
     * Elimina un proyecto y sus recompensas asociadas del sistema.
     *
     * @param proyectos   Matriz bidimensional que contiene los datos de los proyectos.
     * @param recompensas Matriz bidimensional que contiene las recompensas de los proyectos.
     * @param opcion      Índice del proyecto a eliminar.
     */
    public static void eliminarProyecto(String[][] proyectos, String[][] recompensas, int opcion) {
        for (int i = 0; i < proyectos[opcion].length; i++) {
            proyectos[opcion][i] = "";
        }
        for (int i = 0; i < recompensas[opcion].length; i++) {
            recompensas[opcion][i] = "";
        }
        System.out.println("Proyecto eliminado satisfactoriamente.");
    }
}
