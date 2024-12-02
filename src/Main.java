import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                String ADMIN_USUARIO = "admin", ADMIN_CONTRASENA = "adminpass", GESTOR_USUARIO = "gestor", GESTOR_CONTRASENA = "gestorpass",
                        INVERSOR1_USUARIO = "inversor1", INVERSOR1_CONTRASENA = "inversor1pass", INVERSOR2_USUARIO = "inversor2", INVERSOR2_CONTRASENA = "inversor2pass", usuario, contrasena, amigosReferidos="";
                int contadorFallosGestor = 0, contadorFallosInversor1 = 0, contadorFallosInversor2 = 0, contadorTotal = 0;
                boolean bloquearGestor = false, bloquearInversor1 = false, bloquearInversor2 = false, admin, gestor, inversor1, inversor2;
                int carteraInversor1 = 0, carteraInversor2 = 0, dineroAnadido, cantidadInvertir, cantidadInvertidaInversor1Proy01 = 0, cantidadInvertidaInversor1Proy02 = 0, cantidadInvertidaInversor1Proy03 = 0,
                        cantidadInvertidaInversor2Proy01 = 0, cantidadInvertidaInversor2Proy02 = 0, cantidadInvertidaInversor2Proy03 = 0;

                String  rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m",
                        morado = "\033[35m", cyan = "\033[36m", colorNormal = "\u001B[0m";


                int menuGestor, opcion, opcion2;

                // Información de proyectos
                String nombreProyecto01 = "d", nombreProyecto02 = "", nombreProyecto03 = "";
                String descProyecto01 = "", descProyecto02 = "", descProyecto03 = "";
                String categoriaProyecto01 = "", categoriaProyecto02 = "", categoriaProyecto03 = "";
                double cantNecesariaProyecto01 = 350, cantNecesariaProyecto02 = 0, cantNecesariaProyecto03 = 0;
                double cantFinanciadaProyecto01 = 147, cantFinanciadaProyecto02 = 0, cantFinanciadaProyecto03 = 0;

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

                // Gráfico de Barras
                int graficoBarrasProyecto01;
                int graficoBarrasProyecto02;
                int graficoBarrasProyecto03;
                int x, y;

                do {
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
                    opcion= Integer.parseInt(s.nextLine());
                    switch (opcion){
                        case 1:
                            do {
                                gestor = admin = inversor1 = inversor2 = false;
                                System.out.print("Usuario: ");
                                usuario = s.nextLine();
                                System.out.print("Contraseña: ");
                                contrasena = s.nextLine();
                                contadorTotal++;
                                // VALIDACIÓN DE GESTOR
                                if (usuario.equals(GESTOR_USUARIO)) {
                                    if (bloquearGestor) {
                                        System.out.println("El usuario " + GESTOR_USUARIO + " está " + rojo +"bloqueado." + colorNormal);
                                    } else if (contrasena.equals(GESTOR_CONTRASENA)) {
                                        System.out.println(verde +"Bienvenido " + GESTOR_USUARIO + colorNormal);
                                        gestor = true;
                                        contadorFallosGestor = 0;
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + " Vuelva a intentarlo.");
                                        contadorFallosGestor++;
                                        if (contadorFallosGestor > 2) {
                                            System.out.println("Usuario " + GESTOR_USUARIO + rojo +"bloqueado." + colorNormal);
                                            bloquearGestor = true;
                                        }
                                    }
                                }
                                // VALIDACIÓN DE INVERSOR1
                                if (usuario.equals(INVERSOR1_USUARIO)) {
                                    if (bloquearInversor1) {
                                        System.out.println("El usuario " + INVERSOR1_USUARIO + " está " + rojo +"bloqueado." + colorNormal);
                                    } else if (contrasena.equals(INVERSOR1_CONTRASENA)) {
                                        System.out.println(verde +"Bienvenido " + INVERSOR1_USUARIO + colorNormal);
                                        inversor1 = true;
                                        contadorFallosInversor1 = 0;
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + ". Vuelva a intentarlo.");
                                        contadorFallosInversor1++;
                                        if (contadorFallosInversor1 > 2) {
                                            System.out.println("Usuario " + INVERSOR1_USUARIO + rojo +"bloqueado." + colorNormal);
                                            bloquearInversor1 = true;
                                        }
                                    }
                                }
                                // VALIDACIÓN DE INVERSOR2
                                if (usuario.equals(INVERSOR2_USUARIO)) {
                                    if (bloquearInversor2) {
                                        System.out.println("El usuario " + INVERSOR2_USUARIO + " está " + rojo + "bloqueado." + colorNormal);
                                    } else if (contrasena.equals(INVERSOR2_CONTRASENA)) {
                                        System.out.println(verde +"Bienvenido " + INVERSOR2_USUARIO + colorNormal);
                                        inversor2 = true;
                                        contadorFallosInversor2 = 0;
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + " Vuelva a intentarlo.");
                                        contadorFallosInversor2++;
                                        if (contadorFallosInversor2 > 2) {
                                            System.out.println("Usuario " + INVERSOR2_USUARIO + rojo +"bloqueado." + colorNormal);
                                            bloquearInversor2 = true;
                                        }
                                    }
                                }
                                // VALIDACIÓN DE ADMIN
                                if (usuario.equals(ADMIN_USUARIO)) {
                                    if (contrasena.equals(ADMIN_CONTRASENA)) {
                                        System.out.println(verde +"Bienvenido " + ADMIN_USUARIO + colorNormal);
                                        admin = true;
                                    } else {
                                        System.out.println("Contraseña " + rojo + "incorrecta" + colorNormal + " Vuelva a intentarlo.");
                                    }
                                }
                                if (contadorTotal == 3 && !gestor && !inversor1 && !inversor2 && !admin) {
                                    System.out.println(amarillo + "Se han agotado los intentos permitidos. Inténtelo de nuevo." + colorNormal);
                                    contadorTotal = 0;
                                }
                            } while (!gestor && !inversor1 && !inversor2 && !admin);
                            if (admin){
                                do {
                                    System.out.println(morado +"╭ ──────┉──────"+ amarillo +" • "+ morado +"──────┉────── ╮");
                                    System.out.println(verde +"  ┈ ⋞ 〈 "+ azul +"MENÚ ADMINISTRADOR"+ verde +" 〉 ⋟ ┈");
                                    System.out.println(morado +"╰ ──────┉──────"+ amarillo +" • "+ morado +"──────┉────── ╯"+ colorNormal);
                                    System.out.println(verde +"1." + cyan +"Panel de control");
                                    System.out.println(verde +"2." + cyan +"Proyectos");
                                    System.out.println(verde +"3." + cyan +"Configuración");
                                    System.out.println(verde +"4." + cyan +"Cerrar sesión" + colorNormal);
                                    opcion2 = Integer.parseInt(s.nextLine());
                                    switch (opcion2) {
                                        case 1: {
                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                            System.out.println(        "| "+ verde +"      Has ingresado"+ morado +"        |");
                                            System.out.println(        "| "+ azul +"   al Panel de Control"+ morado +"     |");
                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                            System.out.println("Opciones de " + rojo +"bloquear" + azul + "/" + verde +"desbloquear" + colorNormal +" al usuario:");
                                            do {
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ rojo +"   Bloquear" + azul + "/" + verde + "Desbloquear"+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1." + colorNormal +" Usuario " + GESTOR_USUARIO);
                                                System.out.println(verde +"2." + colorNormal +" Usuario " + INVERSOR1_USUARIO);
                                                System.out.println(verde +"3." + colorNormal +" Usuario " + INVERSOR2_USUARIO);
                                                System.out.println(verde +"4." + colorNormal +" Volver al menu Administrador" + colorNormal);
                                                opcion = Integer.parseInt(s.nextLine());
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ verde +"    Proyectos"+ morado +"     |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1." + colorNormal + "Ver Proyectos");
                                                System.out.println(verde +"2." + colorNormal + "Modificar Proyectos");
                                                System.out.println(verde +"3." + colorNormal + "Eliminar Proyectos");
                                                System.out.println(verde +"4." + colorNormal + "Volver al Menú Administrador");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion){
                                                    case 1:
                                                        if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                            System.out.println( amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        }else{
                                                            do {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres ver? "+ morado +" |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                                System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                                System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                                System.out.println(verde +"4." + colorNormal + "Volver.");
                                                                opcion = Integer.parseInt(s.nextLine());
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else{
                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                            System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                            System.out.println("Nombre: " + nombreProyecto01);
                                                                            System.out.println("Categoría: " + categoriaProyecto01);
                                                                            System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                            System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                            System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                            String InvertirODetallada = s.nextLine();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println("Nombre: " + nombreProyecto01);
                                                                                System.out.println("Descripción: " + descProyecto01);
                                                                                System.out.println("Categoría: " + categoriaProyecto01);
                                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                                System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto01);
                                                                                System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto01);
                                                                                System.out.println("Recompensas: ");
                                                                                System.out.println("Recompensa 1: " + recompensa1Proyecto01);
                                                                                System.out.println("Precio: " + preciorecompensa1Proyecto01 + "€");
                                                                                System.out.println("Recompensa 2: " + recompensa2Proyecto01);
                                                                                System.out.println("Precio: " + preciorecompensa2Proyecto01 + "€");
                                                                                System.out.println("Recompensa 3: " + recompensa3Proyecto01);
                                                                                System.out.println("Precio: " + preciorecompensa3Proyecto01 + "€");
                                                                                System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                                                                                        verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                                        "░ : Parte por financiar.");
                                                                                graficoBarrasProyecto01 = (int) ((cantFinanciadaProyecto01 * 100) / cantNecesariaProyecto01);
                                                                                System.out.print("[");
                                                                                for (x = 0; x != graficoBarrasProyecto01; x++) {
                                                                                    System.out.print(verde + "▓" + colorNormal);
                                                                                }
                                                                                if (0 != 100 - graficoBarrasProyecto01) {
                                                                                    for (y = 0; y != 100 - graficoBarrasProyecto01; y++) {
                                                                                        System.out.print("░");
                                                                                    }
                                                                                }
                                                                                System.out.print("]" + x + "%");
                                                                                System.out.println();
                                                                            }else System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (nombreProyecto02.equals("")) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                            System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                            System.out.println("Nombre: " + nombreProyecto02);
                                                                            System.out.println("Categoría: " + categoriaProyecto02);
                                                                            System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                            System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                            System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                            String InvertirODetallada = s.nextLine();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println("Nombre: " + nombreProyecto02);
                                                                                System.out.println("Descripción: " + descProyecto02);
                                                                                System.out.println("Categoría: " + categoriaProyecto02);
                                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                                System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto02);
                                                                                System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto02);
                                                                                System.out.println("Recompensas: ");
                                                                                System.out.println("Recompensa 1: " + recompensa1Proyecto02);
                                                                                System.out.println("Precio: " + preciorecompensa1Proyecto02 + "€");
                                                                                System.out.println("Recompensa 2: " + recompensa2Proyecto02);
                                                                                System.out.println("Precio: " + preciorecompensa2Proyecto02 + "€");
                                                                                System.out.println("Recompensa 3: " + recompensa3Proyecto02);
                                                                                System.out.println("Precio: " + preciorecompensa3Proyecto02 + "€");
                                                                                System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                                        verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                                        "░ : Parte por financiar.");
                                                                                graficoBarrasProyecto02 = (int) ((cantFinanciadaProyecto02 * 100) / cantNecesariaProyecto02);
                                                                                System.out.print("[");
                                                                                for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                                    System.out.print(verde + "▓" + colorNormal);
                                                                                }
                                                                                if (0 != 100 - graficoBarrasProyecto02) {
                                                                                    for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                                        System.out.print("░");
                                                                                    }
                                                                                }
                                                                                System.out.print("]" + x + "%");
                                                                                System.out.println();
                                                                            } else {
                                                                                System.out.println(amarillo + "Opción inválida" + colorNormal);
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.equals("")) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún." + colorNormal);
                                                                        } else {
                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                            System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                            System.out.println("Nombre: " + nombreProyecto03);
                                                                            System.out.println("Categoría: " + categoriaProyecto03);
                                                                            System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                            System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                            System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                            String InvertirODetallada = s.nextLine();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println("Nombre: " + nombreProyecto03);
                                                                                System.out.println("Descripción: " + descProyecto03);
                                                                                System.out.println("Categoría: " + categoriaProyecto03);
                                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                                System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto03);
                                                                                System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto03);
                                                                                System.out.println("Recompensas: ");
                                                                                System.out.println("Recompensa 1: " + recompensa1Proyecto03);
                                                                                System.out.println("Precio: " + preciorecompensa1Proyecto03 + "€");
                                                                                System.out.println("Recompensa 2: " + recompensa2Proyecto03);
                                                                                System.out.println("Precio: " + preciorecompensa2Proyecto03 + "€");
                                                                                System.out.println("Recompensa 3: " + recompensa3Proyecto03);
                                                                                System.out.println("Precio: " + preciorecompensa3Proyecto03 + "€");
                                                                                System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                                        verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                                        "░ : Parte por financiar.");
                                                                                graficoBarrasProyecto03 = (int) ((cantFinanciadaProyecto03 * 100) / cantNecesariaProyecto03);
                                                                                System.out.print("[");
                                                                                for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                                    System.out.print(verde + "▓" + colorNormal);
                                                                                }
                                                                                if (0 != 100 - graficoBarrasProyecto03) {
                                                                                    for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                                        System.out.print("░");
                                                                                    }
                                                                                }
                                                                                System.out.print("]" + x + "%");
                                                                                System.out.println();
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
                                                        if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
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
                                                                opcion = Integer.parseInt(s.nextLine());
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.equals("")){
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
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto01 = s.nextLine();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto01 = s.nextLine();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto01 = s.nextLine();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto01 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto01 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto01 = s.nextLine();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto01 = s.nextLine();
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
                                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto01 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto01 = Integer.parseInt(s.nextLine());
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto01 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto01 = Integer.parseInt(s.nextLine());

                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto01 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto01 = Integer.parseInt(s.nextLine());
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
                                                                        if (nombreProyecto02.equals("")){
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
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto02 = s.nextLine();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto02 = s.nextLine();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto02 = s.nextLine();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto02 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto02 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto02 = s.nextLine();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto02 = s.nextLine();
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
                                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto02 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto02 = Integer.parseInt(s.nextLine());
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto02 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto02 = Integer.parseInt(s.nextLine());
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto02 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto02 = Integer.parseInt(s.nextLine());
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
                                                                        if (nombreProyecto03.equals("")){
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
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                switch (opcion) {
                                                                                    case 1:
                                                                                        System.out.println("Nombre:");
                                                                                        nombreProyecto03 = s.nextLine();
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Descripción:");
                                                                                        descProyecto03 = s.nextLine();
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Categoría:");
                                                                                        categoriaProyecto03 = s.nextLine();
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Cantidad Necesaria:");
                                                                                        cantNecesariaProyecto03 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 5:
                                                                                        System.out.println("Cantidad Financiada:");
                                                                                        cantFinanciadaProyecto03 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 6:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaInicioProyecto03 = s.nextLine();
                                                                                        break;
                                                                                    case 7:
                                                                                        System.out.println("Fecha de Inicio de inversiones:");
                                                                                        fechaFinalProyecto03 = s.nextLine();
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
                                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                                            switch(opcion){
                                                                                                case 1:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                                    recompensa1Proyecto03 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 1:");
                                                                                                    preciorecompensa1Proyecto03 = Integer.parseInt(s.nextLine());
                                                                                                    break;
                                                                                                case 2:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                                    recompensa2Proyecto03 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 2:");
                                                                                                    preciorecompensa2Proyecto03 = Integer.parseInt(s.nextLine());
                                                                                                    break;
                                                                                                case 3:
                                                                                                    System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                                    recompensa3Proyecto03 = s.nextLine();
                                                                                                    System.out.println("Escriba el precio de la recompensa 3:");
                                                                                                    preciorecompensa3Proyecto03 = Integer.parseInt(s.nextLine());
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
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres eliminar? "+ morado +"|");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                                System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                                System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                                System.out.println(verde +"4." + colorNormal + "Volver.");
                                                                opcion = Integer.parseInt(s.nextLine());
                                                                switch (opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto01 + "? (s/n)");
                                                                            String eliminarProyecto1SiNo = s.nextLine();
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
                                                                        if (nombreProyecto02.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto02 + "? (s/n)");
                                                                            String eliminarProyecto2SiNo = s.nextLine();
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
                                                                        if (nombreProyecto01.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto03 + "? (s/n)");
                                                                            String eliminarProyecto3SiNo = s.nextLine();
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"   Configuración"+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1."+ colorNormal +" Cambio de Usuario.");
                                                System.out.println(verde +"2."+ colorNormal +" Cambio de Contraseña.");
                                                System.out.println(verde +"3."+ colorNormal +" Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion) {
                                                    case 1:
                                                        System.out.print("Escribe la contraseña: ");
                                                        contrasena = s.nextLine();
                                                        if (contrasena.equals(ADMIN_CONTRASENA)){
                                                            System.out.print("Nuevo usuario: ");
                                                            ADMIN_USUARIO=s.nextLine();
                                                        }
                                                        else System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
                                                        break;
                                                    case 2:
                                                        System.out.print("Escribe la contraseña: ");
                                                        contrasena = s.nextLine();
                                                        if (contrasena.equals(ADMIN_CONTRASENA)){
                                                            System.out.print("Nueva contraseña: ");
                                                            ADMIN_CONTRASENA =s.nextLine();
                                                        }
                                                        else System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
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
                                    System.out.println(morado +"╭ ────┉────"+ amarillo +" • "+ morado +"────┉──── ╮");
                                    System.out.println(verde +" ┈ ⋞ 〈 "+ azul +"MENÚ GESTOR"+ verde +" 〉 ⋟ ┈");
                                    System.out.println(morado +"╰ ────┉────"+ amarillo +" • "+ morado +"────┉──── ╯"+ colorNormal);
                                    System.out.println(verde +"1."+ colorNormal +" Mis proyectos.");
                                    System.out.println(verde +"2."+ colorNormal +" Configuración.");
                                    System.out.println(verde +"3."+ colorNormal +" Cerrar sesión.");
                                    menuGestor = Integer.parseInt(s.nextLine());
                                    switch (menuGestor){
                                        case 1:
                                            do{
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ verde +"    Proyectos"+ morado +"     |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1." + colorNormal + "Ver Proyectos.");
                                                System.out.println(verde +"2." + colorNormal + "Modificar Proyectos.");
                                                System.out.println(verde +"3." + colorNormal + "Eliminar Proyectos.");
                                                System.out.println(verde +"4." + colorNormal + "Volver al Menú Gestor.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch(opcion){
                                                    case 1:
                                                        if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                            System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                                        }else{
                                                            do {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres ver? "+ morado +" |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                                System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                                System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                                System.out.println(verde +"4." + colorNormal + "Volver.");
                                                                opcion = Integer.parseInt(s.nextLine());
                                                                switch(opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else{
                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                            System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                            System.out.println("Nombre: " + nombreProyecto01);
                                                                            System.out.println("Categoría: " + categoriaProyecto01);
                                                                            System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                            System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                            System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                            String InvertirODetallada = s.nextLine();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println("Nombre: " + nombreProyecto01);
                                                                                System.out.println("Descripción: " + descProyecto01);
                                                                                System.out.println("Categoría: " + categoriaProyecto01);
                                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                                System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto01);
                                                                                System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto01);
                                                                                System.out.println("Recompensas: ");
                                                                                System.out.println("Recompensa 1: " + recompensa1Proyecto01);
                                                                                System.out.println("Precio: " + preciorecompensa1Proyecto01 + "€");
                                                                                System.out.println("Recompensa 2: " + recompensa2Proyecto01);
                                                                                System.out.println("Precio: " + preciorecompensa2Proyecto01 + "€");
                                                                                System.out.println("Recompensa 3: " + recompensa3Proyecto01);
                                                                                System.out.println("Precio: " + preciorecompensa3Proyecto01 + "€");
                                                                                System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                                                                                        verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                                        "░ : Parte por financiar.");
                                                                                graficoBarrasProyecto01 = (int) ((cantFinanciadaProyecto01 * 100) / cantNecesariaProyecto01);
                                                                                System.out.print("[");
                                                                                for (x = 0; x != graficoBarrasProyecto01; x++) {
                                                                                    System.out.print(verde + "▓" + colorNormal);
                                                                                }
                                                                                if (0 != 100 - graficoBarrasProyecto01) {
                                                                                    for (y = 0; y != 100 - graficoBarrasProyecto01; y++) {
                                                                                        System.out.print("░");
                                                                                    }
                                                                                }
                                                                                System.out.print("]" + x + "%");
                                                                                System.out.println();
                                                                            }else System.out.println("Opción inválida");
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (nombreProyecto02.equals("")) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                            System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                            System.out.println("Nombre: " + nombreProyecto02);
                                                                            System.out.println("Categoría: " + categoriaProyecto02);
                                                                            System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                            System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                            System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                            String InvertirODetallada = s.nextLine();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println("Nombre: " + nombreProyecto02);
                                                                                System.out.println("Descripción: " + descProyecto02);
                                                                                System.out.println("Categoría: " + categoriaProyecto02);
                                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                                System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto02);
                                                                                System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto02);
                                                                                System.out.println("Recompensas: ");
                                                                                System.out.println("Recompensa 1: " + recompensa1Proyecto02);
                                                                                System.out.println("Precio: " + preciorecompensa1Proyecto02 + "€");
                                                                                System.out.println("Recompensa 2: " + recompensa2Proyecto02);
                                                                                System.out.println("Precio: " + preciorecompensa2Proyecto02 + "€");
                                                                                System.out.println("Recompensa 3: " + recompensa3Proyecto02);
                                                                                System.out.println("Precio: " + preciorecompensa3Proyecto02 + "€");
                                                                                System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                                        verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                                        "░ : Parte por financiar.");
                                                                                graficoBarrasProyecto02 = (int) ((cantFinanciadaProyecto02 * 100) / cantNecesariaProyecto02);
                                                                                System.out.print("[");
                                                                                for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                                    System.out.print(verde + "▓" + colorNormal);
                                                                                }
                                                                                if (0 != 100 - graficoBarrasProyecto02) {
                                                                                    for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                                        System.out.print("░");
                                                                                    }
                                                                                }
                                                                                System.out.print("]" + x + "%");
                                                                                System.out.println();
                                                                            } else {
                                                                                System.out.println("Opción inválida");
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (nombreProyecto03.equals("")) {
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                            System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                            System.out.println("Nombre: " + nombreProyecto03);
                                                                            System.out.println("Categoría: " + categoriaProyecto03);
                                                                            System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                            System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                            System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                            String InvertirODetallada = s.nextLine();
                                                                            if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println("Nombre: " + nombreProyecto03);
                                                                                System.out.println("Descripción: " + descProyecto03);
                                                                                System.out.println("Categoría: " + categoriaProyecto03);
                                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                                System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto03);
                                                                                System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto03);
                                                                                System.out.println("Recompensas: ");
                                                                                System.out.println("Recompensa 1: " + recompensa1Proyecto03);
                                                                                System.out.println("Precio: " + preciorecompensa1Proyecto03 + "€");
                                                                                System.out.println("Recompensa 2: " + recompensa2Proyecto03);
                                                                                System.out.println("Precio: " + preciorecompensa2Proyecto03 + "€");
                                                                                System.out.println("Recompensa 3: " + recompensa3Proyecto03);
                                                                                System.out.println("Precio: " + preciorecompensa3Proyecto03 + "€");
                                                                                System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                                        verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                                        "░ : Parte por financiar.");
                                                                                graficoBarrasProyecto03 = (int) ((cantFinanciadaProyecto03 * 100) / cantNecesariaProyecto03);
                                                                                System.out.print("[");
                                                                                for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                                    System.out.print(verde + "▓" + colorNormal);
                                                                                }
                                                                                if (0 != 100 - graficoBarrasProyecto03) {
                                                                                    for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                                        System.out.print("░");
                                                                                    }
                                                                                }
                                                                                System.out.print("]" + x + "%");
                                                                                System.out.println();
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
                                                            System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                            System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres cambiar? "+ morado +"|");
                                                            System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                            System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                            System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                            System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                            System.out.println(verde +"4." + colorNormal + "Volver.");
                                                            opcion = Integer.parseInt(s.nextLine());
                                                            switch(opcion){
                                                                case 1:
                                                                    System.out.println("Nombre:");
                                                                    nombreProyecto01 = s.nextLine();
                                                                    if (nombreProyecto01.equals("")){
                                                                        System.out.println(amarillo + "Para crear un proyecto DEBES ponerle nombre." + colorNormal);
                                                                        break;
                                                                    } else {
                                                                        System.out.println("Descripción:");
                                                                        descProyecto01 = s.nextLine();
                                                                        System.out.println("Categoría:");
                                                                        categoriaProyecto01 = s.nextLine();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        cantNecesariaProyecto01 = Integer.parseInt(s.nextLine());
                                                                        System.out.println("Cantidad financiada:");
                                                                        cantFinanciadaProyecto01 = Integer.parseInt(s.nextLine());
                                                                        if (cantNecesariaProyecto01 >= cantFinanciadaProyecto01){
                                                                            System.out.println("Fecha de Inicio de inversiones:");
                                                                            fechaInicioProyecto01 = s.nextLine();
                                                                            System.out.println("Fecha de finalización de inversiones: ");
                                                                            fechaFinalProyecto01 = s.nextLine();
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                System.out.println(verde +"1." + colorNormal +"Recompensa 1.");
                                                                                System.out.println(verde +"2." + colorNormal +"Recompensa 2.");
                                                                                System.out.println(verde +"3." + colorNormal +"Recompensa 3.");
                                                                                System.out.println(verde +"4." + colorNormal +"Volver.");
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                switch(opcion){
                                                                                    case 1:
                                                                                        System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                        recompensa1Proyecto01 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 1:");
                                                                                        preciorecompensa1Proyecto01 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                        recompensa2Proyecto01 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 2:");
                                                                                        preciorecompensa2Proyecto01 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                        recompensa3Proyecto01 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 3:");
                                                                                        preciorecompensa3Proyecto01 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                    default:
                                                                                        System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                                        break;
                                                                                }
                                                                            }while(opcion != 4);
                                                                        } else {
                                                                            System.out.println(amarillo + "La cantidad financiada debe ser menor o igual que la cantidad necesaria." + colorNormal);
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    System.out.println("Nombre:");
                                                                    nombreProyecto02 = s.nextLine();
                                                                    if (nombreProyecto02.equals("")){
                                                                        System.out.println(amarillo + "Para crear un proyecto DEBES ponerle nombre." + colorNormal);
                                                                        break;
                                                                    } else {
                                                                        System.out.println("Descripción:");
                                                                        descProyecto02 = s.nextLine();
                                                                        System.out.println("Categoría:");
                                                                        categoriaProyecto02 = s.nextLine();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        cantNecesariaProyecto02 = Integer.parseInt(s.nextLine());
                                                                        System.out.println("Cantidad financiada:");
                                                                        cantFinanciadaProyecto02 = Integer.parseInt(s.nextLine());
                                                                        if (cantNecesariaProyecto02 >= cantFinanciadaProyecto02){
                                                                            System.out.println("Fecha de Inicio de inversiones:");
                                                                            fechaInicioProyecto02 = s.nextLine();
                                                                            System.out.println("Fecha de finalización de inversiones: ");
                                                                            fechaFinalProyecto02 = s.nextLine();
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                switch(opcion){
                                                                                    case 1:
                                                                                        System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                        recompensa1Proyecto02 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 1:");
                                                                                        preciorecompensa1Proyecto02 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                        recompensa2Proyecto02 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 2:");
                                                                                        preciorecompensa2Proyecto02 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                        recompensa3Proyecto02 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 3:");
                                                                                        preciorecompensa3Proyecto02 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            }while(opcion != 4);
                                                                        } else {
                                                                            System.out.println(amarillo + "La cantidad financiada debe ser menor o igual que la cantidad necesaria." + colorNormal);
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    System.out.println("Nombre:");
                                                                    nombreProyecto03 = s.nextLine();
                                                                    if (nombreProyecto03.equals("")){
                                                                        System.out.println(amarillo + "Para crear un proyecto DEBES ponerle nombre." + colorNormal);
                                                                        break;
                                                                    } else {
                                                                        System.out.println("Descripción:");
                                                                        descProyecto03 = s.nextLine();
                                                                        System.out.println("Categoría:");
                                                                        categoriaProyecto03 = s.nextLine();
                                                                        System.out.println("Cantidad necesaria:");
                                                                        cantNecesariaProyecto03 = Integer.parseInt(s.nextLine());
                                                                        System.out.println("Cantidad financiada:");
                                                                        cantFinanciadaProyecto03 = Integer.parseInt(s.nextLine());
                                                                        if (cantNecesariaProyecto03 >= cantFinanciadaProyecto03){
                                                                            System.out.println("Fecha de Inicio de inversiones:");
                                                                            fechaInicioProyecto03 = s.nextLine();
                                                                            System.out.println("Fecha de finalización de inversiones: ");
                                                                            fechaFinalProyecto03 = s.nextLine();
                                                                            do {
                                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                                System.out.println(        "| "+ amarillo +" ¿Qué recompensa quieres cambiar? "+ morado +" |");
                                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                switch(opcion){
                                                                                    case 1:
                                                                                        System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                        recompensa1Proyecto03 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 1:");
                                                                                        preciorecompensa1Proyecto03 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 2:
                                                                                        System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                        recompensa2Proyecto03 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 2:");
                                                                                        preciorecompensa2Proyecto03 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 3:
                                                                                        System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                        recompensa3Proyecto03 = s.nextLine();
                                                                                        System.out.println("Escriba el precio de la recompensa 3:");
                                                                                        preciorecompensa3Proyecto03 = Integer.parseInt(s.nextLine());
                                                                                        break;
                                                                                    case 4:
                                                                                        System.out.println("Saliendo...");
                                                                                        break;
                                                                                }
                                                                            }while(opcion != 4);
                                                                        } else {
                                                                            System.out.println(amarillo + "La cantidad financiada debe ser menor o igual que la cantidad necesaria." + colorNormal);
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                                case 4:
                                                                    System.out.println("Saliendo...");
                                                                    break;
                                                                default:
                                                                    System.out.println("Elección no existente.");
                                                            }
                                                        }while (opcion != 4);
                                                        break;
                                                    case 3:
                                                        if (!(nombreProyecto01.isEmpty() && nombreProyecto02.isEmpty() && nombreProyecto03.isEmpty())){
                                                            do {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres eliminar? "+ morado +"|");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                                System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                                System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                                System.out.println(verde +"4." + colorNormal + "Volver.");
                                                                opcion = Integer.parseInt(s.nextLine());
                                                                switch (opcion){
                                                                    case 1:
                                                                        if (nombreProyecto01.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto01 + "? (s/n)");
                                                                            String eliminarProyecto1SiNo = s.nextLine();
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
                                                                        if (nombreProyecto02.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto02 + "? (s/n)");
                                                                            String eliminarProyecto2SiNo = s.nextLine();
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
                                                                        if (nombreProyecto01.equals("")){
                                                                            System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                                        } else {
                                                                            System.out.println("¿Quieres eliminar el proyecto " + nombreProyecto03 + "? (s/n)");
                                                                            String eliminarProyecto3SiNo = s.nextLine();
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
                                                    case 4:
                                                        System.out.println("Saliendo...");
                                                        break;
                                                    default:
                                                        System.out.println(amarillo + "Opción inválida, inténtelo de nuevo." + colorNormal);
                                                        break;
                                                }
                                            }while(opcion != 4);
                                            break;
                                        case 2:
                                            do {
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"   Configuración"+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1."+ colorNormal +" Cambio de Usuario.");
                                                System.out.println(verde +"2."+ colorNormal +" Cambio de Contraseña.");
                                                System.out.println(verde +"3."+ colorNormal +" Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion){
                                                    case 1:
                                                        System.out.println("Inserte su anterior usuario:");
                                                        String userAntiguo = s.nextLine();
                                                        if (userAntiguo.equals(GESTOR_USUARIO)){
                                                            System.out.println("Inserte su nuevo usuario:");
                                                            GESTOR_USUARIO = s.nextLine();
                                                            System.out.println(verde +"Su usuario ahora es " + GESTOR_USUARIO + "." + colorNormal);
                                                        }else {
                                                            System.out.println(amarillo + "El usuario no es correcto, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("Inserte su anterior contraseña:");
                                                        String passwordUsuario = s.nextLine();
                                                        if (passwordUsuario.equals(GESTOR_CONTRASENA)){
                                                            System.out.println("Inserte su nueva contraseña:");
                                                            GESTOR_CONTRASENA = s.nextLine();
                                                            System.out.println(verde + "Su contraseña ha sido cambiada." + colorNormal);
                                                        }else {
                                                            System.out.println(amarillo + "La contraseña no es correcta, inténtelo de nuevo." + colorNormal);
                                                            break;
                                                        }
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
                                    System.out.println(morado +"╭ ─────┉─────"+ amarillo +" • "+ morado +"─────┉───── ╮");
                                    System.out.println(verde +"  ┈ ⋞ 〈 "+ azul +"MENÚ INVERSOR1"+ verde +" 〉 ⋟ ┈");
                                    System.out.println(morado +"╰ ─────┉─────"+ amarillo +" • "+ morado +"─────┉───── ╯"+ colorNormal);
                                    System.out.println(verde + "1."+ colorNormal +"Mis Inversiones.");
                                    System.out.println(verde + "2."+ colorNormal +"Proyectos.");
                                    System.out.println(verde + "3."+ colorNormal +"Cartera digital.");
                                    System.out.println(verde + "4."+ colorNormal +"Invitar amigos.");
                                    System.out.println(verde + "5."+ colorNormal +"Configuración.");
                                    System.out.println(verde + "6."+ colorNormal +"Salir.");
                                    opcion = Integer.parseInt(s.nextLine());
                                    switch (opcion){
                                        case 1:
                                            if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                    System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres ver? "+ morado +" |");
                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                    System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                    System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                    System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                    System.out.println(verde +"4." + colorNormal + "Volver.");
                                                    opcion = Integer.parseInt(s.nextLine());
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.equals("")){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto01);
                                                                System.out.println("Categoría: " + categoriaProyecto01);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor1Proy01);
                                                                System.out.println(cyan + "Para ver el proyecto detallado, inserte "+ rojo +"[X]"+ cyan + ", para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto01);
                                                                    System.out.println("Descripción: " + descProyecto01);
                                                                    System.out.println("Categoría: " + categoriaProyecto01);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto01);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto01);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto01 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto01 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto01 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto01 = (int) ((cantFinanciadaProyecto01*100)/cantNecesariaProyecto01);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto01; x++){
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto01){
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto01; y++){
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else if (InvertirODetallada.equals("y")){
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = Integer.parseInt(s.nextLine());
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
                                                            if (nombreProyecto02.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto02);
                                                                System.out.println("Categoría: " + categoriaProyecto02);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor1Proy02);
                                                                System.out.println(cyan + "Para ver el proyecto detallado, inserte "+ rojo +"[X]"+ cyan + ", para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto02);
                                                                    System.out.println("Descripción: " + descProyecto02);
                                                                    System.out.println("Categoría: " + categoriaProyecto02);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto02);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto02);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto02 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto02 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto02 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto02 = (int) ((cantFinanciadaProyecto02*100)/cantNecesariaProyecto02);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto02) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = Integer.parseInt(s.nextLine());
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
                                                            if (nombreProyecto03.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto03);
                                                                System.out.println("Categoría: " + categoriaProyecto03);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor1Proy03);
                                                                System.out.println(cyan + "Para ver el proyecto detallado, inserte "+ rojo +"[X]"+ cyan + ", para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto03);
                                                                    System.out.println("Descripción: " + descProyecto03);
                                                                    System.out.println("Categoría: " + categoriaProyecto03);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto03);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto03);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto03 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto03 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto03 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto03 = (int) ((cantFinanciadaProyecto03*100)/cantNecesariaProyecto03);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto03) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = Integer.parseInt(s.nextLine());
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
                                            if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                    System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres ver? "+ morado +" |");
                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                    System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                    System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                    System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                    System.out.println(verde +"4." + colorNormal + "Volver.");
                                                    opcion = Integer.parseInt(s.nextLine());
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.equals("")){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto01);
                                                                System.out.println("Categoría: " + categoriaProyecto01);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto01);
                                                                    System.out.println("Descripción: " + descProyecto01);
                                                                    System.out.println("Categoría: " + categoriaProyecto01);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto01);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto01);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto01 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto01 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto01 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto01 = (int) ((cantFinanciadaProyecto01*100)/cantNecesariaProyecto01);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto01; x++){
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto01){
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto01; y++){
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto02);
                                                                System.out.println("Categoría: " + categoriaProyecto02);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto02);
                                                                    System.out.println("Descripción: " + descProyecto02);
                                                                    System.out.println("Categoría: " + categoriaProyecto02);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto02);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto02);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto02 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto02 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto02 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto02 = (int) ((cantFinanciadaProyecto02*100)/cantNecesariaProyecto02);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto02) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto03);
                                                                System.out.println("Categoría: " + categoriaProyecto03);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto03);
                                                                    System.out.println("Descripción: " + descProyecto03);
                                                                    System.out.println("Categoría: " + categoriaProyecto03);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto03);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto03);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto03 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto03 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto03 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto03 = (int) ((cantFinanciadaProyecto03*100)/cantNecesariaProyecto03);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto03) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"   Cartera Digital "+ morado +"   |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde + "1." + colorNormal + "Mostrar Saldo Actual.");
                                                System.out.println(verde + "2." + colorNormal + "Añadir saldo.");
                                                System.out.println(verde + "3." + colorNormal + "Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion){
                                                    case 1:
                                                        System.out.println(carteraInversor1);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = Integer.parseInt(s.nextLine());
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"    Invitar Amigo "+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde+"1."+ colorNormal +"Mostrar lista de amigos referidos.");
                                                System.out.println(verde+"2."+ colorNormal +"Añadir un amigo.");
                                                System.out.println(verde+"3."+ colorNormal +"Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
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
                                                        String nuevoAmigo = s.nextLine();
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"   Configuración"+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1."+ colorNormal +" Cambio de Usuario");
                                                System.out.println(verde +"2."+ colorNormal +" Cambio de Contraseña");
                                                System.out.println(verde +"3."+ colorNormal +" Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion){
                                                    case 1:
                                                        System.out.print("Escribe la contraseña: ");
                                                        contrasena = s.nextLine();
                                                        if (contrasena.equals(INVERSOR1_CONTRASENA)){
                                                            System.out.print("Nuevo usuario: ");
                                                            INVERSOR1_USUARIO=s.nextLine();
                                                        }
                                                        else System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
                                                        break;
                                                    case 2:
                                                        System.out.print("Escribe la contraseña: ");
                                                        contrasena = s.nextLine();
                                                        if (contrasena.equals(INVERSOR1_CONTRASENA)){
                                                            System.out.print("Nueva contraseña: ");
                                                            INVERSOR1_CONTRASENA=s.nextLine();
                                                        }
                                                        else System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
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
                                    System.out.println(morado +"╭ ─────┉─────"+ amarillo +" • "+ morado +"─────┉───── ╮");
                                    System.out.println(verde +"  ┈ ⋞ 〈 "+ azul +"MENÚ INVERSOR2"+ verde +" 〉 ⋟ ┈");
                                    System.out.println(morado +"╰ ─────┉─────"+ amarillo +" • "+ morado +"─────┉───── ╯"+ colorNormal);
                                    System.out.println(verde + "1."+ colorNormal +"Mis Inversiones.");
                                    System.out.println(verde + "2."+ colorNormal +"Proyectos.");
                                    System.out.println(verde + "3."+ colorNormal +"Cartera digital.");
                                    System.out.println(verde + "4."+ colorNormal +"Invitar amigos.");
                                    System.out.println(verde + "5."+ colorNormal +"Configuración.");
                                    System.out.println(verde + "6."+ colorNormal +"Salir.");
                                    opcion = Integer.parseInt(s.nextLine());
                                    switch (opcion) {
                                        case 1:
                                            if (nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")) {
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            } else {
                                                do {
                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                    System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres ver? "+ morado +" |");
                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                    System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                    System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                    System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                    System.out.println(verde +"4." + colorNormal + "Volver.");
                                                    opcion = Integer.parseInt(s.nextLine());
                                                    switch(opcion) {
                                                        case 1:
                                                            if (nombreProyecto01.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto01);
                                                                System.out.println("Categoría: " + categoriaProyecto01);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor2Proy01);
                                                                System.out.println(cyan + "Para ver el proyecto detallado, inserte "+ rojo +"[X]"+ cyan + ", para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto01);
                                                                    System.out.println("Descripción: " + descProyecto01);
                                                                    System.out.println("Categoría: " + categoriaProyecto01);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto01);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto01);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto01 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto01 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto01 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto01 = (int) ((cantFinanciadaProyecto01 * 100) / cantNecesariaProyecto01);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto01; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto01) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto01; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = Integer.parseInt(s.nextLine());
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
                                                            if (nombreProyecto02.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto02);
                                                                System.out.println("Categoría: " + categoriaProyecto02);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor2Proy02);
                                                                System.out.println(cyan + "Para ver el proyecto detallado, inserte "+ rojo +"[X]"+ cyan + ", para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto02);
                                                                    System.out.println("Descripción: " + descProyecto02);
                                                                    System.out.println("Categoría: " + categoriaProyecto02);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto02);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto02);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto02 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto02 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto02 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto02 = (int) ((cantFinanciadaProyecto02 * 100) / cantNecesariaProyecto02);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto02) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = Integer.parseInt(s.nextLine());
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
                                                            if (nombreProyecto03.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto03);
                                                                System.out.println("Categoría: " + categoriaProyecto03);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor2Proy03);
                                                                System.out.println(cyan + "Para ver el proyecto detallado, inserte "+ rojo +"[X]"+ cyan + ", para invertir, inserte "+ amarillo +"[Y]" + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto03);
                                                                    System.out.println("Descripción: " + descProyecto03);
                                                                    System.out.println("Categoría: " + categoriaProyecto03);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto03);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto03);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto03 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto03 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto03 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto03 = (int) ((cantFinanciadaProyecto03 * 100) / cantNecesariaProyecto03);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto03) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else if (InvertirODetallada.equals("y")) {
                                                                    System.out.print("Cantidad a invertir: ");
                                                                    cantidadInvertir = Integer.parseInt(s.nextLine());
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
                                            if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                System.out.println(amarillo + "Ningún proyecto ha sido creado aún." + colorNormal);
                                            }else{
                                                do {
                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                    System.out.println(        "| "+ amarillo +"¿Qué proyecto quieres ver? "+ morado +" |");
                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                    System.out.println(verde +"1." + colorNormal + "Primer proyecto.");
                                                    System.out.println(verde +"2." + colorNormal + "Segundo proyecto.");
                                                    System.out.println(verde +"3." + colorNormal + "Tercer proyecto.");
                                                    System.out.println(verde +"4." + colorNormal + "Volver.");
                                                    opcion = Integer.parseInt(s.nextLine());
                                                    switch(opcion){
                                                        case 1:
                                                            if (nombreProyecto01.equals("")){
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else{
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto01);
                                                                System.out.println("Categoría: " + categoriaProyecto01);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")){
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 01 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto01);
                                                                    System.out.println("Descripción: " + descProyecto01);
                                                                    System.out.println("Categoría: " + categoriaProyecto01);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto01);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto01);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto01 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto01 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto01);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto01 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto01 = (int) ((cantFinanciadaProyecto01*100)/cantNecesariaProyecto01);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto01; x++){
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto01){
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto01; y++){
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            if (nombreProyecto02.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto02);
                                                                System.out.println("Categoría: " + categoriaProyecto02);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 02 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto02);
                                                                    System.out.println("Descripción: " + descProyecto02);
                                                                    System.out.println("Categoría: " + categoriaProyecto02);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto02);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto02);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto02);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto02);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto02 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto02 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto02);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto02 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto02 = (int) ((cantFinanciadaProyecto02*100)/cantNecesariaProyecto02);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto02) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                } else {
                                                                    System.out.println(amarillo + "Opción inválida." + colorNormal);
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            if (nombreProyecto03.equals("")) {
                                                                System.out.println(amarillo + "Este proyecto no ha sido creado aún."+ colorNormal);
                                                            } else {
                                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                System.out.println("Nombre: " + nombreProyecto03);
                                                                System.out.println("Categoría: " + categoriaProyecto03);
                                                                System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                System.out.println("Para ver el proyecto detallado, inserte " + rojo +"[X]." + colorNormal);
                                                                String InvertirODetallada = s.nextLine();
                                                                if (InvertirODetallada.equalsIgnoreCase("x")) {
                                                                    System.out.println(morado +"┏━━━━━━━━━━━━━━━━━┓");
                                                                    System.out.println(        "| "+ amarillo +"  PROYECTO 03 "+ morado +"  |");
                                                                    System.out.println(        "┗━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                                    System.out.println("Nombre: " + nombreProyecto03);
                                                                    System.out.println("Descripción: " + descProyecto03);
                                                                    System.out.println("Categoría: " + categoriaProyecto03);
                                                                    System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto03);
                                                                    System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto03);
                                                                    System.out.println("Fecha de inicio de Inversiones: " + fechaInicioProyecto03);
                                                                    System.out.println("Fecha final de Inversiones: " + fechaFinalProyecto03);
                                                                    System.out.println("Recompensas: ");
                                                                    System.out.println("Recompensa 1: " + recompensa1Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa1Proyecto03 + "€");
                                                                    System.out.println("Recompensa 2: " + recompensa2Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa2Proyecto03 + "€");
                                                                    System.out.println("Recompensa 3: " + recompensa3Proyecto03);
                                                                    System.out.println("Precio: " + preciorecompensa3Proyecto03 + "€");
                                                                    System.out.println("Gráfico de barras de cantidad financiada: \n" +
                                                                            verde +"▓ "+colorNormal+": Parte financiada.\n" +
                                                                            "░ : Parte por financiar.");
                                                                    graficoBarrasProyecto03 = (int) ((cantFinanciadaProyecto03*100)/cantNecesariaProyecto03);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                        System.out.print(verde + "▓" + colorNormal);
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto03) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                            System.out.print("░");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"   Cartera Digital "+ morado +"   |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde + "1." + colorNormal + "Mostrar Saldo Actual.");
                                                System.out.println(verde + "2." + colorNormal + "Añadir saldo.");
                                                System.out.println(verde + "3." + colorNormal + "Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion) {
                                                    case 1:
                                                        System.out.println(carteraInversor2);
                                                        break;
                                                    case 2:
                                                        do {
                                                            System.out.println("¿Cuánto dinero quieres añadir?");
                                                            dineroAnadido = Integer.parseInt(s.nextLine());
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"    Invitar Amigo "+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde+"1."+ colorNormal +"Mostrar lista de amigos referidos.");
                                                System.out.println(verde+"2."+ colorNormal +"Añadir un amigo.");
                                                System.out.println(verde+"3."+ colorNormal +"Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
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
                                                        String nuevoAmigo = s.nextLine();
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
                                                System.out.println(morado +"┏━━━━━━━━━━━━━━━━━━━━━┓");
                                                System.out.println(        "| "+ amarillo +"   Configuración"+ morado +"    |");
                                                System.out.println(        "┗━━━━━━━━━━━━━━━━━━━━━┛" + colorNormal);
                                                System.out.println(verde +"1."+ colorNormal +" Cambio de Usuario.");
                                                System.out.println(verde +"2."+ colorNormal +" Cambio de Contraseña.");
                                                System.out.println(verde +"3."+ colorNormal +" Salir.");
                                                opcion = Integer.parseInt(s.nextLine());
                                                switch (opcion) {
                                                    case 1:
                                                        System.out.print("Escribe la contraseña: ");
                                                        contrasena = s.nextLine();
                                                        if (contrasena.equals(INVERSOR2_CONTRASENA)){
                                                            System.out.print("Nuevo usuario: ");
                                                            INVERSOR2_USUARIO = s.nextLine();
                                                        } else System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
                                                        break;
                                                    case 2:
                                                        System.out.print("Escribe la contraseña: ");
                                                        contrasena = s.nextLine();
                                                        if (contrasena.equals(INVERSOR2_CONTRASENA)) {
                                                            System.out.print("Nueva contraseña: ");
                                                            INVERSOR2_CONTRASENA = s.nextLine();
                                                        } else System.out.println(amarillo + "La contraseña es incorrecta" + colorNormal);
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
