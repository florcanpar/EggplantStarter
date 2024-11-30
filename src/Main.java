import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ADMIN_USUARIO = "admin", ADMIN_CONTRASEÑA = "adminpass", GESTOR_USUARIO = "gestor", GESTOR_CONTRASEÑA = "gestorpass",
        INVERSOR1_USUARIO = "inversor1", INVERSOR1_CONTRASEÑA = "inversor1pass", INVERSOR2_USUARIO = "inversor2", INVERSOR2_CONTRASEÑA = "inversor2pass", usuario, contraseña, amigosReferidos="";
        int contadorFallosGestor = 0, contadorFallosInversor1 = 0, contadorFallosInversor2 = 0, contadorTotal = 0;
        boolean bloquearGestor = false, bloquearInversor1 = false, bloquearInversor2 = false, admin = false, gestor = false, inversor1 = false, inversor2 = false;
        int carteraInversor1 = 0, carteraInversor2 = 0, dineroAnadido = 0, cantidadInvertir=0, cantidadInvertidaInversor1Proy01 = 0, cantidadInvertidaInversor1Proy02 = 0, cantidadInvertidaInversor1Proy03 = 0,
                cantidadInvertidaInversor2Proy01 = 0, cantidadInvertidaInversor2Proy02 = 0, cantidadInvertidaInversor2Proy03 = 0;

        String negro = "\033[30m", rojo = "\033[31m", verde = "\033[32m", amarillo = "\033[33m", azul = "\033[34m",
                morado = "\033[35m", cyan = "\033[36m", blanco = "\033[37m", colorNormal = "\u001B[0m";


        int menuGestor = 0, opcion = 0, opcion2 = 0;

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
        int graficoBarrasProyecto01 = 0;
        int graficoBarrasProyecto02 = 0;
        int graficoBarrasProyecto03 = 0;
        int x, y;

        do {
            System.out.println("""
                    Seleccione una opción:\s
                    1.- Iniciar sesión.
                    2.- Salir.""");
            opcion= s.nextInt();
            switch (opcion){
                case 1:
                    do {
                        gestor = admin = inversor1 = inversor2 = false;
                        System.out.println("Usuario: ");
                        usuario = s.next();
                        System.out.println("Contraseña: ");
                        contraseña = s.next();
                        contadorTotal++;
                        // VALIDACIÓN DE GESTOR
                        if (usuario.equals(GESTOR_USUARIO)) {
                            if (bloquearGestor) {
                                System.out.println("El usuario " + GESTOR_USUARIO + " está bloqueado.");
                            } else if (contraseña.equals(GESTOR_CONTRASEÑA)) {
                                System.out.println("Bienvenido " + GESTOR_USUARIO);
                                gestor = true;
                                contadorFallosGestor = 0; // Reiniciar contador de fallos
                            } else {
                                System.out.println("Contraseña incorrecta. Vuelva a intentarlo.");
                                contadorFallosGestor++;
                                if (contadorFallosGestor > 2) {
                                    System.out.println("Usuario " + GESTOR_USUARIO + " bloqueado.");
                                    bloquearGestor = true;
                                }
                            }
                        }
                        // VALIDACIÓN DE INVERSOR1
                        if (usuario.equals(INVERSOR1_USUARIO)) {
                            if (bloquearInversor1) {
                                System.out.println("El usuario " + INVERSOR1_USUARIO + " está bloqueado.");
                            } else if (contraseña.equals(INVERSOR1_CONTRASEÑA)) {
                                System.out.println("Bienvenido " + INVERSOR1_USUARIO);
                                inversor1 = true;
                                contadorFallosInversor1 = 0; // Reiniciar contador de fallos
                            } else {
                                System.out.println("Contraseña incorrecta. Vuelva a intentarlo.");
                                contadorFallosInversor1++;
                                if (contadorFallosInversor1 > 2) {
                                    System.out.println("Usuario " + INVERSOR1_USUARIO + " bloqueado.");
                                    bloquearInversor1 = true;
                                }
                            }
                        }
                        // VALIDACIÓN DE INVERSOR2
                        if (usuario.equals(INVERSOR2_USUARIO)) {
                            if (bloquearInversor2) {
                                System.out.println("El usuario " + INVERSOR2_USUARIO + " está bloqueado.");
                            } else if (contraseña.equals(INVERSOR2_CONTRASEÑA)) {
                                System.out.println("Bienvenido " + INVERSOR2_USUARIO);
                                inversor2 = true;
                                contadorFallosInversor2 = 0; // Reiniciar contador de fallos
                            } else {
                                System.out.println("Contraseña incorrecta. Vuelva a intentarlo.");
                                contadorFallosInversor2++;
                                if (contadorFallosInversor2 > 2) {
                                    System.out.println("Usuario " + INVERSOR2_USUARIO + " bloqueado.");
                                    bloquearInversor2 = true;
                                }
                            }
                        }
                        // VALIDACIÓN DE ADMIN
                        if (usuario.equals(ADMIN_USUARIO)) {
                            if (contraseña.equals(ADMIN_CONTRASEÑA)) {
                                System.out.println("Bienvenido " + ADMIN_USUARIO);
                                admin = true;
                            } else {
                                System.out.println("Contraseña incorrecta. Vuelva a intentarlo.");
                            }
                        }
                        if (contadorTotal == 3 && !gestor && !inversor1 && !inversor2 && !admin) {
                            System.out.println("Se han agotado los intentos permitidos. Inténtelo de nuevo.");
                            contadorTotal = 0; // Reiniciar el contador total para permitir nuevos intentos
                        }
                    } while (!gestor && !inversor1 && !inversor2 && !admin);
                    if (admin){
                        do {
                            System.out.println("\n Menu Administrador ");
                            System.out.println("1.Panel de control");
                            System.out.println("2.Proyectos");
                            System.out.println("3.Configuracion");
                            System.out.println("4.Cerrar sesion");
                            opcion2 = s.nextInt();
                            switch (opcion2) {
                                case 1: {
                                    System.out.println("Has ingresado a: Panel de Control");
                                    System.out.println("Opciones de bloquear/desbloquear al usuario");
                                    do {
                                        System.out.println("#### Bloquear/Desbloquear ####");
                                        System.out.println("1. Usuario " + GESTOR_USUARIO);
                                        System.out.println("2. Usuario " + INVERSOR1_USUARIO);
                                        System.out.println("3. Usuario " + INVERSOR2_USUARIO);
                                        System.out.println("4. Volver al menu Administrador");
                                        opcion = s.nextInt();
                                        switch (opcion){
                                            case 1 :
                                                if (bloquearGestor){
                                                    System.out.println(GESTOR_USUARIO + " desbloqueado.");
                                                    bloquearGestor=false;
                                                }else{
                                                    System.out.println(GESTOR_USUARIO + " bloqueado.");
                                                    bloquearGestor=true;
                                                }
                                                break;
                                            case 2:
                                                if (bloquearInversor1){
                                                    System.out.println(INVERSOR1_USUARIO + " desbloqueado.");
                                                    bloquearInversor1=false;
                                                }else{
                                                    System.out.println(INVERSOR1_USUARIO + " bloqueado.");
                                                    bloquearInversor1=true;
                                                }
                                                break;
                                            case 3:
                                                if (bloquearInversor2){
                                                    System.out.println(INVERSOR2_USUARIO + " desbloqueado.");
                                                    bloquearInversor2=false;
                                                }else{
                                                    System.out.println(INVERSOR2_USUARIO + " bloqueado.");
                                                    bloquearInversor2=true;
                                                }
                                                break;
                                            case 4:
                                                break;
                                            default:
                                                System.out.println("Esta opcion no existe");
                                        }
                                    }while (opcion != 4);
                                }
                                break;
                                case 2: {
                                    System.out.println("Has ingresado a: Proyectos");
                                    do {
                                        System.out.println("1. Ver Proyectos");
                                        System.out.println("2. Modificar Proyectos");
                                        System.out.println("3. Eliminar Proyectos");
                                        System.out.println("4. Vuelta al menu Administrador");
                                        opcion = s.nextInt();
                                        switch (opcion){
                                            case 1:
                                                if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                    System.out.println("Ningún proyecto ha sido creado aún.");
                                                }else{
                                                    do {
                                                        System.out.println("""
                                                        ¿Qué proyecto quieres ver?
                                                        1. Primer proyecto.
                                                        2. Segundo proyecto.
                                                        3. Tercer proyecto.
                                                        4. Volver.""");
                                                        opcion = s.nextInt();
                                                        switch(opcion){
                                                            case 1:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else{
                                                                    System.out.println("PROYECTO 01");
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
                                                                            "| : Parte financiada.\n" +
                                                                            "* : Parte por financiar.");
                                                                    graficoBarrasProyecto01 = (int) (((double)cantFinanciadaProyecto01*100)/cantNecesariaProyecto01);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto01; x++){
                                                                        System.out.print("|");
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto01){
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto01; y++){
                                                                            System.out.print("*");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                }
                                                                break;
                                                            case 2:
                                                                if (nombreProyecto02.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("PROYECTO 02");
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
                                                                            "| : Parte financiada.\n" +
                                                                            "* : Parte por financiar.");
                                                                    graficoBarrasProyecto02 = (int) (((double)cantFinanciadaProyecto02 * 100) / cantNecesariaProyecto02);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                        System.out.print("|");
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto02) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                            System.out.print("*");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                }
                                                                break;
                                                            case 3:
                                                                if (nombreProyecto03.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("PROYECTO 03");
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
                                                                            "| : Parte financiada.\n" +
                                                                            "* : Parte por financiar.");
                                                                    graficoBarrasProyecto03 = (int) (((double)cantFinanciadaProyecto03 * 100) / cantNecesariaProyecto03);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                        System.out.print("|");
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto03) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                            System.out.print("*");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                }
                                                                break;
                                                            case 4:
                                                                System.out.println("Saliendo...");
                                                                break;
                                                            default:
                                                                System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                break;
                                                        }
                                                    }while (opcion != 4);
                                                }
                                                break;
                                            case 2 :
                                                if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                    System.out.println("Ningún proyecto ha sido creado aún, dile al gesto que cree un proyecto para modificarlo.");
                                                }else{
                                                    do {
                                                        System.out.println("""
                                                      ¿Qué proyecto quieres cambiar?
                                                      1. Primer proyecto.
                                                      2. Segundo proyecto.
                                                      3. Tercer proyecto.
                                                      4. Volver.""");
                                                        opcion = s.nextInt();
                                                        switch(opcion){
                                                            case 1:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué quieres cambiar?
                                                                1. Nombre.
                                                                2. Descripción.
                                                                3. Categoría.
                                                                4. Cantidad necesaria.
                                                                5. Cantidad financiada.
                                                                6. Fecha de Inicio de inversiones.
                                                                7. Fecha de finalización de inversiones.
                                                                8. Recompensas
                                                                9. Volver.
                                                                """);
                                                                        opcion = s.nextInt();
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
                                                                                cantNecesariaProyecto01 = s.nextInt();
                                                                                break;
                                                                            case 5:
                                                                                System.out.println("Cantidad Financiada:");
                                                                                cantFinanciadaProyecto01 = s.nextInt();
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
                                                                                    System.out.println("""
                                                                ¿Qué recompensa quieres cambiar?
                                                                1. Recompensa 1.
                                                                2. Recompensa 2.
                                                                3. Recompensa 3.
                                                                4. Volver""");
                                                                                    opcion = s.nextInt();
                                                                                    switch(opcion){
                                                                                        case 1:
                                                                                            System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                            s.nextLine();
                                                                                            recompensa1Proyecto01 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 1:");
                                                                                            preciorecompensa1Proyecto01 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                            s.nextLine();
                                                                                            recompensa2Proyecto01 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 2:");
                                                                                            preciorecompensa2Proyecto01 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                            s.nextLine();
                                                                                            recompensa3Proyecto01 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 3:");
                                                                                            preciorecompensa3Proyecto01 = s.nextInt();
                                                                                            s.nextLine();
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
                                                            case 2:
                                                                if (nombreProyecto02.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué quieres cambiar?
                                                                1. Nombre.
                                                                2. Descripción.
                                                                3. Categoría.
                                                                4. Cantidad necesaria.
                                                                5. Cantidad financiada.
                                                                6. Fecha de Inicio de inversiones.
                                                                7. Fecha de finalización de inversiones.
                                                                8. Recompensas
                                                                9. Volver.
                                                                """);
                                                                        opcion = s.nextInt();
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
                                                                                cantNecesariaProyecto02 = s.nextInt();
                                                                                break;
                                                                            case 5:
                                                                                System.out.println("Cantidad Financiada:");
                                                                                cantFinanciadaProyecto02 = s.nextInt();
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
                                                                                    System.out.println("""
                                                                                    ¿Qué recompensa quieres cambiar?
                                                                                    1. Recompensa 1.
                                                                                    2. Recompensa 2.
                                                                                    3. Recompensa 3.
                                                                                    4. Volver""");
                                                                                    opcion = s.nextInt();
                                                                                    switch(opcion){
                                                                                        case 1:
                                                                                            System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                            s.nextLine();
                                                                                            recompensa1Proyecto02 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 1:");
                                                                                            preciorecompensa1Proyecto02 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                            s.nextLine();
                                                                                            recompensa2Proyecto02 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 2:");
                                                                                            preciorecompensa2Proyecto02 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                            s.nextLine();
                                                                                            recompensa3Proyecto02 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 3:");
                                                                                            preciorecompensa3Proyecto02 = s.nextInt();
                                                                                            s.nextLine();
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
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    do {
                                                                        System.out.println("""
                                                                        ¿Qué quieres cambiar?
                                                                        1. Nombre.
                                                                        2. Descripción.
                                                                        3. Categoría.
                                                                        4. Cantidad necesaria.
                                                                        5. Cantidad financiada.
                                                                        6. Fecha de Inicio de inversiones.
                                                                        7. Fecha de finalización de inversiones.
                                                                        8. Recompensas
                                                                        9. Volver.
                                                                        """);
                                                                        opcion = s.nextInt();
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
                                                                                cantNecesariaProyecto03 = s.nextInt();
                                                                                break;
                                                                            case 5:
                                                                                System.out.println("Cantidad Financiada:");
                                                                                cantFinanciadaProyecto03 = s.nextInt();
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
                                                                                    System.out.println("""
                                                                                    ¿Qué recompensa quieres cambiar?
                                                                                    1. Recompensa 1.
                                                                                    2. Recompensa 2.
                                                                                    3. Recompensa 3.
                                                                                    4. Volver""");
                                                                                    opcion = s.nextInt();
                                                                                    switch(opcion){
                                                                                        case 1:
                                                                                            System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                            s.nextLine();
                                                                                            recompensa1Proyecto03 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 1:");
                                                                                            preciorecompensa1Proyecto03 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                            s.nextLine();
                                                                                            recompensa2Proyecto03 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 2:");
                                                                                            preciorecompensa2Proyecto03 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                            s.nextLine();
                                                                                            recompensa3Proyecto03 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 3:");
                                                                                            preciorecompensa3Proyecto03 = s.nextInt();
                                                                                            s.nextLine();
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
                                                if (nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("") && descProyecto01.equals("") && descProyecto02.equals("") && descProyecto03.equals("") && categoriaProyecto01.equals("")){
                                                    do {
                                                        System.out.println("""
                                        ¿Qué proyecto quieres eliminar?
                                        1. Primer Proyecto.
                                        2. Segundo Proyecto.
                                        3. Tercero Proyecto.
                                        4. Volver.
                                        """);
                                                        opcion = s.nextInt();
                                                        switch (opcion){
                                                            case 1:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("¿Quieres eliminar el proyecto" + nombreProyecto01 + "? (s/n)");
                                                                    String eliminarProyecto1SiNo = s.next();
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
                                                                    } else {
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    }
                                                                }
                                                            case 2:
                                                                if (nombreProyecto02.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("¿Quieres eliminar el proyecto" + nombreProyecto02 + "? (s/n)");
                                                                    String eliminarProyecto2SiNo = s.next();
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
                                                                    } else {
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("¿Quieres eliminar el proyecto" + nombreProyecto03 + "? (s/n)");
                                                                    String eliminarProyecto3SiNo = s.next();
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
                                                                    } else {
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                break;
                                                            default:
                                                                System.out.println("Opción inválida.");
                                                                break;
                                                        }
                                                    }while (opcion != 4);
                                                }
                                                break;
                                            case 4 :
                                                System.out.println("Vuelta al menu Administrador ");
                                                break;
                                            default:
                                                System.out.println("Esta opcion no existe o no se ha encontrado el proyecto");
                                        }
                                    } while (opcion != 4);
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
                                                do{
                                                    System.out.println("Introduzca su antigua contraseña");
                                                    contraseña = s.nextLine();
                                                }while (contraseña.equals(ADMIN_CONTRASEÑA));
                                                System.out.println("Introduzca su nueva contraseña");
                                                ADMIN_CONTRASEÑA = s.nextLine();
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
                        } while (opcion2 != 4);
                    } else if (gestor && !bloquearGestor) {
                        do{
                            System.out.println(amarillo + "*************");
                            System.out.println(morado + " MENÚ GESTOR");
                            System.out.println(amarillo + "*************" + colorNormal);
                            System.out.println("1. Mis proyectos.");
                            System.out.println("2. Cambiar usuario/contraseña.");
                            System.out.println("3. Cerrar sesión.");
                            menuGestor = s.nextInt();
                            switch (menuGestor){
                                case 1:
                                    do{
                                        System.out.println(amarillo + "*************");
                                        System.out.println(morado + "MIS PROYECTOS");
                                        System.out.println(amarillo + "*************" + colorNormal);
                                        System.out.println("""
                                1. Ver proyecto.
                                2. Crear proyecto.
                                3. Modificar proyecto.
                                4. Eliminar proyecto.
                                5. Volver al menú gestor.
                                """);
                                        opcion = s.nextInt();
                                        switch(opcion){
                                            case 1:
                                                if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                    System.out.println("Ningún proyecto ha sido creado aún.");
                                                }else{
                                                    do {
                                                        System.out.println("""
                                        ¿Qué proyecto quieres ver?
                                        1. Primer proyecto.
                                        2. Segundo proyecto.
                                        3. Tercer proyecto.
                                        4. Volver.""");
                                                        opcion = s.nextInt();
                                                        switch(opcion){
                                                            case 1:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else{
                                                                    System.out.println("PROYECTO 01");
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
                                                                            "| : Parte financiada.\n" +
                                                                            "* : Parte por financiar.");
                                                                    graficoBarrasProyecto01 = (int) (((double)cantFinanciadaProyecto01*100)/cantNecesariaProyecto01);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto01; x++){
                                                                        System.out.print("|");
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto01){
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto01; y++){
                                                                            System.out.print("*");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                }
                                                                break;
                                                            case 2:
                                                                if (nombreProyecto02.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("PROYECTO 02");
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
                                                                            "| : Parte financiada.\n" +
                                                                            "* : Parte por financiar.");
                                                                    graficoBarrasProyecto02 = (int) (((double)cantFinanciadaProyecto02 * 100) / cantNecesariaProyecto02);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto02; x++) {
                                                                        System.out.print("|");
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto02) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto02; y++) {
                                                                            System.out.print("*");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                }
                                                                break;
                                                            case 3:
                                                                if (nombreProyecto03.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("PROYECTO 03");
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
                                                                            "| : Parte financiada.\n" +
                                                                            "* : Parte por financiar.");
                                                                    graficoBarrasProyecto03 = (int) (((double)cantFinanciadaProyecto03 * 100) / cantNecesariaProyecto03);
                                                                    System.out.print("[");
                                                                    for (x = 0; x != graficoBarrasProyecto03; x++) {
                                                                        System.out.print("|");
                                                                    }
                                                                    if (0 != 100 - graficoBarrasProyecto03) {
                                                                        for (y = 0; y != 100 - graficoBarrasProyecto03; y++) {
                                                                            System.out.print("*");
                                                                        }
                                                                    }
                                                                    System.out.print("]" + x + "%");
                                                                    System.out.println();
                                                                }
                                                                break;
                                                            case 4:
                                                                System.out.println("Saliendo...");
                                                                break;
                                                            default:
                                                                System.out.println("Opción inválida, inténtelo de nuevo.");
                                                                break;
                                                        }
                                                    }while (opcion != 4);
                                                }
                                                break;
                                            case 2:
                                                do {
                                                    System.out.println("""
                                                      ¿Qué proyecto quieres crear?
                                                      1. Primer proyecto.
                                                      2. Segundo proyecto.
                                                      3. Tercer proyecto.
                                                      4. Volver.""");
                                                    opcion = s.nextInt();
                                                    switch(opcion){
                                                        case 1:
                                                            System.out.println("Nombre:");
                                                            s.nextLine();
                                                            nombreProyecto01 = s.nextLine();
                                                            if (nombreProyecto01.equals("")){
                                                                System.out.println("Para crear un proyecto DEBES ponerle nombre.");
                                                                break;
                                                            } else {
                                                                System.out.println("Descripción:");
                                                                descProyecto01 = s.nextLine();
                                                                System.out.println("Categoría:");
                                                                categoriaProyecto01 = s.nextLine();
                                                                System.out.println("Cantidad necesaria:");
                                                                cantNecesariaProyecto01 = s.nextInt();
                                                                System.out.println("Cantidad financiada:");
                                                                cantFinanciadaProyecto01 = s.nextInt();
                                                                s.nextLine();
                                                                if (cantNecesariaProyecto01 >= cantFinanciadaProyecto01){
                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                    fechaInicioProyecto01 = s.nextLine();
                                                                    System.out.println("Fecha de finalización de inversiones: ");
                                                                    fechaFinalProyecto01 = s.nextLine();
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué recompensa quieres crear?
                                                                1. Recompensa 1.
                                                                2. Recompensa 2.
                                                                3. Recompensa 3.
                                                                4. Volver""");
                                                                        opcion = s.nextInt();
                                                                        switch(opcion){
                                                                            case 1:
                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                recompensa1Proyecto01 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                preciorecompensa1Proyecto01 = s.nextInt();
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                recompensa2Proyecto01 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                preciorecompensa2Proyecto01 = s.nextInt();
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                recompensa3Proyecto01 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                preciorecompensa3Proyecto01 = s.nextInt();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                        }
                                                                    }while(opcion != 4);
                                                                } else {
                                                                    System.out.println("La cantidad financiada debe ser menor o igual que la cantidad necesaria.");
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            System.out.println("Nombre:");
                                                            s.nextLine();
                                                            nombreProyecto02 = s.nextLine();
                                                            if (nombreProyecto02.equals("")){
                                                                System.out.println("Para crear un proyecto DEBES ponerle nombre.");
                                                                break;
                                                            } else {
                                                                System.out.println("Descripción:");
                                                                descProyecto02 = s.nextLine();
                                                                System.out.println("Categoría:");
                                                                categoriaProyecto02 = s.nextLine();
                                                                System.out.println("Cantidad necesaria:");
                                                                cantNecesariaProyecto02 = s.nextInt();
                                                                System.out.println("Cantidad financiada:");
                                                                cantFinanciadaProyecto02 = s.nextInt();
                                                                s.nextLine();
                                                                if (cantNecesariaProyecto02 >= cantFinanciadaProyecto02){
                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                    fechaInicioProyecto02 = s.nextLine();
                                                                    System.out.println("Fecha de finalización de inversiones: ");
                                                                    fechaFinalProyecto02 = s.nextLine();
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué recompensa quieres crear?
                                                                1. Recompensa 1.
                                                                2. Recompensa 2.
                                                                3. Recompensa 3.
                                                                4. Volver""");
                                                                        opcion = s.nextInt();
                                                                        switch(opcion){
                                                                            case 1:
                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                recompensa1Proyecto02 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                preciorecompensa1Proyecto02 = s.nextInt();
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                recompensa2Proyecto02 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                preciorecompensa2Proyecto02 = s.nextInt();
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                recompensa3Proyecto02 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                preciorecompensa3Proyecto02 = s.nextInt();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                        }
                                                                    }while(opcion != 4);
                                                                } else {
                                                                    System.out.println("La cantidad financiada debe ser menor o igual que la cantidad necesaria.");
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case 3:
                                                            System.out.println("Nombre:");
                                                            s.nextLine();
                                                            nombreProyecto03 = s.nextLine();
                                                            if (nombreProyecto03.equals("")){
                                                                System.out.println("Para crear un proyecto DEBES ponerle nombre.");
                                                                break;
                                                            } else {
                                                                System.out.println("Descripción:");
                                                                descProyecto03 = s.nextLine();
                                                                System.out.println("Categoría:");
                                                                categoriaProyecto03 = s.nextLine();
                                                                System.out.println("Cantidad necesaria:");
                                                                cantNecesariaProyecto03 = s.nextInt();
                                                                System.out.println("Cantidad financiada:");
                                                                cantFinanciadaProyecto03 = s.nextInt();
                                                                s.nextLine();
                                                                if (cantNecesariaProyecto03 >= cantFinanciadaProyecto03){
                                                                    System.out.println("Fecha de Inicio de inversiones:");
                                                                    fechaInicioProyecto03 = s.nextLine();
                                                                    System.out.println("Fecha de finalización de inversiones: ");
                                                                    fechaFinalProyecto03 = s.nextLine();
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué recompensa quieres crear?
                                                                1. Recompensa 1.
                                                                2. Recompensa 2.
                                                                3. Recompensa 3.
                                                                4. Volver""");
                                                                        opcion = s.nextInt();
                                                                        switch(opcion){
                                                                            case 1:
                                                                                System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                s.nextLine();
                                                                                recompensa1Proyecto03 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 1:");
                                                                                preciorecompensa1Proyecto03 = s.nextInt();
                                                                                s.nextLine();
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                s.nextLine();
                                                                                recompensa2Proyecto03 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 2:");
                                                                                preciorecompensa2Proyecto03 = s.nextInt();
                                                                                s.nextLine();
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                s.nextLine();
                                                                                recompensa3Proyecto03 = s.nextLine();
                                                                                System.out.println("Escriba el precio de la recompensa 3:");
                                                                                preciorecompensa3Proyecto03 = s.nextInt();
                                                                                s.nextLine();
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Saliendo...");
                                                                                break;
                                                                        }

                                                                    }while(opcion != 4);
                                                                } else {
                                                                    System.out.println("La cantidad financiada debe ser menor o igual que la cantidad necesaria.");
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
                                                if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                                    System.out.println("Ningún proyecto ha sido creado aún, crea un proyecto para modificarlo.");
                                                }else{
                                                    do {
                                                        System.out.println("""
                                                      ¿Qué proyecto quieres cambiar?
                                                      1. Primer proyecto.
                                                      2. Segundo proyecto.
                                                      3. Tercer proyecto.
                                                      4. Volver.""");
                                                        opcion = s.nextInt();
                                                        switch(opcion){
                                                            case 1:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué quieres cambiar?
                                                                1. Nombre.
                                                                2. Descripción.
                                                                3. Categoría.
                                                                4. Cantidad necesaria.
                                                                5. Cantidad financiada.
                                                                6. Fecha de Inicio de inversiones.
                                                                7. Fecha de finalización de inversiones.
                                                                8. Recompensas
                                                                9. Volver.
                                                                """);
                                                                        opcion = s.nextInt();
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
                                                                                cantNecesariaProyecto01 = s.nextInt();
                                                                                break;
                                                                            case 5:
                                                                                System.out.println("Cantidad Financiada:");
                                                                                cantFinanciadaProyecto01 = s.nextInt();
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
                                                                                    System.out.println("""
                                                                                    ¿Qué recompensa quieres cambiar?
                                                                                    1. Recompensa 1.
                                                                                    2. Recompensa 2.
                                                                                    3. Recompensa 3.
                                                                                    4. Volver""");
                                                                                    opcion = s.nextInt();
                                                                                    switch(opcion){
                                                                                        case 1:
                                                                                            System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                            s.nextLine();
                                                                                            recompensa1Proyecto01 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 1:");
                                                                                            preciorecompensa1Proyecto01 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                            s.nextLine();
                                                                                            recompensa2Proyecto01 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 2:");
                                                                                            preciorecompensa2Proyecto01 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                            s.nextLine();
                                                                                            recompensa3Proyecto01 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 3:");
                                                                                            preciorecompensa3Proyecto01 = s.nextInt();
                                                                                            s.nextLine();
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
                                                            case 2:
                                                                if (nombreProyecto02.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    do {
                                                                        System.out.println("""
                                                                        ¿Qué quieres cambiar?
                                                                        1. Nombre.
                                                                        2. Descripción.
                                                                        3. Categoría.
                                                                        4. Cantidad necesaria.
                                                                        5. Cantidad financiada.
                                                                        6. Fecha de Inicio de inversiones.
                                                                        7. Fecha de finalización de inversiones.
                                                                        8. Recompensas
                                                                        9. Volver.
                                                                        """);
                                                                        opcion = s.nextInt();
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
                                                                                cantNecesariaProyecto02 = s.nextInt();
                                                                                break;
                                                                            case 5:
                                                                                System.out.println("Cantidad Financiada:");
                                                                                cantFinanciadaProyecto02 = s.nextInt();
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
                                                                                    System.out.println("""
                                                                ¿Qué recompensa quieres cambiar?
                                                                1. Recompensa 1.
                                                                2. Recompensa 2.
                                                                3. Recompensa 3.
                                                                4. Volver""");
                                                                                    opcion = s.nextInt();
                                                                                    switch(opcion){
                                                                                        case 1:
                                                                                            System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                            s.nextLine();
                                                                                            recompensa1Proyecto02 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 1:");
                                                                                            preciorecompensa1Proyecto02 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                            s.nextLine();
                                                                                            recompensa2Proyecto02 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 2:");
                                                                                            preciorecompensa2Proyecto02 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                            s.nextLine();
                                                                                            recompensa3Proyecto02 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 3:");
                                                                                            preciorecompensa3Proyecto02 = s.nextInt();
                                                                                            s.nextLine();
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
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    do {
                                                                        System.out.println("""
                                                                ¿Qué quieres cambiar?
                                                                1. Nombre.
                                                                2. Descripción.
                                                                3. Categoría.
                                                                4. Cantidad necesaria.
                                                                5. Cantidad financiada.
                                                                6. Fecha de Inicio de inversiones.
                                                                7. Fecha de finalización de inversiones.
                                                                8. Recompensas
                                                                9. Volver.
                                                                """);
                                                                        opcion = s.nextInt();
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
                                                                                cantNecesariaProyecto03 = s.nextInt();
                                                                                break;
                                                                            case 5:
                                                                                System.out.println("Cantidad Financiada:");
                                                                                cantFinanciadaProyecto03 = s.nextInt();
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
                                                                                    System.out.println("""
                                                                ¿Qué recompensa quieres cambiar?
                                                                1. Recompensa 1.
                                                                2. Recompensa 2.
                                                                3. Recompensa 3.
                                                                4. Volver""");
                                                                                    opcion = s.nextInt();
                                                                                    switch(opcion){
                                                                                        case 1:
                                                                                            System.out.println("Escriba la descripción de la recompensa 1:");
                                                                                            s.nextLine();
                                                                                            recompensa1Proyecto03 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 1:");
                                                                                            preciorecompensa1Proyecto03 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("Escriba la descripción de la recompensa 2:");
                                                                                            s.nextLine();
                                                                                            recompensa2Proyecto03 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 2:");
                                                                                            preciorecompensa2Proyecto03 = s.nextInt();
                                                                                            s.nextLine();
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("Escriba la descripción de la recompensa 3:");
                                                                                            s.nextLine();
                                                                                            recompensa3Proyecto03 = s.nextLine();
                                                                                            System.out.println("Escriba el precio de la recompensa 3:");
                                                                                            preciorecompensa3Proyecto03 = s.nextInt();
                                                                                            s.nextLine();
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
                                                if (nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("") && descProyecto01.equals("") && descProyecto02.equals("") && descProyecto03.equals("") && categoriaProyecto01.equals("")){
                                                    do {
                                                        System.out.println("""
                                                        ¿Qué proyecto quieres eliminar?
                                                        1. Primer Proyecto.
                                                        2. Segundo Proyecto.
                                                        3. Tercero Proyecto.
                                                        4. Volver.
                                                        """);
                                                        opcion = s.nextInt();
                                                        switch (opcion){
                                                            case 1:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("¿Quieres eliminar el proyecto" + nombreProyecto01 + "? (s/n)");
                                                                    String eliminarProyecto1SiNo = s.next();
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
                                                                    } else {
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    }
                                                                }
                                                            case 2:
                                                                if (nombreProyecto02.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("¿Quieres eliminar el proyecto" + nombreProyecto02 + "? (s/n)");
                                                                    String eliminarProyecto2SiNo = s.next();
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
                                                                    } else {
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                if (nombreProyecto01.equals("")){
                                                                    System.out.println("Este proyecto no ha sido creado aún.");
                                                                } else {
                                                                    System.out.println("¿Quieres eliminar el proyecto" + nombreProyecto03 + "? (s/n)");
                                                                    String eliminarProyecto3SiNo = s.next();
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
                                                                    } else {
                                                                        System.out.println("Saliendo...");
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                break;
                                                            default:
                                                                System.out.println("Opción inválida.");
                                                                break;
                                                        }
                                                    }while (opcion != 4);
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Saliendo...");
                                                break;
                                            default:
                                                System.out.println("Opción inválida, inténtelo de nuevo.");
                                                break;
                                        }
                                    }while(opcion != 5);
                                    break;
                                case 2:
                                    do {
                                        System.out.println(amarillo + "**************************");
                                        System.out.println(morado + "CAMBIAR USUARIO Y CONTRASEÑA");
                                        System.out.println(amarillo + "**************************" + colorNormal);
                                        System.out.println("1. Cambiar usuario.");
                                        System.out.println("2. Cambiar contraseña.");
                                        System.out.println("3. Volver al Menú Gestor.");
                                        opcion = s.nextInt();
                                        switch (opcion){
                                            case 1:
                                                System.out.println("Inserte su anterior usuario:");
                                                String userAntiguo = s.next();
                                                if (userAntiguo.equals(GESTOR_USUARIO)){
                                                    System.out.println("Inserte su nuevo usuario:");
                                                    String userNuevo = s.next();
                                                    GESTOR_USUARIO = userNuevo;
                                                    System.out.println("Su usuario ahora es " + GESTOR_USUARIO + ".");
                                                }else {
                                                    System.out.println("El usuario no es correcto, inténtelo de nuevo.");
                                                    break;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Inserte su anterior contraseña:");
                                                String passwordUsuario = s.next();
                                                if (passwordUsuario.equals(GESTOR_CONTRASEÑA)){
                                                    System.out.println("Inserte su nueva contraseña:");
                                                    String passwordNueva = s.next();
                                                    GESTOR_CONTRASEÑA = passwordNueva;
                                                    System.out.println("Su contraseña ha sido cambiada.");
                                                }else {
                                                    System.out.println("La contraseña no es correcta, inténtelo de nuevo.");
                                                    break;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Volviendo al Menú Gestor...");
                                                break;
                                            default:
                                                System.out.println("La opción insertada es inválida.");
                                                break;
                                        }
                                    }while(opcion != 3);
                                    break;
                                case 3:
                                    System.out.println("Cerrando sesión...");
                                    break;
                                default:
                                    System.out.println("La opción insertada es inválida.");
                                    break;
                            }
                        }while(menuGestor != 3);
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
                            opcion = s.nextInt();
                            switch (opcion){
                                case 1:
                                    if(nombreProyecto01.equals("") && nombreProyecto02.equals("") && nombreProyecto03.equals("")){
                                        System.out.println("Ningún proyecto ha sido creado aún.");
                                    }else{
                                        do {
                                            System.out.println("""
                                        ¿Qué proyecto quieres ver?
                                        1. Primer proyecto.
                                        2. Segundo proyecto.
                                        3. Tercer proyecto.
                                        4. Volver.""");
                                            opcion = s.nextInt();
                                            switch(opcion){
                                                case 1:
                                                    if (nombreProyecto01.equals("")){
                                                        System.out.println("Este proyecto no ha sido creado aún.");
                                                    } else{
                                                        System.out.println("PROYECTO 01");
                                                        System.out.println("Nombre: " + nombreProyecto01);
                                                        System.out.println("Categoría: " + categoriaProyecto01);
                                                        System.out.println("Cantidad Necesaria: " + cantNecesariaProyecto01);
                                                        System.out.println("Cantidad Financiada: " + cantFinanciadaProyecto01);
                                                        System.out.println("Cantidad Invertida: " + cantidadInvertidaInversor1Proy01);
                                                        System.out.println("¿Deseas invertir?(s/n)");
                                                        String inversionSiNo = s.next();
                                                        if (inversionSiNo.equalsIgnoreCase("s")) {
                                                            System.out.print("Cantidad a invertir: ");
                                                            cantidadInvertir = s.nextLine();
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
                                                            }
                                                        } else {
                                                            System.out.println("Saliendo...");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    if (nombreProyecto02.equals("")){
                                                        System.out.println("Este proyecto no ha sido creado aún.");
                                                    } else {
                                                        System.out.println("PROYECTO 02");
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
                                                    }
                                                    break;
                                                case 3:
                                                    if (nombreProyecto03.equals("")){
                                                        System.out.println("Este proyecto no ha sido creado aún.");
                                                    } else {
                                                        System.out.println("PROYECTO 03");
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

                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Saliendo...");
                                                    break;
                                                default:
                                                    System.out.println("Opción inválida, inténtelo de nuevo.");
                                                    break;
                                            }
                                        }while (opcion != 4);
                                    }
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
                                    do {
                                        System.out.println("""
                                        INVITAR AMIGOS
                                        1. Mostrar lista de amigos referidos.
                                        2. Añadir un amigo.
                                        3. Salir.""");
                                        opcion = Integer.parseInt(s.nextLine());
                                        switch (opcion) {
                                            case 1:
                                                if (amigosReferidos.isEmpty()) {
                                                    System.out.println("Aún no has invitado a ningún amigo.");
                                                } else {
                                                    System.out.println("Amigos referidos: " + amigosReferidos);
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Introduce el correo electrónico del amigo: ");
                                                String nuevoAmigo = s.nextLine();
                                                if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                    System.out.println("El correo introducido no es válido.");
                                                } else {
                                                    if (amigosReferidos.isEmpty()) {
                                                        amigosReferidos = nuevoAmigo;
                                                    } else {
                                                        amigosReferidos += ", " + nuevoAmigo;
                                                    }
                                                    System.out.println("Amigo añadido correctamente.");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Saliendo del menú Invitar Amigos.");
                                                break;
                                            default:
                                                System.out.println("Opción no válida, inténtalo de nuevo.");
                                                break;
                                        }
                                    } while (opcion != 3);
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
                    } else if (inversor2 && !bloquearInversor2) {
                        do {
                            System.out.println("""
                                    MENU INVERSOR2\s
                                    1. Mis Inversiones.
                                    2. Proyectos.
                                    3. Cartera Digital.
                                    4. Invitar amigos.
                                    5. Configuración.
                                    6. Salir.""");
                            opcion = Integer.parseInt(s.nextLine());
                            switch (opcion) {
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
                                        switch (opcion) {
                                            case 1:
                                                System.out.println(carteraInversor2);
                                                break;
                                            case 2:
                                                do {
                                                    System.out.println("¿Cuánto dinero quieres añadir?");
                                                    dineroAnadido = Double.parseDouble(s.nextLine());
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
                                        System.out.println("""
                                            INVITAR AMIGOS
                                            1. Mostrar lista de amigos referidos.
                                            2. Añadir un amigo.
                                            3. Salir.""");
                                        opcion = Integer.parseInt(s.nextLine());
                                        switch (opcion) {
                                            case 1:
                                                if (amigosReferidos.isEmpty()) {
                                                    System.out.println("Aún no has invitado a ningún amigo.");
                                                } else {
                                                    System.out.println("Amigos referidos: " + amigosReferidos);
                                                }
                                                break;
                                            case 2:
                                                System.out.print("Introduce el correo electrónico del amigo: ");
                                                String nuevoAmigo = s.nextLine();
                                                if (!nuevoAmigo.contains("@") || !nuevoAmigo.contains(".")) {
                                                    System.out.println("El correo introducido no es válido.");
                                                } else {
                                                    if (amigosReferidos.isEmpty()) {
                                                        amigosReferidos = nuevoAmigo;
                                                    } else {
                                                        amigosReferidos += ", " + nuevoAmigo;
                                                    }
                                                    System.out.println("Amigo añadido correctamente.");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Saliendo del menú Invitar Amigos.");
                                                break;
                                            default:
                                                System.out.println("Opción no válida, inténtalo de nuevo.");
                                                break;
                                        }
                                    } while (opcion != 3);
                                    break;
                                case 5:
                                    do {
                                        System.out.println("""
                                                CONFIGURACIÓN
                                                1. Cambiar usuario.
                                                2. Cambiar contraseña.
                                                3. Salir""");
                                        opcion = Integer.parseInt(s.nextLine());
                                        switch (opcion) {
                                            case 1:
                                                System.out.print("Escribe la contraseña");
                                                contraseña = s.nextLine();
                                                if (contraseña.equals(INVERSOR2_CONTRASEÑA)) {
                                                    System.out.print("Nuevo usuario: ");
                                                    INVERSOR2_USUARIO = s.nextLine();
                                                } else System.out.println("La contraseña es incorrecta");
                                                break;
                                            case 2:
                                                System.out.print("Escribe la contraseña:");
                                                contraseña = s.nextLine();
                                                if (contraseña.equals(INVERSOR2_CONTRASEÑA)) {
                                                    System.out.print("Nueva contraseña: ");
                                                    INVERSOR2_CONTRASEÑA = s.nextLine();
                                                } else System.out.println("La contraseña es incorrecta");
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