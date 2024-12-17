import static biblioteca.Funciones.*;
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                String ADMIN_USUARIO = "admin", ADMIN_CONTRASENA = "adminpass", GESTOR_USUARIO = "gestor", GESTOR_CONTRASENA = "gestorpass",
                        INVERSOR1_USUARIO = "inversor1", INVERSOR1_CONTRASENA = "inversor1pass", INVERSOR2_USUARIO = "inversor2", INVERSOR2_CONTRASENA = "inversor2pass", usuario, contrasena, amigosReferidos="", correoUsuarioDestinatario="";
                int contadorFallosGestor = 0, contadorFallosInversor1 = 0, contadorFallosInversor2 = 0;
                boolean bloquearGestor = false, bloquearInversor1 = false, bloquearInversor2 = false, admin, gestor, inversor1, inversor2;
                int carteraInversor1 = 0, carteraInversor2 = 0, dineroAnadido, cantidadInvertir, cantidadInvertidaInversor1Proy01 = 0, cantidadInvertidaInversor1Proy02 = 0, cantidadInvertidaInversor1Proy03 = 0,
                        cantidadInvertidaInversor2Proy01 = 0, cantidadInvertidaInversor2Proy02 = 0, cantidadInvertidaInversor2Proy03 = 0;

                String  rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m",
                        morado = "\033[35m", cyan = "\033[36m", colorNormal = "\u001B[0m";

                int menuGestor, opcion, opcion2;

                String nombreProyecto01="", nombreProyecto02 = "", nombreProyecto03 = "";
                String descProyecto01 = "", descProyecto02 = "", descProyecto03 = "";
                String categoriaProyecto01 = "", categoriaProyecto02 = "", categoriaProyecto03 = "";
                double cantNecesariaProyecto01 = 0, cantNecesariaProyecto02 = 0, cantNecesariaProyecto03 = 0;
                double cantFinanciadaProyecto01 = 10, cantFinanciadaProyecto02 = 0, cantFinanciadaProyecto03 = 0;

                // Fechas de los proyectos
                String fechaInicioProyecto01 = "", fechaInicioProyecto02 = "", fechaInicioProyecto03 = "";
                String fechaFinalProyecto01 = "", fechaFinalProyecto02 = "", fechaFinalProyecto03 = "";

                // Recompensas de los proyectos
                String recompensa1Proyecto01 = "", recompensa2Proyecto01 = "", recompensa3Proyecto01 = "";
                String recompensa1Proyecto02 = "", recompensa2Proyecto02 = "", recompensa3Proyecto02 = "";
                String recompensa1Proyecto03 = "", recompensa2Proyecto03 = "", recompensa3Proyecto03 = "";
                int preciorecompensa1Proyecto01 = 0, preciorecompensa2Proyecto01 = 0, preciorecompensa3Proyecto01 = 0;
                int preciorecompensa1Proyecto02 = 0, preciorecompensa2Proyecto02 = 0, preciorecompensa3Proyecto02 = 0;
                int preciorecompensa1Proyecto03 = 0, preciorecompensa2Proyecto03 = 0, preciorecompensa3Proyecto03 = 0;

                do {
                    menuInicioSesion();
                    opcion= leerInt();
                    switch (opcion){
                        case 1:
                            do {
                                gestor = admin = inversor1 = inversor2 = false;
                                System.out.print("Usuario: ");
                                usuario = leerString();
                                System.out.print("Contraseña: ");
                                contrasena = leerString();
                                // VALIDACIÓN DE GESTOR
                                if (usuario.equals(GESTOR_USUARIO)) {
                                    if (bloquearGestor) {
                                        System.out.println("El usuario " + GESTOR_USUARIO + " está " + rojo + "bloqueado." + colorNormal);
                                    } else if (contrasena.equals(GESTOR_CONTRASENA)) {
                                        System.out.println("Inserta tu correo:");
                                        correoUsuarioDestinatario = leerString();
                                        System.out.println("Se le ha enviado un código de verificación a su correo.");
                                        String codigoGenerado = correoEnviar(correoUsuarioDestinatario);
                                        System.out.println("Inserte el código: ");
                                        String codigoInsertaUsuario = leerString();
                                        if (codigoInsertaUsuario.equals(codigoGenerado)){
                                            System.out.println(verde + "Bienvenido " + GESTOR_USUARIO + colorNormal);
                                            gestor=true;
                                            contadorFallosGestor=0;
                                        } else {
                                            System.out.println(rojo + "Código incorrecto." + colorNormal);
                                            contadorFallosGestor++;
                                            if (contadorFallosGestor > 2) {
                                                System.out.println("Usuario " + GESTOR_USUARIO + rojo + " bloqueado." + colorNormal);
                                                bloquearGestor = true;
                                            }
                                        }
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + " Vuelva a intentarlo.");
                                        contadorFallosGestor++;
                                        if (contadorFallosGestor > 2) {
                                            System.out.println("Usuario " + GESTOR_USUARIO + rojo + " bloqueado." + colorNormal);
                                            bloquearGestor = true;
                                        }
                                    }
                                }
                                // VALIDACIÓN DE INVERSOR1
                                if (usuario.equals(INVERSOR1_USUARIO)) {
                                    if (bloquearInversor1) {
                                        System.out.println("El usuario " + INVERSOR1_USUARIO + " está " + rojo +"bloqueado." + colorNormal);
                                    } else if (contrasena.equals(INVERSOR1_CONTRASENA)) {
                                        System.out.println("Inserta tu correo:");
                                        correoUsuarioDestinatario = leerString();
                                        System.out.println("Se le ha enviado un código de verificación a su correo.");
                                        String codigoGenerado = correoEnviar(correoUsuarioDestinatario);
                                        System.out.println("Inserte el código: ");
                                        String codigoInsertaUsuario = leerString();
                                        if (codigoInsertaUsuario.equals(codigoGenerado)){
                                            System.out.println(verde + "Bienvenido " + INVERSOR1_USUARIO + colorNormal);
                                            inversor1=true;
                                            contadorFallosInversor1=0;
                                        } else {
                                            System.out.println(rojo + "Código incorrecto." + colorNormal);
                                            contadorFallosInversor1++;
                                            if (contadorFallosInversor1 > 2) {
                                                System.out.println("Usuario " + INVERSOR1_USUARIO + rojo +" bloqueado." + colorNormal);
                                                bloquearInversor1 = true;
                                            }
                                        }
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + ". Vuelva a intentarlo.");
                                        contadorFallosInversor1++;
                                        if (contadorFallosInversor1 > 2) {
                                            System.out.println("Usuario " + INVERSOR1_USUARIO + rojo +" bloqueado." + colorNormal);
                                            bloquearInversor1 = true;
                                        }
                                    }
                                }
                                // VALIDACIÓN DE INVERSOR2
                                if (usuario.equals(INVERSOR2_USUARIO)) {
                                    if (bloquearInversor2) {
                                        System.out.println("El usuario " + INVERSOR2_USUARIO + " está " + rojo + "bloqueado." + colorNormal);
                                    } else if (contrasena.equals(INVERSOR2_CONTRASENA)) {
                                        System.out.println("Inserta tu correo:");
                                        correoUsuarioDestinatario = leerString();
                                        System.out.println("Se le ha enviado un código de verificación a su correo.");
                                        String codigoGenerado = correoEnviar(correoUsuarioDestinatario);
                                        System.out.println("Inserte el código: ");
                                        String codigoInsertaUsuario = leerString();
                                        if (codigoInsertaUsuario.equals(codigoGenerado)){
                                            System.out.println(verde + "Bienvenido " + INVERSOR2_USUARIO + colorNormal);
                                            inversor2=true;
                                            contadorFallosInversor2=0;
                                        } else {
                                            System.out.println(rojo + "Código incorrecto." + colorNormal);
                                            contadorFallosInversor2++;
                                            if (contadorFallosInversor2 > 2) {
                                                System.out.println("Usuario " + INVERSOR2_USUARIO + rojo +" bloqueado." + colorNormal);
                                                bloquearInversor2 = true;
                                            }
                                        }
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + " Vuelva a intentarlo.");
                                        contadorFallosInversor2++;
                                        if (contadorFallosInversor2 > 2) {
                                            System.out.println("Usuario " + INVERSOR2_USUARIO + rojo +" bloqueado." + colorNormal);
                                            bloquearInversor2 = true;
                                        }
                                    }
                                }
                                // VALIDACIÓN DE ADMIN
                                if(validarAdmin(usuario,contrasena,ADMIN_USUARIO,ADMIN_CONTRASENA,admin,verde,colorNormal,rojo)) admin=true;
                            }while (!gestor && !inversor1 && !inversor2 && !admin);
                            if (admin){
                                do {
                                    menuAdmin();
                                    opcion2 = leerInt();
                                    switch (opcion2) {
                                        case 1: {
                                            menuPanelDeControl();
                                            do {
                                                listadoPanelDeCotrol(GESTOR_USUARIO,INVERSOR1_USUARIO,INVERSOR2_USUARIO);
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1 :
                                                        if (bloquearGestor){
                                                            System.out.println(GESTOR_USUARIO + verde + " desbloqueado." + colorNormal);
                                                            bloquearGestor=false;
                                                        }else{
                                                            System.out.println(GESTOR_USUARIO + rojo + " bloqueado." + colorNormal);
                                                            bloquearGestor=true;
                                                        }
                                                        break;
                                                    case 2:
                                                        if (bloquearInversor1){
                                                            System.out.println(INVERSOR1_USUARIO + verde + " desbloqueado." + colorNormal);
                                                            bloquearInversor1=false;
                                                        }else{
                                                            System.out.println(INVERSOR1_USUARIO + rojo + " bloqueado." + colorNormal);
                                                            bloquearInversor1=true;
                                                        }
                                                        break;
                                                    case 3:
                                                        if (bloquearInversor2){
                                                            System.out.println(INVERSOR2_USUARIO + verde + " desbloqueado." + colorNormal);
                                                            bloquearInversor2=false;
                                                        }else{
                                                            System.out.println(INVERSOR2_USUARIO + rojo + " bloqueado." + colorNormal);
                                                            bloquearInversor2=true;
                                                        }
                                                        break;
                                                    case 4:
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                }
                                            }while (opcion != 4);
                                        }
                                        break;
                                        case 2: {
                                            do {
                                                menuProyectosAdmin();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                            System.out.println( amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        }else{
                                                            do {
                                                                menuVerProyectos();
                                                                opcion = leerInt();
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else{
                                                                            mostrarResumenProyecto(nombreProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(nombreProyecto01,descProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01,fechaInicioProyecto01,fechaFinalProyecto01,recompensa1Proyecto01,preciorecompensa1Proyecto01,recompensa2Proyecto01,preciorecompensa2Proyecto01,recompensa3Proyecto01,preciorecompensa3Proyecto01);
                                                                            }else System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            mostrarResumenProyecto(nombreProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(nombreProyecto02,descProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02,fechaInicioProyecto02,fechaFinalProyecto02,recompensa1Proyecto02,preciorecompensa1Proyecto02,recompensa2Proyecto02,preciorecompensa2Proyecto02,recompensa3Proyecto02,preciorecompensa3Proyecto02);
                                                                            } else {
                                                                                System.out.println(amarillo + "Opción inválida" + colorNormal);
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            mostrarResumenProyecto(nombreProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(nombreProyecto03,descProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03,fechaInicioProyecto03,fechaFinalProyecto03,recompensa1Proyecto03,preciorecompensa1Proyecto03,recompensa2Proyecto03,preciorecompensa2Proyecto03,recompensa3Proyecto03,preciorecompensa3Proyecto03);
                                                                            } else {
                                                                                System.out.println(amarillo + "Opción inválida" + colorNormal);
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    default:
                                                                        System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                        }
                                                        break;
                                                    case 2 :
                                                        if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                            System.out.println(amarillo +"Ningún proyecto ha sido creado aún, dile al gesto que cree un proyecto para modificarlo." + colorNormal);
                                                        }else{
                                                            do {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres cambiar? "+ morado +"|");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println(verde +"1." + colorNormal +"Primer proyecto.");
                                                                System.out.println(verde +"2." + colorNormal +"Segundo proyecto.");
                                                                System.out.println(verde +"3." + colorNormal +"Tercer proyecto.");
                                                                System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                opcion = leerInt();
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Nombre");
                                                                                System.out.println(verde +"2." + colorNormal +"Descripción.");
                                                                                System.out.println(verde +"3." + colorNormal +"Categoría.");
                                                                                System.out.println(verde +"4." + colorNormal +"Cantidad Necesaria.");
                                                                                System.out.println(verde +"5." + colorNormal +"Cantidad Financiada.");
                                                                                System.out.println(verde +"6." + colorNormal +"Fecha de Inicio de inversiones.");
                                                                                System.out.println(verde +"7." + colorNormal +"Fecha de finalización de inversiones.");
                                                                                System.out.println(verde +"8." + colorNormal +"Recompensas.");
                                                                                System.out.println(verde +"9." + colorNormal +"Volver.");
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto01 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto01 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto01 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto01 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto01 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto01 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto01 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                            System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                            System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                            System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                            System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                            System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto01 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto01 = leerInt();

                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto01 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                                default:
                                                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                                    break;
                                                                                            }
                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                        }
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Nombre");
                                                                                System.out.println(verde +"2." + colorNormal +"Descripción.");
                                                                                System.out.println(verde +"3." + colorNormal +"Categoría.");
                                                                                System.out.println(verde +"4." + colorNormal +"Cantidad Necesaria.");
                                                                                System.out.println(verde +"5." + colorNormal +"Cantidad Financiada.");
                                                                                System.out.println(verde +"6." + colorNormal +"Fecha de Inicio de inversiones.");
                                                                                System.out.println(verde +"7." + colorNormal +"Fecha de finalización de inversiones.");
                                                                                System.out.println(verde +"8." + colorNormal +"Recompensas.");
                                                                                System.out.println(verde +"9." + colorNormal +"Volver.");
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto02 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto02 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto02 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto02 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto02 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto02 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto02 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                            System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                            System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                            System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                            System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                            System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                            }

                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Nombre");
                                                                                System.out.println(verde +"2." + colorNormal +"Descripción.");
                                                                                System.out.println(verde +"3." + colorNormal +"Categoría.");
                                                                                System.out.println(verde +"4." + colorNormal +"Cantidad Necesaria.");
                                                                                System.out.println(verde +"5." + colorNormal +"Cantidad Financiada.");
                                                                                System.out.println(verde +"6." + colorNormal +"Fecha de Inicio de inversiones.");
                                                                                System.out.println(verde +"7." + colorNormal +"Fecha de finalización de inversiones.");
                                                                                System.out.println(verde +"8." + colorNormal +"Recompensas.");
                                                                                System.out.println(verde +"9." + colorNormal +"Volver.");
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto03 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto03 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto03 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto03 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto03 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto03 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto03 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                            System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                            System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                            System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                            System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                            System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                            }
                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                            break;
                                                                        }
                                                                    case 4:
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                            break;
                                                        }
                                                        break;
                                                    case 3 :
                                                        if (!(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty())){
                                                            do {
                                                                menuEliminarProyectos();
                                                                opcion = leerInt();
                                                                switch (opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto01 + "? (s/n)");
                                                                            String eliminarProyecto1SiNo = leerString();
                                                                            if (eliminarProyecto1SiNo.equalsIgnoreCase("s")) {
                                                                                nombreProyecto01 = "";
                                                                                descProyecto01 = "";
                                                                                categoriaProyecto01 = "";
                                                                                cantNecesariaProyecto01 = 0;
                                                                                cantFinanciadaProyecto01 = 0;
                                                                                fechaFinalProyecto01 = "";
                                                                                fechaInicioProyecto01 = "";
                                                                                recompensa1Proyecto01 = "";
                                                                                recompensa2Proyecto01 = "";
                                                                                recompensa3Proyecto01 = "";
                                                                                preciorecompensa1Proyecto01 = 0;
                                                                                preciorecompensa2Proyecto01 = 0;
                                                                                preciorecompensa3Proyecto01 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto02 + "? (s/n)");
                                                                            String eliminarProyecto2SiNo = leerString();
                                                                            if (eliminarProyecto2SiNo.equalsIgnoreCase("s")){
                                                                                nombreProyecto02 = "";
                                                                                descProyecto02 = "";
                                                                                categoriaProyecto02 = "";
                                                                                cantNecesariaProyecto02 = 0;
                                                                                cantFinanciadaProyecto02 = 0;
                                                                                fechaFinalProyecto02 = "";
                                                                                fechaInicioProyecto02 = "";
                                                                                recompensa1Proyecto02 = "";
                                                                                recompensa2Proyecto02 = "";
                                                                                recompensa3Proyecto02 = "";
                                                                                preciorecompensa1Proyecto02 = 0;
                                                                                preciorecompensa2Proyecto02 = 0;
                                                                                preciorecompensa3Proyecto02 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto03 + "? (s/n)");
                                                                            String eliminarProyecto3SiNo = leerString();
                                                                            if (eliminarProyecto3SiNo.equalsIgnoreCase("s")) {
                                                                                nombreProyecto03 = "";
                                                                                descProyecto03 = "";
                                                                                categoriaProyecto03 = "";
                                                                                cantNecesariaProyecto03 = 0;
                                                                                cantFinanciadaProyecto03 = 0;
                                                                                fechaFinalProyecto03 = "";
                                                                                fechaInicioProyecto03 = "";
                                                                                recompensa1Proyecto03 = "";
                                                                                recompensa2Proyecto03 = "";
                                                                                recompensa3Proyecto03 = "";
                                                                                preciorecompensa1Proyecto03 = 0;
                                                                                preciorecompensa2Proyecto03 = 0;
                                                                                preciorecompensa3Proyecto03 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        break;
                                                                    default:
                                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                        }else System.out.println(amarillo +"Aún no hay proyectos creados, cuando lo estén podrás eliminarlos."+ colorNormal);
                                                        break;
                                                    case 4 :
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                }
                                            } while (opcion != 4);
                                        }
                                        break;
                                        case 3: {
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        ADMIN_USUARIO=cambiarUsuarioContrasena(ADMIN_CONTRASENA);
                                                        break;
                                                    case 2:
                                                        ADMIN_CONTRASENA=cambiarUsuarioContrasena(ADMIN_CONTRASENA);
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción Inválida." + colorNormal);
                                                }
                                            }while (opcion != 3) ;
                                        }
                                        break;
                                        case 4: {
                                            System.out.println("Cerrando sesión...");
                                            break;
                                        }
                                        default:
                                            System.out.println(amarillo + "Opción Inválida." + colorNormal);
                                    }
                                } while (opcion2 != 4);
                            } else if (gestor && !bloquearGestor) {
                                do{
                                    mostrarMenuGestor();
                                    menuGestor = leerInt();
                                    switch (menuGestor){
                                        case 1:
                                            do{
                                                mostrarMenuProyectosGestor();
                                                opcion = leerInt();
                                                switch(opcion){
                                                    case 1:
                                                        if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                            System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        }else{
                                                            do {
                                                                menuVerProyectos();
                                                                opcion = leerInt();
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else{
                                                                            mostrarResumenProyecto(nombreProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(nombreProyecto01,descProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01,fechaInicioProyecto01,fechaFinalProyecto01,recompensa1Proyecto01,preciorecompensa1Proyecto01,recompensa2Proyecto01,preciorecompensa2Proyecto01,recompensa3Proyecto01,preciorecompensa3Proyecto01);
                                                                            }else System.out.println("Opción inválida");
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            mostrarResumenProyecto(nombreProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(nombreProyecto02,descProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02,fechaInicioProyecto02,fechaFinalProyecto02,recompensa1Proyecto02,preciorecompensa1Proyecto02,recompensa2Proyecto02,preciorecompensa2Proyecto02,recompensa3Proyecto02,preciorecompensa3Proyecto02);
                                                                            } else {
                                                                                System.out.println("Opción inválida");
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            mostrarResumenProyecto(nombreProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03);
                                                                            String InvertirODetallada = leerString();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                mostrarProyecto(nombreProyecto03,descProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03,fechaInicioProyecto03,fechaFinalProyecto03,recompensa1Proyecto03,preciorecompensa1Proyecto03,recompensa2Proyecto03,preciorecompensa2Proyecto03,recompensa3Proyecto03,preciorecompensa3Proyecto03);
                                                                            } else {
                                                                                System.out.println(amarillo + "Opción inválida" + colorNormal);
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    default:
                                                                        System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                        }
                                                        break;
                                                    case 2:
                                                        do {
                                                            menuCrearProyectos();
                                                            opcion = leerInt();
                                                            switch(opcion){
                                                                case 1:
                                                                    do {
                                                                        System.out.println("Nombre:");
                                                                        nombreProyecto01 = s.nextLine();
                                                                        System.out.println("Descripción:");
                                                                        descProyecto01 = s.nextLine();
                                                                        System.out.println("Categoría:");
                                                                        categoriaProyecto01 = s.nextLine();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        cantNecesariaProyecto01 = Integer.parseInt(s.nextLine());
                                                                        System.out.println("Cantidad financiada:");
                                                                        cantFinanciadaProyecto01 = Integer.parseInt(s.nextLine());
                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                        fechaInicioProyecto01 = s.nextLine();
                                                                        System.out.println("Fecha de finalización de inversiones: ");
                                                                        fechaFinalProyecto01 = s.nextLine();
                                                                        if (cantNecesariaProyecto01<cantFinanciadaProyecto01) System.out.println("La cantidad necesaria tiene que ser mayor que la financiada.");
                                                                    }while (cantNecesariaProyecto01<cantFinanciadaProyecto01);
                                                                    do {
                                                                        menuCrearRecompensa();
                                                                        opcion = leerInt();
                                                                        switch(opcion){
                                                                            case 1:
                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                recompensa1Proyecto01 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                preciorecompensa1Proyecto01 = leerInt();
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                recompensa2Proyecto01 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                preciorecompensa2Proyecto01 = leerInt();
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                recompensa3Proyecto01 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                preciorecompensa3Proyecto01 = leerInt();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                        }
                                                                    }while(opcion != 4);
                                                                    break;
                                                                case 2:
                                                                    do {
                                                                        System.out.println("Nombre:");
                                                                        nombreProyecto02 = leerString();
                                                                        System.out.println("Descripción:");
                                                                        descProyecto02 = leerString();
                                                                        System.out.println("Categoría:");
                                                                        categoriaProyecto02 = leerString();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        cantNecesariaProyecto02 = leerInt();
                                                                        System.out.println("Cantidad financiada:");
                                                                        cantFinanciadaProyecto02 = leerInt();
                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                        fechaInicioProyecto02 = leerString();
                                                                        System.out.println("Fecha de finalización de inversiones: ");
                                                                        fechaFinalProyecto02 = leerString();
                                                                        if (cantNecesariaProyecto02 < cantFinanciadaProyecto02)
                                                                            System.out.println("La cantidad necesaria tiene que ser mayor que la financiada.");
                                                                    }while (cantNecesariaProyecto02<cantFinanciadaProyecto02);
                                                                    do {
                                                                        menuCrearRecompensa();
                                                                        opcion = leerInt();
                                                                        switch(opcion){
                                                                            case 1:
                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                recompensa1Proyecto02 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                preciorecompensa1Proyecto02 = leerInt();
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                recompensa2Proyecto02 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                preciorecompensa2Proyecto02 = leerInt();
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                recompensa3Proyecto02 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                preciorecompensa3Proyecto02 = leerInt();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                        }
                                                                    }while(opcion != 4);
                                                                    break;
                                                                case 3:
                                                                    do{
                                                                        System.out.println("Nombre:");
                                                                        nombreProyecto03 = leerString();
                                                                        System.out.println("Descripción:");
                                                                        descProyecto03 = leerString();
                                                                        System.out.println("Categoría:");
                                                                        categoriaProyecto03 = leerString();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        cantNecesariaProyecto03 = leerInt();
                                                                        System.out.println("Cantidad financiada:");
                                                                        cantFinanciadaProyecto03 = leerInt();
                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                        fechaInicioProyecto03 = leerString();
                                                                        System.out.println("Fecha de finalización de inversiones: ");
                                                                        fechaFinalProyecto03 = leerString();
                                                                        if (cantNecesariaProyecto03<cantFinanciadaProyecto03) System.out.println("La cantidad necesaria tiene que ser mayor que la financiada.");
                                                                    }while (cantNecesariaProyecto03<cantFinanciadaProyecto03);
                                                                    do {
                                                                        menuCrearRecompensa();
                                                                        opcion = leerInt();
                                                                        switch(opcion){
                                                                            case 1:
                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                recompensa1Proyecto03 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                preciorecompensa1Proyecto03 = leerInt();
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                recompensa2Proyecto03 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                preciorecompensa2Proyecto03 = leerInt();
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                recompensa3Proyecto03 = leerString();
                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                preciorecompensa3Proyecto03 = leerInt();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                        }
                                                                    }while(opcion != 4);
                                                                    break;
                                                                case 4:
                                                                    System.out.println("Saliendo...");
                                                                    break;
                                                            }
                                                        }while (opcion != 4);
                                                        break;
                                                    case 3:
                                                        if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                            System.out.println(amarillo +"Ningún proyecto ha sido creado aún, dile al gesto que cree un proyecto para modificarlo." + colorNormal);
                                                        }else{
                                                            do {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres cambiar? "+ morado +"|");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println(verde +"1." + colorNormal +"Primer proyecto.");
                                                                System.out.println(verde +"2." + colorNormal +"Segundo proyecto.");
                                                                System.out.println(verde +"3." + colorNormal +"Tercer proyecto.");
                                                                System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                opcion = leerInt();
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Nombre");
                                                                                System.out.println(verde +"2." + colorNormal +"Descripción.");
                                                                                System.out.println(verde +"3." + colorNormal +"Categoría.");
                                                                                System.out.println(verde +"4." + colorNormal +"Cantidad Necesaria.");
                                                                                System.out.println(verde +"5." + colorNormal +"Cantidad Financiada.");
                                                                                System.out.println(verde +"6." + colorNormal +"Fecha de Inicio de inversiones.");
                                                                                System.out.println(verde +"7." + colorNormal +"Fecha de finalización de inversiones.");
                                                                                System.out.println(verde +"8." + colorNormal +"Recompensas.");
                                                                                System.out.println(verde +"9." + colorNormal +"Volver.");
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto01 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto01 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto01 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto01 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto01 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto01 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto01 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                            System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                            System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                            System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                            System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                            System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto01 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto01 = leerInt();

                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto01 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto01 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                                default:
                                                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                                    break;
                                                                                            }
                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                        }
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Nombre");
                                                                                System.out.println(verde +"2." + colorNormal +"Descripción.");
                                                                                System.out.println(verde +"3." + colorNormal +"Categoría.");
                                                                                System.out.println(verde +"4." + colorNormal +"Cantidad Necesaria.");
                                                                                System.out.println(verde +"5." + colorNormal +"Cantidad Financiada.");
                                                                                System.out.println(verde +"6." + colorNormal +"Fecha de Inicio de inversiones.");
                                                                                System.out.println(verde +"7." + colorNormal +"Fecha de finalización de inversiones.");
                                                                                System.out.println(verde +"8." + colorNormal +"Recompensas.");
                                                                                System.out.println(verde +"9." + colorNormal +"Volver.");
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto02 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto02 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto02 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto02 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto02 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto02 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto02 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                            System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                            System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                            System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                            System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                            System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto02 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto02 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                            }

                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Nombre");
                                                                                System.out.println(verde +"2." + colorNormal +"Descripción.");
                                                                                System.out.println(verde +"3." + colorNormal +"Categoría.");
                                                                                System.out.println(verde +"4." + colorNormal +"Cantidad Necesaria.");
                                                                                System.out.println(verde +"5." + colorNormal +"Cantidad Financiada.");
                                                                                System.out.println(verde +"6." + colorNormal +"Fecha de Inicio de inversiones.");
                                                                                System.out.println(verde +"7." + colorNormal +"Fecha de finalización de inversiones.");
                                                                                System.out.println(verde +"8." + colorNormal +"Recompensas.");
                                                                                System.out.println(verde +"9." + colorNormal +"Volver.");
                                                                                opcion = leerInt();
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto03 = leerString();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto03 = leerString();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto03 = leerString();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto03 = leerInt();
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto03 = leerInt();
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto03 = leerString();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto03 = leerString();
                                                                                        break;
                                                                                    case 8:
                                                                                        do {
                                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                            System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                            System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                            System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                            System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                            System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                            opcion = leerInt();
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto03 = leerString();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto03 = leerInt();
                                                                                                    break;
                                                                                                case 4:
                                                                                                    System.out.println("Saliendo...");
                                                                                                    break;
                                                                                            }
                                                                                        }while(opcion != 4);
                                                                                        break;
                                                                                    case 9:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            } while (opcion != 9);
                                                                            break;
                                                                        }
                                                                    case 4:
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                            break;
                                                        }
                                                        break;
                                                    case 4:
                                                        if (!(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty())){
                                                            do {
                                                                menuEliminarProyectos();
                                                                opcion = leerInt();
                                                                switch (opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto01 + "? (s/n)");
                                                                            String eliminarProyecto1SiNo = leerString();
                                                                            if (eliminarProyecto1SiNo.equalsIgnoreCase("s")) {
                                                                                nombreProyecto01 = "";
                                                                                descProyecto01 = "";
                                                                                categoriaProyecto01 = "";
                                                                                cantNecesariaProyecto01 = 0;
                                                                                cantFinanciadaProyecto01 = 0;
                                                                                fechaFinalProyecto01 = "";
                                                                                fechaInicioProyecto01 = "";
                                                                                recompensa1Proyecto01 = "";
                                                                                recompensa2Proyecto01 = "";
                                                                                recompensa3Proyecto01 = "";
                                                                                preciorecompensa1Proyecto01 = 0;
                                                                                preciorecompensa2Proyecto01 = 0;
                                                                                preciorecompensa3Proyecto01 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (nombreProyecto02.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto02 + "? (s/n)");
                                                                            String eliminarProyecto2SiNo = leerString();
                                                                            if (eliminarProyecto2SiNo.equalsIgnoreCase("s")){
                                                                                nombreProyecto02 = "";
                                                                                descProyecto02 = "";
                                                                                categoriaProyecto02 = "";
                                                                                cantNecesariaProyecto02 = 0;
                                                                                cantFinanciadaProyecto02 = 0;
                                                                                fechaFinalProyecto02 = "";
                                                                                fechaInicioProyecto02 = "";
                                                                                recompensa1Proyecto02 = "";
                                                                                recompensa2Proyecto02 = "";
                                                                                recompensa3Proyecto02 = "";
                                                                                preciorecompensa1Proyecto02 = 0;
                                                                                preciorecompensa2Proyecto02 = 0;
                                                                                preciorecompensa3Proyecto02 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.isEmpty()){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto03 + "? (s/n)");
                                                                            String eliminarProyecto3SiNo = leerString();
                                                                            if (eliminarProyecto3SiNo.equalsIgnoreCase("s")) {
                                                                                nombreProyecto03 = "";
                                                                                descProyecto03 = "";
                                                                                categoriaProyecto03 = "";
                                                                                cantNecesariaProyecto03 = 0;
                                                                                cantFinanciadaProyecto03 = 0;
                                                                                fechaFinalProyecto03 = "";
                                                                                fechaInicioProyecto03 = "";
                                                                                recompensa1Proyecto03 = "";
                                                                                recompensa2Proyecto03 = "";
                                                                                recompensa3Proyecto03 = "";
                                                                                preciorecompensa1Proyecto03 = 0;
                                                                                preciorecompensa2Proyecto03 = 0;
                                                                                preciorecompensa3Proyecto03 = 0;
                                                                                System.out.println(verde + "Proyecto eliminado satisfactoriamente." + colorNormal);
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        break;
                                                                    default:
                                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                        break;
                                                                }
                                                            }while (opcion != 4);
                                                        }
                                                        break;
                                                    case 5:
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                        break;
                                                }
                                            }while(opcion != 5);
                                            break;
                                        case 2:
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        GESTOR_USUARIO=cambiarUsuarioContrasena(GESTOR_CONTRASENA);
                                                        break;
                                                    case 2:
                                                        GESTOR_CONTRASENA=cambiarUsuarioContrasena(GESTOR_CONTRASENA);
                                                        break;
                                                    case 3:
                                                        System.out.println("Volviendo al Menú Gestor...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                        break;
                                                }
                                            }while(opcion != 3);
                                            break;
                                        case 3:
                                            System.out.println("Cerrando sesión...");
                                            break;
                                        default:
                                            System.out.println(amarillo + "Opción inválida." + colorNormal);
                                            break;
                                    }
                                }while(menuGestor != 3);
                            } else if (inversor1 && !bloquearInversor1) {
                                do {
                                    menuInversor();
                                    opcion = leerInt();
                                    switch (opcion){
                                        case 1:
                                            if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                mostrarResumenProyecto(nombreProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    mostrarProyecto(nombreProyecto01,descProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01,fechaInicioProyecto01,fechaFinalProyecto01,recompensa1Proyecto01,preciorecompensa1Proyecto01,recompensa2Proyecto01,preciorecompensa2Proyecto01,recompensa3Proyecto01,preciorecompensa3Proyecto01);
                                                                } else if (InvertirODetallada.equals("y")){
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor1) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto01 - cantFinanciadaProyecto01)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor1 = carteraInversor1 - cantidadInvertir;
                                                                        cantFinanciadaProyecto01 += cantidadInvertir;
                                                                        cantidadInvertidaInversor1Proy01 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto02,descProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02,fechaInicioProyecto02,fechaFinalProyecto02,recompensa1Proyecto02,preciorecompensa1Proyecto02,recompensa2Proyecto02,preciorecompensa2Proyecto02,recompensa3Proyecto02,preciorecompensa3Proyecto02);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor1) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto02 - cantFinanciadaProyecto02)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor1 = carteraInversor1 - cantidadInvertir;
                                                                        cantFinanciadaProyecto02 += cantidadInvertir;
                                                                        cantidadInvertidaInversor1Proy02 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto03,descProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03,fechaInicioProyecto03,fechaFinalProyecto03,recompensa1Proyecto03,preciorecompensa1Proyecto03,recompensa2Proyecto03,preciorecompensa2Proyecto03,recompensa3Proyecto03,preciorecompensa3Proyecto03);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor1) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto03 - cantFinanciadaProyecto03)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor1 = carteraInversor1 - cantidadInvertir;
                                                                        cantFinanciadaProyecto03 += cantidadInvertir;
                                                                        cantidadInvertidaInversor1Proy03 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                }while (opcion != 4);
                                            }
                                            break;
                                        case 2:
                                            if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                               mostrarResumenProyecto(nombreProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    mostrarProyecto(nombreProyecto01,descProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01,fechaInicioProyecto01,fechaFinalProyecto01,recompensa1Proyecto01,preciorecompensa1Proyecto01,recompensa2Proyecto01,preciorecompensa2Proyecto01,recompensa3Proyecto01,preciorecompensa3Proyecto01);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto02,descProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02,fechaInicioProyecto02,fechaFinalProyecto02,recompensa1Proyecto02,preciorecompensa1Proyecto02,recompensa2Proyecto02,preciorecompensa2Proyecto02,recompensa3Proyecto02,preciorecompensa3Proyecto02);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto03,descProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03,fechaInicioProyecto03,fechaFinalProyecto03,recompensa1Proyecto03,preciorecompensa1Proyecto03,recompensa2Proyecto03,preciorecompensa2Proyecto03,recompensa3Proyecto03,preciorecompensa3Proyecto03);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                }while (opcion != 4);
                                            }
                                            break;
                                        case 3:
                                            do {
                                                menuCarteraDigital();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        System.out.println(carteraInversor1);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = leerInt();
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
                                            do {
                                                menuInvitarAmigos();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (amigosReferidos.isEmpty()) {
                                                            System.out.println(amarillo + "Aún no has invitado a ningún amigo." + colorNormal);
                                                        } else {
                                                            System.out.println("Amigos referidos: " + amigosReferidos);
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Introduce el correo electrónico del amigo: ");
                                                        String nuevoAmigo = leerString();
                                                        if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                            System.out.println(amarillo + "El correo introducido no es válido." + colorNormal);
                                                        } else {
                                                            if (amigosReferidos.isEmpty()) {
                                                                amigosReferidos = nuevoAmigo;
                                                            } else {
                                                                amigosReferidos += ", " + nuevoAmigo;
                                                            }
                                                            System.out.println(cyan + "Amigo añadido correctamente." + colorNormal);
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo del menú Invitar Amigos.");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción no válida, inténtalo de nuevo." + colorNormal);
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 5:
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                switch (opcion){
                                                    case 1:
                                                        INVERSOR1_USUARIO=cambiarUsuarioContrasena(INVERSOR1_CONTRASENA);
                                                        break;
                                                    case 2:
                                                        INVERSOR1_CONTRASENA=cambiarUsuarioContrasena(INVERSOR1_CONTRASENA);
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
                            } else if (inversor2 && !bloquearInversor2) {
                                do {
                                    menuInversor();
                                    opcion = leerInt();
                                    switch (opcion) {
                                        case 1:
                                            if (nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()) {
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            } else {
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion) {
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto01,descProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01,fechaInicioProyecto01,fechaFinalProyecto01,recompensa1Proyecto01,preciorecompensa1Proyecto01,recompensa2Proyecto01,preciorecompensa2Proyecto01,recompensa3Proyecto01,preciorecompensa3Proyecto01);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor2) {
                                                                        System.out.println(amarillo + "No tienes suficiente saldo en tu cartera" + colorNormal);
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto01 - cantFinanciadaProyecto01)) {
                                                                        System.out.println(amarillo +"Cantidad Invertida mayor a la necesaria." + colorNormal);
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor2 = carteraInversor2 - cantidadInvertir;
                                                                        cantFinanciadaProyecto01 += cantidadInvertir;
                                                                        cantidadInvertidaInversor2Proy01 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto02,descProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02,fechaInicioProyecto02,fechaFinalProyecto02,recompensa1Proyecto02,preciorecompensa1Proyecto02,recompensa2Proyecto02,preciorecompensa2Proyecto02,recompensa3Proyecto02,preciorecompensa3Proyecto02);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor2) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto02 - cantFinanciadaProyecto02)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor2 = carteraInversor2 - cantidadInvertir;
                                                                        cantFinanciadaProyecto02 += cantidadInvertir;
                                                                        cantidadInvertidaInversor2Proy02 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03);
                                                                System.out.println("Para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto03,descProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03,fechaInicioProyecto03,fechaFinalProyecto03,recompensa1Proyecto03,preciorecompensa1Proyecto03,recompensa2Proyecto03,preciorecompensa2Proyecto03,recompensa3Proyecto03,preciorecompensa3Proyecto03);
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = leerInt();
                                                                    if (cantidadInvertir > carteraInversor2) {
                                                                        System.out.println("No tienes suficiente saldo en tu cartera");
                                                                    } else if (cantidadInvertir > (cantNecesariaProyecto03 - cantFinanciadaProyecto03)) {
                                                                        System.out.println("Cantidad Invertida mayor a la necesaria.");
                                                                    } else if (cantidadInvertir <= 0) {
                                                                        System.out.println("Introduce una cantidad mayor a 0.");
                                                                    } else {
                                                                        System.out.println("Has invertido " + cantidadInvertir + " euros.");
                                                                        carteraInversor2 = carteraInversor2 - cantidadInvertir;
                                                                        cantFinanciadaProyecto03 += cantidadInvertir;
                                                                        cantidadInvertidaInversor2Proy03 += cantidadInvertir;
                                                                    }
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                } while (opcion != 4);
                                            }
                                        case 2:
                                            if(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty()){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    menuVerProyectos();
                                                    opcion = leerInt();
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.isEmpty()){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                mostrarResumenProyecto(nombreProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    mostrarProyecto(nombreProyecto01,descProyecto01,categoriaProyecto01,cantNecesariaProyecto01,cantFinanciadaProyecto01,fechaInicioProyecto01,fechaFinalProyecto01,recompensa1Proyecto01,preciorecompensa1Proyecto01,recompensa2Proyecto01,preciorecompensa2Proyecto01,recompensa3Proyecto01,preciorecompensa3Proyecto01);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto02,descProyecto02,categoriaProyecto02,cantNecesariaProyecto02,cantFinanciadaProyecto02,fechaInicioProyecto02,fechaFinalProyecto02,recompensa1Proyecto02,preciorecompensa1Proyecto02,recompensa2Proyecto02,preciorecompensa2Proyecto02,recompensa3Proyecto02,preciorecompensa3Proyecto02);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.isEmpty()) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                mostrarResumenProyecto(nombreProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03);
                                                                String InvertirODetallada = leerString();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    mostrarProyecto(nombreProyecto03,descProyecto03,categoriaProyecto03,cantNecesariaProyecto03,cantFinanciadaProyecto03,fechaInicioProyecto03,fechaFinalProyecto03,recompensa1Proyecto03,preciorecompensa1Proyecto03,recompensa2Proyecto03,preciorecompensa2Proyecto03,recompensa3Proyecto03,preciorecompensa3Proyecto03);
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 4:
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        default:
                                                            System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                    }
                                                }while (opcion != 4);
                                            }
                                            break;
                                        case 3:
                                            do {
                                                menuCarteraDigital();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        System.out.println(carteraInversor2);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = leerInt();
                                                            if (dineroAnadido < 0)
                                                                System.out.println("La cantidad añadida debe ser mayor a 0");
                                                            else carteraInversor2 += dineroAnadido;
                                                        } while (dineroAnadido <= 0);
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo");
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 4:
                                            do {
                                                menuInvitarAmigos();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        if (amigosReferidos.isEmpty()) {
                                                            System.out.println(amarillo + "Aún no has invitado a ningún amigo." + colorNormal);
                                                        } else {
                                                            System.out.println("Amigos referidos: " + amigosReferidos);
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Introduce el correo electrónico del amigo: ");
                                                        String nuevoAmigo = leerString();
                                                        if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                            System.out.println(amarillo + "El correo introducido no es válido." + colorNormal);
                                                        } else {
                                                            if (amigosReferidos.isEmpty()) {
                                                                amigosReferidos = nuevoAmigo;
                                                            } else {
                                                                amigosReferidos += ", " + nuevoAmigo;
                                                            }
                                                            System.out.println(cyan + "Amigo añadido correctamente." + colorNormal);
                                                        }
                                                        break;
                                                    case 3:
                                                        System.out.println("Saliendo del menú Invitar Amigos.");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción no válida, inténtalo de nuevo." + colorNormal);
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 5:
                                            do {
                                                menuConfiguracionUsuarioContrasena();
                                                opcion = leerInt();
                                                switch (opcion) {
                                                    case 1:
                                                        INVERSOR2_USUARIO=cambiarUsuarioContrasena(INVERSOR2_CONTRASENA);
                                                        break;
                                                    case 2:
                                                        INVERSOR2_CONTRASENA=cambiarUsuarioContrasena(INVERSOR2_CONTRASENA);
                                                        break;
                                                    case 3:
                                                        break;
                                                }
                                            } while (opcion != 3);
                                            break;
                                        case 6:
                                            System.out.println("Saliendo");
                                            break;
                                    }
                                } while (opcion != 6);
                            }
                        case 2: // se pone case 2 para que no salga el mensaje de default al pulsar 2
                            break;
                        default:
                            System.out.println("Vuelve a intentarlo");
                    }
                }while(opcion!=2);
            }
        }